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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.porcisaludvr.ui.theme.Itim

@Composable
fun InfoScreen(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text ="Sobre PorciSalud",
            fontFamily = Itim,
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            color = Color(211,58,84,255),
            textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(16.dp)
        )
        // Imagen
        Image(
            painter = painterResource(id = R.drawable.m6_nosotros_logo),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .background(Color.Transparent)
        )
        var longText= """
            ¡Bienvenidos a PorciSalud! Somos un proyecto desarrollado por dos  estudiantes universitarios, 
            hemos combinado nuestros conocimientos en la tecnología y la ganadería porcina para crear 
            esta aplicación de M-Learning con Realidad Aumentada. Durante nuestra investigación y desarrollo,
            hemos invertido tiempo y esfuerzo en comprender las necesidades de los productores de ganado porcino 
            y los técnicos de la industria, sobre todo en las enfermedades. 
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

    }
}

@Preview
@Composable
fun InfoScreenPreview() {
    // Puedes usar este preview para verificar cómo se ve la pantalla
    InfoScreen(navController = rememberNavController())
}