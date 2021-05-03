package com.example.skincare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.os.Handler
import android.util.Patterns
import android.view.View
import android.widget.Toast
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class Activity_Log_In : AppCompatActivity() {
    lateinit var tv1:TextView
    lateinit var ed_email:EditText
    lateinit var  ed_password: EditText
    lateinit var bt_Login:Button
    lateinit var bt_singUp:Button
    val MIN_PASSWORD_LENGTH = 6
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity__log__in)
        tv1=findViewById(R.id.tv1)
        ed_email=findViewById(R.id.ed_email)
        ed_password=findViewById(R.id.ed_password)
        bt_Login=findViewById(R.id.bt_Login)
        bt_singUp=findViewById(R.id.bt_singUp)

        bt_singUp.setOnClickListener(object :View.OnClickListener {
            override fun onClick(v: View?) {
                intent = Intent(this@Activity_Log_In, Activity_Sign_Up::class.java)
                startActivity(intent)
            }
        })

        bt_Login.setOnClickListener(object :View.OnClickListener {
            override fun onClick(v: View?) {
                if(validateInput1()){
                    val email = ed_email.text.toString()
                    val password = ed_password.text.toString()
                    Toast.makeText(this@Activity_Log_In,"Login Success",Toast.LENGTH_SHORT).show()
                    // Here you can call you API
                }
            }
        })


    }
    // Checking if the input in form is valid
    fun validateInput1(): Boolean {
        if (ed_email.text.toString().equals("")) {
            ed_email.setError("Please Enter Email")
            return false
        }
        if (ed_password.text.toString().equals("")) {
            ed_password.setError("Please Enter Password")
            return false
        }

        // checking the proper email format
        if (!isEmailValid(ed_email.text.toString())) {
            ed_email.setError("Please Enter Valid Email")
            return false
        }
        if (ed_password.text.length < MIN_PASSWORD_LENGTH) {
            ed_password.setError("Password Length must be more than " + MIN_PASSWORD_LENGTH + " characters")
            return false
        }
        return true
    }

    fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

}
