package com.example.calculatorblud

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    TipCalcScreen()
                }
            }
        }
    }
}

@Composable
fun TipCalcScreen() {
    // 1. Состояния для ввода данных
    var billAmount by remember { mutableStateOf("") }
    var dishCount by remember { mutableStateOf("") }

    // 2. Состояние слайдера (от 0 до 25)
    var tipPercent by remember { mutableFloatStateOf(0f) }

    // 3. Логика расчета скидки (Пункт 5 методички)
    val dishes = dishCount.toIntOrNull() ?: 0
    val discountPercent = when {
        dishes in 1..2 -> 3
        dishes in 3..5 -> 5
        dishes in 6..10 -> 7
        dishes > 10 -> 10
        else -> 0
    }


}


@Composable
fun RadioGroup(discountPercent: Int) {
    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = discountPercent == 3, onClick = null)
            Text("3% (1-2 блюда)")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = discountPercent == 5, onClick = null)
            Text("5% (3-5 блюд)")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = discountPercent == 7, onClick = null)
            Text("7% (6-10 блюд)")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = discountPercent == 10, onClick = null)
            Text("10% (более 10 блюд)")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TipCalcScreenPreview() {
    MaterialTheme {
        TipCalcScreen()
    }
}