package com.example.composetutorial.stateCodelab

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
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
 * @link[https://developer.android.com/jetpack/compose/state#state-hoisting]
 * State hoisting - Pattern of moving state to a composable's caller to make a composable stateless.
 * The general pattern for state hoisting in Jetpack Compose is to replace the state variable with two parameters:
 *  value: T: the current value to display
 *  onValueChange: (T) -> Unit: an event that requests the value to change, where T is the proposed new value
 * [StatefulWaterCount] hoisted count from StatelessCounter to StatefulCounter.
 */
@Composable
fun StatefulWaterCount(modifier: Modifier) {
    /**  [remember] - saves state across re-compositions
     *   [rememberSaveable] - saves states across configuration changes
     *                      (recreation of activity) and re-compositions
     *   [mutableStateOf] - Makes the parameter observable
     */
    var count by rememberSaveable { mutableStateOf(0) }
    StatelessWaterCount(modifier, count, onIncrement = { count += 1 }, onReset = { count = 0 })
}

/**
 * https://developer.android.com/codelabs/jetpack-compose-state?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fjetpack-compose-for-android-developers-1%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-state#4
 */
@Composable
fun StatelessWaterCount(
    modifier: Modifier, count: Int, onIncrement: () -> Unit, onReset: () -> Unit
) {
    ConstraintLayout(modifier = modifier) {
        val (waterCountBlock, resetButton) = createRefs()

        AddButton(text = stringResource(R.string.reset),
            modifier = Modifier
                .padding(end = 24.dp, top = 24.dp)
                .constrainAs(resetButton) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                }) {
            onReset.invoke()
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
                onIncrement.invoke()
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

        StatefulWaterCount(
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
        StatefulWaterCount(
            Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        )
    }
}