package com.pfranccino.learnApp.ui.register

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.pfranccino.learnApp.model.Profile
import com.pfranccino.learnApp.util.AppDataBase

class RegisterInteractor(val mInteractorOutput: RegisterContract.InteractorOutput) :
    RegisterContract.Interactor {

    val mAuth = FirebaseAuth.getInstance()
    val db = AppDataBase.INSTANCE
    override fun sendUser(email: String, password: String) {

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { autResult ->
            if (autResult.isSuccessful) {
                mAuth.currentUser?.let {
                    mInteractorOutput.onSuccessSendUser(it)
                } ?: mInteractorOutput.onErrorSendUser()
            } else mInteractorOutput.onErrorSendUser()
        }
            .addOnFailureListener {
                mInteractorOutput.onFailureSendUser()
            }
    }

    override fun saveProfileUser(profile: Profile) {
        db?.let {
            with(it.profileDAO()) {
                Log.e(javaClass.simpleName, profile.toString())
                insertProfile(profile)
            }
            mInteractorOutput.onFailureSendUser()

        } ?: mInteractorOutput.onErrorSendUser()


    }
}