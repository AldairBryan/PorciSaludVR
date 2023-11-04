package com.example.porcisaludvr.GestionCerdos.views.cerdos

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
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.porcisaludvr.GestionCerdos.viewmodels.CerdosViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CerdosInicioView(navController: NavController, viewModel: CerdosViewModel){
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Cerdos Gestion", color= Color.White, fontWeight = FontWeight.Bold)
            },
                colors=TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("gestion_cerdos_agregar") },
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.White
                ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Agregar")
            }
        }
    ) {
        ContentCerdosInicioView(it, navController, viewModel)
    }
}

@Composable
fun ContentCerdosInicioView(it: PaddingValues, navController: NavController, viewModel: CerdosViewModel){
    val state = viewModel.state
    Column(
        modifier= Modifier.padding(it)
    ){
        LazyColumn {
            items(state.listaCerdos){
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ){
                    Column(
                        modifier= Modifier
                            .padding(12.dp)
                    ){
                        Text(text = it.nombre)
                        Text(text = it.peso.toString())
                        Text(text = it.fecha_obtencion)
                        Text(text = it.especieId.toString())
                        IconButton(
                            onClick = { navController.navigate("gestion_cerdos_editar/${it.id}/${it.nombre}/${it.peso}/${it.fecha_obtencion}/${it.especieId}") }
                        ) {
                            Icon(imageVector = Icons.Default.Edit, contentDescription = "Editar")
                        }
                        IconButton(
                            onClick = { viewModel.borrarCerdo(it) }
                        ) {
                            Icon(imageVector = Icons.Default.Delete, contentDescription = "Borrar")
                        }
                    }
                }
            }
        }
    }
}