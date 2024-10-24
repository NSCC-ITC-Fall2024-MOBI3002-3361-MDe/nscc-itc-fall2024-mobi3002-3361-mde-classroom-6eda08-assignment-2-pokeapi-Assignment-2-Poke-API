package com.example.pokemonapp.retrofit

import com.example.pokemonapp.models.PokemonResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface Api {
    @GET("pokemon/ditto")
    suspend fun getPokemon(): PokemonResponse
}
object RetrofitInstance{
    val api: Api by lazy {
        Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
    }
}

//TODO
//I need to figure out how to call and search as well.