package com.example.pokemonapi.di

import PokeAPI
import com.example.pokemonapi.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    const val BASE_URL = "https://pokeapi.co/api/v2/"

    @Singleton
    @Provides
    fun providePokemonRepository(
        api: PokeAPI,
    ) = PokemonRepository(api) as PokemonRepository

    @Singleton
    @Provides
    fun providePokeApi(): PokeAPI {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(PokeAPI::class.java)
    }
}