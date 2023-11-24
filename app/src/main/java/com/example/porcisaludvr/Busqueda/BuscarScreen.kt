package com.example.porcisaludvr.Busqueda

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuscarScreen(navController: NavHostController) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedTags by remember { mutableStateOf(setOf<String>()) }

    val modules = listOf(
        Module("Module 1", setOf("tag1", "tagA")),
        Module("Module 2", setOf("tag2", "tagB")),
        // Add more modules as needed
    )

    val filteredModules = modules.filter { module ->
        module.name.contains(searchQuery, ignoreCase = true) ||
                module.tags.any { it.contains(searchQuery, ignoreCase = true) }
    }

    val filteredTags = modules.flatMap { it.tags }.distinct().filter {
        it.contains(searchQuery, ignoreCase = true) || searchQuery.isBlank()
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Search bar
            OutlinedTextField(
                value = searchQuery,
                onValueChange = {
                    searchQuery = it
                    // Clear selected tags when the search query changes
                    selectedTags = setOf()
                },
                label = { Text("Search") },
                leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )

            // Display tags only when there is a search query
            if (searchQuery.isNotBlank() || selectedTags.isNotEmpty()) {
                TagBar(
                    tags = filteredTags,
                    selectedTags = selectedTags,
                    onTagClick = { tag ->
                        // Toggle tag selection
                        selectedTags = if (tag in selectedTags) {
                            selectedTags - tag
                        } else {
                            selectedTags + tag
                        }
                    }
                )
            }

            // Display modules
            ModuleList(modules = filteredModules, selectedTags = selectedTags)
        }
    }
}
@Composable
fun TagBar(
    tags: List<String>,
    selectedTags: Set<String>,
    onTagClick: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .horizontalScroll(rememberScrollState())
    ) {
        tags.forEach { tag ->
            TagChip(
                tag = tag,
                isSelected = tag in selectedTags,
                onTagClick = { onTagClick(tag) }
            )
        }
    }
}

@Composable
fun TagChip(
    tag: String,
    isSelected: Boolean,
    onTagClick: () -> Unit
) {
    OutlinedButton(
        onClick = { onTagClick() },
        modifier = Modifier
            .padding(end = 8.dp)
            .height(32.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = if (isSelected) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.primary
        )
    ) {
        Text(text = tag)
    }
}

@Composable
fun ModuleList(
    modules: List<Module>,
    selectedTags: Set<String>
) {
    // Display modules based on the selected tags
    modules.forEach { module ->
        if (module.tags.any { it in selectedTags } || selectedTags.isEmpty()) {
            // Show a button for each module
            Button(
                onClick = {
                    // TODO: Navigate to the specific screen for the clicked module
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(text = module.name)
            }
        }
    }
}
data class Module(val name: String, val tags: Set<String>)
