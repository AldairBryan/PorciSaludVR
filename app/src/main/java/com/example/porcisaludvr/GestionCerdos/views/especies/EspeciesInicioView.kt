package com.example.porcisaludvr.GestionCerdos.views.especies

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.porcisaludvr.GestionCerdos.viewmodels.EspeciesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EspeciesInicioView(navController: NavController, viewModel: EspeciesViewModel){
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Especies Gestion", color= Color.White, fontWeight = FontWeight.Bold)
                },
                colors= TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("gestion_especies_agregar") },
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.White
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Agregar")
            }
        }
    ) {
        ContentEspeciesInicioView(it, navController, viewModel)
    }
}

@Composable
fun ContentEspeciesInicioView(it: PaddingValues, navController: NavController, viewModel: EspeciesViewModel){
    val state = viewModel.state
    val openDialog = remember { mutableStateOf(false)  }
    Column(
        modifier= Modifier.padding(it)
    ){
        LazyColumn {
            items(state.listaEspecies){
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ){
                    Column(
                        modifier= Modifier
                            .padding(12.dp)
                    ){
                        Text(text = it.especie)
                        Text(text = it.informacion)
                        IconButton(
                            onClick = { navController.navigate("gestion_especies_editar/${it.id}/${it.especie}/${it.informacion}") }
                        ) {
                            Icon(imageVector = Icons.Default.Edit, contentDescription = "Editar")
                        }
                        IconButton(
                            onClick = { openDialog.value=true }
                        ) {
                            Icon(imageVector = Icons.Default.Delete, contentDescription = "Borrar")
                        }
                        if (openDialog.value) {
                            AlertDialog(
                                onDismissRequest = {
                                    openDialog.value = false
                                },
                                title = { Text(text = "Confirmación") },
                                text = { Text(text = "¿Estás seguro de que deseas borrar este registro?") },
                                confirmButton = {
                                    Button(
                                        onClick = {
                                            viewModel.borrarEspecie(it)
                                            openDialog.value = false
                                        }
                                    ) {
                                        Text(text = "Sí")
                                    }
                                },
                                dismissButton = {
                                    Button(
                                        onClick = {
                                            openDialog.value = false
                                        }
                                    ) {
                                        Text(text = "Cancelar")
                                    }
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}