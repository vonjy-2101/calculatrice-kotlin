package com.example.tuto_kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tuto_kotlin.screens.CalculatriceScreen
import com.example.tuto_kotlin.screens.CalculeRapideScreen
import com.example.tuto_kotlin.ui.theme.TutokotlinTheme
import com.example.tuto_kotlin.viewmodel.CalculatriveViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val calculatriceViewModel = ViewModelProvider(this)[CalculatriveViewModel::class.java]
        enableEdgeToEdge()
        setContent {
            //CalculatriceScreen(viewModel = calculatriceViewModel)
            myAppCalculatrice()
        }
    }
}

@Composable
fun myAppCalculatrice()
{
    val navControllers = rememberNavController()
    NavHost(navController = navControllers, startDestination = "calculatriceScreen") {
        composable("calculatriceScreen") { CalculatriceScreen(navControllers = navControllers) }
        composable("calculeRapideScreen") { CalculeRapideScreen() }
    }
}