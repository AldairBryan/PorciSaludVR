package com.example.porcisaludvr.GestionCerdos.views.medicamentos

import androidx.compose.foundation.background
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
import com.example.porcisaludvr.GestionCerdos.models.Medicamentos
import com.example.porcisaludvr.GestionCerdos.viewmodels.MedicamentosViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MedicamentosEditarView(navController: NavController, viewModel: MedicamentosViewModel,
                           id: Int, medicamento: String?, precio: Double?, descripcion: String?){
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Editar Medicamentos", color= Color.White, fontWeight = FontWeight.Bold)
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
        ContentMedicamentosEditarView(it, navController, viewModel, id, medicamento, precio, descripcion)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentMedicamentosEditarView(it: PaddingValues, navController: NavController, viewModel: MedicamentosViewModel,
                                  id: Int, medicamento: String?, precio: Double?, descripcion: String?){
    var medicamento by remember { mutableStateOf(medicamento) }
    var precio by remember { mutableStateOf(precio.toString()) }
    var descripcion by remember { mutableStateOf(descripcion) }
    Column (
        modifier = Modifier
            .padding(it)
            .padding(top = 30.dp)
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = medicamento?: "",
            onValueChange = {medicamento = it},
            label = { Text(text = "Medicamento") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )
        OutlinedTextField(
            value = precio?: "",
            onValueChange = {precio = it},
            label = { Text(text = "Precio") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = descripcion?: "",
            onValueChange = {descripcion = it},
            label = { Text(text = "Descripcion") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )
        Button(
            onClick = {
                val medicamento = Medicamentos ( medicamento = medicamento!!, precio = precio.toDouble()!!, descripcion = descripcion!!)
                viewModel.actualizarMedicamento(medicamento)
                navController.popBackStack()
            }
        ) {
            Text(text = "Editar")
        }
    }
}