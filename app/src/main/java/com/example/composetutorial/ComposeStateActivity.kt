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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composetutorial.stateCodelab.StatefulWaterCount
import com.example.composetutorial.stateCodelab.WellnessTasksList
import com.example.composetutorial.stateCodelab.viewModel.WellnessViewModel
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
    fun WellnessScreen(
        modifier: Modifier = Modifier,
        wellnessViewModel: WellnessViewModel = viewModel()
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.greyBackground)),
        ) {
            StatefulWaterCount(modifier.fillMaxHeight(0.3f))

            WellnessTasksList(
                notePadding = PaddingValues(horizontal = 24.dp, vertical = 8.dp),
                contentPadding = PaddingValues(vertical = 24.dp, horizontal = 24.dp),
                list = wellnessViewModel.getTasks(),
                onClose = { task ->
                    wellnessViewModel.removeTask(task)
                },
                onCheckboxClicked = { task, checked ->
                    wellnessViewModel.changeTaskChecked(task, checked)
                }
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



