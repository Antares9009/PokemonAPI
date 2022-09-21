package com.example.pokemonapi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokemonapi.R
import com.example.pokemonapi.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<PokemonViewModel>()
    private val pokeAdapter = PokeAdapter(mutableListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewModels()
        initViews()
        initObservers()
    }

    private fun initViews(){
        binding.rvPokemon.apply {
            adapter = pokeAdapter
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }
    }

    private fun initViewModels() {
        viewModel.getPokeList()
    }

    private fun initObservers(){
        viewModel.pokeResponse.observe(this){ response ->
            pokeAdapter.updatePokemonList(response.results.filter { result ->
                result.name.startsWith("b")
            })
        }
    }
}