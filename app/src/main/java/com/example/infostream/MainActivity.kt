package com.example.infostream

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.example.infostream.ui.theme.InfoStreamTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InfoStreamTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Title_News(innerPadding)
                }
            }
        }
    }
    @Composable
    fun Title_News(innerPadding: PaddingValues){
        val Newsviewmodel = ViewModelProvider(this)[NewsViewModel::class.java]
        Column (
            modifier = Modifier.padding(innerPadding).fillMaxSize(),
        ){
            Text(
                text = "News Title",
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                color = Color.Red,
                fontSize = 25.sp,
                fontFamily = FontFamily.Serif
            )
            HomePage(Newsviewmodel)
        }
    }
}

