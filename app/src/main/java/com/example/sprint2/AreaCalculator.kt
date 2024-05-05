package com.example.sprint2

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sprint2.databinding.ActivityAreaCalculatorBinding

class AreaCalculator : AppCompatActivity(), View.OnClickListener{

    private val areaCalculatorViewModel: AreaCalculatorViewModel by viewModels()
    private lateinit var binding: ActivityAreaCalculatorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAreaCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        circleType()
        configClickListener()
    }

    fun circleType() {
        val shape = intent.getStringExtra("shape")

        if(shape != null && shape == "circle"){
                    binding.tvBase.text = "Radius"
                    binding.tvHeight.visibility = View.INVISIBLE
                    binding.etHeight.visibility = View.INVISIBLE
        }
    }

    private fun configClickListener() {
        binding.btCalculate.setOnClickListener(this)
        binding.btBack.setOnClickListener(this)
    }

    override fun onClick(view: View?) {

        when (view?.id) {
            R.id.btCalculate -> {
                val shape = intent.getStringExtra("shape")
                val toast = "Campo vacío"

                if (shape != null) {
                    val base = binding.etBase.text.toString()
                    val height = binding.etHeight.text.toString()

                    when (shape) {
                        "circle" -> {
                            calculateCircleArea(base, toast)
                        }

                        "square" -> {
                            calculateSquareArea(base, height, toast)

                        }

                        "triangle" -> {
                            calculateTriangleArea(base, height, toast)
                        }
                    }
                }
            }
            R.id.btBack -> {
                finish()
            }
        }

        }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun calculateCircleArea(radius: String, toast: String) {
        if (radius.isNotEmpty()) {
            val result = areaCalculatorViewModel.getCircle(radius)
            binding.tvResult.text = "The area of the circle is $result cm2"
        } else {
            showToast(toast)
        }
    }

    private fun calculateSquareArea(base: String, height: String, toast: String) {
        if (base.isNotEmpty() && height.isNotEmpty()) {
            val result = areaCalculatorViewModel.getSquare(base, height)
            binding.tvResult.text = "The area of the square/rectangle is $result cm2"
        } else {
            showToast(toast)
        }
    }

    private fun calculateTriangleArea(base: String, height: String, toast: String) {
        if (base.isNotEmpty() && height.isNotEmpty()) {
            val result = areaCalculatorViewModel.getTriangle(base, height)
            binding.tvResult.text = "The area of the triangle is $result cm2"
        } else {
            showToast(toast)
        }
    }

}
