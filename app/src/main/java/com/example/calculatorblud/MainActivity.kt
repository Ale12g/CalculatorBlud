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


}

// Отдельная функция для радиокнопок, чтобы не загромождать основной код
@Composable
fun RadioGroup(discountPercent: Int) {

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TipCalcScreenPreview() {
    MaterialTheme {
        TipCalcScreen()
    }
}