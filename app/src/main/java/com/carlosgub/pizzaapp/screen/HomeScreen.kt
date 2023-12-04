@file:OptIn(ExperimentalMaterial3Api::class)

package com.carlosgub.pizzaapp.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.carlosgub.pizzaapp.R
import com.carlosgub.pizzaapp.data.DataDummy
import com.carlosgub.pizzaapp.model.Pizza
import com.carlosgub.pizzaapp.navegation.Screen
import com.carlosgub.pizzaapp.ui.theme.ColorRed
import com.carlosgub.pizzaapp.ui.theme.ColorRose

@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBarHome()
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            PizzaHomeContent(
                onItemClicked = { pizza ->
                    navController.navigate(Screen.Detail.route)
                }
            )
        }
    }
}

@Composable
private fun TopAppBarHome() {
    TopAppBar(
        title = {
            Text(
                text = "MyPizza",
                fontWeight = FontWeight.Bold
            )
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = ColorRed,
            titleContentColor = Color.White,
            actionIconContentColor = Color.White
        ),
        actions = {
            Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .size(32.dp)
            )
        }
    )
}

@Composable
private fun PizzaHomeContent(
    onItemClicked: (Pizza) -> Unit
) {
    PizzaHomeSearch()
    TopMenuHeader()
    TopMenuList(onItemClicked = onItemClicked)
    HotPromoHeader()
    HotPromoContent()
}

@Composable
private fun PizzaHomeSearch() {
    val focusManager = LocalFocusManager.current
    var text by remember { mutableStateOf("") }
    Card(
        shape = RoundedCornerShape(
            bottomEnd = 12.dp,
            bottomStart = 12.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = ColorRed
        ),
        modifier = Modifier.fillMaxWidth()
    ) {
        TextField(
            label = {
                Text("Busca tu pizza favorita")
            },
            value = text,
            onValueChange = { newValue ->
                text = newValue
            },
            maxLines = 1,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Search,
                keyboardType = KeyboardType.Text
            ),
            keyboardActions = KeyboardActions(
                onSearch = { focusManager.clearFocus() }
            ),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                disabledTextColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(8.dp),
            trailingIcon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = null,
                    tint = ColorRed,
                    modifier = Modifier
                        .padding(8.dp)
                        .size(32.dp)
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        )
    }
}

@Composable
private fun TopMenuHeader() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
    ) {
        Text(
            "Top Menu",
            color = ColorRed,
            style = MaterialTheme.typography.titleSmall
        )
        Text(
            "See all",
            color = Color.Gray,
            style = MaterialTheme.typography.titleSmall
        )
    }
}

@Composable
private fun TopMenuList(
    onItemClicked: (Pizza) -> Unit
) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(DataDummy.getTopMenuPizza()) { pizza ->
            TopMenuItem(
                pizza = pizza,
                onItemClicked = onItemClicked
            )
        }
    }
}

@Composable
private fun TopMenuItem(
    pizza: Pizza,
    onItemClicked: (Pizza) -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = ColorRose
        ),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .width(180.dp)
            .clickable {
                onItemClicked(pizza)
            }
    ) {
        Column(
            modifier = Modifier
                .padding(
                    all = 16.dp
                )
        ) {
            Image(
                painter = painterResource(id = pizza.image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Text(
                text = pizza.name,
                style = MaterialTheme.typography.bodySmall,
                color = ColorRed,
                modifier = Modifier.padding(top = 8.dp)
            )
            Text(
                text = pizza.category,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray,
                modifier = Modifier.padding(top = 4.dp)
            )
            Text(
                text = stringResource(
                    id = R.string.top_menu_item_price,
                    pizza.price
                ),
                style = MaterialTheme.typography.bodySmall,
                color = Color.Black,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

@Composable
private fun HotPromoHeader() {
    Text(
        text = "Hot Promo!",
        color = ColorRed,
        style = MaterialTheme.typography.titleSmall,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 8.dp)
    )
}

@Composable
private fun HotPromoContent() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = ColorRed
        ),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth()

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.pizza_2),
                contentDescription = null,
                Modifier.fillMaxWidth(0.45f)
            )
            Column(
                modifier = Modifier
                    .padding(start = 4.dp)
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .height(IntrinsicSize.Min)
            ) {
                Text(
                    text = "Pizza Beef Cheese",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.White
                )
                Text(
                    text = "Pizza",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Black,
                    modifier = Modifier.padding(top = 4.dp)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(top = 4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.AccessTime,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp),
                        tint = Color.White
                    )
                    Text(
                        text = "3 days left",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.White,
                        modifier = Modifier.padding(4.dp)
                    )
                }
                Row(
                    verticalAlignment = Alignment.Bottom,
                    modifier = Modifier
                        .padding(top = 4.dp)
                        .fillMaxHeight()
                ) {
                    Text(
                        text = stringResource(
                            id = R.string.hot_menu_item_price,
                            7.98
                        ),
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Black,
                        textDecoration = TextDecoration.LineThrough
                    )
                    Text(
                        text = stringResource(
                            id = R.string.hot_menu_item_discount_price,
                            5.98
                        ),
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.White,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }

            }
        }
    }
}

@Preview
@Composable
private fun PizzaHomePreview() {
    HomeScreen(rememberNavController())
}