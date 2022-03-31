package com.example.assignment4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.assignment4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        setContentView(binding.root)

        JokeApp.jokeComponent.inject(this) //handle @component dependency operations
    }
}