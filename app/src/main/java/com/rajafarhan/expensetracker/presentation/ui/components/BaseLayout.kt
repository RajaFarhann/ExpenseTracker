package com.rajafarhan.expensetracker.presentation.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rajafarhan.expensetracker.R
import com.rajafarhan.expensetracker.presentation.theme.ExpenseTrackerTheme

@Composable
fun BaseLayout() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(370.dp)
                .align(Alignment.TopCenter)
        ) {
            val path = Path().apply {
                moveTo(0f, 0f)
                lineTo(size.width, 0f)

                lineTo(size.width, size.height * 0.7f)

                quadraticTo(
                    size.width / 2,
                    size.height * 0.8f,
                    0f,
                    size.height * 0.7f
                )

                close()
            }

            drawPath(
                path = path,
                color = Color(0xFF429690)
            )
        }
        Image(
            painter = painterResource(id = R.drawable.ic_base),
            contentDescription = "Icon Base",
            modifier = Modifier
                .offset(x = (-55).dp, y = (-22).dp)
        )
    }
}


@Preview
@Composable
private fun BaseLayoutPreview() {
    ExpenseTrackerTheme {
        BaseLayout()
    }
}