package com.example.nagaparkmaster.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class HomeViewModel : ViewModel() {


    private lateinit var auth: FirebaseAuth



    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }

    private val _username_text = MutableLiveData<String>().apply {
        auth = FirebaseAuth.getInstance();

        if(auth.currentUser!=null){
            value = auth.currentUser?.email.toString();
        }

    }
    val text: LiveData<String> = _text
    val username_text: LiveData<String> = _username_text
}