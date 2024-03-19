package com.example.botoeseestado

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.botoeseestado.ui.theme.BotoesEEstadoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BotoesEEstadoTheme {
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
    Column(modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        var contadorDeCliques by remember {
            mutableStateOf(0)
        }
        Button(onClick = {
            contadorDeCliques++
            Log.d("cliqueDebug", "Contador de cliques = $contadorDeCliques")
        }) {

            Image(
                modifier = modifier.padding(4.dp),
                painter = painterResource(
                    id = R.drawable.done_fill0_wght400_grad0_opsz24
                ),
                contentDescription = "Concluir"
            )
            Text(text = "$contadorDeCliques", modifier = modifier.padding(4.dp))

        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BotoesEEstadoTheme {
        Greeting("Android")
    }
}