package com.pfranccino.learnApp.ui.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.pfranccino.learnApp.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(), RegisterContract.View {

    lateinit var mPresenter: RegisterContract.Presenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        mPresenter = RegisterPresenter(this)


        btnSendRegister.setOnClickListener {
            mPresenter.validate(
                inputEmail.text.toString().trim(),
                inputEmail.text.toString().trim()
            )
        }



    }

    override fun disableButton() {
        btnSendRegister.isEnabled = false
    }

    override fun enableErrorColors() {
        TODO("Not yet implemented")
    }

    override fun enableButton() {
        btnSendRegister.isEnabled = true
    }

    override fun errorMinValues() {
        Toast.makeText(this, " Los campos email y password son requeridos ", Toast.LENGTH_LONG)
            .show()
    }
}