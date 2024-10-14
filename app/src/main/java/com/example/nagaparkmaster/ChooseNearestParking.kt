package com.example.nagaparkmaster

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth

class ChooseNearestParking : AppCompatActivity() {



    private lateinit var  auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        auth = FirebaseAuth.getInstance();




        setContentView(R.layout.activity_choose_nearest_parking)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val image_nearest_parking: ImageView = findViewById<ImageView>(R.id.imageView_back_nearest_parking);
        val cardview_parking_one: CardView = findViewById<CardView>(R.id.cardview_parking_one);
        val cardview_parking_two: CardView = findViewById<CardView>(R.id.cardview_parking_two);

        image_nearest_parking.setOnClickListener {
            val intent = Intent(this, MainMenu::class.java)
            startActivity(intent);
        }

        cardview_parking_one.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent);
        }
        cardview_parking_two.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent);
        }
    }
}