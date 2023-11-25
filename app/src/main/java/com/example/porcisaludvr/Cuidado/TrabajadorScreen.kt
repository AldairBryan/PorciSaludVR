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
fun TrabajadorScreen(navHostController: NavHostController){
    var colorInfo: Color = Color(211,58,84,255)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text ="Salud y Bienestar del Trabajador",
            fontFamily = Itim,
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            color = colorInfo,
            textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(16.dp)
        )
        // Imagen
        Image(
            painter = painterResource(id = R.drawable.m3_cuidado_0_bienestar_8),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .background(Color.Transparent)
        )

        // Informacion
        ExpandableCard(title = "Informacion",
            description = "Constituye el conjunto de elementos interrelacionados que tienen como objetivo la seguridad y salud en el centro de trabajo en la que se promueve la cultura de prevención de riesgos. La agro industria por su naturaleza, a pesar que no aparece como una actividad de riesgo en la legislación vigente, conlleva potenciales riesgos vinculados a la salud y seguridad ocupacional.",
            colorTitle = colorInfo)
        Spacer(modifier = Modifier.height(6.dp))

        //Sintomas
        ExpandableCard(title = "Investigaciones",
            description = "De acuerdo a la investigación realizada por el instituto Salud y trabajo (ISAT 2005), con frecuencia los trabajadores de este sector están expuestos a factores físicos, químicos, biológicos, psicosociales y ergonómicos. Los síntomas más habituales son las enfermedades bronco-pulmonares, la intoxicación por contacto con agro químicos (fertilizantes- pesticidas), la radiación solar y el riesgo ergonómico por desconocimiento y ausencia de políticas preventivas de salud y seguridad en el trabajo que diferencien las necesidades de salud y protección a hombres y mujeres.",
            colorBG = colorInfo,
            colorTitle = Color.White,
            colorText = Color.White)
        Spacer(modifier = Modifier.height(6.dp))
    }
}