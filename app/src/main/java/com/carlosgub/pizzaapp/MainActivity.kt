@file:OptIn(ExperimentalMaterial3Api::class)

package com.carlosgub.pizzaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.carlosgub.pizzaapp.navegation.Screen
import com.carlosgub.pizzaapp.screen.DetailScreen
import com.carlosgub.pizzaapp.screen.HistoryScreen
import com.carlosgub.pizzaapp.screen.HomeScreen
import com.carlosgub.pizzaapp.screen.PaymentScreen
import com.carlosgub.pizzaapp.screen.ProfileScreen
import com.carlosgub.pizzaapp.ui.theme.PizzaAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            PizzaAppTheme {
                Scaffold(
                    bottomBar = {
                        MainBottomBar(
                            navController = navController
                        )
                    }
                ) { paddingValues ->
                    NavHost(
                        navController = navController,
                        startDestination = Screen.Home.route,
                        modifier = Modifier.padding(paddingValues)
                    ) {
                        composable(Screen.Home.route) { HomeScreen(navController = navController) }
                        composable(Screen.Payments.route) { PaymentScreen() }
                        composable(Screen.History.route) { HistoryScreen() }
                        composable(Screen.Profile.route) { ProfileScreen() }
                        composable(Screen.Detail.route) { DetailScreen() }
                    }
                }
            }
        }
    }
}

@Composable
private fun MainBottomBar(
    navController: NavController,
) {
    var currentRoute by remember { mutableStateOf(Screen.Home.route) }
    NavigationBar(
        containerColor = Color.White
    ) {
        MainBottomBarItem(
            navController = navController,
            rowScope = this,
            screen = Screen.Home,
            currentRoute = currentRoute,
            onItemClicked = {
                currentRoute = Screen.Home.route
            }
        )
        MainBottomBarItem(
            navController = navController,
            rowScope = this,
            screen = Screen.Payments,
            currentRoute = currentRoute,
            onItemClicked = {
                currentRoute = Screen.Payments.route
            }
        )
        MainBottomBarItem(
            navController = navController,
            rowScope = this,
            screen = Screen.History,
            currentRoute = currentRoute,
            onItemClicked = {
                currentRoute = Screen.History.route
            }
        )
        MainBottomBarItem(
            navController = navController,
            rowScope = this,
            screen = Screen.Profile,
            currentRoute = currentRoute,
            onItemClicked = {
                currentRoute = Screen.Profile.route
            }
        )
    }
}

@Composable
private fun MainBottomBarItem(
    navController: NavController,
    rowScope: RowScope,
    screen: Screen,
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