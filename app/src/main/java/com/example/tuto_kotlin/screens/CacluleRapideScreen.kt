package com.example.tuto_kotlin.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.tuto_kotlin.ui.theme.Purple80
import com.example.tuto_kotlin.ui.theme.TutokotlinTheme

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun CalculeRapideScreen()
{
    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = Purple80,
                    titleContentColor = Color.White,
                ),
                title = {
                    Text("Calculatrice RAPIDE", style = TextStyle(fontSize = 14.sp))
                }
            )
        }
    ) {
        innerPadding -> Box(
            modifier = Modifier.padding(innerPadding)
        ){
            Column(Modifier.fillMaxWidth()) {

            }
        }
    }
}

@Preview
@Composable
fun CalculRapidePreview() {
    TutokotlinTheme {
        CalculeRapideScreen()
    }
}