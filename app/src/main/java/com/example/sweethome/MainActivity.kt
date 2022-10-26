package com.example.sweethome

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private var editUsername: EditText?= null
    private var editPassword : EditText?=null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editUsername = findViewById(R.id.editUserName)
        editPassword = findViewById(R.id.editPassword)

        val btnRegister = findViewById<Button>(R.id.btnRegister)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        fun onLogin(botonLogin: View){
            if(editUsername!!.text.toString() == "kkk@gmail.com" && editPassword!!.text.toString() == "#Kim1297") {
                val intent = Intent(this, WelcomeActivity::class.java)
                startActivity(intent)
            }else{
                val dialog = AlertDialog.Builder(this).setTitle("ERROR!!").setMessage("@string/errorText").create().show()
            }
        }

        btnRegister?.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

    }
}