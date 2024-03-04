package com.example.appvideoaula

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.appvideoaula.ui.theme.AppVideoAulaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           PrimeiraTela()
        }
    }

    

    @Composable
    fun PrimeiraTela() {
        Column {
            Text(text = "Hello Word!")
            Text(text = "Teste 01")
            Text(text = "Laércio")
        }

    }

    @Preview
    @Composable
    fun PrimeiraTelaPreview() {
        PrimeiraTela()
    }
}
