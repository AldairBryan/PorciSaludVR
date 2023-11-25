package com.example.porcisaludvr.Cuidado

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import com.example.porcisaludvr.ExpandableCard
import com.example.porcisaludvr.R
import com.example.porcisaludvr.ui.theme.Itim

@Composable
fun BienestarAnimalScreen(navHostController: NavHostController){
    var colorInfo: Color = Color(137,73,136,255)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text ="Bienestar Animal",
            fontFamily = Itim,
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            color = colorInfo,
            textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(16.dp)
        )
        // Imagen
        Image(
            painter = painterResource(id = R.drawable.m3_cuidado_0_bienestar_4),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .background(Color.Transparent)
        )

        // Informacion
        ExpandableCard(title = "Informacion",
            description = "Los principales puntos que debemos asegurar en los porcinos, se resumen en las 5 " +
                    "libertades, a partir de las cuales se pueden rediseñar los procedimientos operacionales y " +
                    "generar BIENESTAR ANIMAL en la crianza",
            colorTitle = colorInfo)
        Spacer(modifier = Modifier.height(6.dp))

        //Sintomas
        ExpandableCard(title = "Puntos",
            description = "- Libre de hambre y sed: brindar acceso de agua fresca y una alimentación balanceada " +
                    "que mantenga plena salud y vigor.\n" +
                    "- Libre de incomodidad: proveer un entorno adecuado y una zona de descanso " +
                    "confortable.\n" +
                    "- Libre de dolor, lesiones y enfermedades: prevención cuando sea posible y rápido " +
                    "diagnóstico y tratamiento cuando se producen lesiones o enfermedades.\n" +
                    "- Libertad de expresar un comportamiento normal: proveer suficiente y adecuado espacio " +
                    "y la compañía e interés de otros porcinos.\n" +
                    "- Libre de temor y angustia: manejo de los animales libre de maltrato, condiciones " +
                    "ambientales constantes y ausencia de agresión por parte de otros porcinos.",
            colorBG = colorInfo,
            colorTitle = Color.White,
            colorText = Color.White)
        Spacer(modifier = Modifier.height(6.dp))
    }
}