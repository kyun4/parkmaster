package com.example.nagaparkmaster

import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.FirebaseApp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        FirebaseApp.initializeApp(this);
        //addDataToFirebase()

        val btn = findViewById<Button>(R.id.buttonSignIn);
        val text_signup = findViewById<TextView>(R.id.textView_create_account);

        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics);

        val textview_signup_params = text_signup.layoutParams
        textview_signup_params.width = displayMetrics.widthPixels/7;

        btn.setOnClickListener {

            val intent = Intent(this, MainMenu::class.java);
            startActivity(intent);

        }

        text_signup.setOnClickListener {
            val intent = Intent(this, SignUp::class.java);
            startActivity(intent);
        }

    }

    fun addDataToFirebase(){


//
//        val database: FirebaseDatabase = FirebaseDatabase.getInstance()
//        val myRef: DatabaseReference = database.getReference("/object_detection/object_detected_id_1/current_object/")
//
//
//        myRef.setValue("wall")
//
//        myRef.addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                val value = dataSnapshot.getValue(String::class.java)
//                println("Value from Firebase: $value")
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                println("Failed to read value: ${error.toException()}")
//            }
//        })

    } // addToFirebase

}