package com.example.nagaparkmaster.ui.parking_history

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ParkingHistoryViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Parking History Fragment"
    }
    val text: LiveData<String> = _text
}