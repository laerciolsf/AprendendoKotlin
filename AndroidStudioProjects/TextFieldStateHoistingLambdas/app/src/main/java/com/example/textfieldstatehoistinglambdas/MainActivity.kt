package com.example.textfieldstatehoistinglambdas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.tooling.preview.Preview
import com.example.textfieldstatehoistinglambdas.ui.theme.TextFieldStateHoistingLambdasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextFieldStateHoistingLambdasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Aula03app()
                }
            }
        }
    }
}

@Composable
fun Aula03app(modifier: Modifier = Modifier) {

    var nome by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        TextFildExemplo(
            value = nome,
            onValueChange = {
                nome = it
            },
            modifier = modifier
        )
    }
}

@Composable
fun TextFildExemplo(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier
) {
    TextField(value = value, onValueChange = onValueChange, label = { Text("Value") })
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TextFieldStateHoistingLambdasTheme {
        Aula03app()
    }
}