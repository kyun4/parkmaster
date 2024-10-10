package com.example.nagaparkmaster.ui.account

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AccountViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Account Profile Fragment"
    }
    val text: LiveData<String> = _text
}