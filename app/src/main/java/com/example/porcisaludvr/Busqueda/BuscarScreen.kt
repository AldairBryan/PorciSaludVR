package com.example.porcisaludvr.Busqueda

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.porcisaludvr.ui.theme.Itim

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuscarScreen(navController: NavHostController) {
    var searchQuery by remember { mutableStateOf("") }
    var allSelectedTags by remember { mutableStateOf(setOf<String>()) }

    val modules = listOf(
        Module("Peste Porcina Clasica",
            setOf("tag1", "tagA"),
            Color(0,142,141,255),"info_enfermedad_ppc"),

        Module("Sarna Sarcoptica",
            setOf("tag2", "tagB"),
            Color(137,73,136,255),"info_enfermedad_sarna"),

        Module("Neumonia Enzootica",
            setOf("tag3", "tagC"),
            Color(211,58,84,255),"info_enfermedad_neumonia"),

        Module("Cuidados Sobre Cerdos",
            setOf("tag4", "tagD"),
            Color(175,180,43,255),"cuidados_cerdos"),
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

        if (searchQuery.isNotBlank() && filteredTags.isEmpty()) {
            Text("Tags de Búsqueda:")
            Text("Sin tags coincidentes encontrados")
        } else  {
            // Texto para indicar los Tags de Búsqueda
            if (searchQuery.isNotBlank() && filteredTags.isNotEmpty() ) {
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
        }

        if(searchQuery.isEmpty() && filteredTags.isNotEmpty()){
            Text(text = "Resultados")
            ModuleList(modules = filteredModules, selectedTags = allSelectedTags, navController= navController)
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SelectedTagsBar(
    selectedTags: Set<String>,
    onTagRemove: (String) -> Unit
) {
    FlowRow( modifier = Modifier
            .padding(8.dp)
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

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TagBar(
    tags: List<String>,
    selectedTags: Set<String>,
    onTagClick: (String) -> Unit
) {
    FlowRow (modifier = Modifier
        .padding(8.dp)) {
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
    selectedTags: Set<String>,
    navController: NavHostController
) {
    // Mostrar módulos en función de los tags seleccionados
    modules.forEach { module ->
        if (module.tags.any { it in selectedTags } || selectedTags.isEmpty()) {
            crearBoton(texto = module.name, color = module.color, route = module.route, navController = navController)
        }
    }
}
@Composable
fun crearBoton(texto: String, color: Color, route: String, navController: NavHostController){
    Button(
        onClick = {
            navController.navigate(route)
        },
        colors = ButtonDefaults.buttonColors(Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp, vertical = 8.dp)
            .shadow(elevation = 4.dp, shape = RoundedCornerShape(24.dp))
            .border(
                width = 5.dp, // Ancho del borde
                color = color, // Color del borde
                shape = RoundedCornerShape(24.dp) // Bordes redondeados
            )
            .background(Color.Transparent)
    ) {
        Text(text = texto,
            fontFamily = Itim,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = color,
            textAlign = TextAlign.Center)
    }
}

data class Module(val name: String, val tags: Set<String>, val color: Color,val route: String)