@file:OptIn(ExperimentalMaterial3Api::class)

package com.carlosgub.pizzaapp.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.carlosgub.pizzaapp.R
import com.carlosgub.pizzaapp.model.Pizza
import com.carlosgub.pizzaapp.ui.theme.ColorRed
import com.carlosgub.pizzaapp.ui.theme.ColorRose
import com.carlosgub.pizzaapp.ui.theme.ColorRoseDetail

@Composable
fun DetailScreen(pizza: Pizza, rootNavController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBarDetail(rootNavController = rootNavController)
        }
    ) { paddingValues ->
        DetailContent(pizza = pizza, paddingValues = paddingValues)
    }
}

@Composable
private fun TopAppBarDetail(rootNavController: NavHostController) {
    TopAppBar(
        title = {},
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = ColorRoseDetail,
            actionIconContentColor = ColorRed,
            navigationIconContentColor = ColorRed
        ),
        navigationIcon = {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .size(32.dp)
                    .clickable {
                        rootNavController.popBackStack()
                    }
            )
        },
        actions = {
            Icon(
                imageVector = Icons.Outlined.FavoriteBorder,
                contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .size(32.dp)
            )
        }
    )
}

@Composable
private fun DetailContent(pizza: Pizza, paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f, false)
        ) {
            PizzaDetailBackground()
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                PizzaName(pizza.name)
                PizzaImage()
                PizzaInfoContainer()
                PizzaDescriptionAndCounterContainer()
            }
        }
        PizzaDetailFooter(pizza.price)
    }
}

@Composable
private fun PizzaDetailFooter(price: Float) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .padding(
                all = 24.dp
            )
    ) {
        Text(
            text = stringResource(
                id = R.string.top_menu_item_price,
                price
            ),
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            color = ColorRed,
            fontSize = 36.sp
        )
        Button(
            onClick = {

            },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = ColorRed
            ),
            content = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier
                            .size(32.dp)
                            .padding(4.dp)
                    )
                    Text(text = "Add to cart")
                }
            }
        )
    }
}

@Composable
private fun PizzaDetailBackground() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .background(
                color = ColorRoseDetail,
                shape = RoundedCornerShape(
                    bottomEnd = 70.dp,
                    bottomStart = 70.dp
                )
            )
    )
}

@Composable
private fun PizzaDescriptionAndCounterContainer() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 24.dp,
                start = 24.dp,
                end = 24.dp
            )
    ) {
        Text(
            text = stringResource(id = R.string.pizza_detail_description),
            modifier = Modifier.weight(1f, false),
            color = Color.Gray,
            style = MaterialTheme.typography.bodyLarge
        )
        CountCounter(
            modifier = Modifier
                .width(IntrinsicSize.Min)
                .padding(horizontal = 16.dp)
        )
    }
}

@Composable
private fun PizzaInfoContainer() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 8.dp,
                start = 24.dp,
                end = 24.dp
            ),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        PizzaInfo(
            "Energy",
            "355 kcal"
        )
        PizzaInfo(
            "Weight",
            "800 gr"
        )
        PizzaInfo(
            "Delivery",
            "20 min"
        )
    }
}

@Composable
private fun PizzaImage() {
    Image(
        painter = painterResource(id = R.drawable.pizza_2),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 16.dp,
                start = 16.dp,
                end = 16.dp
            )
    )
}

@Composable
private fun PizzaName(name: String) {
    Text(
        text = name,
        modifier = Modifier
            .padding(
                top = 40.dp,
                start = 16.dp,
                end = 16.dp
            )
            .fillMaxWidth(),
        textAlign = TextAlign.Center,
        color = ColorRed,
        style = MaterialTheme.typography.titleLarge
    )
}

@Composable
private fun PizzaInfo(
    title: String,
    description: String
) {
    Column(
        modifier = Modifier.width(IntrinsicSize.Max)
    ) {
        Text(
            text = description,
            textAlign = TextAlign.Center,
            color = Color.Black,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = title,
            textAlign = TextAlign.Center,
            color = ColorRed,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun CountCounter(
    modifier: Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = null,
            tint = ColorRed,
            modifier = Modifier
                .size(32.dp)
                .background(
                    ColorRose,
                    shape = RoundedCornerShape(8.dp)
                )
                .clickable {

                }
                .padding(4.dp)
        )
        Text(
            text = "1",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        Icon(
            imageVector = Icons.Filled.Remove,
            contentDescription = null,
            tint = ColorRed,
            modifier = Modifier
                .size(32.dp)
                .background(
                    ColorRose,
                    shape = RoundedCornerShape(8.dp)
                )
                .clickable {

                }
                .padding(4.dp)
        )
    }
}