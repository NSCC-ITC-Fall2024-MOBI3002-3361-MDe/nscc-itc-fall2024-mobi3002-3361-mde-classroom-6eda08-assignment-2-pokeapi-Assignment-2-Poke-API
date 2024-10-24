package com.example.pokemonapp.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonapp.retrofit.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PokemonViewModel : ViewModel() {
    private val _r = MutableStateFlow<List<Pokemon>>(emptyList())
    val r: StateFlow<List<Pokemon>> = _r

    init {
        fetchPokemon()
    }
    private fun fetchPokemon(){
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getPokemon()
                _r.value = response.results
            } catch(e: Exception){

            }
        }
    }
}