package com.example.profilesignup

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnSignUp = findViewById<Button>(R.id.btnSignUp)
        val etFirstName = findViewById<EditText>(R.id.etFirstName)
        val etLastName = findViewById<EditText>(R.id.etLastName)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPass = findViewById<EditText>(R.id.etPass)
        val etPhone = findViewById<EditText>(R.id.etPhone)
        val etAge = findViewById<EditText>(R.id.etAge)

            btnSignUp.setOnClickListener {
                if(etFirstName?.text.toString().trim().isEmpty()||
                    etLastName?.text.toString().trim().isEmpty() ||
                    etEmail?.text.toString().trim().isEmpty() ||
                    etPass?.text.toString().trim().isEmpty() ||
                    etPhone?.text.toString().trim().isEmpty() ||
                    etAge?.text.toString().trim().isEmpty()  ) {

                    Toast.makeText(this, "Please Enter Something !", Toast.LENGTH_SHORT).show()

                } else {
                    Intent(this, ProfileActivity::class.java).also {
                        it.putExtra("FIRST_NAME" , etFirstName.text.toString())
                        it.putExtra("LAST_NAME" , etLastName.text.toString())
                        it.putExtra("EMAIL" , etEmail.text.toString())

                        startActivity(it)
                    }
                }
            }



    }
}