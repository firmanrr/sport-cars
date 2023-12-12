package com.example.finaldicoding

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.widget.TextView
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SignInActivity : AppCompatActivity() {
    private lateinit var correctEmail: String
    private lateinit var correctPassword: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        val tvRegister = findViewById<TextView>(R.id.tv_signup)
        tvRegister.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        val btnLogin = findViewById<Button>(R.id.btn_signin)
        btnLogin.setOnClickListener {
            val emailEditText = findViewById<EditText>(R.id.emailFill)
            val passwordEditText = findViewById<EditText>(R.id.passwordFill)
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            val sharedPreferences = getSharedPreferences("registration_data", MODE_PRIVATE)
            correctEmail = sharedPreferences.getString("signUpEmail", "").toString()
            correctPassword = sharedPreferences.getString("signUpPassword", "").toString()

            checkLogin(email, password)
        }
    }

    private fun checkLogin(email: String, password: String) {
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter both email and password", Toast.LENGTH_SHORT).show()
        } else if (email == correctEmail && password == correctPassword) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Incorrect email or password", Toast.LENGTH_SHORT).show()
        }
    }
}