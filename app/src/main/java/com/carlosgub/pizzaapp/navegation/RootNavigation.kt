package com.carlosgub.pizzaapp.navegation

import android.net.Uri
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LocalPizza
import androidx.compose.material.icons.outlined.Payments
import androidx.compose.material.icons.outlined.PersonOutline
import androidx.compose.material.icons.outlined.ReceiptLong
import androidx.compose.ui.graphics.vector.ImageVector
import com.carlosgub.pizzaapp.model.Pizza
import com.google.gson.Gson

sealed class RootNavigation(
    val route: String
) {
    object Main : RootNavigation(
        route = "home"
    )

    object Detail : RootNavigation(
        route = "detail/{${NavArgs.DetailScreen.key}}"
    ) {
        fun createRoute(pizza: Pizza) =
            "detail/${Uri.encode(Gson().toJson(pizza))}"
    }
}

enum class NavArgs(val key: String) {
    DetailScreen("DetailScreen")
}