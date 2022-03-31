package com.example.assignment4.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment4.rest.JokeRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class JokeViewModel (private val jokeRepository: JokeRepository,
                     private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO)
    : ViewModel(){

    //read+write, update UI
    private val _theJoke :MutableLiveData<JokeState> = MutableLiveData(JokeState.LOADING)
    //read, observe state in fragment/activity
    val theJoke :LiveData<JokeState> get() = _theJoke

    fun getRandomJoke(){
        viewModelScope.launch(ioDispatcher){
            //display loading state
            _theJoke.postValue(JokeState.LOADING)
            //check state
            try {
                val response = jokeRepository.getRandomJoke()
                if (response.isSuccessful){
                    response.body() ?.let{
                        _theJoke.postValue(JokeState.SUCCESS(it))  //body not null
                    } ?: throw Exception("no response")  //body is null
                }
                else{
                    throw Exception("no response")
                }
            }
            catch (exception:Exception){
                _theJoke.postValue(JokeState.ERROR(exception))
            }
        }
    }

    fun getSpecificJoke(firstName:String, lastName:String){
        viewModelScope.launch(ioDispatcher){
            _theJoke.postValue(JokeState.LOADING)
            try{
                val response2 = jokeRepository.getSpecificJoke(firstName,lastName)
                if(response2.isSuccessful){
                    response2.body() ?.let {
                        _theJoke.postValue(JokeState.SUCCESS(it))
                    } ?: throw Exception("no response")
                }
                else{ throw Exception("no response") }
            }
            catch (exception:Exception){
                _theJoke.postValue(JokeState.ERROR(exception))
            }
        }
    }

    fun getRandomJokes(number:Int){
        viewModelScope.launch(ioDispatcher){
            val response3 = jokeRepository.getRandomJokes(number)
            try{
                if(response3.isSuccessful){
                    response3.body() ?.let {
                        _theJoke.postValue(JokeState.SUCCESS(it))
                    } ?: throw Exception("no response")
                } else{ throw Exception("no response") }
            }
            catch (exception:java.lang.Exception){
                _theJoke.postValue(JokeState.ERROR(exception))
            }
        }
    }

}