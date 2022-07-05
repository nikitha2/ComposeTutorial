package com.example.composetutorial

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Palette
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetutorial.ui.theme.ComposeTutorialTheme
import java.util.*

/*Link to codeLab
* https://developer.android.com/codelabs/jetpack-compose-theming?authuser=1&continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%3Fauthuser%3D1%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-theming#1
* */
class ComposeThemeLayoutsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SetupNewsReaderScreen()
                }
            }
        }
    }

    @Composable
    private fun SetupNewsReaderScreen() {
        Home()
    }

    @Composable
    fun Home() {
        val featured = remember { SampleData.PostRepo.getFeaturedPost() }
        val posts = remember { SampleData.PostRepo.getPosts() }
        MaterialTheme {
            Scaffold(
                topBar = { AppBar() }
            ) { innerPadding ->
                LazyColumn(contentPadding = innerPadding) {
                    item {
                        Header(stringResource(R.string.top))
                    }
                    item {
                        FeaturedPost(
                            post = featured,
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                    item {
                        Header(stringResource(R.string.popular))
                    }
                    items(posts) { post ->
                        PostItem(post = post)
                        Divider(startIndent = 72.dp)
                    }
                }
            }
        }
    }

    @Composable
    private fun AppBar() {
        TopAppBar(
            navigationIcon = {
                Icon(
                    imageVector = Icons.Rounded.Palette,
                    contentDescription = null,
                    modifier = Modifier.padding(horizontal = 12.dp)
                )
            },
            title = {
                Text(text = stringResource(R.string.app_name_theming))
            },
            backgroundColor = MaterialTheme.colors.primary
        )
    }

    @Composable
    fun Header(
        text: String,
        modifier: Modifier = Modifier
    ) {
        Text(
            text = text,
            modifier = modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .semantics { heading() }
                .padding(horizontal = 16.dp, vertical = 8.dp)
        )
    }

    @Composable
    fun FeaturedPost(
        post: SampleData.Post,
        modifier: Modifier = Modifier
    ) {
        Card(modifier) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { /* onClick */ }
            ) {
                Image(
                    painter = painterResource(post.imageId),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .heightIn(min = 180.dp)
                        .fillMaxWidth()
                )
                Spacer(Modifier.height(16.dp))

                val padding = Modifier.padding(horizontal = 16.dp)
                Text(
                    text = post.title,
                    modifier = padding
                )
                Text(
                    text = post.metadata.author.name,
                    modifier = padding
                )
                PostMetadata(post, padding)
                Spacer(Modifier.height(16.dp))
            }
        }
    }

    @Composable
    private fun PostMetadata(
        post: SampleData.Post,
        modifier: Modifier = Modifier
    ) {
        val divider = "  •  "
        val tagDivider = "  "
        val text = buildAnnotatedString {
            append(post.metadata.date)
            append(divider)
            append(stringResource(R.string.read_time, post.metadata.readTimeMinutes))
            append(divider)
            post.tags.forEachIndexed { index, tag ->
                if (index != 0) {
                    append(tagDivider)
                }
                append(" ${tag.uppercase(Locale.getDefault())} ")
            }
        }
        Text(
            text = text,
            modifier = modifier
        )
    }

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun PostItem(
        post: SampleData.Post,
        modifier: Modifier = Modifier
    ) {
        ListItem(
            modifier = modifier
                .clickable { /* todo */ }
                .padding(vertical = 8.dp),
            icon = {
                Image(
                    painter = painterResource(post.imageThumbId),
                    contentDescription = null
                )
            },
            text = {
                Text(text = post.title)
            },
            secondaryText = {
                PostMetadata(post)
            }
        )
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
        SetupNewsReaderScreen()
    }
}