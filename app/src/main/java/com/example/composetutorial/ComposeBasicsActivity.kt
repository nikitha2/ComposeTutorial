package com.example.composetutorial

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetutorial.ui.theme.ComposeTutorialTheme

class  ComposeBasicsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme {
                MyApp()
            }
        }
    }

    data class Greeting(val greetingText: String, val body: String)

    @Composable
    fun DisplayListOfGreetings(greetings: List<Greeting>) {
        LazyColumn(modifier = Modifier.padding(2.dp)) {
            items(greetings) { greeting ->
                Row(modifier = Modifier.padding(2.dp)) {
                    Surface(color = MaterialTheme.colors.primary) {
                        GreetingCard(greeting)
                    }
                }
            }
        }
    }

    @Composable
    fun MyApp() {
        Surface(
            color = MaterialTheme.colors.background
        ) {
            // This state should be hoisted as its being used in child composable. We have a callback to change the value
            /*"remember" saves state when data changes, but value for remember object persists
            What happens if there is a configuration change? Say theme changed from light to dark. Due to configuration change our activity will be re-generated as a result
            we will be seeing OnBoardingScreen again even when we are in greetingsScreen. TO avoid this we can ise "rememberSaveable" to save state during configuration changes
            and also during re-composition
            */
            var shouldShowOnboarding by rememberSaveable{ mutableStateOf(true) }
            if(shouldShowOnboarding){
                OnBoardingScreen(onContinueClicked = { shouldShowOnboarding = false })
            }else
                DisplayListOfGreetings(SampleData.cards)
        }
    }

    @Composable
    private fun GreetingCard(greeting: Greeting) {
        var isExpanded by remember { mutableStateOf(false) }
        val extraPadding by animateDpAsState(
            targetValue = if(isExpanded) 4.dp else 0.dp,
           // animationSpec = tween(durationMillis = 500) // This will slow the animation by 1/2 second
        )
        val contentDescription = if (isExpanded) stringResource(R.string.show_less) else stringResource(R.string.show_more)

        Column(modifier = Modifier.padding(24.dp)) {
            Row(verticalAlignment = CenterVertically) {
                Text(text = greeting.greetingText, modifier = Modifier.weight(1f))

               // OutlinedButton gives a button with outline
//                OutlinedButton(onClick = {
//                    isExpanded = !isExpanded
//                }) {
//                    Text(if (isExpanded) "Show less" else "Show more")
//                }

                //Lets use icon instead of the button above
                IconButton(onClick = {  isExpanded = !isExpanded }) {
                    Icon(
                        imageVector = if (isExpanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                        contentDescription = contentDescription
                    )
                }
            }
            if (isExpanded)
                Text(
                    text = greeting.body,
                    modifier = Modifier.padding(all = extraPadding)
                )
        }
    }

    @Composable
    fun OnBoardingScreen(onContinueClicked: () -> Unit) {
        Surface {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Welcome to the Basics CodeLab!")
                Button(
                    modifier = Modifier.padding(vertical = 24.dp),
                    onClick = onContinueClicked
                ) {
                    Text("Continue")
                }
            }
        }
    }

    //preview light mode
    @Preview(name = "Light Mode", showBackground = true)
    //preview dark mode
    @Preview(
        uiMode = Configuration.UI_MODE_NIGHT_YES,
        showBackground = true,
        name = "Dark Mode"
    )
    @Composable
    fun OnBoardingPreview() {
        ComposeTutorialTheme {
            OnBoardingScreen(onContinueClicked = {})
        }
    }

    //preview light mode
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
            DisplayListOfGreetings(SampleData.cards)
        }
    }
}
