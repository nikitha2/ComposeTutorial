package com.example.composetutorial

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable

open class BaseActivity : ComponentActivity() {
    var context: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //Child classes will implement this part
        }

    }

    @Composable
    fun TopAppBar(title:String) {
        TopAppBar({ Text(text = title) })
    }
}