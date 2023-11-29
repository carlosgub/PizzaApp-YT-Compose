package com.carlosgub.pizzaapp.icons

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

@Composable
fun rememberLocalPizza(): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "local_pizza",
            defaultWidth = 40.0.dp,
            defaultHeight = 40.0.dp,
            viewportWidth = 40.0f,
            viewportHeight = 40.0f
        ).apply {
            path(
                fill = SolidColor(Color.Black),
                fillAlpha = 1f,
                stroke = null,
                strokeAlpha = 1f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(20f, 34.125f)
                quadToRelative(-0.625f, 0f, -1.208f, -0.292f)
                quadToRelative(-0.584f, -0.291f, -1f, -0.875f)
                lineTo(5.125f, 13.833f)
                quadToRelative(-0.625f, -0.958f, -0.437f, -2.083f)
                quadToRelative(0.187f, -1.125f, 1.062f, -1.75f)
                quadToRelative(3.167f, -2.208f, 6.771f, -3.479f)
                reflectiveQuadTo(20f, 5.25f)
                quadToRelative(3.875f, 0f, 7.5f, 1.271f)
                reflectiveQuadTo(34.292f, 10f)
                quadToRelative(0.875f, 0.625f, 1.041f, 1.75f)
                quadToRelative(0.167f, 1.125f, -0.416f, 2.042f)
                lineTo(22.208f, 32.958f)
                quadToRelative(-0.416f, 0.584f, -1f, 0.875f)
                quadToRelative(-0.583f, 0.292f, -1.208f, 0.292f)
                close()
                moveToRelative(0f, -2.583f)
                lineToRelative(12.875f, -19.334f)
                quadToRelative(-2.917f, -1.875f, -6.167f, -3.104f)
                reflectiveQuadTo(20f, 7.875f)
                quadToRelative(-3.458f, 0f, -6.708f, 1.229f)
                reflectiveQuadToRelative(-6.125f, 3.104f)
                close()
                moveTo(15.542f, 16.5f)
                quadToRelative(0.958f, 0f, 1.625f, -0.667f)
                quadToRelative(0.666f, -0.666f, 0.666f, -1.625f)
                quadToRelative(0f, -0.958f, -0.666f, -1.625f)
                quadToRelative(-0.667f, -0.666f, -1.625f, -0.666f)
                quadToRelative(-1f, 0f, -1.667f, 0.666f)
                quadToRelative(-0.667f, 0.667f, -0.667f, 1.625f)
                quadToRelative(0f, 0.959f, 0.667f, 1.625f)
                quadToRelative(0.667f, 0.667f, 1.667f, 0.667f)
                close()
                moveToRelative(4.5f, 8.667f)
                quadToRelative(0.958f, 0f, 1.625f, -0.667f)
                quadToRelative(0.666f, -0.667f, 0.666f, -1.625f)
                quadToRelative(0f, -1f, -0.666f, -1.667f)
                quadToRelative(-0.667f, -0.666f, -1.625f, -0.666f)
                quadToRelative(-1f, 0f, -1.667f, 0.666f)
                quadToRelative(-0.667f, 0.667f, -0.667f, 1.667f)
                quadToRelative(0f, 0.958f, 0.667f, 1.625f)
                reflectiveQuadToRelative(1.667f, 0.667f)
                close()
                moveToRelative(0f, -5.459f)
                close()
            }
        }.build()
    }
}