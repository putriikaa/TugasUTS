package com.example.tugasuts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tugasuts.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val TAG = "MainActivityLifecycle"

    companion object {
        const val EXTRA_USERNAME = "extra_username"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            loginButton.setOnClickListener {
                val enteredUsername = username.text.toString()
                val enteredPassword = password.text.toString()

                if (enteredUsername == "nanda" && enteredPassword == "1234") {
                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    intent.putExtra(EXTRA_USERNAME, username.text.toString())
                    startActivity(intent)
                }else{
                    val toastMessage = "Username atau password salah"
                    Toast.makeText(this@LoginActivity, toastMessage, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
