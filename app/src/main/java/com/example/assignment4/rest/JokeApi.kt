package com.example.assignment4.rest

import com.example.assignment4.model.Jokes
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface JokeApi {
    //get data from server
    //http://api.icndb.com/jokes/random
    @GET(PATH_RANDOM)
    suspend fun getRandomJoke():Response<Jokes>

    //http://api.icndb.com/jokes/random?firstName=John&lastName=Doe
    @GET(PATH_RANDOM)
    suspend fun getSpecificJoke(
        @Query("firstName") firstName:String ,
        @Query("lastName") lastName:String
    ):Response<Jokes>

    //http://api.icndb.com/jokes/random/<number>
    @GET(PATH_RANDOMS)
    suspend fun getRandomJokes(
        @Path("number") number:Int = NumberOfJokes
    ):Response<Jokes>

    //handle url
    companion object{
        const val BASE_URL = "http://api.icndb.com/"
        private const val PATH_RANDOM = "jokes/random"
        private const val NumberOfJokes = 20
        private const val PATH_RANDOMS = "jokes/random/{<}number}"
    }
}