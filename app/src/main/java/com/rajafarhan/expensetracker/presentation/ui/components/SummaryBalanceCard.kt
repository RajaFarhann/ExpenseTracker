package com.rajafarhan.expensetracker.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rajafarhan.expensetracker.R
import com.rajafarhan.expensetracker.presentation.theme.ExpenseTrackerTheme
import com.rajafarhan.expensetracker.utils.rupiahFormatWithoutCommas

@Composable
fun SummaryBalanceCard(
    modifier: Modifier = Modifier,
    totalBalance: Long,
    income: Long,
    expense: Long
) {
    Card(
        modifier = modifier
            .fillMaxWidth(0.95f)
            .height(192.dp),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF2F7E79))
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(20.dp,24.dp)
        ) {
            Text(
                "Total Balance",
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )
            Spacer(Modifier.height(8.dp))
            Text(
                rupiahFormatWithoutCommas(totalBalance),
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
            Spacer(Modifier.height(24.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier.weight(1.1f)
                ) {
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.ic_income),
                            contentDescription = "Icon Income",
                            modifier = Modifier
                                .size(24.dp)
                                .padding(end = 4.dp)
                        )
                        Text(
                            "Income",
                            color = Color.White,
                            fontWeight = FontWeight.Medium,
                            fontSize = 12.sp
                        )
                    }
                    Text(
                        rupiahFormatWithoutCommas(income),
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp
                    )
                }
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.ic_expenses),
                            contentDescription = "Icon Expense",
                            modifier = Modifier
                                .size(24.dp)
                                .padding(end = 4.dp)
                        )
                        Text(
                            "Expenses",
                            color = Color.White,
                            fontWeight = FontWeight.Medium,
                            fontSize = 12.sp
                        )
                    }
                    Text(
                        rupiahFormatWithoutCommas(expense),
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun SummaryBalanceCardPreview() {
    ExpenseTrackerTheme {
        SummaryBalanceCard(
            totalBalance = 2500000,
            income = 1840000,
            expense = 284000
        )
    }
}