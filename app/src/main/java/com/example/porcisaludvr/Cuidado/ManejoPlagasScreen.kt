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
fun ManejoPlagasScreen(navHostController: NavHostController){
    var colorInfo: Color = Color(0,142,141,255)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text ="Peste Porcina Clasica",
            fontFamily = Itim,
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            color = colorInfo,
            textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(16.dp)
        )
        // Imagen
        Image(
            painter = painterResource(id = R.drawable.m2_info_1_ppc),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .background(Color.Transparent)
        )

        // Informacion
        ExpandableCard(title = "Informacion",
            description = " Es una ",
            colorTitle = colorInfo)
        Spacer(modifier = Modifier.height(6.dp))

        //Sintomas
        ExpandableCard(title = "Sintomas",
            description = "En la",
            colorBG = colorInfo,
            colorTitle = Color.White,
            colorText = Color.White)
        Spacer(modifier = Modifier.height(6.dp))

        //Lesiones de Necropsia
        ExpandableCard(title = "Lesiones de Necropsia",
            description = "En l ",
            colorTitle = colorInfo)
        Spacer(modifier = Modifier.height(6.dp))

        //Tratamiento
        ExpandableCard(title = "Tratamiento",
            description = "Para el ",
            colorTitle = Color.White,
            colorText = Color.White,
            colorBG = colorInfo)
        Spacer(modifier = Modifier.height(6.dp))

        //Prevencion y control
        ExpandableCard(title = "Prevencion y Control",
            description = "La medida más im",
            colorTitle = colorInfo)
        Spacer(modifier = Modifier.height(6.dp))

        //PRINCIPALES MEDIDAS Que TOMAR ANTE UN BROTE
        ExpandableCard(title = "Principales medidas que tomar ante un brote",
            description = "Vacunar o",
            colorTitle = Color.White,
            colorText = Color.White,
            colorBG = colorInfo)
        Spacer(modifier = Modifier.height(6.dp))
    }
}