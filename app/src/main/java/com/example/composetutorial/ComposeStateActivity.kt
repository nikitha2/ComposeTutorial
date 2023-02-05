package com.example.composetutorial

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetutorial.stateCodelab.Notes
import com.example.composetutorial.stateCodelab.WaterCount
import com.example.composetutorial.ui.theme.ComposeTutorialTheme

class ComposeStateActivity : BaseActivity() {


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


    @Composable
    fun WellnessScreen(modifier: Modifier = Modifier) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.greyBackground)),
        ) {
            WaterCount(modifier.fillMaxHeight(0.3f))
            Notes(
                notePadding = PaddingValues(horizontal = 24.dp, vertical = 8.dp),
                contentPadding = PaddingValues(vertical = 24.dp, horizontal = 24.dp)
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun WellnessScreenPreview() {
        ComposeTutorialTheme {
            WellnessScreen(Modifier)
        }
    }
}



