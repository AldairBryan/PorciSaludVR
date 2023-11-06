package com.example.porcisaludvr.GestionCerdos.views.diagnosticos

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.porcisaludvr.GestionCerdos.models.Diagnosticos
import com.example.porcisaludvr.GestionCerdos.viewmodels.DiagnosticosViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiagnosticosAgregarView(navController: NavController, viewModel: DiagnosticosViewModel){
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Agregar Diagnostico", color= Color.White, fontWeight = FontWeight.Bold)
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
        ContentDiagnosticosAgregarView(it, navController, viewModel)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentDiagnosticosAgregarView(it: PaddingValues, navController: NavController, viewModel: DiagnosticosViewModel){
    var cerdoId by remember { mutableStateOf("") }
    var estadoId by remember { mutableStateOf("") }
    var fecha by remember { mutableStateOf("") }
    var sintomas by remember { mutableStateOf("") }
    var observaciones by remember { mutableStateOf("") }
    Column (
        modifier = Modifier
            .padding(it)
            .padding(top = 30.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = estadoId,
            onValueChange = {estadoId = it},
            label = { Text(text = "Estado") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )
        OutlinedTextField(
            value = fecha,
            onValueChange = {fecha = it},
            label = { Text(text = "Fecha") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp),
        )
        OutlinedTextField(
            value = sintomas,
            onValueChange = {sintomas = it},
            label = { Text(text = "Sintomas") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )
        OutlinedTextField(
            value = observaciones,
            onValueChange = {observaciones = it},
            label = { Text(text = "Observaciones") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp),
        )
        Button(
            onClick = {
                val diagnostico = Diagnosticos ( cerdoId = 1, estadoId = estadoId.toInt(), fecha = fecha, sintomas = sintomas, observaciones = observaciones)
                viewModel.agregarDiagnostico(diagnostico)
                navController.popBackStack()
            }
        ) {
            Text(text = "Agregar")
        }
    }
}