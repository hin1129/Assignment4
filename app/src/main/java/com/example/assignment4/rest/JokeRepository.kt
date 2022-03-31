package com.example.assignment4.rest

import com.example.assignment4.model.Jokes
import io.reactivex.Single
import retrofit2.Response
import javax.inject.Singleton

interface JokeRepository{
    suspend fun getRandomJoke() : Response<Jokes>
    suspend fun getSpecificJoke(firstName:String, lastName:String) :Response<Jokes>
    suspend fun getRandomJokes(number:Int) :Response<Jokes>
}

class JokeRepositoryImpl (private val jokeApi:JokeApi) :JokeRepository{
    override suspend fun getRandomJoke() : Response<Jokes>{
        return jokeApi.getRandomJoke()
    }

    override suspend fun getSpecificJoke(firstName:String, lastName:String) : Response<Jokes>{
        return jokeApi.getSpecificJoke(firstName=firstName, lastName=lastName)
    }

    override suspend fun getRandomJokes(number:Int) : Response<Jokes>{
        return jokeApi.getRandomJokes(number=number)
    }
}