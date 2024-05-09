package com.example.sprint2

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(), Shapes{

    override fun getCircle(): String {
        return "circle"
    }
    override fun getSquare(): String{
        return "square"
    }
    override fun getTriangle(): String{
        return "triangle"
    }

}