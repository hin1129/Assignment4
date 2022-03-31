package com.example.assignment4

import android.app.Application
import com.example.assignment4.di.ApplicationModule
import com.example.assignment4.di.DaggerJokeComponent
import com.example.assignment4.di.JokeComponent

class JokeApp :Application() {
    override fun onCreate() {
        super.onCreate()

        //initiate di component
        jokeComponent = DaggerJokeComponent
            .builder()
            .applicationModule(ApplicationModule(this)) //pass app context
            .build()
    }

    companion object{
        lateinit var jokeComponent :JokeComponent
    }
}