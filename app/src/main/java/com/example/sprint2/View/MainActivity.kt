package com.example.sprint2.View

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sprint2.R
import com.example.sprint2.ViewModel.MainViewModel
import com.example.sprint2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        configClickListener()
    }

    private fun configClickListener() {
        binding.circle.setOnClickListener(this)
        binding.square.setOnClickListener(this)
        binding.triangle.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        val intent = Intent(this, AreaCalculator::class.java)

        when (view?.id) {
            R.id.circle -> {
                val shape = mainViewModel.getCircle()
                intent.putExtra("shape", shape)
                startActivity(intent)
            }

            R.id.square -> {
                val shape = mainViewModel.getSquare()
                intent.putExtra("shape", shape)
                startActivity(intent)
            }

            R.id.triangle -> {
                val shape = mainViewModel.getTriangle()
                intent.putExtra("shape", shape)
                startActivity(intent)
            }
        }
    }
}