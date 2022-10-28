package com.example.sweethome

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import java.util.regex.Pattern

class RegisterActivity : AppCompatActivity() {

    private var userName : EditText? = null
    private var userLastName : EditText? = null
    private var nit : EditText? = null
    private var phone : EditText? = null
    private var email : EditText? = null
    private var editPassword : TextInputEditText?=null
    private var confirmPassword : TextInputEditText?=null
    private var checKPolicies : CheckBox? = null
    private val text_pattern : Pattern = Pattern.compile("[a-zA-Z]*")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        userName = findViewById(R.id.userName)
        userLastName = findViewById(R.id.userLastName)
        nit = findViewById(R.id.nit)
        phone = findViewById(R.id.phone)
        email = findViewById(R.id.email)
        editPassword = findViewById(R.id.editPassword)
        confirmPassword = findViewById(R.id.confirmPassword)
        checKPolicies = findViewById(R.id.checkPolicies)

        val btnRegister = findViewById<Button>(R.id.btnRegister)
        val link_to_login = findViewById<TextView>(R.id.link_to_login)

        link_to_login?.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }

    fun onRegister(view: View) {
        if(ValidateForm()){
            val intent = Intent(this, NavegationActivity::class.java)
            startActivity(intent)
        }
    }

    fun onCheck(view: View) {
        val btnRegister = findViewById<Button>(R.id.btnRegister)
        if(checKPolicies!!.isChecked) {
            btnRegister.isEnabled = true
            btnRegister.isClickable = true
            btnRegister.setTextColor(Color.BLACK)
            btnRegister.setBackgroundColor(Color.rgb(66,142,146))
        }
        else{
            btnRegister.isEnabled = false
            btnRegister.isClickable = false
            btnRegister.setTextColor(Color.BLACK)
            btnRegister.setBackgroundColor(Color.GRAY)
        }
    }

    private fun ValidateForm() : Boolean {
        var validate: Boolean = true
        val user = userName!!.text.toString()
        val lastName = userLastName!!.text.toString()
        if(TextUtils.isEmpty(user))
        {
            userName!!.error = "@strings/required"
            validate = false
        } else if (!text_pattern.matcher(user.replace(" ", "")).matches()){
            userName!!.error = "Nombre invalido"
            validate = false
        }
        if(TextUtils.isEmpty(lastName))
        {
            userLastName!!.error = "@strings/required"
            validate = false
        } else if (!text_pattern.matcher(lastName.replace(" ", "")).matches()){
            userLastName!!.error = "Apellido invalido"
            validate = false
        }
        if(TextUtils.isEmpty(nit!!.text.toString()))
        {
            nit!!.error = "@strings/required"
            validate = false
        }
        if(TextUtils.isEmpty(phone!!.text.toString()))
        {
            phone!!.error = "@strings/required"
            validate = false
        }
        if(TextUtils.isEmpty(email!!.text.toString()))
        {
            email!!.error = "@strings/required"
            validate = false
        }
        if(TextUtils.isEmpty(editPassword!!.text.toString()))
        {
            editPassword!!.error = "@strings/required"
            validate = false
        }
        if(TextUtils.isEmpty(confirmPassword!!.text.toString()))
        {
            confirmPassword!!.error = "@strings/required"
            validate = false
        }
        return validate
    }
}