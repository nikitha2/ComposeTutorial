package com.example.composetutorial.stateCodelab.viewModel

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.composetutorial.ui.theme.ComposeTutorialTheme

/**
 * @param count is the value
 * @param onButtonClickListener is the onValueChange
 * */
@Composable
fun MediumArticleCodeStateless(count: Int, onButtonClickListener: () -> Unit) {
//    var count : MutableState<Int> = remember { mutableStateOf(0) }
//    var count by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            textAlign = TextAlign.Center,
            text = "You've had $count glasses.",
        )

        Button(onClick = onButtonClickListener) {
            Text(text = "Add one")
        }
    }
}

@Composable
fun MediumArticleCodeStateful() {
    var count by rememberSaveable { mutableStateOf(0) }
    MediumArticleCodeStateless(count, onButtonClickListener = { count += 1 })
}


@Preview(showBackground = true)
@Composable
fun MediumArticleCodePreview() {
    ComposeTutorialTheme {
        MediumArticleCodeStateful()
    }
}