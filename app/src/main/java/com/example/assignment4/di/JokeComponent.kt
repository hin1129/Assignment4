package com.example.assignment4.di

import com.example.assignment4.MainActivity
import com.example.assignment4.view.NeverEndingFragment
import com.example.assignment4.view.RandomJokeFragment
import com.example.assignment4.view.TextInputFragment
import dagger.Component

//inject modules to component
@Component(
    modules = [
    NetworkModule::class, ApplicationModule::class
])

//inject modules to classes
interface JokeComponent {
    fun inject (mainActivity: MainActivity)
    fun inject (randomJokeFragment: RandomJokeFragment)
    fun inject (textInputFragment: TextInputFragment)
    fun inject (neverEndingFragment: NeverEndingFragment)
}