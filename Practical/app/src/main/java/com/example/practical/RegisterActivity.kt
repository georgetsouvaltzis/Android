package com.example.practical

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.practical.MainActivity.Companion.usernameValues

class RegisterActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        val username = findViewById<EditText>(R.id.InputUsername)
        val firstPassword = findViewById<EditText>(R.id.InputPassword)
        val secondPassword = findViewById<EditText>(R.id.InputPasswordAgain)
        val registerButton = findViewById<Button>(R.id.RegisterButtonFromRegisterActivity)
        val donotMatch = findViewById<TextView>(R.id.passwordOrUserNameDoesntMatch)
        registerButton.setOnClickListener {

            if(username.text.toString() in usernameValues) {
                donotMatch.setText("given username is already registered.")
                donotMatch.visibility = View.VISIBLE
            }
            else if(firstPassword.text.toString() != secondPassword.text.toString()) {
                donotMatch.setText("passwords do not match")
                donotMatch.visibility = View.VISIBLE
            } else {
                usernameValues.put(username.text.toString(),firstPassword.text.toString())
                finish()
            }
        }

    }

}