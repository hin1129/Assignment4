package com.example.assignment4.di

import android.content.Context
import dagger.Module
import dagger.Provides

//provide dagger content, inject all dependencies when app created
@Module
class ApplicationModule (private val applicationContext:Context){

    @Provides
    fun providesApplicationContext() = applicationContext
}