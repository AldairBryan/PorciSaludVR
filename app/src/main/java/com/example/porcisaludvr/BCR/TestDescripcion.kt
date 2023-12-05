package com.example.porcisaludvr.BCR

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.example.porcisaludvr.R
import com.example.porcisaludvr.ui.theme.Itim

@Composable
fun TestDescripcion (navHostController: NavHostController){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp)
                .shadow(elevation = 4.dp, shape = RoundedCornerShape(24.dp))
                .border(
                    width = 5.dp, // Ancho del borde
                    Color(156, 52, 194, 255), // Color del borde
                    shape = RoundedCornerShape(24.dp) // Bordes redondeados
                )
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "¿Observa sintomas en algun cerdo?",
                    fontFamily = Itim,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(156,52,194,255),
                    textAlign = TextAlign.Center
                )
                Spacer(
                    modifier = Modifier.height(16.dp)
                )
                // Imagen
                Image(
                    painter = painterResource(id = R.drawable.m0_menu_4_rbc),
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color.Transparent)
                )
                Spacer(modifier = Modifier.height(8.dp))
                var longText = "Si observa sintomas en algun cerdo y piensa que podria tener alguna enfermedad, " +
                        "entonces resuelva el siguiente Test para predecir de que enfermedad se podria tratar.\n" +
                        "Por el momento este test solo puede arrojar 4 enfermedad: Peste Porcina, Neumonia Enzootica, Sarna y Erisipela Porcina.\n" +
                        "Recomendadmos la visita a un especialista" +
                        "ante cualquier signo de enfermedad."
                Text(
                    text = longText,
                    fontFamily = Itim,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Justify,
                    color= Color(156,52,194,255),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }
        }
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ){
            Button(
                onClick = { navHostController.popBackStack() },
                colors = ButtonDefaults.buttonColors(Color.White),
                modifier = Modifier
                    .weight(1f)
                    .shadow(elevation = 4.dp, shape = RoundedCornerShape(24.dp))
                    .border(
                        width = 5.dp, // Ancho del borde
                        color = Color(156,52,194,255), // Color del borde
                        shape = RoundedCornerShape(24.dp) // Bordes redondeados
                    )
                    .background(Color.Transparent))
            {
                Text(text = "Regresar",
                    fontFamily = Itim,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(156,52,194,255),
                    textAlign = TextAlign.Center)
            }
            Button(
                onClick = { navHostController.navigate("test_pig_confirmar") },
                colors = ButtonDefaults.buttonColors(Color(156,52,194,255)),
                modifier = Modifier
                    .weight(1f)
                    .shadow(elevation = 4.dp, shape = RoundedCornerShape(24.dp))
                    .border(
                        width = 5.dp, // Ancho del borde
                        color = Color(156,52,194,255), // Color del borde
                        shape = RoundedCornerShape(24.dp) // Bordes redondeados
                    ))
            {
                Text(text = "Empezar",
                    fontFamily = Itim,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Center)
            }
        }
    }
}
