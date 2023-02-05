package com.example.composetutorial.stateCodelab

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.composetutorial.R
import com.example.composetutorial.ui.theme.ComposeTutorialTheme

@Composable
fun WaterCounter(modifier: Modifier, count: Int) {
    Text(
        modifier = modifier,
        textAlign = TextAlign.Center,
        text = "You've had $count glasses.",
    )
}

@Composable
fun AddButton(text: String, modifier: Modifier, onclickListener: () -> Unit) {
    Button(
        modifier = modifier,
        onClick = onclickListener,
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.surface)
    ) {
        Text(text = text, color = MaterialTheme.colors.background)
    }
}

/**
 * https://developer.android.com/codelabs/jetpack-compose-state?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fjetpack-compose-for-android-developers-1%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-state#4
 */
@Composable
fun WaterCount(modifier: Modifier) {
    var count by remember { mutableStateOf(0) }
    ConstraintLayout(modifier = modifier) {
        val (waterCountBlock, resetButton) = createRefs()

        AddButton(text = stringResource(R.string.reset),
            modifier = Modifier
                .padding(end = 24.dp, top = 24.dp)
                .constrainAs(resetButton) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                }) {
            count = 0
        }

        Column(
            modifier = Modifier.constrainAs(waterCountBlock) {
                top.linkTo(resetButton.bottom)
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end)
                start.linkTo(parent.start)
            },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            WaterCounter(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp), count
            )

            AddButton(
                stringResource(R.string.add_one), Modifier.padding(top = 16.dp)
            ) {
                count += 1
            }
        }
    }
}

@Composable
fun WaterCounterScreen(modifier: Modifier) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.greyBackground))
    ) {
        val (nextButton, waterCountBlock) = createRefs()

        WaterCount(
            modifier
                .fillMaxHeight(0.5f)
                .fillMaxWidth()
                .constrainAs(waterCountBlock) {
                    top.linkTo(parent.top)
                    bottom.linkTo(nextButton.top)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                })

        AddButton(text = stringResource(R.string.next),
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight(0.06f)
                .padding(horizontal = 24.dp)
                .constrainAs(nextButton) {
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom, margin = 24.dp)
                }) {}
    }
}

@Preview(showBackground = true)
@Composable
fun WaterCounterScreenPreview() {
    ComposeTutorialTheme {
        WaterCounterScreen(Modifier)
    }
}

@Preview(showBackground = true)
@Composable
fun WaterCountPreview() {
    ComposeTutorialTheme {
        WaterCount(
            Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        )
    }
}