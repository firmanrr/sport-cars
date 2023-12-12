package com.example.finaldicoding

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.content.Context
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {
    private lateinit var signUpEmail: String
    private lateinit var signUpPassword: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val textToSignIn = findViewById<TextView>(R.id.tv_signin)
        textToSignIn.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }

        val btnSignUp = findViewById<Button>(R.id.btn_signup)
        btnSignUp.setOnClickListener {
            val nameEditText = findViewById<EditText>(R.id.nameFillSignUp)
            val emailEditText = findViewById<EditText>(R.id.emailFillSignUp)
            val passwordEditText = findViewById<EditText>(R.id.passwordFillSignUp)

            if (nameEditText.text.toString().isEmpty() ||
                emailEditText.text.toString().isEmpty() ||
                passwordEditText.text.toString().isEmpty()
            ) {
                showToast("All fields must be filled")
            } else {
                signUpEmail = emailEditText.text.toString()
                signUpPassword = passwordEditText.text.toString()
                saveRegistrationData()

                val intent = Intent(this, SignInActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun saveRegistrationData() {
        val sharedPreferences = getSharedPreferences("registration_data", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        editor.putString("signUpEmail", signUpEmail)
        editor.putString("signUpPassword", signUpPassword)

        editor.apply()
    }

    private fun showToast(message: String) {
        val toast = Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT)
        toast.show()
    }
}