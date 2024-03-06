package com.example.addimagens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.addimagens.ui.theme.AddImagensTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AddImagensTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val image = R.drawable.android//nome da imagem
    Box(modifier = modifier.fillMaxSize()) {
        Image(
            modifier = modifier.fillMaxSize(),//Tela Cheia.
            painter = painterResource(id = image),
            contentDescription = null,//Aqui coloca legenda para acessibilidade.
            contentScale = ContentScale.Crop, //Deixa no tamanho maximo tem distorcer a imagem.
            alpha = 0.5f//Controla a opacide, isso deixa um pouco mais tranparente.
        )

        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,//Centraliza na horizontal
            verticalArrangement = Arrangement.Center//Centraliza na Vertical
        ) {

            Text(text = "Programção", fontSize = 38.sp)
            Text(text = "para", fontSize = 38.sp)
            Text(text = "Dispositivos", fontSize = 38.sp)
            Text(text = "Moveis", fontSize = 38.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AddImagensTheme {
        Greeting("Android")
    }
}