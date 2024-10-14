package com.example.nagaparkmaster

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import android.content.Intent as Intent1

class AccountProfile : AppCompatActivity() {

    private lateinit var button_logout: Button
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_account_profile)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        auth = FirebaseAuth.getInstance();

        button_logout = findViewById(R.id.buttonLogout);

        button_logout.setOnClickListener {

            if(auth.currentUser!=null){
                auth.signOut()
            }

            val intent= Intent(this, MainActivity::class.java);
            startActivity(intent);

        }
    }
}