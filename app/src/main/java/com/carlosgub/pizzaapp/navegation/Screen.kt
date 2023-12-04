package com.carlosgub.pizzaapp.navegation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LocalPizza
import androidx.compose.material.icons.outlined.Payments
import androidx.compose.material.icons.outlined.PersonOutline
import androidx.compose.material.icons.outlined.ReceiptLong
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
    val route:String,
    val icon:ImageVector,
    val label:String
) {
    object Home : Screen(
        route = "home",
        icon = Icons.Outlined.Home,
        label = "Home"
    )

    object Payments : Screen(
        route = "payments",
        icon = Icons.Outlined.Payments,
        label = "Payments"
    )

    object History : Screen(
        route = "history",
        icon = Icons.Outlined.ReceiptLong,
        label = "History"
    )

    object Profile : Screen(
        route = "profile",
        icon = Icons.Outlined.PersonOutline,
        label = "Profile"
    )

    object Detail : Screen(
        route = "detail",
        icon = Icons.Outlined.LocalPizza,
        label = "Detail"
    )
}