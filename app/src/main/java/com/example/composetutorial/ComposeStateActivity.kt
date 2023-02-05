package com.example.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.composetutorial.stateCodelab.waterCounterScreen
import com.example.composetutorial.ui.theme.ComposeTutorialTheme

class ComposeStateActivity  : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    WellnessScreen(Modifier)
                }
            }
        }
    }
}

@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {
    waterCounterScreen(modifier)
}