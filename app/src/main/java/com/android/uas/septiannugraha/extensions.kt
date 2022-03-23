package com.android.uas.septiannugraha

import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.text.Format

fun Double.digit(): String {
    val digitFormat = DecimalFormat.getCurrencyInstance() as DecimalFormat
    val formatdigit = DecimalFormatSymbols()
    formatdigit.currencySymbol = ""
    formatdigit.monetaryDecimalSeparator = '.'
    formatdigit.groupingSeparator = '.'
    digitFormat.decimalFormatSymbols = formatdigit
    return digitFormat.format(this)
}

fun Double.digitdes(): String {
    val digitFormat = DecimalFormat.getCurrencyInstance() as DecimalFormat
    val formatdigit = DecimalFormatSymbols()
    formatdigit.currencySymbol = ""
    formatdigit.monetaryDecimalSeparator = '.'
    formatdigit.groupingSeparator = '.'
    digitFormat.decimalFormatSymbols = formatdigit
    return digitFormat.format(this)
}

fun Activity.hideKeyboard(): Boolean {
    return (getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager)
        .hideSoftInputFromWindow((currentFocus ?: View(this)).windowToken, 0)
}
