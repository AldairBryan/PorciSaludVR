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
import com.example.porcisaludvr.ExpandableCardImage
import com.example.porcisaludvr.R
import com.example.porcisaludvr.ui.theme.Itim

@Composable
fun SuministroAguaScreen(navHostController: NavHostController){
    var colorInfo: Color = Color(197, 182, 22,255)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text ="Suministro de Agua",
            fontFamily = Itim,
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            color = colorInfo,
            textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(16.dp)
        )

        // Informacion
        ExpandableCard(title = "Funciones",
            description = "Las funciones más importantes en las que intervienen el agua en la vida de los porcinos son:\n" +
                    "- Forma parte de los tejidos, interviene en todos los procesos nutritivos,\n" +
                    "- Juega un papel decisivo en la secreción de leche y en la regulación de la temperatura" +
                    "corporal.\n" +
                    "- Es indispensable para la vida y su falta puede desencadenar la muerte del animal, de una " +
                    "forma más rápida que la falta de alimentos.\n" +
                    "- Un animal puede perder la grasa de su cuerpo y hasta la mitad de la proteína sin perecer " +
                    "pero, si pierde el 10% de su agua corporal, el animal muere.",
            colorTitle = colorInfo)
        Spacer(modifier = Modifier.height(6.dp))

        //Sintomas
        ExpandableCard(title = "Calidad del Agua",
            description = "La calidad del agua puede afectar el consumo de los alimentos en forma directa ya que el agua de baja calidad genera normalmente un consumo reducido de ella y por lo tanto, un consumo bajo de alimento. El agua a proporcionar a los porcinos debe ser fresca, limpia, sin olores y que no contenga tóxicos que puedan afectar la salud y el normal consumo por parte de los animales.",
            colorBG = colorInfo,
            colorTitle = Color.White,
            colorText = Color.White)
        Spacer(modifier = Modifier.height(6.dp))

        //Lesiones de Necropsia
        ExpandableCard(title = "Consideraciones",
            description = "Evitar el uso de agua proveniente de fuentes contaminadas, servidas y de acequia. El agua " +
                    "debe de tener un mínimo de cloro libre de 0.5 ppb",
            colorTitle = colorInfo)
        Spacer(modifier = Modifier.height(6.dp))

        //Tratamiento
        ExpandableCard(title = "Variaciones en el consumo",
            description = "Variaciones en el consumo de agua obedecen a:" +
                    "\n- Nivel de sal en la ración.\n" +
                    "- Minerales o medicamentos en el agua (alteran su sabor).\n" +
                    "- Temperatura del agua.\n" +
                    "- Área del corral.\n" +
                    "- Número de veces que se alimenta al animal y tipo de ración.",
            colorTitle = Color.White,
            colorText = Color.White,
            colorBG = colorInfo)
        Spacer(modifier = Modifier.height(6.dp))

        ExpandableCard(title = "Consideraciones",
            description = "Evitar el uso de agua proveniente de fuentes contaminadas, servidas y de acequia. El agua " +
                    "debe de tener un mínimo de cloro libre de 0.5 ppb",
            colorTitle = colorInfo)

        ExpandableCardImage(title = "Requerimiento en crianza",
            image = R.drawable.m3_cuidado_5_tabla,
            colorTitle = Color.White,
            colorBG = colorInfo)
        Spacer(modifier = Modifier.height(6.dp))
    }
}