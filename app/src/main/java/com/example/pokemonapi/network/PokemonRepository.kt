package com.example.pokemonapi.network

import com.example.pokemonapi.data.PokeResponse
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val api: PokeAPI) : IPokemonRepository  {

    override suspend fun getPokeList(): PokeResponse {
        return api.getPokeList()
    }

}