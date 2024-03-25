package com.example.jogoblackjack


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jogoblackjack.ui.theme.JogoBlackJackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JogoBlackJackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    BlackJackApp()
                }
            }
        }
    }
}

@Composable
fun BlackJackApp() {
    MainScreen()
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = null,
            modifier = modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            PlacarCima(
                vitorias = 10,
                empates = 2,
                derrotas = 1,
                modifier = modifier
            )

            Cartas(listOf(7, 1), true, modifier)
            RestatGame(modifier = modifier)
            Cartas(listOf(3, 4, 5, 6), false, modifier)
            BotoesDeAcao(modifier = modifier)
        }
    }
}

@Composable
fun BotoesDeAcao(modifier: Modifier) {
    Row(
        modifier = modifier
            .fillMaxSize()
            .padding(bottom = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(onClick = { /*TODO*/ }) {
            Text(
                text = "Hold",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
        Button(onClick = { /*TODO*/ }) {
            Text(
                text = "Hit",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

@Composable
fun RestatGame(modifier: Modifier) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Fim de Rodada!",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Button(onClick = { /*TODO*/ }) {
            Text(
                text = "Jogar Novamente",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}


@Composable
fun Cartas(cartas: List<Int>, mostrarCartas: Boolean, modifier: Modifier = Modifier) {
    val offset = 29
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp)
    )
    {
        cartas.forEachIndexed { index, card ->
            var cardDrawble = if (index == 1 && mostrarCartas) {
                R.drawable.back
            } else when (card) {
                1 -> R.drawable.ace
                2 -> R.drawable.two
                3 -> R.drawable.three
                4 -> R.drawable.four
                5 -> R.drawable.five
                6 -> R.drawable.six
                7 -> R.drawable.seven
                8 -> R.drawable.eight
                9 -> R.drawable.nine
                10 -> R.drawable.ten
                11 -> R.drawable.jack
                12 -> R.drawable.queen
                else -> R.drawable.king
            }
            Image(
                painter = painterResource(id = cardDrawble),
                contentDescription = "$card",
                contentScale = ContentScale.Fit,
                modifier = modifier
                    .height(334.dp)
                    .width(160.dp)
                    .offset(x = (offset * index).dp)
            )
        }
    }
}

@Composable
fun PlacarCima(vitorias: Int, empates: Int, derrotas: Int, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        Text(
            text = "Vitorias: $vitorias",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Text(
            text = "Empates: $empates",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Text(
            text = "Derrotas: $derrotas",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JogoBlackJackTheme {
        BlackJackApp()
    }
}