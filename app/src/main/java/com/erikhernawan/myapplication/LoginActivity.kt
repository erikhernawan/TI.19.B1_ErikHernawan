package com.erikhernawan.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.erikhernawan.myapplication.databinding.ActivityLoginBinding

private lateinit var binding: ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val dataLogin = ModelLogin(
                binding.textPUsername.text.toString(),
                binding.textPUsername.text.toString()
            )
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("data", dataLogin)
            startActivity(intent)
        }
    }
}