package com.example.sprint2

import androidx.lifecycle.ViewModel

class AreaCalculatorViewModel: ViewModel() {

    fun getCircle(radius: String): Double{
        val area = radius.toDouble()
        val pi = 3.14
        val result = pi * area * area

        return result
    }
    fun getSquare(base: String, height: String): Int {
        val result = base.toInt() * height.toInt()

        return result
    }
    fun getTriangle(base: String, height: String) :Int {
        val result = (base.toInt() * height.toInt()) /2

        return result
    }
}