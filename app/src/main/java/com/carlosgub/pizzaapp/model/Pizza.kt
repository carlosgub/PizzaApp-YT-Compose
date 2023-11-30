package com.carlosgub.pizzaapp.model

import androidx.annotation.DrawableRes

data class Pizza(
    @DrawableRes val image: Int,
    val name: String,
    val category: String,
    val price: Float
)