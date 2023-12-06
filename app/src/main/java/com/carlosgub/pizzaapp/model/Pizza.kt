package com.carlosgub.pizzaapp.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pizza(
    @DrawableRes val image: Int,
    val name: String,
    val category: String,
    val price: Float
) : Parcelable