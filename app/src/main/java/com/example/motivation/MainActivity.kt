package com.example.motivation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.motivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Esconder a barra de suporte
        supportActionBar?.hide()

        //eventos
        binding.buttonNewPhrase.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.button_new_phrase) {

        }
    }


}