package com.example.practical

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.graphics.convertTo
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        var usernameValues = mutableMapOf<String,String>("georgetsouvaltzis" to "password")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val usernameEditText = findViewById<EditText>(R.id.username)
        var passwordEditText = findViewById<EditText>(R.id.password)
        val notFoundEditText = findViewById<TextView>(R.id.NotFound)


        val logInButton = findViewById<Button>(R.id.logInButton)
        val registerButton = findViewById<Button>(R.id.registerButton)

        logInButton.setOnClickListener {
            if(usernameEditText.text.toString() in usernameValues && passwordEditText.text.toString() == usernameValues[usernameEditText.text.toString()]) {
                notFoundEditText.visibility = View.INVISIBLE
                val loginIntent = Intent(this,LoginActivity::class.java)
                startActivity(loginIntent)
            } else if(usernameValues[usernameEditText.text.toString()] != passwordEditText.text.toString())
            {
                notFoundEditText.setText("password is incorrect.")
                notFoundEditText.visibility = View.VISIBLE
            }
            else {
                notFoundEditText.visibility = View.VISIBLE
            }
        }
        registerButton.setOnClickListener {
            val registerIntent = Intent(this, RegisterActivity::class.java);
            startActivity(registerIntent)
            notFoundEditText.visibility = View.INVISIBLE

        }



    }

}