package com.example.porcisaludvr

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
fun PPCInfoScreen(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text ="Peste Porcina Clasica",
            fontFamily = Itim,
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            color = Color(211,58,84,255),
            textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(16.dp)
        )
        // Imagen
        Image(
            painter = painterResource(id = R.drawable.ppc_info),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .background(Color.Transparent)
        )
        var longText= """
            La peste porcina clásica (PPC), también conocida como fiebre aftosa porcina, 
            es una enfermedad viral altamente contagiosa que afecta a los cerdos.
            La PPC es causada por un virus perteneciente al género Pestivirus, específicamente el virus de 
            la peste porcina clásica. Este virus puede afectar a los cerdos domésticos y jabalíes, 
            y se encuentra en todo el mundo.
            """.trimIndent()
        Text(
            text = longText,
            fontFamily = Itim,
            fontSize = 19.sp,
            textAlign = TextAlign.Left,

            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp, vertical = 8.dp)

        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(text ="Sintomas",
            fontFamily = Itim,
            fontSize = 19.sp,
            fontWeight = FontWeight.Bold,
            color = Color(211,58,84,255),
            textAlign = TextAlign.Left)
        Spacer(modifier = Modifier.height(1.dp)
        )
        Spacer(modifier = Modifier.height(6.dp))
        var longText2= """
            Fiebre: Los cerdos infectados pueden desarrollar fiebre alta.
            Problemas respiratorios: Esto puede incluir tos y dificultad para respirar.
            Problemas gastrointestinales: Los cerdos pueden experimentar diarrea y vómitos.
            Lesiones cutáneas: Algunos cerdos pueden desarrollar lesiones cutáneas en forma de costras y erosiones en la piel.
            Letargo: Los cerdos afectados suelen volverse letárgicos, deprimidos y pueden dejar de comer.
            """.trimIndent()
        Text(
            text = longText2,
            fontFamily = Itim,
            fontSize = 19.sp,
            textAlign = TextAlign.Left,

            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp, vertical = 8.dp)

        )
    }
}