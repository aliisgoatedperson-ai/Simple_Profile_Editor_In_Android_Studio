package com.example.profilesignup

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity: AppCompatActivity(
) {

    private lateinit var ivProfile:ImageView

    private val pickImage =
        registerForActivityResult(ActivityResultContracts.GetContent()) { Uri ->
            if ( Uri != null) {
                ivProfile.setImageURI(Uri)
            }

        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val tvName = findViewById<TextView>(R.id.tvProfileName)
        val firstName = intent.getStringExtra("FIRST_NAME")
        val LastName = intent.getStringExtra("LAST_NAME")

        ivProfile = findViewById<ImageView>(R.id.ivProfile)

        val Email = intent.getStringExtra("EMAIL")
        val tvEmail = findViewById<TextView>(R.id.tvEmail)
        val btnAddImage = findViewById< ImageButton>(R.id.btnAddPhoto)


        tvName.text = "$firstName $LastName"
        tvEmail.text = "$Email"



        btnAddImage.setOnClickListener {
            pickImage.launch("image/*")
        }


    }
}