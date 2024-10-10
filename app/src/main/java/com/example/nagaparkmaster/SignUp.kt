package com.example.nagaparkmaster

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up);


        val img_back = findViewById<ImageView>(R.id.imageView_back);
        val textview_login = findViewById<TextView>(R.id.textView_login);

        img_back.setOnClickListener {
            val intent= Intent(this, MainActivity::class.java);
            startActivity(intent);
        }
        textview_login.setOnClickListener {
            val intent= Intent(this, MainActivity::class.java);
            startActivity(intent);
        }
    }
}