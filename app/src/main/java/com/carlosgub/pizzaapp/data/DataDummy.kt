package com.carlosgub.pizzaapp.data

import com.carlosgub.pizzaapp.R
import com.carlosgub.pizzaapp.model.Pizza

class DataDummy{
    companion object{
        fun getTopMenuPizza():List<Pizza>{
            return listOf(
                Pizza(
                    image = R.drawable.pizza_1,
                    name = "Tommato Bacon Cake",
                    category = "Pizza",
                    price = 6.58f
                ),
                Pizza(
                    image = R.drawable.pizza_1,
                    name = "Tommato Bacon Cake",
                    category = "Pizza",
                    price = 6.58f
                ),
                Pizza(
                    image = R.drawable.pizza_1,
                    name = "Tommato Bacon Cake",
                    category = "Pizza",
                    price = 6.58f
                ),
                Pizza(
                    image = R.drawable.pizza_1,
                    name = "Tommato Bacon Cake",
                    category = "Pizza",
                    price = 6.58f
                )
            )
        }
    }
}