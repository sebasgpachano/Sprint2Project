package com.example.sprint2

import androidx.lifecycle.ViewModel

class AreaCalculatorViewModel: ViewModel() {

    fun getCircle(radius: String): Int {
        val area = radius.toInt()
        val pi = 3.14
        val result = pi * area * area

        return result.toInt()
    }
    fun getSquare(base: String, height: String): Int {
        val result = base.toInt() * height.toInt()

        return result
    }
    fun getTriangle(base: String, height: String) :Int {
        val result = (base.toInt() * height.toInt()) /2

        return result
    }

    fun shape(shape: String, base: String, height: String): Int {
        var result = 0
            when (shape) {
                "circle" -> {
                    if(base.isNotEmpty()){
                        result = getCircle(base)
                    }
                }
                "square" -> {
                    if(base.isNotEmpty() && height.isNotEmpty()){
                        result = getSquare(base, height)
                    }
                }
                "triangle" -> {
                    if(base.isNotEmpty() && height.isNotEmpty()){
                        result = getTriangle(base, height)
                    }
                }
            }

        return result
    }
}