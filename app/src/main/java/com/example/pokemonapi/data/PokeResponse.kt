package com.example.pokemonapi.data

data class PokeResponse(
    val count: Int,
    val next: Any,
    val previous: Any,
    val results: List<Result>
)

data class Result(
    val name: String,
    val url: String
)