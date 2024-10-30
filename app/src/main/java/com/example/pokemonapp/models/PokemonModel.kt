package com.example.pokemonapp.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class Pokemon(
    @SerializedName("name")val name: String,
    @SerializedName("weight")val weight: Int,
    @SerializedName("height")val height: Int,
    @SerializedName("types")val types: List<Type>,
    @SerializedName("sprite")val sprite: Sprite
)
data class Type(
    @SerializedName("name")val name: String
)
data class Sprite(
    @SerializedName("front_default") val imageURL: String
)

//TODO
//I hate nested data