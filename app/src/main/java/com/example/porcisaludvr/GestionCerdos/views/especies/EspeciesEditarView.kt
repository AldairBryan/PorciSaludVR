package com.example.porcisaludvr.GestionCerdos.views.especies

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.porcisaludvr.GestionCerdos.models.Especies
import com.example.porcisaludvr.GestionCerdos.viewmodels.EspeciesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EspeciesEditarView(navController: NavController, viewModel: EspeciesViewModel,
                       id: Int, especie: String?, informacion: String?){
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Editar Especie", color= Color.White, fontWeight = FontWeight.Bold)
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    IconButton(
                        onClick = { navController.popBackStack() }
                    ) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Regresar")
                    }
                }
            )
        }
    ){
        ContentEspeciesEditarView(it, navController, viewModel, id, especie, informacion)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentEspeciesEditarView(it: PaddingValues, navController: NavController, viewModel: EspeciesViewModel,
                              id: Int, especie: String?, informacion: String?){
    var especie by remember { mutableStateOf(especie) }
    var informacion by remember { mutableStateOf(informacion) }
    Column (
        modifier = Modifier
            .padding(it)
            .padding(top = 30.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = especie?: "",
            onValueChange = {especie = it},
            label = { Text(text = "Especie") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )
        OutlinedTextField(
            value = informacion?: "",
            onValueChange = {informacion = it},
            label = { Text(text = "Informacion") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp),
        )
        Button(
            onClick = {
                val especie = Especies ( especie = especie!!, informacion = informacion!!)
                viewModel.actualizarEspecie(especie)
                navController.popBackStack()
            }
        ) {
            Text(text = "Editar")
        }
    }
}