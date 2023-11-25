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
    var colorInfo: Color = Color(159, 105, 191,255)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text ="Manejo Integrado de Plagas",
            fontFamily = Itim,
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            color = colorInfo,
            textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(16.dp)
        )
        // Imagen
        Image(
            painter = painterResource(id = R.drawable.m3_cuidado_0_plaga_7),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .background(Color.Transparent)
        )

        // Informacion
        ExpandableCard(title = "Recomendaciones",
            description = " Se recomienda:\n" +
                    "- Eliminar tanto los residuos líquidos como sólidos.\n" +
                    "- Limpiar diariamente y limpiar con cloro los corrales, después de cada campaña\n" +
                    "considerando un descanso sin animales no menor que 30 días entre ciclo de crianza.\n" +
                    "- Desinsectar los corrales cada 3 meses.\n" +
                    "- 2-3 veces al año se debe desratizar los ambientes.\n" +
                    "- Recordar que tanto los insecticidas y rodenticidas no deben causar impacto negativo sobre\n" +
                    "el medio ambiente.",
            colorTitle = colorInfo)
        Spacer(modifier = Modifier.height(6.dp))
    }
}