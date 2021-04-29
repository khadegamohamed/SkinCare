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

class MainActivity : AppCompatActivity() {
    lateinit var tv1:TextView
    lateinit var ed1:EditText
    lateinit var  ed2: EditText
    lateinit var btn1:Button
    lateinit var tv2 :TextView
    lateinit var tv3:TextView
    val MIN_PASSWORD_LENGTH = 6;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv1=findViewById(R.id.tv1)
        ed1=findViewById(R.id.ed1)
        ed2=findViewById(R.id.ed2)
        btn1=findViewById(R.id.btn1)
        tv2=findViewById(R.id.tv2)
        tv3=findViewById(R.id.tv3)

        tv3.setOnClickListener(object :View.OnClickListener {
            override fun onClick(v: View?) {
                intent = Intent(this@MainActivity, SignUpActivity::class.java)
                startActivity(intent)
            }
        })

        btn1.setOnClickListener(object :View.OnClickListener {
            override fun onClick(v: View?) {
                if(validateInput1()){
                    val email = ed1.text.toString()
                    val password = ed2.text.toString()
                    Toast.makeText(this@MainActivity,"Login Success",Toast.LENGTH_SHORT).show()
                    // Here you can call you API
                }
            }
        })


    }
    // Checking if the input in form is valid
    fun validateInput1(): Boolean {
        if (ed1.text.toString().equals("")) {
            ed1.setError("Please Enter Email")
            return false
        }
        if (ed2.text.toString().equals("")) {
            ed2.setError("Please Enter Password")
            return false
        }

        // checking the proper email format
        if (!isEmailValid(ed1.text.toString())) {
            ed1.setError("Please Enter Valid Email")
            return false
        }
        if (ed2.text.length < MIN_PASSWORD_LENGTH) {
            ed2.setError("Password Length must be more than " + MIN_PASSWORD_LENGTH + " characters")
            return false
        }
        return true
    }

    fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

}
