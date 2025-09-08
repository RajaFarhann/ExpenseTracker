package com.rajafarhan.expensetracker.utils

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

fun rupiahFormatWithoutCommas(amount: Long): String {
    val symbols = DecimalFormatSymbols(Locale("in", "ID"))
    symbols.groupingSeparator = '.'
    symbols.decimalSeparator = ','

    val decimalFormat = DecimalFormat("#,###", symbols)
    return "Rp${decimalFormat.format(amount)}"
}