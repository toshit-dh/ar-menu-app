package com.example.armenu.model

import com.example.armenu.R

data class Food(
    val name: String,
    val image: Int
)

val FoodList = listOf(
    Food("Burger", R.drawable.burger),
    Food("Pizza", R.drawable.pizza),
    Food("Momos", R.drawable.momos),
    Food("Ramen", R.drawable.ramen),
    Food("Instant", R.drawable.instant)
)