package com.example.tuto_kotlin.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel

class CalculatriveViewModel : ViewModel() {

    fun onButtonClick(btn : String)
    {
        Log.i("Button clicked is $btn",btn)
    }

}