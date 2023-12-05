package com.example.porcisaludvr

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.porcisaludvr.ui.theme.Itim

@Composable
fun MainScreen(navController: NavHostController) {
    val buttonItems = listOf(
        ButtonItem("Realidad Aumentada", R.drawable.m0_menu_1_realidad_aumentada, "select_enfermedad_vr",
            Color(252,209,49,255)
        ),
        ButtonItem("Enfermedades", R.drawable.m0_menu_2_enfermedades, "enfermedades_cerdos",
            Color(211,58,84,255)
        ),
        ButtonItem("Sobre el Cuidado", R.drawable.m0_menu_3_cuidado, "cuidados_cerdos",
            Color(175,180,43,255)
        ),
        ButtonItem("¿Estara enfermo?", R.drawable.m0_menu_4_rbc, "test_pig", Color(156,52,194,255)),
        ButtonItem("Busqueda", R.drawable.m0_menu_5_busqueda, "busqueda", Color(143,201,195,255)),
        ButtonItem("Sobre  Nosotros", R.drawable.m0_menu_6_nosotros, "info_screen", Color(0,200,0,255))
    )

    Column (
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        val buttonItemsInPairs = buttonItems.chunked(2)
        buttonItemsInPairs.forEach { rowItems->
            Row (
                modifier= Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ){
                rowItems.forEach { item ->
                    Button(
                        onClick = {
                            navController.navigate(item.route)
                        },
                        colors = ButtonDefaults.buttonColors(Color.Transparent),
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f)
                            .border(
                                width = 5.dp, // Ancho del borde
                                color = item.color, // Color del borde
                                shape = RoundedCornerShape(16.dp) // Bordes redondeados
                            )
                            .background(Color.Transparent)
                    )
                    {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = item.imageResource),
                                contentDescription = "icon", // Puedes proporcionar una descripción adecuada aquí
                                modifier = Modifier
                                    .size(100.dp)
                            )
                            Text(text = item.label,
                                fontFamily = Itim,
                                fontSize = 19.sp,
                                fontWeight = FontWeight.Bold,
                                color = item.color,
                                textAlign = TextAlign.Center)
                        }
                    }
                }
            }
        }
    }
}

data class ButtonItem(val label: String, val imageResource: Int, val route: String, val color: Color)