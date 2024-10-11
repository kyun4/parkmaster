package com.example.nagaparkmaster

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ForgotPassword : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_forgot_password)

        FirebaseApp.initializeApp(this);
        auth = FirebaseAuth.getInstance();


        var email_input = "";

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imageview_back = findViewById<ImageView>(R.id.imageView_back_forgot_password);
        val button_send_email = findViewById<Button>(R.id.buttonSendEmailForPasswordReset);
        val edittext_email = findViewById<EditText>(R.id.et_email_reset_password);

        imageview_back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java);
            startActivity(intent);
        }



            button_send_email.setOnClickListener {

                var error_messages = "";

                if(edittext_email.text.toString().isEmpty()){
                    error_messages += "Please specify your last registered e-mail\n";
                }else{
                    email_input = edittext_email.text.toString();

                }

                if(!Patterns.EMAIL_ADDRESS.matcher(email_input).matches()){
                    error_messages += "Invalid Email Address Format\n";
                }

                if(error_messages.equals("")){
                    error_messages += getAllUsers(email_input);
                }

                if(error_messages.equals("")){
                    button_send_email.setOnClickListener {


                        Toast.makeText(this, "Reset Password Link sent to your E-mail\nYou may check now to reset your password!", Toast.LENGTH_LONG).show();
                        val intent = Intent(this, MainActivity::class.java);
                        startActivity(intent);

                        edittext_email.setText("");

                    }
                }else{
                    Toast.makeText(this, error_messages.trim(),Toast.LENGTH_LONG).show();
                }

            }



    }

    fun getAllUsers(email: String): String{


        var error_messages = "";

        val users_list =  mutableListOf<UsersClass>();

        var found_count: Int = 0;

        val database: DatabaseReference;

        database = FirebaseDatabase.getInstance().getReference("/users/");

        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {


                var objects =snapshot.children.mapNotNull { child->
                    child.getValue(UsersClass::class.java);
                }

                for (dataRecord in objects){

                    users_list.add(dataRecord);

                }

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(baseContext,"Checking Existing Users Cancelled\nDetails: "+error.message.toString(),Toast.LENGTH_LONG).show();
            }
        })

        for(users_item in users_list){
            if(users_item.email.equals(email)){
                found_count+=1;
            }
        }

        if(found_count > 0)
        {

        }else{
            error_messages += "Email Address not Register on this App\nYou may Sign-Up first to continue";
        }

        if(email.trim().equals("") || email.trim().isEmpty()){
            error_messages = "";
        }

        return error_messages;

        //users_list.add(UsersClass("","","","","","","","","",""));

    }
}