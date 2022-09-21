package com.example.pokemonapi.network

import com.example.pokemonapi.data.PokeResponse

interface IPokemonRepository {

    suspend fun getPokeList() : PokeResponse
}