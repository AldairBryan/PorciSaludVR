package com.example.porcisaludvr.Busqueda

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuscarScreen(navController: NavHostController) {
    var searchQuery by remember { mutableStateOf("") }
    var allSelectedTags by remember { mutableStateOf(setOf<String>()) }

    val modules = listOf(
        Module("Module 1", setOf("tag1", "tagA")),
        Module("Module 2", setOf("tag2", "tagB")),
        // Add more modules as needed
    )

    val filteredModules = modules.filter { module ->
        module.name.contains(searchQuery, ignoreCase = true) ||
                module.tags.any { it.contains(searchQuery, ignoreCase = true) }
    }

    // Filtrar tags para que no aparezcan en "Tags de Búsqueda" si ya están seleccionados
    val filteredTags = modules.flatMap { it.tags }
        .distinct()
        .filter { it.contains(searchQuery, ignoreCase = true) || searchQuery.isBlank() }
        .filterNot { it in allSelectedTags }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Barra de búsqueda
        OutlinedTextField(
            value = searchQuery,
            onValueChange = {
                searchQuery = it
                // No hay cambio en los tags seleccionados al cambiar la búsqueda
            },
            label = { Text("Search") },
            leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        // Texto para indicar los Tags Seleccionados
        if (allSelectedTags.isNotEmpty()) {
            Text("Tags Seleccionados:")
            // Barra de tags seleccionados
            SelectedTagsBar(
                selectedTags = allSelectedTags,
                onTagRemove = { tag ->
                    allSelectedTags -= tag
                }
            )
        }

        // Texto para indicar los Tags de Búsqueda
        if (filteredTags.isNotEmpty()) {
            Text("Tags de Búsqueda:")
            // Barra de tags de búsqueda
            TagBar(
                tags = filteredTags,
                selectedTags = allSelectedTags,
                onTagClick = { tag ->
                    // Alternar la selección de tag
                    allSelectedTags = if (tag in allSelectedTags) {
                        allSelectedTags - tag
                    } else {
                        allSelectedTags + tag
                    }
                    // Limpiar la búsqueda al agregar un tag
                    searchQuery = ""
                }
            )
        }

        // Mostrar módulos
        ModuleList(modules = filteredModules, selectedTags = allSelectedTags)
    }
}


@Composable
fun SelectedTagsBar(
    selectedTags: Set<String>,
    onTagRemove: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        selectedTags.forEach { tag ->
            TagChip(
                tag = tag,
                isSelected = true,
                onTagClick = { onTagRemove(tag) }
            )
        }
    }
}

@Composable
fun TagBar(
    tags: List<String>,
    selectedTags: Set<String>,
    onTagClick: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
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
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(text = tag)
            if (isSelected) {
                // Mostrar la "X" para eliminar el tag
                Icon(imageVector = Icons.Default.Close, contentDescription = null)
            }
        }
    }
}

@Composable
fun ModuleList(
    modules: List<Module>,
    selectedTags: Set<String>
) {
    // Mostrar módulos en función de los tags seleccionados
    modules.forEach { module ->
        if (module.tags.any { it in selectedTags } || selectedTags.isEmpty()) {
            // Mostrar un botón para cada módulo
            Button(
                onClick = {
                    // TODO: Navegar a la pantalla específica para el módulo clicado
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