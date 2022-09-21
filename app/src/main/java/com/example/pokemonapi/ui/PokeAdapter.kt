package com.example.pokemonapi.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapi.data.Result
import com.example.pokemonapi.databinding.ItemPokemonBinding
import javax.inject.Inject

class PokeAdapter @Inject constructor(
    private val pokemons : MutableList<Result>
) : RecyclerView.Adapter<PokeAdapter.PokeViewHolder>(){

    inner class PokeViewHolder(private val binding: ItemPokemonBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(pokemon : Result){
            binding.apply {
                tvPokemon.text = pokemon.name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeViewHolder {
        val binding = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PokeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PokeViewHolder, position: Int) {
       holder.bind(pokemons[position])
    }

    override fun getItemCount() = pokemons.size

    fun updatePokemonList(pokeList: List<Result>){
        pokemons.clear()
        pokemons.addAll(pokeList)
        notifyDataSetChanged()
    }
}