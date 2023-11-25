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
import com.example.porcisaludvr.ExpandableCardTable
import com.example.porcisaludvr.R
import com.example.porcisaludvr.ui.theme.Itim

@Composable
fun SanidadScreen(navHostController: NavHostController){
    var colorInfo: Color = Color(94,190,124,255)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text ="Sanidad",
            fontFamily = Itim,
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            color = colorInfo,
            textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(16.dp)
        )

        // Informacion
        ExpandableCard(title = "Principales Enfermedades",
            description = "Las principales enfermedades de mayor presentación en este tipo de crianza las constituyen:\n" +
                    "- Cólera porcino.\n" +
                    "- Erisipela.\n" +
                    "- Pasteurelosis.\n" +
                    "- Neumonía enzoótica.\n" +
                    "- Colibacilosis.\n" +
                    "- Salmonelosis.\n" +
                    "- Disentería porcina.\n" +
                    "- Sarna.\n" +
                    "\nPrincipales enfermedades zoonóticas: Cisticercosis, Hidatidosis, Leptospirosis.\n" +
                    "\nDel programa de vacunación: " +
                    "\nSe recomienda ceñirse a los lineamientos establecidos por SENASA en el plan de estrategia " +
                    "sanitaria para las enfermedades de notificación obligatoria, como en el caso del cólera " +
                    "porcino." +
                    "\n\nCertificado de vacunación:\n" +
                    "Tener presente que la vacunación será acreditada con el correspondiente Certificado Oficial " +
                    "de vacunación contra enfermedades comprendidas en el programa del sistema sanitario " +
                    "porcino, conducido por el SENASA.",
            colorTitle = colorInfo)
        Spacer(modifier = Modifier.height(6.dp))

        //Sintomas
        ExpandableCard(title = "Uso racional de medicamentos",
            description = "Para el uso racional de medicamentos veterinarios se debe considerar:" +
                    "\n- Los fármacos, aditivos y vacunas a utilizar durante la crianza de porcinos ya sean de " +
                    "aplicación directa al animal o a través del alimento o agua deben estar aprobados y " +
                    "registrados por el SENASA.\n" +
                    "- Antes de usar un producto verificar la fecha de caducidad. Se eliminará aquellos " +
                    "productos vencidos.\n" +
                    "- Es necesario cumplir con los períodos de retiro proyectados en las etiquetas de los " +
                    "productos, las instrucciones de uso deben ser respetadas así se genera una administración " +
                    "exitosa y se evitan peligros sobre operadores, animales, consumidores finales y medio " +
                    "ambiente." +
                    "\n- Limpiar y desinfectar los equipos empleados para la aplicación de fármacos previo y " +
                    "después de su uso, mantenerlos adecuadamente.\n" +
                    "- Disponer con la mayor seguridad posible el instrumental desechable usado, de acuerdo a " +
                    "las instrucciones establecidas por el fabricante: Los desechos punzocortantes, reactivos o " +
                    "tóxicos deben ser introducidos en una botella plástica boca ancha la cual deberá ser bien " +
                    "tapada y rotulada.\n" +
                    "- Almacenar los fármacos en lugares frescos, limpios secos, lejos de la incidencia directa " +
                    "de la luz solar y del alcance delos niños y animales domésticos.\n" +
                    "- Es recomendable utilizar agujas limpias para extraer el contenido de los frascos, NUNCA " +
                    "almacenar medicamentos en jeringas debido al potencial riesgo de su INACTIVACION.\n" +
                    "- De utilizar jeringas NO DESECHABLES, se recomienda lavar y desinfectar previo a su " +
                    "uso este equipo. Se recomienda usar una aguja por animal.\n" +
                    "- Los envases de los productos vacíos NO DEBEN ser reutilizados.\n" +
                    "- Para el manejo de vacunas considerar la cadena de frío, estos productos deben ser " +
                    "mantenidos en refrigeración o en cooler con hielo, durante el tiempo que la vacuna será " +
                    "aplicada a fin que no pierda su eficacia. Respecto a la dosis por utilizar no debe ser " +
                    "excedida. Sólo se vacunaran animales sanos. Las dosis de vacunas reconstituidas no " +
                    "utilizadas; deben ser inactivadas con cloro y agua caliente luego ser eliminadas." +
                    "\n\nLargo y calibre de agujas: ",
            colorBG = colorInfo,
            colorTitle = Color.White,
            colorText = Color.White,
            image = R.drawable.m3_cuidado_4_aguja)
        Spacer(modifier = Modifier.height(6.dp))

        //Lesiones de Necropsia
        ExpandableCardTable(title = "Programa Sanitorio de Manejo  sugerido",
            colorTitle = colorInfo,
            image = R.drawable.m3_cuidado_4_tabla_1,
            image2 = R.drawable.m3_cuidado_4_tabla_2)
        Spacer(modifier = Modifier.height(6.dp))

        //Tratamiento
        ExpandableCardTable(title = "Inmunizacion basica de PPC",
            colorTitle = Color.White,
            colorBG = colorInfo,
            image = R.drawable.m3_cuidado_4_tabla_3)
        Spacer(modifier = Modifier.height(6.dp))
    }
}