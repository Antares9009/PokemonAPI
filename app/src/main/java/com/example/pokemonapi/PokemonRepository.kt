package com.example.pokemonapi

import PokeAPI
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val api: PokeAPI
)  {


}