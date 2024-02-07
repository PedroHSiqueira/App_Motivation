package com.example.motivation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.motivation.databinding.ActivityMainBinding
import com.example.motivation.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.buttonSaveName.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.button_save_name) {
            handleSave()
        }
    }

    private fun handleSave() {
        val username = binding.editName.text.toString()
        val validationText = R.string.validation_mandatory_name

        if (username != "") {
            SecurityPreferences(this).storeString("USER_NAME", username)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        } else {
            Toast.makeText(this, validationText, Toast.LENGTH_SHORT).show()
        }
    }
}