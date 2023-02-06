package com.example.composetutorial.stateCodelab

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetutorial.SampleData
import com.example.composetutorial.ui.theme.ComposeTutorialTheme

@Composable
fun ShowNotesScreen(
    note: String,
    modifier: Modifier,
    checked: Boolean,
    onCheck: (Boolean) -> Unit,
    onClose: () -> Unit
) {
    Row(modifier = modifier.fillMaxWidth(),
        verticalAlignment= Alignment.CenterVertically) {
        Text(
            text = "Task # $note",
            modifier = modifier,
            color = MaterialTheme.colors.onPrimary
        )

        Checkbox(checked = checked, onCheckedChange = onCheck)
        IconButton(onClick = onClose) {
            Icon(Icons.Filled.Close, contentDescription = "Close")
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Notes(notePadding: PaddingValues, contentPadding: PaddingValues) {
    LazyColumn(contentPadding = contentPadding) {
        stickyHeader {
            Text(
                text = "Notes!!",
                Modifier
                    .fillMaxWidth()
                    .background(color = MaterialTheme.colors.surface)
                    .padding(8.dp),
                color = MaterialTheme.colors.background,
            )
        }
        items(SampleData.noteItems) { item ->
            var checked by rememberSaveable { mutableStateOf(false) }
            var showTask by rememberSaveable { mutableStateOf(true) }

            if (showTask){
                ShowNotesScreen(item, Modifier.padding(notePadding),
                    checked = checked,
                    onCheck = {
                        checked = !checked
                    },
                    onClose = {
                        showTask = false
                    })
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun NotesPreview() {
    ComposeTutorialTheme {
        Notes(
            notePadding = PaddingValues(vertical = 8.dp),
            contentPadding = PaddingValues(vertical = 24.dp, horizontal = 24.dp)
        )
    }
}