package com.example.tuto_kotlin.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tuto_kotlin.ui.theme.Purple40
import com.example.tuto_kotlin.ui.theme.Purple80
import com.example.tuto_kotlin.ui.theme.TutokotlinTheme

@OptIn(ExperimentalMaterial3Api::class)


@Composable
fun CalculeRapideScreen()
{
    val operatorSign = listOf("+","-","x","/")
    var number1 by remember{ mutableStateOf("0") }
    var number2 by remember{ mutableStateOf("0") }
    var result by remember{ mutableStateOf("0") }

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
            Column(Modifier.fillMaxWidth().padding(horizontal = 10.dp)) {
                Spacer(Modifier.height(20.dp))
                TextField(
                    value = number1,
                    maxLines = 1,
                    onValueChange = { number1 = it },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 2.dp),
                    placeholder = {
                        Text("Entrer le numero 1")
                    }
                )
                Spacer(Modifier.height(20.dp))
                TextField(
                    value = number2,
                    maxLines = 1,
                    onValueChange = { number2 = it },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 2.dp),
                    placeholder = {
                        Text("Entrer le numero 2")
                    }
                )
                Spacer(Modifier.height(40.dp))
                Text("Résultat obtenu : ", style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.W500))
                Spacer(Modifier.height(20.dp))
                Surface(
                    modifier = Modifier.height(60.dp).padding(horizontal = 20.dp).fillMaxWidth(),
                    color = Purple40,
                    shape = RoundedCornerShape(15),
                ){
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    {
                        Text(result, style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold, color = Color.White))
                    }
                }
                Spacer(Modifier.weight(1f))
                LazyVerticalGrid(
                    columns = GridCells.Fixed(4)
                ) {
                    items(operatorSign.size){
                        ButtonOperator(operatorSign[it],number1,number2, onResult = {result = it})
                    }
                }
                Spacer(Modifier.height(40.dp))
            }
        }
    }
}

@Composable
fun ButtonOperator(sign : String, number1 : String, number2 : String,onResult: (String) -> Unit){
    Button(
        onClick = {
            var result = "";
            if(sign == "+")
                result = (number1.toDouble() + number2.toDouble()).toString()
            if(sign == "-")
                result = (number1.toDouble() - number2.toDouble()).toString()
            if(sign == "x")
                result = (number1.toDouble() * number2.toDouble()).toString()
            if(sign == "/")
                result = (number1.toDouble() / number2.toDouble()).toString()
            onResult(result)
        },
        modifier = Modifier.fillMaxWidth().height(60.dp).padding(horizontal = 5.dp),
        shape = RoundedCornerShape(15)
    ){
        Text(sign, style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.W500))
    }
}

@Preview
@Composable
fun CalculRapidePreview() {
    TutokotlinTheme {
        CalculeRapideScreen()
    }
}