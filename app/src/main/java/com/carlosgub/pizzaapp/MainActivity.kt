@file:OptIn(ExperimentalMaterial3Api::class)

package com.carlosgub.pizzaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.chocolateros.admin.core.navigate.type.ParcelableNavType
import com.carlosgub.pizzaapp.model.Pizza
import com.carlosgub.pizzaapp.navegation.NavArgs
import com.carlosgub.pizzaapp.navegation.RootNavigation
import com.carlosgub.pizzaapp.navegation.model.NavArgument
import com.carlosgub.pizzaapp.screen.DetailScreen
import com.carlosgub.pizzaapp.screen.MainScreen
import com.carlosgub.pizzaapp.ui.theme.PizzaAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val rootNavController = rememberNavController()
            PizzaAppTheme {
                NavHost(
                    navController = rootNavController,
                    startDestination = RootNavigation.Main.route
                ) {
                    composable(
                        RootNavigation.Main.route
                    ) {
                        MainScreen(
                            rootNavController = rootNavController
                        )
                    }
                    composable(
                        RootNavigation.Detail.route,
                        arguments = listOf(
                            NavArgument.nullable(
                                name = NavArgs.DetailScreen.key,
                                type = ParcelableNavType(Pizza::class)
                            )

                        )
                    ) { backStackEntry ->
                        DetailScreen(
                            backStackEntry
                                .arguments?.getParcelable(NavArgs.DetailScreen.key)!!
                        )
                    }
                }
            }
        }
    }
}