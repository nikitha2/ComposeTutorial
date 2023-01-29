package com.example.composetutorial

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.composetutorial.ui.theme.ComposeTutorialTheme

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.primary
                ){
                    SetButtons(SampleData.buttons)
                }
            }
        }
    }

    data class Button(val text: String, val screenToOpen: String)

    @Composable
    private fun SetButtons(buttons: List<Button>) {
        SetToolbar(stringResource(R.string.mainLabel))
        context = LocalContext.current
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            items(buttons) { button ->
                Button(onClick = {
                    openActivity(button.screenToOpen)
                }) {
                    Text(text = button.text)
                }
        }
    }
    }

    private fun openActivity(screenToOpen: String) {
        when (screenToOpen) {
            "ComposeOverviewTutorialActivity" -> context?.startActivity(Intent(context, ChatActivity::class.java))
            "ComposeBasicsActivity" -> context?.startActivity(Intent(context, ComposeBasicsActivity::class.java))
            "ComposeMigrateActivity" -> context?.startActivity(Intent(context, ComposeMigrateActivity::class.java))
            "ComposeBasicLayoutsActivity" -> context?.startActivity(Intent(context, ComposeBasicLayoutsActivity::class.java))
            "ComposeThemeLayoutsActivity" -> context?.startActivity(Intent(context, ComposeThemeLayoutsActivity::class.java))
            "ComposeStateActivity" -> context?.startActivity(Intent(context, ComposeStateActivity::class.java))

            else -> context?.startActivity(Intent(context, ChatActivity::class.java))
        }
    }

    @Preview(name = "Light Mode", showBackground = true)
    //preview dark mode
    @Preview(
        uiMode = Configuration.UI_MODE_NIGHT_YES,
        showBackground = true,
        name = "Dark Mode"
    )
    @Composable
    fun DefaultPreview() {
        ComposeTutorialTheme {
            SetButtons(SampleData.buttons)
        }
    }
}
