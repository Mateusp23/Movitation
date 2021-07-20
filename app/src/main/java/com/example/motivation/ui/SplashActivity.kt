package com.example.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.motivation.R
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.infra.SecurityPreferences
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mSecurityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar!!.hide()

        mSecurityPreferences = SecurityPreferences(this)

        button_save.setOnClickListener(this)

        verifyName()
    }

    override fun onClick(v: View?) {
        val id = v?.id
        if(id == R.id.button_save){
            handleSave()
        }
    }

    private fun verifyName() {
        val name = mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)
        if(name != ""){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    private fun handleSave() {
        val name = editName.text.toString()

        if( name != "") {
            mSecurityPreferences.storeString(MotivationConstants.KEY.PERSON_NAME, name)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        } else {
            Toast.makeText(applicationContext, "Preencha o campo com seu nome", Toast.LENGTH_SHORT).show()
        }
    }
}