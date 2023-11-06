package com.example.porcisaludvr.GestionCerdos.views.cerdos

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.wear.compose.material.MaterialTheme.colors
import com.example.porcisaludvr.GestionCerdos.viewmodels.CerdosViewModel
import com.example.porcisaludvr.R
import com.example.porcisaludvr.ui.theme.Itim

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CerdosInicioView(navController: NavController, viewModel: CerdosViewModel){
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Cerdos Gestion", fontFamily = Itim
                        ,color= Color(246,102,149,255), fontWeight = FontWeight.Bold,
                        fontSize = 25.sp)
            },
                colors=TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.White
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("gestion_cerdos_agregar") },
                containerColor = Color.White,
                contentColor = Color(246,102,149,255)
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
    val openDialog = remember { mutableStateOf(false)  }
    Column(
        modifier= Modifier
            .fillMaxSize()
            .padding(it)
    ){
        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(state.listaCerdos){
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .shadow(elevation = 4.dp, shape = RoundedCornerShape(24.dp))
                        .border(
                            width = 5.dp, // Ancho del borde
                            color = Color(246,102,149,255),
                            shape = RoundedCornerShape(24.dp) // Bordes redondeados
                        )
                        .background(Color.White)
                        .clickable( onClick = {
                            navController.navigate("gestion_diagnosticos")
                        })
                ){
                    Column(
                        modifier= Modifier
                            .padding(12.dp)
                    ){
                        Text(text = "Nombre: "+it.nombre, fontFamily = Itim)
                        Text(text = "Peso: "+it.peso.toString()+ "kg", fontFamily = Itim)
                        Text(text = "Fecha de Obtencion: "+it.fecha_obtencion, fontFamily = Itim)
                        Row ( modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween){
                            Text(text = "Especie: "+it.especieId.toString(), fontFamily = Itim)
                            Row {
                                IconButton(
                                    onClick = { navController.navigate("gestion_cerdos_editar/${it.id}/${it.nombre}/${it.peso}/${it.fecha_obtencion}/${it.especieId}") }
                                ) {
                                    Icon(imageVector = Icons.Default.Edit, contentDescription = "Editar")
                                }
                                IconButton(
                                    onClick = { openDialog.value=true }
                                ) {
                                    Icon(imageVector = Icons.Default.Delete, contentDescription = "Borrar")
                                }
                            }
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
                                            viewModel.borrarCerdo(it)
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
        Row {
            Button( onClick = {navController.navigate("gestion_especies") },
                colors = ButtonDefaults.buttonColors(Color.Transparent),
                modifier = Modifier.border(
                    width = 5.dp, // Ancho del borde
                    color = Color(211,58,84,255), // Color del borde
                    shape = RoundedCornerShape(16.dp) // Bordes redondeados
                ).background(Color.Transparent)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.gestion_especies),
                        contentDescription = "icon", // Puedes proporcionar una descripción adecuada aquí
                        modifier = Modifier
                            .size(100.dp)
                    )
                    Text(text = "Especies",
                        fontFamily = Itim,
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(211,58,84,255),
                        textAlign = TextAlign.Center)
                }
            }
            Button(onClick = { navController.navigate("gestion_medicamentos") },
                colors = ButtonDefaults.buttonColors(Color.Transparent),
                modifier = Modifier.border(
                    width = 5.dp, // Ancho del borde
                    color = Color(137,73,136,255), // Color del borde
                    shape = RoundedCornerShape(16.dp) // Bordes redondeados
                ).background(Color.Transparent)
                ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.gestion_medicamentos),
                        contentDescription = "icon", // Puedes proporcionar una descripción adecuada aquí
                        modifier = Modifier
                            .size(100.dp)
                    )
                    Text(text = "Medicamentos",
                        fontFamily = Itim,
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(137,73,136,255),
                        textAlign = TextAlign.Center)
                }
            }
        }
    }
}