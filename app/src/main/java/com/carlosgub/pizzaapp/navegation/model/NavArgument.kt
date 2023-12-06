package com.carlosgub.pizzaapp.navegation.model

import androidx.navigation.NavType
import androidx.navigation.navArgument

object NavArgument {
    fun nullable(
        name: String,
        type: NavType<*>
    ) = navArgument(name) {
        this.type = type
        this.nullable = true
    }

    fun notNullable(
        name: String,
        type: NavType<*>,
        defaultValue: Any
    ) = navArgument(name) {
        this.type = type
        this.nullable = false
        this.defaultValue = defaultValue
    }
}