package com.example.porcisaludvr.InfoEnfermedades

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.porcisaludvr.R
import com.example.porcisaludvr.ui.theme.Itim

@Composable
fun SelectEnfermedadesInfo(navController: NavHostController) {
    val listState = rememberLazyListState()
    val buttonItems = listOf(
        ButtonItem("Peste Porcina", R.drawable.m1_vr_1_ppc, "info_enfermedad_ppc",
            Color(0,142,141,255)
        ),
        ButtonItem("Sarna Sarcoptica", R.drawable.m1_vr_2_sarna, "info_enfermedad_sarna",
            Color(137,73,136,255)
        ),
        ButtonItem("Neumonía Enzoótica", R.drawable.m1_vr_3_neumonia, "info_enfermedad_neumonia",
            Color(211,58,84,255)
        ),
    )

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp)
                .shadow(elevation = 4.dp, shape = RoundedCornerShape(24.dp))
                .border(
                    width = 5.dp, // Ancho del borde
                    Color(211,58,84,255), // Color del borde
                    shape = RoundedCornerShape(24.dp) // Bordes redondeados
                )
                .background(Color.White)
                .padding(16.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Selecciona la Enfermedad para ver mas informacion sobre ella: ",
                    fontFamily = Itim,
                    fontSize = 23.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(211,58,84,255),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.padding(8.dp))
                Image(
                    painter = painterResource(id = R.drawable.m2_info_0_info),
                    contentDescription = null,
                    modifier = Modifier
                        .size(120.dp)
                        .background(Color.Transparent),
                    colorFilter = ColorFilter.tint(color = Color(211,58,84,255))
                )
                Spacer(modifier = Modifier.padding(8.dp))
            }
        }
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
}

data class ButtonItem(val label: String, val imageResource: Int, val route: String, val color: Color)
