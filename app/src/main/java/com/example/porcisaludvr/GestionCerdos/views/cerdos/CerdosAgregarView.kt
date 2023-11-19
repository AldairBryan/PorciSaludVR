package com.example.porcisaludvr.GestionCerdos.views.cerdos

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.porcisaludvr.GestionCerdos.models.Cerdos
import com.example.porcisaludvr.GestionCerdos.viewmodels.CerdosViewModel
import com.example.porcisaludvr.GestionCerdos.viewmodels.EspeciesViewModel
import com.example.porcisaludvr.ui.theme.Itim

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CerdosAgregarView(navController: NavController, viewModel: CerdosViewModel, especiesDrop: EspeciesViewModel){
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Agregar Cerdo", color= Color.White, fontWeight = FontWeight.Bold)
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
        ContentCerdosAgregarView(it, navController, viewModel, especiesDrop)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentCerdosAgregarView(it: PaddingValues, navController: NavController, viewModel: CerdosViewModel, especiesDrop: EspeciesViewModel){
    var nombre by remember { mutableStateOf("") }
    var peso by remember { mutableStateOf("") }
    var fecha_obtencion by remember { mutableStateOf("") }
    var especieId by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var especieDesc by remember { mutableStateOf("")}
    Column (
        modifier = Modifier
            .padding(it)
            .padding(top = 30.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = nombre,
            onValueChange = {nombre = it},
            label = { Text(text = "Nombre", fontFamily = Itim, color = Color(246, 102, 149, 255))},
            shape = RoundedCornerShape(24.dp),
            textStyle = TextStyle(fontFamily = Itim),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(246, 102, 149, 255),
                unfocusedBorderColor = Color(246, 102, 149, 255),
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )
        OutlinedTextField(
            value = peso,
            onValueChange = {peso = it},
            label = { Text(text = "Peso", fontFamily = Itim, color = Color(246, 102, 149, 255))},
            shape = RoundedCornerShape(24.dp),
            textStyle = TextStyle(fontFamily = Itim),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(246, 102, 149, 255),
                unfocusedBorderColor = Color(246, 102, 149, 255),
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = fecha_obtencion,
            onValueChange = {fecha_obtencion = it},
            label = { Text(text = "Fecha de Obtencion", fontFamily = Itim, color = Color(246, 102, 149, 255))},
            shape = RoundedCornerShape(24.dp),
            textStyle = TextStyle(fontFamily = Itim),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(246, 102, 149, 255),
                unfocusedBorderColor = Color(246, 102, 149, 255),
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)
            .padding(bottom = 15.dp))
        {
                ExposedDropdownMenuBox(expanded = expanded, onExpandedChange ={ expanded = !expanded}) {
                TextField(
                    value = especieDesc,
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                    modifier = Modifier.menuAnchor(),
                    placeholder = {
                        Text(text = "Selecciona Especie")
                    },
                )
                ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded=false }) {
                    especiesDrop.state.listaEspecies.forEach {especie->
                        DropdownMenuItem(
                            text = {
                                   Text(text = especie.especie)
                            },
                            onClick = {
                                expanded = false
                                especieId = especie.id.toString()
                                especieDesc = especie.especie
                            })
                    }
                }
            }
        }
        Button(
            onClick = {
                val cerdo = Cerdos ( nombre = nombre, peso = peso.toDouble(), fecha_obtencion = fecha_obtencion, especieId = especieId.toInt() )
                viewModel.agregarCerdo(cerdo)
                navController.popBackStack()
            }
        ) {
            Text(text = "Agregar")
        }
    }
}