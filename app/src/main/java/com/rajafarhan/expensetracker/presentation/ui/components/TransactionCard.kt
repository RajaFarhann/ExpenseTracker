package com.rajafarhan.expensetracker.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rajafarhan.expensetracker.R
import com.rajafarhan.expensetracker.presentation.theme.ExpenseTrackerTheme
import com.rajafarhan.expensetracker.utils.rupiahFormatWithoutCommas

@Composable
fun TransactionCard(
    modifier: Modifier = Modifier,
    status: String,
    name : String,
    date: String,
    amount : Long,
    image : Int

) {

    val (prefix, color) = when (status.lowercase()) {
        "income" -> Pair("+", Color(0xFF25A969))
        "expense" -> Pair("-", Color(0xFFF95B51))
        else -> Pair("", Color.Black)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth(0.95f)
            .height(70.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF0F6F5))
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(50.dp),
                    contentAlignment = Alignment.Center
                ){
                    Image(
                        painter = painterResource(id = image),
                        contentDescription = "Transaction Image",
                        modifier = Modifier
                            .size(30.dp)
                    )
                }
                Spacer(Modifier.width(8.dp))
                Column(
                ) {
                    Text(
                        name,
                        modifier = Modifier
                            .width(125.dp),
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1
                    )
                    Text(
                        date,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFF8C8C8C),
                        fontSize = 12.sp
                    )
                }
            }
            Spacer(Modifier.weight(1f))
            Text(
                "$prefix ${rupiahFormatWithoutCommas(amount)}",
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                color = color
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun TransactionCardPreview() {
    ExpenseTrackerTheme {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            TransactionCard(
                status = "Expense",
                name = "Netflix",
                date = "Jan 12, 2025",
                amount = 150000,
                image = R.drawable.ic_dummy
            )
            Spacer(Modifier.height(12.dp))
            TransactionCard(
                status = "Income",
                name = "Salary",
                date = "Des 28, 2024",
                amount = 150000,
                image = R.drawable.ic_income
            )
        }
    }
}