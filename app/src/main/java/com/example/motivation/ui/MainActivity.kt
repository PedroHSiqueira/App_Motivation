package com.example.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.motivation.infrestructure.MotivationConstants
import com.example.motivation.R
import com.example.motivation.data.Mock
import com.example.motivation.infrestructure.SecurityPreferences
import com.example.motivation.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var categoryId = MotivationConstants.FILTER.LOOP
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Esconder a barra de suporte
        supportActionBar?.hide()

        //eventos
        listeners()

        //Inicializa
        handleFilter(R.id.image_loop)
        refreshPhrase()
        handleUserName()
    }

    //Trata os eventos de Click
    override fun onClick(v: View?) {
        if (v!!.id == R.id.button_new_phrase) {
            refreshPhrase()
        } else if (v.id in listOf(R.id.image_loop, R.id.image_face, R.id.image_sunny)) {
            handleFilter(v.id)
        }
    }

    //Atribui evento aos elementos
    private fun listeners(){
        binding.buttonNewPhrase.setOnClickListener(this)
        binding.imageLoop.setOnClickListener(this)
        binding.imageFace.setOnClickListener(this)
        binding.imageSunny.setOnClickListener(this)
    }

    //atualiza a frase de motivação
    private fun refreshPhrase() {
        binding.textMiddlePhrase.text = Mock().getPhrase(categoryId, Locale.getDefault().language)
    }
    //Busca o nome do usuario

    private fun handleUserName() {
        val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)
        val greetings = getString(R.string.hello)
        binding.textUserName.text = "$greetings, $name!"
    }

    //Trata o filtro aplicado nas frases
    private fun handleFilter(id: Int) {

        binding.imageLoop.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageFace.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))

        when (id) {
            R.id.image_loop -> {
                binding.imageLoop.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.LOOP
            }

            R.id.image_face -> {
                binding.imageFace.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.FACE
            }

            R.id.image_sunny -> {
                binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.SUNNY
            }
        }
    }
}