package com.example.sweethome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

class RegisterActivity : AppCompatActivity() {

    private var userName : EditText? = null
    private var userLastName : EditText? = null
    private var nit : EditText? = null
    private var phone : EditText? = null
    private var email : EditText? = null
    private var editPassword : TextInputEditText?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        userName = findViewById(R.id.userName)
        userLastName = findViewById(R.id.userLastName)
        nit = findViewById(R.id.nit)
        phone = findViewById(R.id.phone)
        email = findViewById(R.id.email)
        editPassword = findViewById(R.id.editPassword)

        val btnRegister = findViewById<Button>(R.id.btnRegister)
        val link_to_login = findViewById<TextView>(R.id.link_to_login)

        link_to_login?.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        btnRegister?.setOnClickListener{
            val intent = Intent(this, WelcomeActivity ::class.java)
            startActivity(intent)
        }
    }
}