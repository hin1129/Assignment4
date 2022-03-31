package com.example.assignment4.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.assignment4.viewmodel.JokeViewModel


open class BaseFragment :Fragment() {
    val jokeViewModel :JokeViewModel by viewModels()
}