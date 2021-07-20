package com.example.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.motivation.R
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.infra.SecurityPreferences
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mSecurityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()


        mSecurityPreferences = SecurityPreferences(this)
        textName.text = mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)

        buttonNewPhrase.setOnClickListener(this)
        imageAll.setOnClickListener(this)
        imageHappy.setOnClickListener(this)
        imageMorning.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        val id = v.id

        val listFilter = listOf(R.id.imageAll,R.id.imageHappy, R.id.imageMorning )

        if(id == R.id.buttonNewPhrase){
            handleNewPhrase()
        } else if (id in listFilter){
            handleFilter(id)
        }
    }

    private fun handleFilter(id: Int) {

        imageAll.setColorFilter(resources.getColor(R.color.white))
        imageHappy.setColorFilter(resources.getColor(R.color.white))
        imageMorning.setColorFilter(resources.getColor(R.color.white))

        when (id) {
            R.id.imageAll -> {
                imageAll.setColorFilter(resources.getColor(R.color.purple_700))
            }
            R.id.imageHappy -> {
                imageHappy.setColorFilter(resources.getColor(R.color.purple_700))
            }
            R.id.imageMorning -> {
                imageMorning.setColorFilter(resources.getColor(R.color.purple_700))
            }
        }
    }

    private fun handleNewPhrase() {
    }
}