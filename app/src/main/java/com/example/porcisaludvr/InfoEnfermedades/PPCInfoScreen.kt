package com.example.porcisaludvr.InfoEnfermedades

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.porcisaludvr.R
import com.example.porcisaludvr.ui.theme.Itim

@Composable
fun PPCInfoScreen(navController: NavHostController) {

    var colorInfo: Color = Color(211,58,84,255)
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
            color = colorInfo,
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

        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {
                // Navega a la ruta cuando se hace clic en el botón
                navController.navigate("VR-ppc")
            },
            colors = ButtonDefaults.buttonColors(colorInfo),
            modifier = Modifier
                .size(280.dp, 48.dp)
                .shadow(elevation = 4.dp, shape = RoundedCornerShape(24.dp))
                .border(
                    width = 5.dp, // Ancho del borde
                    color = colorInfo, // Color del borde
                    shape = RoundedCornerShape(16.dp) // Bordes redondeados
                )
                .background(Color.Transparent)
        ) {
                Text(text = "Ver en Realidad Aumentada",
                    fontFamily = Itim,
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Center)
        }
    }
}

@Preview
@Composable
fun PPCInfoScreenPreview() {
    // Puedes usar este preview para verificar cómo se ve la pantalla
    PPCInfoScreen(navController = rememberNavController())
}