package com.example.shaadidemoapp

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.shaadidemoapp.databinding.ActivityMainNewBinding

class MainActivityNew : AppCompatActivity() {

    lateinit var binding : ActivityMainNewBinding
    lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main_new)
        context = this@MainActivityNew

        binding.btnAccept.setOnClickListener {

        }
        binding.btnDecline.setOnClickListener {

        }
    }
}