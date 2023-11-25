package com.example.porcisaludvr.Cuidado

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.porcisaludvr.R
import com.example.porcisaludvr.ui.theme.Itim

@Composable
fun SelectCuidadoScreen(navController: NavHostController) {
    val listState = rememberLazyListState()
    val buttonItems = listOf(
        ButtonItem("Instalaciones", R.drawable.m3_cuidado_0_instalacion_1, "cuidado_instalaciones",
            Color(0,142,141,255)
        ),
        ButtonItem("Manejo Est. Productivos", R.drawable.m3_cuidado_0_manejo_2, "cuidado_manejo",
            Color(255,135,74,255)
        ),
        ButtonItem("Sanidad", R.drawable.m3_cuidado_0_sanidad_3, "cuidado_sanidad",
            Color(94,190,124,255)
        ),
        ButtonItem("Bienestar Animal", R.drawable.m3_cuidado_0_bienestar_4, "cuidado_bienestar",
            Color(137,73,136,255)
        ),
        ButtonItem("Suministro de Agua", R.drawable.m3_cuidado_0_agua_5, "cuidado_suministro_agua",
            Color(197, 182, 22,255)
        ),
        ButtonItem("Suministro de Alimento", R.drawable.m3_cuidado_0_comida_6, "cuidado_suministro_alimento",
            Color(0, 201, 203,255)
        ),
        ButtonItem("Manejo de Plagas", R.drawable.m3_cuidado_0_plaga_7, "cuidado_plagas",
            Color(159, 105, 191,255)
        ),
        ButtonItem("Bienestar del Trabajador", R.drawable.m3_cuidado_0_bienestar_8, "cuidado_trabajador",
            Color(211,58,84,255)
        ),
    )
    LazyColumn(
        state = listState,
        modifier = Modifier.fillMaxSize()
    ) {
        itemsIndexed(buttonItems) {index, buttonItem ->
            Spacer(modifier = Modifier.height(25.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp, vertical = 4.dp)
                    .shadow(elevation = 4.dp, shape = RoundedCornerShape(24.dp))
                    .border(
                        width = 5.dp, // Ancho del borde
                        color = buttonItem.color, // Color del borde
                        shape = RoundedCornerShape(24.dp) // Bordes redondeados
                    )
                    .background(Color.White)
                    .clickable(onClick = {
                        navController.navigate(buttonItem.route)
                    }),
                contentAlignment = Alignment.CenterStart
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 32.dp, vertical = 8.dp)
                ) {
                    Text(
                        text = buttonItem.label,
                        fontFamily = Itim,
                        fontSize = 22.sp,
                        color = buttonItem.color,
                        textAlign = TextAlign.Left
                    )
                    Spacer(modifier = Modifier.width(13.dp))
                    Image(
                        painter = painterResource(id = buttonItem.imageResource),
                        contentDescription = "Imagen de la enfermedad",
                        modifier = Modifier
                            .size(40.dp)
                    )
                }
            }
        }
    }
}

data class ButtonItem(val label: String, val imageResource: Int, val route: String, val color: Color)