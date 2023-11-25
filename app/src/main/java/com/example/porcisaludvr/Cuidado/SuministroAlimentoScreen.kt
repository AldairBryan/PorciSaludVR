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
fun SuministroAlimentoScreen(navHostController: NavHostController){
    var colorInfo: Color = Color(0, 201, 203,255)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text ="Suministro de Alimento",
            fontFamily = Itim,
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            color = colorInfo,
            textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(16.dp)
        )

        // Informacion
        ExpandableCard(title = "Informacion",
            description = "Se sugiere, alimentar a los porcinos a intervalos regulares, y con una alimentación fresca que se debe poner sólo después de haber eliminado la ración anterior del comedero, Los alimentos a suministrar deberían cumplir con los requerimientos básicos nutricionales para cada etapa fisiológica productiva y estar libres de contaminantes durante la elaboración y el almacenamiento." +
                    "\nUna dieta balanceada debería proveer la totalidad de nutrientes, energía, proteína (aminoácidos esenciales y no esenciales, proteína bruta), grasas, minerales y vitaminas, en cantidad y calidad, que permitan al animal manifestar su potencial de producción cuando se encuentra en un estado sanitario y en condiciones ambientales adecuadas. Cantidades inferiores limitan el desempeño de los animales, y si se exceden los valores o proporciones de nutrientes recomendados existirá un uso ineficiente y se habrán de tener pérdidas a través de las excreciones, induciendo un proceso contaminante." +
                    "\nAl abaratar los costos en la alimentación, los criadores buscan alimentar a los porcinos con alternativas como sub productos y residuos de cocina, sin embargo desconocen que es difícil indicar la cantidad exacta, por la variación en la composición y calidad, consecuentemente los porcinos pueden experimentar más problemas y entrar en un gasto mayor, que si se brindaría el alimento balanceado convencional. Es fundamental que los productores no alimenten a los porcinos con desechos de basurales, ya que esto representa un riesgo sanitario para los animales y para la población en general." +
                    "\nRespecto a la crianza familiar y traspatio, la única manera de enriquecer la dieta es incorporando SUPLEMENTOS tales como aditivos, vitaminas, harinas procesadas además de incorporar pasturas tipo leguminosas a fin de tener un margen mayor de proteína.",
            colorTitle = colorInfo)
        Spacer(modifier = Modifier.height(6.dp))

        //Sintomas
        ExpandableCard(title = "Consideraciones",
            description = "Consideraciones de cantidades a suministrar en diferentes etapas productivas y necesidades de proteína" +
                    "\n\nMachos sementales: 2 kilos de un alimento de mantenimiento por día y dependiendo de su trabajo." +
                    "\n\nHembras en gestación (preñadas): 2 kilos/día en promedio de alimento de gestación para mantener una condición de carnes en 3,5 (calificación de 1 a 5)" +
                    "\n\nHembras en lactancia y destetadas hasta el momento del nuevo servicio: Alimento de lactancia (tiene más energía) a voluntad varias veces al día (4-5 veces para evitar desperdicios)" +
                    "\n\nLechones en lactancia: Sólo granitos de un pre iniciador (21% proteína) en la tercera semana de nacidos para que aprenda a comer antes del destete." +
                    "\n\nEn crecimiento se suministra alimento de levante (16% de proteína) a voluntad y se cambia luego gradualmente a alimento de engorde o finalización (14% de proteína) también a voluntad hasta llegar a peso de mercado.",
            colorBG = colorInfo,
            colorTitle = Color.White,
            colorText = Color.White)
        Spacer(modifier = Modifier.height(6.dp))
    }
}