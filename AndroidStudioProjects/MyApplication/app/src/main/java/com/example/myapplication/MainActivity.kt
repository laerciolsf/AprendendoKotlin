package com.example.myapplication

// Importações necessárias
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

// Definição da atividade principal da aplicação
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Define o conteúdo da atividade
        setContent {
            MyApplicationTheme {
                // Define a aparência global da interface do usuário
                // Contém um contêiner visual básico (Surface) que ocupa todo o tamanho disponível
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    // Função Greeting é chamada para exibir uma mensagem
                    Greeting("Android")
                }
            }
        }
    }
}

// Composable que exibe uma mensagem de saudação
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Surface(color = Color.Blue) {
        // Renderiza um texto de saudação com o nome fornecido
        Text(
            text = "Olá meu nome é: $name",
            modifier = modifier.padding(24.dp),
            fontSize = 100. sp,
            lineHeight = 116. sp

        )
    }
}

// Composable de visualização para prévia do layout
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        // Mostra uma prévia da saudação com o nome "Laércio"
        Greeting("Laércio")
    }
}
