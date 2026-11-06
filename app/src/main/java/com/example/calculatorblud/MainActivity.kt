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
    var billAmount by remember { mutableStateOf("") }
    var dishCount by remember { mutableStateOf("") }

    var tipPercent by remember { mutableFloatStateOf(0f) }

    val dishes = dishCount.toIntOrNull() ?: 0
    val discountPercent = when {
        dishes in 1..2 -> 3
        dishes in 3..5 -> 5
        dishes in 6..10 -> 7
        dishes > 10 -> 10
        else -> 0
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Калькулятор чаевых", fontSize = 24.sp, style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(24.dp))


        TextField(
            value = billAmount,
            onValueChange = { billAmount = it },
            label = { Text("Сумма счета") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))


        TextField(
            value = dishCount,
            onValueChange = { dishCount = it },
            label = { Text("Количество блюд") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))


        Text("Процент чаевых: ${tipPercent.toInt()}%", fontSize = 18.sp)
        Slider(
            value = tipPercent,
            onValueChange = { tipPercent = it },
            valueRange = 0f..25f,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))

        Text("Текущая скидка:", fontSize = 18.sp, style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))

        RadioGroup(discountPercent = discountPercent)
        Spacer(modifier = Modifier.height(32.dp))


        //Text("Сумма к оплате: ${tipPercent.toInt()}%", fontSize = 20.sp, color = MaterialTheme.colorScheme.primary)
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