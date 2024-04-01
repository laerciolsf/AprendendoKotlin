package com.example.quizdeperguntaserespostas

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        JogoQuiz()
    }
}

@Composable
fun JogoQuiz() {
    // Variáveis para controlar o estado do jogo
    var indicePerguntaAtual by remember { mutableStateOf(0) } // Índice da pergunta atual
    var respostaSelecionada by remember { mutableStateOf<String?>(null) } // Opção selecionada pelo usuário
    var respostasCorretas by remember { mutableStateOf(0) } // Contador de respostas corretas
    var resultado: String by remember { mutableStateOf("") } // Resultado do jogo
    var exibirTelaInicial by remember { mutableStateOf(true) } // Flag para exibir a tela inicial
    var opcaoSelecionada by remember { mutableStateOf(false) } // Flag para indicar se uma opção foi selecionada

    // Lista de perguntas e suas respectivas opções de resposta
    val perguntas = listOf(
        "Qual é a capital do Brasil?" to listOf(
            "A) Brasília    ",
            "B) Rio de Janeiro    ",
            "C) São Paulo    ",
            "D) Belo Horizonte    ",
            "E) Porto Alegre    "
        ),
        "Qual é a capital da França?" to listOf(
            "A) Paris    ",
            "B) Londres    ",
            "C) Roma    ",
            "D) Berlim    ",
            "E) Madri    "
        ),
        "Qual é a capital de São Paulo?" to listOf(
            "A) Brasília    ",
            "B) Rio de Janeiro    ",
            "C) São Paulo    ",
            "D) Belo Horizonte    ",
            "E) Porto Alegre    "
        ),
        "Qual é a capital da Espanha?" to listOf(
            "A) Paris    ",
            "B) Londres    ",
            "C) Roma    ",
            "D) Berlim    ",
            "E) Madri    "
        )
    )

    // Lista das respostas corretas para cada pergunta
    val respostasCorretasEsperadas = listOf(
        listOf("A"), // Resposta correta para a primeira pergunta
        listOf("A"), // Resposta correta para a segunda pergunta
        listOf("C"), // Resposta correta para a terceira pergunta
        listOf("E")  // Resposta correta para a quarta pergunta
    )

    // Layout principal do jogo
    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        // Verificar se deve exibir a tela inicial ou o jogo em si
        if (exibirTelaInicial) {
            // Tela inicial: botão para iniciar o jogo
            Button(
                onClick = {
                    // Ao clicar, esconde a tela inicial e reseta o estado do jogo
                    exibirTelaInicial = false
                    resultado = ""
                    indicePerguntaAtual = 0
                    respostaSelecionada = null
                    respostasCorretas = 0
                    opcaoSelecionada = false
                }
            ) {
                Text(
                    text = "Iniciar Jogo",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )
                )
            }
        } else {
            // Verificar se o jogo terminou
            if (resultado.isNotEmpty()) {
                // Tela de resultado: exibir o resultado final do jogo
                Text(
                    text = resultado,
                    modifier = Modifier.padding(16.dp),
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )
                )

                // Calcular média e atribuir nota de 1 a 10
                val media = respostasCorretas.toDouble() / perguntas.size.toDouble()
                val nota = (media * 10).toInt()

                // Exibir a média e a nota
                Text(
                    text = "Média de acertos: ${media * 100}%\nNota: $nota/10",
                    modifier = Modifier.padding(16.dp),
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )
                )

                // Botão para voltar ao início
                Button(
                    onClick = {
                        exibirTelaInicial = true
                    }
                ) {
                    Text(
                        text = "Voltar ao Início",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp
                        )
                    )
                }
            } else {
                // Pergunta atual: exibir a pergunta e as opções de resposta
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = perguntas[indicePerguntaAtual].first,
                        modifier = Modifier.padding(bottom = 8.dp),
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp
                        )
                    )

                    // Iterar sobre as opções de resposta da pergunta atual
                    perguntas[indicePerguntaAtual].second.forEach { opcao ->
                        // Determinar a cor de fundo da opção com base na seleção do usuário
                        val corDeFundo = when {
                            respostaSelecionada != null -> {
                                if (opcao.substring(0, 1) == respostaSelecionada) {
                                    if (respostaSelecionada in respostasCorretasEsperadas[indicePerguntaAtual]) {
                                        Color.Green // Cor verde para opção correta selecionada
                                    } else {
                                        Color.Red // Cor vermelha para opção incorreta selecionada
                                    }
                                } else if (opcao.substring(0, 1) in respostasCorretasEsperadas[indicePerguntaAtual]) {
                                    Color.Green // Cor verde para opção correta não selecionada
                                } else {
                                    Color.Transparent // Sem cor de fundo para outras opções
                                }
                            }
                            else -> Color.Transparent // Sem cor de fundo quando nenhuma opção foi selecionada
                        }

                        // Layout da opção de resposta
                        Box(
                            modifier = Modifier
                                .background(corDeFundo, shape = RoundedCornerShape(8.dp))
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                // RadioButton para selecionar a opção
                                RadioButton(
                                    selected = (respostaSelecionada == opcao.substring(0, 1)),
                                    onClick = {
                                        if (!opcaoSelecionada) {
                                            respostaSelecionada = opcao.substring(0, 1)
                                            opcaoSelecionada = true
                                        }
                                    }
                                )

                                // Texto da opção de resposta
                                Text(
                                    text = opcao,
                                    style = TextStyle(
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 24.sp
                                    )
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(16.dp)) // Espaço vertical entre as opções
                    }
                }

                // Botão para avançar para a próxima pergunta ou verificar o resultado final
                Button(
                    onClick = {
                        if ((opcaoSelecionada || respostaSelecionada != null) || (indicePerguntaAtual == 0 && respostaSelecionada != null)) {
                            // Verificar se a resposta selecionada está correta
                            if (respostaSelecionada in respostasCorretasEsperadas[indicePerguntaAtual]) {
                                respostasCorretas++
                            }

                            // Avançar para a próxima pergunta ou exibir o resultado final
                            if (indicePerguntaAtual < perguntas.size - 1) {
                                indicePerguntaAtual++
                                respostaSelecionada = null // Limpar a resposta selecionada
                                opcaoSelecionada = false // Resetar a variável de controle
                            } else {
                                // Exibir o resultado final
                                resultado = "Você acertou $respostasCorretas de ${perguntas.size} perguntas!"
                            }
                        }
                    },
                    enabled = (opcaoSelecionada || respostaSelecionada != null) || (indicePerguntaAtual == 0 && respostaSelecionada != null) // Habilitar o botão apenas se uma opção foi selecionada ou se for a primeira pergunta com uma opção selecionada
                ) {
                    if (indicePerguntaAtual < perguntas.size - 1) {
                        Text(
                            text = "Próxima Pergunta",
                            style = TextStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 24.sp
                            )
                        )
                    } else {
                        Text(
                            text = "Verificar Resultado",
                            style = TextStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 24.sp
                            )
                        )
                    }
                }
            }
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