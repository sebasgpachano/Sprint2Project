package com.example.sprint2.ViewModel

import androidx.lifecycle.ViewModel
import com.example.sprint2.Shapes

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