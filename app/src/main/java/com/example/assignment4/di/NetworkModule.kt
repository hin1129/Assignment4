package com.example.assignment4.di

import com.example.assignment4.rest.JokeApi
import com.example.assignment4.rest.JokeRepository
import com.example.assignment4.rest.JokeRepositoryImpl
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    fun providesRetrofitService(okHttpClient:OkHttpClient, gson:Gson) :JokeApi{
        return Retrofit.Builder()
            .baseUrl(JokeApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())  //observables
            .client(okHttpClient)
            .build()
            .create(JokeApi::class.java)
    }

    @Provides
    fun providesOkHttpClient(loggingInterceptor:HttpLoggingInterceptor
    ) :OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(30,TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30,TimeUnit.SECONDS)
            .build()
    }

    @Provides
    fun providesLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Provides
    fun providesGson () = Gson()


    @Provides
    fun providesJokeRepository(jokeApi: JokeApi) :JokeRepository{
        return JokeRepositoryImpl(jokeApi)
    }
}