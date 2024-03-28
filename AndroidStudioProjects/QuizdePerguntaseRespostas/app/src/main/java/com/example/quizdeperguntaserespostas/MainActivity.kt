package com.example.quizdeperguntaserespostas

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quizdeperguntaserespostas.ui.theme.QuizDePerguntasERespostasTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuizDePerguntasERespostasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MinhaTela()
                }
            }
        }
    }
}

@Composable
fun MinhaTela() {
    Column(
        modifier = Modifier.fillMaxSize(), // Ocupa toda a tela
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        /*var questionarioIniciado by remember { mutableStateOf(false) }

        if (!questionarioIniciado) {
            Button(
                onClick = { questionarioIniciado = true }
            ) {
                Text(text = "Iniciar Questionário")
            }
        } else {
            JogoQuiz()
        }
         */
        JogoQuiz()
    }
}

@Composable
fun JogoQuiz() {
    var indicePerguntaAtual by remember { mutableStateOf(0) }
    var respostaSelecionada by remember { mutableStateOf<String?>(null) }
    var respostasCorretas by remember { mutableStateOf(0) }
    var resultado: String by remember { mutableStateOf("") }
    var exibirTelaInicial by remember { mutableStateOf(true) }

    val perguntas = listOf(
        "Qual é a capital do Brasil?" to listOf(
            "A) Brasília",
            "B) Rio de Janeiro",
            "C) São Paulo",
            "D) Belo Horizonte",
            "E) Porto Alegre"
        ),
        "Qual é a capital da França?" to listOf(
            "A) Paris",
            "B) Londres",
            "C) Roma",
            "D) Berlim",
            "E) Madri"
        ),
        "Qual é a capital de São Paulo?" to listOf(
            "A) Brasília",
            "B) Rio de Janeiro",
            "C) São Paulo",
            "D) Belo Horizonte",
            "E) Porto Alegre"
        ),
        "Qual é a capital da Espanha?" to listOf(
            "A) Paris",
            "B) Londres",
            "C) Roma",
            "D) Berlim",
            "E) Madri"
        )
    )

    val respostasCorretasEsperadas = listOf(
        listOf("A"), // Resposta correta 1
        listOf("A"), // Resposta correta 2
        listOf("C"), // Resposta correta 3
        listOf("E")  // Resposta correta 4
    )

    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        if (exibirTelaInicial) {
            // Se exibirTelaInicial for true, mostrar a tela inicial
            Button(
                onClick = {
                    exibirTelaInicial = false
                    resultado = "" // Limpar o resultado ao voltar para o início
                    indicePerguntaAtual = 0 // Reiniciar o índice da pergunta
                    respostaSelecionada = null // Limpar a resposta selecionada
                    respostasCorretas = 0 // Reiniciar o contador de respostas corretas
                }
            ) {
                Text(text = "Iniciar Jogo")
            }
        } else {
            if (resultado.isNotEmpty()) {
                // Se o resultado não estiver vazio, mostrar apenas o resultado
                Text(
                    text = resultado,
                    modifier = Modifier.padding(16.dp)
                )





                Spacer(modifier = Modifier.height(16.dp))

                // Botão para voltar ao início
                Button(
                    onClick = {
                        exibirTelaInicial = true
                    }
                ) {
                    Text(text = "Voltar ao Início")
                }




            } else {
                // Caso contrário, mostrar a pergunta e as opções de resposta
                Text(
                    text = perguntas[indicePerguntaAtual].first,
                    modifier = Modifier.padding(16.dp)
                )

                perguntas[indicePerguntaAtual].second.forEach { opcao ->
                    Row(
                        modifier = Modifier.padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (respostaSelecionada == opcao.substring(0, 1)),
                            onClick = { respostaSelecionada = opcao.substring(0, 1) }
                        )
                        Text(text = opcao, modifier = Modifier.padding(start = 8.dp))
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        // Verifica se a resposta selecionada está correta
                        if (respostaSelecionada in respostasCorretasEsperadas[indicePerguntaAtual]) {
                            respostasCorretas++
                        }

                        // Passa para a próxima pergunta ou exibe o resultado final
                        if (indicePerguntaAtual < perguntas.size - 1) {
                            indicePerguntaAtual++
                            respostaSelecionada =
                                null // Limpa a resposta selecionada para a próxima pergunta
                        } else {
                            // Exibe o resultado final
                            resultado =
                                "Você acertou $respostasCorretas de ${perguntas.size} perguntas!"
                        }
                    }
                ) {
                    if (indicePerguntaAtual < perguntas.size - 1) {
                        Text(text = "Próxima Pergunta")
                    } else {
                        Text(text = "Verificar Resultado")
                    }
                }
            }

//
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QuizDePerguntasERespostasTheme {
        MinhaTela()
    }
}