package com.example.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.motivation.infrestructure.MotivationConstants
import com.example.motivation.R
import com.example.motivation.infrestructure.SecurityPreferences
import com.example.motivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Esconder a barra de suporte
        supportActionBar?.hide()

        handleUserName()

        //eventos
        binding.buttonNewPhrase.setOnClickListener(this)
    }

    private fun handleUserName() {
        val name = SecurityPreferences(this).getString(MotivationConstants.Key.USER_NAME)

        binding.textUserName.text = "Olá, $name!"
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.button_new_phrase) {

        }
    }


}