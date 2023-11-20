package com.example.porcisaludvr.GestionCerdos.views.cerdos

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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.porcisaludvr.GestionCerdos.models.Cerdos
import com.example.porcisaludvr.GestionCerdos.viewmodels.CerdosViewModel
import com.example.porcisaludvr.GestionCerdos.viewmodels.EspeciesViewModel
import com.example.porcisaludvr.ui.theme.Itim

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CerdosEditarView(navController: NavController, viewModel: CerdosViewModel, especiesDrop: EspeciesViewModel,
                     id: Int, nombre: String?, peso: Double?, fecha_obtencion: String?, especieId: Int?){
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Editar Cerdo", fontFamily = Itim,
                        color= Color(246,102,149,255), fontWeight = FontWeight.Bold,
                        fontSize = 25.sp)
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.White
                ),
                navigationIcon = {
                    IconButton(
                        onClick = { navController.popBackStack() }
                    ) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Regresar", tint = Color(246,102,149,255))
                    }
                }
            )
        }
    ){
        ContentCerdosEditarView(it, navController, viewModel,especiesDrop, id, nombre, peso, fecha_obtencion, especieId)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentCerdosEditarView(it: PaddingValues, navController: NavController, viewModel: CerdosViewModel, especiesDrop: EspeciesViewModel,
                            id: Int, nombre: String?, peso: Double?, fecha_obtencion: String?, especieId: Int?){
    var nombre by remember { mutableStateOf(nombre) }
    var peso by remember { mutableStateOf(peso.toString()) }
    var fecha_obtencion by remember { mutableStateOf(fecha_obtencion) }
    var especieIdChange by remember { mutableStateOf(especieId.toString()) }

    var expanded by remember { mutableStateOf(false) }
    var especieDesc by remember { mutableStateOf(especieId.toString())}
    Column (
        modifier = Modifier
            .padding(it)
            .padding(top = 30.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = nombre ?: "",
            onValueChange = {nombre = it},
            label = { Text(text = "Nombre") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )
        OutlinedTextField(
            value = peso ?: "",
            onValueChange = {peso = it},
            label = { Text(text = "Peso") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = fecha_obtencion ?: "",
            onValueChange = {fecha_obtencion = it},
            label = { Text(text = "Fecha de Obtencion") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )
        ExposedDropdownMenuBox(expanded = expanded, onExpandedChange ={ expanded = !expanded},
            modifier = Modifier.padding(bottom = 15.dp),
        ) {
            TextField(
                value = especieDesc,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.menuAnchor(),
                colors = TextFieldDefaults.textFieldColors( containerColor =  Color.White,
                    focusedTrailingIconColor = Color(246,102,149,255),
                    unfocusedTrailingIconColor = Color(246,102,149,255),
                    unfocusedIndicatorColor = Color(246,102,149,255),
                    focusedIndicatorColor = Color(246,102,149,255)),
                placeholder = {
                    Text(text = "Selecciona Especie", fontFamily = Itim, // Cambia la fuente
                        color =  Color(246,102,149,255))
                },
                textStyle = TextStyle(
                    fontFamily = Itim, // Cambia la fuente
                    color =  Color(246,102,149,255) // Cambia el color del texto
                ),
            )
            ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded=false },
                modifier = Modifier.background(color = Color.White)) {
                especiesDrop.state.listaEspecies.forEach {especie->
                    DropdownMenuItem(
                        text = {
                            Text(text = especie.especie, fontFamily = Itim, // Cambia la fuente
                                color =  Color(246,102,149,255))
                        },
                        modifier = Modifier.background(
                            color = Color.White
                        ),
                        onClick = {
                            expanded = false
                            especieIdChange = especie.id.toString()
                            especieDesc = especie.especie
                        })
                }
            }
        }
        Button(
            onClick = {
                val cerdo = Cerdos ( id = id, nombre = nombre!!, peso = peso.toDouble()!!, fecha_obtencion = fecha_obtencion!!, especieId = especieIdChange.toInt()!! )
                viewModel.actualizarCerdo(cerdo)
                navController.popBackStack()
            }
        ) {
            Text(text = "Editar")
        }
    }
}