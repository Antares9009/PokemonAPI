package com.example.pokemonapi.network

import com.example.pokemonapi.data.PokeResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PokeAPI {

    @GET("pokemon")
    suspend fun getPokeList(
        @Query("limit") limit: Int = 100000,
        @Query("offset") offset: Int = 0
    ) : PokeResponse
}