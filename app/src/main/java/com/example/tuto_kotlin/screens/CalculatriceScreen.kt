package com.example.tuto_kotlin.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tuto_kotlin.ui.theme.Purple80
import com.example.tuto_kotlin.ui.theme.TutokotlinTheme
import com.example.tuto_kotlin.viewmodel.CalculatriveViewModel

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun CalculatriceScreen(modifier: Modifier = Modifier,navControllers: NavController)
{
    //, viewModel: CalculatriveViewModel
    val keyboardList = listOf(
        "C","(",")","/",
        "7","8","9","X",
        "4","5","6","-",
        "1","2","3","+",
        "AC","0",".","="
    );
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = Purple80,
                    titleContentColor = Color.White,
                ),
                title = {
                    Text("Calculatrice", style = TextStyle(fontSize = 14.sp))
                }
            )
        }
    ) {
        innerPadding->
        Box(
            modifier = Modifier.padding(innerPadding)
        ){
            Column(Modifier.padding(15.dp).fillMaxWidth()) {
                Spacer(Modifier.height(50.dp))
                Surface(

                ) {
                    Text(
                        "12+3",
                        modifier = Modifier.fillMaxWidth(),
                        style = TextStyle(fontSize = 45.sp, fontWeight = FontWeight.Bold),
                        textAlign = TextAlign.End
                    )
                }
                Spacer(Modifier.weight(1f))
                Text(
                    "24",
                    modifier = Modifier.fillMaxWidth(),
                    style = TextStyle(fontSize = 45.sp, fontWeight = FontWeight.W200),
                    textAlign = TextAlign.End
                )
                Spacer(Modifier.height(50.dp))
                LazyVerticalGrid(
                    columns = GridCells.Fixed(4)
                ) {
                    items(keyboardList){
                        ButtonCalculatrice(it, onClick = {
                            //viewModel.onButtonClick(btn = it)
                        })
                    }
                }
                Button(
                    onClick = {
                        navControllers.navigate("calculeRapideScreen")
                    },
                    modifier = Modifier.fillMaxWidth().height(70.dp),
                    shape = RoundedCornerShape(10.dp)
                ){
                    Text("Calcule Rapide", style = TextStyle(color = Color.White, fontSize = 15.sp, fontWeight = FontWeight.Bold))
                }
            }
        }
    }
}

@Composable
fun ButtonCalculatrice(textOperation : String, onClick : ()->Unit)
{
    Button(
        onClick = onClick,
        modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp).height(70.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = getColor(textOperation)
        ),
        shape = RoundedCornerShape(10.dp)
    ) {
        Text(textOperation, style = TextStyle(color = Color.White, fontSize = 15.sp, fontWeight = FontWeight.Bold))
    }
}

fun getColor(operator : String) : Color
{
    if(operator == "X" || operator == "+" || operator == "-" || operator == "/")
    {
        return Color(0xFFBB634B);
    }

    if(operator == "(" || operator == ")")
    {
        return Color(0xFF110A0A);
    }

    if(operator == "=")
    {
        return Color(0xFF07426E);
    }

    if(operator == "C" || operator == "AC")
    {
        return Color(0xFF505050);
    }

    return  Color(0xFF009688);
}


/*@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TutokotlinTheme {
        CalculatriceScreen()
    }
}*/