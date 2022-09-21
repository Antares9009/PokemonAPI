package com.example.pokemonapi.di

import com.example.pokemonapi.network.PokeAPI
import com.example.pokemonapi.network.PokemonRepository
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
    fun provideRetrofit() : Retrofit {
        return  Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
    }

    @Singleton
    @Provides
    fun providePokeApi(retrofit: Retrofit): PokeAPI = retrofit.create(PokeAPI::class.java)
}