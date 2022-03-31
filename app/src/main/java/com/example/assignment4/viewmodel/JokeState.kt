package com.example.assignment4.viewmodel

import android.view.View

//generic interface, app state
sealed interface JokeState{
    object LOADING :JokeState
    class SUCCESS<T> (response:T) :JokeState
    class ERROR(val error:Throwable) :JokeState
}