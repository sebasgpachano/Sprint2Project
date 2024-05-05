package com.example.sprint2.ViewModel

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){

    fun getCircle(): String {
        return "circle"
    }
    fun getSquare(): String{
        return "square"
    }
    fun getTriangle(): String{
        return "triangle"
    }

}