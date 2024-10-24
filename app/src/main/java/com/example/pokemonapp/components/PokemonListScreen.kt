package com.example.pokemonapp.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import com.example.pokemonapp.models.Pokemon
import com.example.pokemonapp.models.PokemonViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonListScreen(pokemonViewModel: PokemonViewModel = viewModel()){
    val r by pokemonViewModel.r.collectAsState()
    Scaffold (
        topBar = {
            TopAppBar(title = {Text("Pokemon") })
        }
    ){ innerPadding ->
        LazyColumn (
            modifier = Modifier.padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            items(r) { pokemon ->
                PokemonItem(pokemon)
            }
        }
    }
}

@Composable
fun PokemonItem(pokemon: Pokemon) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
//            AsyncImage(
//                model = pokemon.front_default,
//                contentDescription = pokemon.name,
//            )
            Text(text= "Name: ${pokemon.name}")
//            Text(text= "Types: ${pokemon.types}")
            Text(text= "Weight: ${pokemon.weight}")
            Text(text= "Height: ${pokemon.height}")
        }
    }
}

//TODO
//Pokemon banner, search bar, go button