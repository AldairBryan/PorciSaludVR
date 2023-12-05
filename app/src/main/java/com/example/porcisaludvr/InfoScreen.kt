package com.example.porcisaludvr

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.porcisaludvr.ui.theme.Itim

@Composable
fun InfoScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp)
            .shadow(elevation = 4.dp, shape = RoundedCornerShape(24.dp))
            .border(
                width = 5.dp, // Ancho del borde
                Color(211, 58, 84, 255), // Color del borde
                shape = RoundedCornerShape(24.dp) // Bordes redondeados
            )
            .background(Color.White)
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Sobre PorciSalud",
                fontFamily = Itim,
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                color = Color(211, 58, 84, 255),
                textAlign = TextAlign.Center
            )
            Spacer(
                modifier = Modifier.height(16.dp)
            )
            // Imagen
            Image(
                painter = painterResource(id = R.drawable.m6_nosotros_logo),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Transparent)
            )
            Spacer(modifier = Modifier.height(16.dp))
            var longText = "¡Bienvenidos a PorciSalud! Somos un proyecto desarrollado por dos  estudiantes universitarios, " +
                    "hemos creado esta aplicación de M-Learning con Realidad Aumentada y Razonamiento Basado en Casos, para enseñar " +
                    "sobre enfermedades porcinas. \n" +
                    "¡Agradecemos tu opinion! "
            Text(
                text = longText,
                fontFamily = Itim,
                fontSize = 16.sp,
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}