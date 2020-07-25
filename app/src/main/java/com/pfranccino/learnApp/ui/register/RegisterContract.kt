package com.pfranccino.learnApp.ui.register

import com.google.firebase.auth.FirebaseUser
import com.pfranccino.learnApp.model.Profile

interface RegisterContract {

    interface Interactor {
        fun sendUser(email: String, password: String)
        fun saveProfileUser(profile : Profile)
    }

    interface InteractorOutput{
        fun onErrorSendUser()
        fun onSuccessSendUser(user: FirebaseUser)
        fun onFailureSendUser()
    }

    interface Presenter {
        fun validate(email: String, password: String)
    }


    interface View {
        fun disableButton()
        fun enableErrorColors()
        fun enableButton()
        fun errorMinValues()
    }

    interface Router{
        fun goMain()
    }
}