package com.example.porcisaludvr.BCR

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.navigation.NavController
import com.example.porcisaludvr.R
import com.example.porcisaludvr.ui.theme.Itim

@Composable
fun TestResultScreen(result: String, navController: NavController) {
    var resultEnfermedad: Result=Result("",Color.White,"","",0)
    when (result) {
        "['ppc']" -> {
            resultEnfermedad = Result("Peste Porcina",
                Color(0,142,141,255),"info_enfermedad_ppc",
                "Enfermedad viral altamente contagiosa que afecta a los cerdos. Causada por el virus de la " +
                        "peste porcina africana (PPA), esta enfermedad provoca fiebre alta, debilidad, y en muchos casos, " +
                        "la muerte de los cerdos infectados.", R.drawable.ppc_info)
        }
        "['sarcoptic']" -> {
            resultEnfermedad = Result("Sarna Sarcoptica",
                Color(137,73,136,255),"info_enfermedad_sarna",
                "Enfermedad de la piel causada por el ácaro Sarcoptes scabiei. Esta enfermedad afecta a los " +
                        "cerdos y provoca intensa picazón, pérdida de pelo, costras y lesiones cutáneas. La sarna " +
                        "sarcoptica puede transmitirse entre cerdos.",R.drawable.sarna_info)
        }
        "['erisipela']" -> {
            resultEnfermedad = Result("Neumonía Enzoótica",
                Color(211,58,84,255),"info_enfermedad_neumonia",
                "Enfermedad respiratoria crónica que afecta a los cerdos. Es causada principalmente por el bacterium " +
                        "Mycoplasma hyopneumoniae, pero puede agravarse por infecciones virales secundarias. Los síntomas " +
                        "incluyen tos, dificultad para respirar y bajo rendimiento de crecimiento.",R.drawable.ppc_info)
        }
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(elevation = 4.dp, shape = RoundedCornerShape(24.dp))
                .border(
                    width = 5.dp, // Ancho del borde
                    color = resultEnfermedad.color,
                    shape = RoundedCornerShape(24.dp) // Bordes redondeados
                )
                .background(Color.White)
        ) {
            Column (    horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    text = "La enfermedad mas probable es:\n"+resultEnfermedad.text,
                    fontFamily = Itim,
                    color = resultEnfermedad.color,
                    fontSize = 23.sp,
                    modifier = Modifier.padding(16.dp),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    )
                Image(
                    painter = painterResource(id =resultEnfermedad.imageResource),
                    contentDescription = null,
                    modifier = Modifier
                        .size(150.dp)
                        .background(Color.Transparent),
                )
                Text(
                    text = resultEnfermedad.desc,
                    fontFamily = Itim,
                    color = resultEnfermedad.color,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(16.dp),
                    textAlign = TextAlign.Justify
                )
            }
        }
        Spacer(modifier = Modifier.height(25.dp))
        Button(onClick = {
            navController.navigate(resultEnfermedad.route) },
            colors = ButtonDefaults.buttonColors(resultEnfermedad.color),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp, vertical = 8.dp)
                .shadow(elevation = 4.dp, shape = RoundedCornerShape(24.dp))
        ) {
            Text(text = "Ver Informacion sobre "+resultEnfermedad.text,
                fontFamily = Itim,
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center)
        }
    }
}

data class Result(val text: String, val color: Color, val route: String, val desc: String,val imageResource: Int)
