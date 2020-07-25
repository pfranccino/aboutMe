package com.pfranccino.learnApp.ui.register

import android.app.Activity
import android.provider.ContactsContract
import android.util.Log
import com.google.firebase.auth.FirebaseUser
import com.pfranccino.learnApp.model.Profile
import com.pfranccino.learnApp.util.AppDataBase

class RegisterPresenter(activity: Activity) : RegisterContract.Presenter,
    RegisterContract.InteractorOutput {

    val mInteractor: RegisterContract.Interactor = RegisterInteractor(this)
    val mView: RegisterContract.View = activity as RegisterContract.View


    override fun onErrorSendUser() {
        mView.enableButton()
        mView.errorMinValues()
    }

    override fun onSuccessSendUser(user: FirebaseUser) {

        val profile = Profile(
            email = user.email.toString(),
            displayName = user.displayName.toString(),
            photoUrl = user.photoUrl.toString()
        )

        mInteractor.saveProfileUser(profile)
    }


    override fun onFailureSendUser() {

    }

    override fun validate(email: String, password: String) {
        mView.disableButton()

        if (email.isEmpty() && password.isEmpty()) {
            mView.errorMinValues()
            mView.enableButton()
        } else mInteractor.sendUser(email, password)
    }

}