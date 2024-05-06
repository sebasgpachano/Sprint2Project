package com.example.sprint2.View

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sprint2.R
import com.example.sprint2.ViewModel.AreaCalculatorViewModel
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
            binding.tvBase.text = "Radio"
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

                if (shape != null) {
                    val base = binding.etBase.text.toString()
                    val height = binding.etHeight.text.toString()
                    val result = areaCalculatorViewModel.shape(shape, base, height)
                    binding.tvResult.text = "El área es $result cm2"
                }
            }
            R.id.btBack -> {
                finish()
            }
        }
    }
}
