package com.carlosgub.pizzaapp.navegation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LocalPizza
import androidx.compose.material.icons.outlined.Payments
import androidx.compose.material.icons.outlined.PersonOutline
import androidx.compose.material.icons.outlined.ReceiptLong
import androidx.compose.ui.graphics.vector.ImageVector

sealed class MainNavigation(
    val route:String,
    val icon:ImageVector,
    val label:String
) {
    object Home : MainNavigation(
        route = "home",
        icon = Icons.Outlined.Home,
        label = "Home"
    )

    object Payments : MainNavigation(
        route = "payments",
        icon = Icons.Outlined.Payments,
        label = "Payments"
    )

    object History : MainNavigation(
        route = "history",
        icon = Icons.Outlined.ReceiptLong,
        label = "History"
    )

    object Profile : MainNavigation(
        route = "profile",
        icon = Icons.Outlined.PersonOutline,
        label = "Profile"
    )
}