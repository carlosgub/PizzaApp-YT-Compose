@file:OptIn(ExperimentalMaterial3Api::class)

package com.carlosgub.pizzaapp.screen

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.carlosgub.pizzaapp.navegation.MainNavigation

@Composable
fun MainScreen(rootNavController: NavHostController) {
    val mainNavController = rememberNavController()
    Scaffold(
        bottomBar = {
            MainBottomBar(
                navController = mainNavController
            )
        }
    ) { paddingValues ->
        NavHost(
            navController = mainNavController,
            startDestination = MainNavigation.Home.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(MainNavigation.Home.route) {
                HomeScreen(
                    rootNavController = rootNavController
                )
            }
            composable(MainNavigation.Payments.route) { PaymentScreen() }
            composable(MainNavigation.History.route) { HistoryScreen() }
            composable(MainNavigation.Profile.route) { ProfileScreen() }
        }
    }
}

@Composable
private fun MainBottomBar(
    navController: NavController,
) {
    var currentRoute by remember { mutableStateOf(MainNavigation.Home.route) }
    NavigationBar(
        containerColor = Color.White
    ) {
        MainBottomBarItem(
            navController = navController,
            rowScope = this,
            screen = MainNavigation.Home,
            currentRoute = currentRoute,
            onItemClicked = {
                currentRoute = MainNavigation.Home.route
            }
        )
        MainBottomBarItem(
            navController = navController,
            rowScope = this,
            screen = MainNavigation.Payments,
            currentRoute = currentRoute,
            onItemClicked = {
                currentRoute = MainNavigation.Payments.route
            }
        )
        MainBottomBarItem(
            navController = navController,
            rowScope = this,
            screen = MainNavigation.History,
            currentRoute = currentRoute,
            onItemClicked = {
                currentRoute = MainNavigation.History.route
            }
        )
        MainBottomBarItem(
            navController = navController,
            rowScope = this,
            screen = MainNavigation.Profile,
            currentRoute = currentRoute,
            onItemClicked = {
                currentRoute = MainNavigation.Profile.route
            }
        )
    }
}

@Composable
private fun MainBottomBarItem(
    navController: NavController,
    rowScope: RowScope,
    screen: MainNavigation,
    currentRoute: String,
    onItemClicked: () -> Unit
) {
    val isSelected = currentRoute == screen.route
    rowScope.NavigationBarItem(
        onClick = {
            if (!isSelected) {
                onItemClicked()
                navController.navigate(screen.route)
            }
        },
        selected = isSelected,
        label = {
            Text(text = screen.label)
        },
        icon = {
            Icon(imageVector = screen.icon, contentDescription = null)
        },
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = Color.Red,
            selectedTextColor = Color.Red,
            unselectedIconColor = Color.Gray,
            unselectedTextColor = Color.Gray,
        )
    )
}