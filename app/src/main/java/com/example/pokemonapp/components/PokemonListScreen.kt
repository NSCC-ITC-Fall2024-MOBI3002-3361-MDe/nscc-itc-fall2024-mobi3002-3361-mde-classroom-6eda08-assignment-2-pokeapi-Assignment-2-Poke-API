package com.example.pokemonapp.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pokemonapp.models.PokemonViewModel
import java.util.Locale

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonScreen(pokemonViewModel: PokemonViewModel = viewModel()) {
    val pokemon by pokemonViewModel.pokemon.collectAsState()
    Column {
//        Banner()
    InputField(pokemonViewModel)
    pokemon?.let {
        Text(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth(),
            text = it.name,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontSize = 24.sp
        )
//        Text(
//            modifier = Modifier
//                .padding(top = 8.dp)
//                .fillMaxWidth(),
//            text = "Types: "+(it.types.joinToString("-"){ it.toString() }.takeWhile { it.isDigit() }),
//            fontWeight = FontWeight.Bold,
//            textAlign = TextAlign.Center,
//            fontSize = 24.sp
//        )
        Text(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth(),
            text = "Height: "+it.height.toString()+"ft",
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontSize = 24.sp
        )
    }
//                Text(
//                    modifier = Modifier
//                        .padding(top = 8.dp)
//                        .fillMaxWidth(),
//                    text = "Weight: "+pokemon.weight.toString()+"lbs",
//                    fontWeight = FontWeight.Bold,
//                    textAlign = TextAlign.Center,
//                    fontSize = 24.sp
//                )
    }
}
//    Scaffold(
//        topBar = {
//            TopAppBar(title = { Text("Pokemon") })
//        }
//    ){ innerPadding ->
//        Column(
//            modifier = Modifier.padding(innerPadding),
//            verticalArrangement = Arrangement.spacedBy(8.dp)
//        ) {
//            InputField(pokemonViewModel)
//            Content(pokemon)
//        }
//    }
//}
//@Composable
//private fun Content(pokemon: Pokemon?) {
//    if (pokemon == null) {
//        CircularProgressIndicator()
//    } else {
//        Box(
//            modifier = Modifier.fillMaxSize(),
//            contentAlignment = Alignment.Center
//        ) {
//            Column(
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ){
//                val spriteUrl = pokemon.sprite?.imageURL
//                if (spriteUrl != null) {
//                    PokemonSprite(url = spriteUrl)
//                } else {
//                    Text("No image available")
//                }
//                Text(
//                    modifier = Modifier
//                        .padding(top = 8.dp)
//                        .fillMaxWidth(),
//                    text = pokemon.name,
//                    fontWeight = FontWeight.Bold,
//                    textAlign = TextAlign.Center,
//                    fontSize = 24.sp
//                )
//                Text(
//                    modifier = Modifier
//                        .padding(top = 8.dp)
//                        .fillMaxWidth(),
//                    text = "Types: "+(pokemon.types.joinToString("-"){ it.toString() }.takeWhile { it.isDigit() }),
//                    fontWeight = FontWeight.Bold,
//                    textAlign = TextAlign.Center,
//                    fontSize = 24.sp
//                )
//                Text(
//                    modifier = Modifier
//                        .padding(top = 8.dp)
//                        .fillMaxWidth(),
//                    text = "Height: "+pokemon.height.toString()+"ft",
//                    fontWeight = FontWeight.Bold,
//                    textAlign = TextAlign.Center,
//                    fontSize = 24.sp
//                )
//                Text(
//                    modifier = Modifier
//                        .padding(top = 8.dp)
//                        .fillMaxWidth(),
//                    text = "Weight: "+pokemon.weight.toString()+"lbs",
//                    fontWeight = FontWeight.Bold,
//                    textAlign = TextAlign.Center,
//                    fontSize = 24.sp
//                )
//            }
//        }
//    }
//}
//@Composable
//fun Banner(i){
//    Image(
//        painter = painterResource(),
//        contentDescription = "Pokemon"
//    )
//}
@Composable
fun InputField(pokemonViewModel: PokemonViewModel) {

    val inputText = remember {
        mutableStateOf("")
    }
    Row(
        modifier = Modifier.padding(4.dp)
    ) {
        OutlinedTextField(
            value = inputText.value,
            onValueChange = { inputText.value = it },
            label = {
                Text("Search")
            }
        )
        Button(onClick = {
            if (inputText.value != "") pokemonViewModel.fetchPokemon(
                inputText.value.lowercase(
                    Locale.getDefault()
                )
            )
        }) { Text("GO") } //.lowercase so I dont have to do only lower case characters to search
    }
}
//@Composable
//private fun PokemonSprite(url: String) {
//    val painter = rememberAsyncImagePainter(url)
//    Image(
//        painter = painter,
//        contentDescription = "",
//    )
//}
//TODO
//Pokemon banner, search bar, go button