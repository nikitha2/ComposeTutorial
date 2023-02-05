package com.example.composetutorial

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetutorial.ui.theme.ComposeTutorialTheme
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.imagepipeline.backends.okhttp3.OkHttpImagePipelineConfigFactory
import okhttp3.OkHttpClient
import java.util.*

class ComposeBasicLayoutsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val pipelineConfig =
            OkHttpImagePipelineConfigFactory
                .newBuilder(this, OkHttpClient.Builder().build())
                .setDiskCacheEnabled(true)
                .setDownsampleEnabled(true)
                .setResizeAndRotateEnabledForNetwork(true)
                .build()

        Fresco.initialize(this, pipelineConfig)
        setContent {
            ComposeTutorialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.primary,
                ) {
                    SetupMySootheScreen(SampleData.workouts)
                }
            }
        }
    }

    data class Workout(val name: String, @DrawableRes val image: Int)

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Composable
    private fun SetupMySootheScreen(workouts: List<Workout>) {
        context = LocalContext.current

        Scaffold(
            bottomBar = { SootheBottomNavigation() },
            backgroundColor = colorResource(id = R.color.greyBackground)
        ) {
            Column(
                Modifier.background(colorResource(id = R.color.greyBackground))
            ) {
                SearchBar(
                    Modifier
                        .padding(dimensionResource(id = R.dimen.Padding4))
                        .fillMaxWidth()
                        .heightIn(min = 56.dp)
                )
                HomeSection(R.string.align_your_body) {
                    AlignYourBody(workouts)
                }

                HomeSection(R.string.favorite_collection) {
                    Favorites(workouts)
                }
            }
        }
    }

    @Composable
    fun SearchBar(
        modifier: Modifier
    ) {
        var textFieldText by remember { mutableStateOf("") }

        //https://developer.android.com/jetpack/compose/text#enter-modify-text
        TextField(
            value = textFieldText,
            onValueChange = {
                textFieldText=it
                Toast.makeText(context, textFieldText,Toast.LENGTH_SHORT).show()},
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    tint=colorResource(id = R.color.black)
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor =colorResource(id = R.color.white),
                textColor=colorResource(id = R.color.black),
                cursorColor=colorResource(id = R.color.black),
                placeholderColor=colorResource(id = R.color.black),
            ),
            placeholder = {
                Text(stringResource(R.string.placeholder_search))
            },
            modifier = modifier
        )
    }

    @Composable
    private fun SootheBottomNavigation(modifier: Modifier = Modifier) {
        BottomNavigation(
            backgroundColor = colorResource(id = R.color.greyBackground),
            modifier = modifier
        ) {
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = Icons.Default.Spa,
                        contentDescription = null
                    )
                },
                label = {
                    Text(stringResource(R.string.bottom_navigation_home))
                },
                selected = true,
                onClick = {Toast.makeText(context,"${getString(R.string.bottom_navigation_home)} clicked",Toast.LENGTH_SHORT).show()}
            )
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = null
                    )
                },
                label = {
                    Text(stringResource(R.string.bottom_navigation_profile))
                },
                selected = false,
                onClick = {Toast.makeText(context,"${getString(R.string.bottom_navigation_profile)} clicked",Toast.LENGTH_SHORT).show()}
            )
        }
    }

    @Composable
    fun Favorites(workouts: List<Workout>) {
        LazyHorizontalGrid(
            rows = GridCells.Fixed(2),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .height(120.dp)
        ) {
            items(workouts.size) { workoutIndex ->
                FavoriteCollectionElement(workouts[workoutIndex])
            }
        }
    }

    @Composable
    fun AlignYourBody(workouts: List<Workout>) {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(workouts) { workout ->
                AlignYourBodyElement(
                    workout,
                    Modifier
                        .size(88.dp)
                        .clip(CircleShape),
                    Modifier
                        .paddingFromBaseline(top = 24.dp, bottom = 8.dp)
                        .size(88.dp)
                        .wrapContentHeight()
                )
            }
        }
    }

    @Composable
    private fun AlignYourBodyElement(
        workout: Workout,
        modifier: Modifier,
        modifier_text: Modifier
    ) {
        Column(
            horizontalAlignment = CenterHorizontally,
            modifier = Modifier.padding(dimensionResource(id = R.dimen.paddingBetweenCards))
        ) {
            Image(
                painter = painterResource(workout.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier,
            )

            Text(
                text = workout.name,
                modifier = modifier_text.fillMaxWidth(),
                style = MaterialTheme.typography.h3,
                fontStyle = FontStyle(R.style.Theme_ComposeTutorial),
                color = colorResource(id = R.color.black),
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )
        }
    }

    @Composable
    private fun FavoriteCollectionElement(workout: Workout) {
        Card(
            shape = MaterialTheme.shapes.small,
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.paddingBetweenCards))
                .width(dimensionResource(id = R.dimen.cardWidth))
        ) {
            Row(
                verticalAlignment = CenterVertically,
                modifier = Modifier
                    .background(color = colorResource(id = R.color.white))
                    .width(192.dp)
            ) {
                Image(
                    painter = painterResource(workout.image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(56.dp)
                )
                Text(
                    text = workout.name, modifier = Modifier
                        .wrapContentHeight(CenterVertically)
                        .padding(horizontal = dimensionResource(id = R.dimen.Padding4))
                        .align(CenterVertically),
                    color = colorResource(id = R.color.black),
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.h3

                )
            }
        }
    }

    @Composable
    fun HomeSection(
        @StringRes title: Int,
        modifier: Modifier = Modifier,
        content: @Composable () -> Unit
    ) {
        Column(modifier) {
            Text(
                text = stringResource(title).uppercase(Locale.getDefault()),
                style = MaterialTheme.typography.h2,
                modifier = Modifier
                    .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
                    .padding(horizontal = 16.dp),
                fontSize = 24.sp
            )
            content()
        }
    }

    @Preview(name = "Light Mode", showBackground = true, backgroundColor = 0xFFF0EAE2)
    //preview dark mode
    @Preview(
        uiMode = Configuration.UI_MODE_NIGHT_YES,
        showBackground = true, backgroundColor = 0xFFF0EAE2,
        name = "Dark Mode"
    )
    @Composable
    fun DefaultPreview() {
        SetupMySootheScreen(SampleData.workouts)
    }
}