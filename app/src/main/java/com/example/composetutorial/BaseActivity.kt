package com.example.composetutorial

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

open class BaseActivity : ComponentActivity() {
    var context: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //Child classes will implement this part
        }

    }

    @Composable
    fun SetToolbar(title: String) {
        TopAppBar(
            title = {
                Text(text = title)
            },
            backgroundColor = MaterialTheme.colors.surface,
            elevation = 10.dp
        )
    }
}