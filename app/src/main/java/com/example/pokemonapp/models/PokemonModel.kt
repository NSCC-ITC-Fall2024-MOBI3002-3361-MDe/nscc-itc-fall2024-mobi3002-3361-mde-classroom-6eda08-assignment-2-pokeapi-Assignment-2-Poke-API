package com.example.pokemonapp.models

data class Pokemon(
//    val front_default: String,
    val name: String,
    val weight: Int,
    val height: Int,
//    val types: List<String>
)

data class PokemonResponse(
    val results: List<Pokemon>
)

//TODO
//I hate nested data