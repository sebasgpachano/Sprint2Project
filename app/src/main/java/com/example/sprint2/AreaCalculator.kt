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

        shapeType()
        configClickListener()
    }

    fun shapeType() {
        val shape = intent.getStringExtra("shape")

        if(shape != null) {
            when(shape){
                "circle" -> {
                    binding.tvBase.text = "Radius"
                    binding.tvHeight.visibility = View.INVISIBLE
                    binding.etHeight.visibility = View.INVISIBLE
                }
                

            }
        }
    }

    private fun configClickListener() {
        binding.btCalculate.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if(binding.tvBase.text == "Radius"){
            if(binding.etBase.text.isNotEmpty()){
                val radius = binding.etBase.text.toString()
                val result = areaCalculatorViewModel.getCircle(radius)
                binding.tvResult.text = "El área del círculo es $result"
            } else{
                Toast.makeText(this, "Pon un número", Toast.LENGTH_SHORT).show()
            }

        }
    }


}