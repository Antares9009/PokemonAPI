package com.example.pokemonapi.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonapi.data.PokeResponse
import com.example.pokemonapi.di.IoDispatcher
import com.example.pokemonapi.network.IPokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val repository: IPokemonRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _pokeResponse: MutableLiveData<PokeResponse> = MutableLiveData()
    val pokeResponse : LiveData<PokeResponse>
        get() = _pokeResponse

    fun getPokeList() {
        viewModelScope.launch(ioDispatcher){
            _pokeResponse.postValue(repository.getPokeList())
        }
    }

    //function should update pokeList LiveData
    //unit test for viewmodel
    //a.agnihotri@wgu.edu

}