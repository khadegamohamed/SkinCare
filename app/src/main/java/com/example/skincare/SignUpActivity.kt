package com.example.skincare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {
    lateinit var etFirstName: EditText
    lateinit var etLastName:EditText
    lateinit var etEmail: EditText
    lateinit var etPassword:EditText
    lateinit var etRepeatPassword:EditText
    lateinit var etCity:EditText
    val MIN_PASSWORD_LENGTH = 6;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        viewInitializations()
    }

    fun viewInitializations() {
        etFirstName = findViewById(R.id.et_first_name)
        etLastName = findViewById(R.id.et_last_name)
        etEmail = findViewById(R.id.et_email)
        etPassword = findViewById(R.id.et_password)
        etRepeatPassword = findViewById(R.id.et_repeat_password)
        etCity = findViewById(R.id.et_city)
        // To show back button in actionbar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    // Checking if the input in form is valid
    fun validateInput(): Boolean {
        if (etFirstName.text.toString().equals("")) {
            etFirstName.setError("Please Enter First Name")
            return false
        }
        if (etLastName.text.toString().equals("")) {
            etLastName.setError("Please Enter Last Name")
            return false
        }
        if (etEmail.text.toString().equals("")) {
            etEmail.setError("Please Enter Email")
            return false
        }
        if (etCity.text.toString().equals("")) {
            etCity.setError("Please Enter City")
            return false
        }
        if (etPassword.text.toString().equals("")) {
            etPassword.setError("Please Enter Password")
            return false
        }
        if (etRepeatPassword.text.toString().equals("")) {
            etRepeatPassword.setError("Please Enter Repeat Password")
            return false
        }

        // checking the proper email format
        if (!isEmailValid(etEmail.text.toString())) {
            etEmail.setError("Please Enter Valid Email")
            return false
        }

        // checking minimum password Length
        if (etPassword.text.length < MIN_PASSWORD_LENGTH) {
            etPassword.setError("Password Length must be more than " + MIN_PASSWORD_LENGTH + " characters")
            return false
        }

        // Checking if repeat password is same
        if (!etPassword.text.toString().equals(etRepeatPassword.text.toString())) {
            etRepeatPassword.setError("Password does not match")
            return false
        }
        return true
    }

    fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    // Hook Click Event

    fun performSignUp (view: View) {
        if (validateInput()) {

            // Input is valid, here send data to your server

            val firstName = etFirstName.text.toString()
            val lastName = etLastName.text.toString()
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            val repeatPassword = etRepeatPassword.text.toString()

            Toast.makeText(this,"Login Success",Toast.LENGTH_SHORT).show()
            // Here you can call you API

        }
    }

}