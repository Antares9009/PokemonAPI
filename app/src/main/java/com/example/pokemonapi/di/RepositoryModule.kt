package com.example.pokemonapi.di

import com.example.pokemonapi.network.PokemonRepository
import com.example.pokemonapi.network.IPokemonRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule{

    @Binds
    abstract fun provideRepository(
        repository: PokemonRepository
    ): IPokemonRepository
}