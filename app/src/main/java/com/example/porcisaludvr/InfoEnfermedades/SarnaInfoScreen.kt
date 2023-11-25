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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.porcisaludvr.ExpandableCard
import com.example.porcisaludvr.R
import com.example.porcisaludvr.ui.theme.Itim

@Composable
fun SarnaInfoScreen(navController: NavHostController){
    var colorInfo: Color = Color(137,73,136,255)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text ="Sarna",
            fontFamily = Itim,
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            color = colorInfo,
            textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(16.dp)
        )
        // Imagen
        Image(
            painter = painterResource(id = R.drawable.m2_info_2_sarna),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .background(Color.Transparent)
        )

        //Informacion
        ExpandableCard(title = "Informacion",
            description = "La sarna es una enfermedad de piel causada por un parásito externo (ácaro) " +
                    "que se caracteriza por hinchazón severa que afecta el crecimiento de cerdos.\n" +
                    "Nombres alternativos: Sarna sarcóptica, Sarcoptes scabiei, scabies\n" +
                    "La sarna es una enfermedad parasitaria de la piel causada por Sarcoptes scabiei. " +
                    "La sarna en cerdos por Demodex phylloides es rara. La sarna sarcóptica (a veces " +
                    "llamada scabies) es con diferencia la más frecuente e importante porque es irritante " +
                    "e incómoda para el cerdo, haciendo que se rasque y dañe la piel. Reduce de forma " +
                    "significativa la tasa de crecimiento y la eficiencia de conversión del pienso. El ciclo " +
                    "de vida del ácaro es directo y tarda 14-15 días para completar un ciclo de adulto a adulto. " +
                    "El ácaro muere rápidamente fuera del cerdo (horas hasta 15 días), en la mayoría de " +
                    "condiciones, en menos de cinco días. Es importante tener esto en cuenta para su control. " +
                    "Si una granja está libre de sarna, es una de las enfermedades más fáciles de evitar, " +
                    "porque sólo puede ser introducida por animales portadores. Sin embargo, una vez se introduce " +
                    "en la granja tiende a permanecer endémico si no se toman medidas.",
            colorBG = colorInfo,
            colorTitle = Color.White,
            colorText = Color.White)
        Spacer(modifier = Modifier.height(6.dp))

        //Sintomas
        ExpandableCard(title = "Sintomas",
            description = "En caso de enfermedad aguda:\n" +
                    "\n" +
                    " - Sacuden las orejas.\n" +
                    " - Se rasca continuamente contra las paredes del corral. Aproximadamente tres a ocho semanas después de la infección inicial la piel pasa a ser sensible a la proteína del ácaro y puede desarrollarse una alergia intensa dando lugar a unos pequeños granos de color rojo que cubren toda la piel.\n" +
                    " - Grave prurito que hace que el animal se rasque hasta el punto de producir sangre.\n" +
                    " - Pequeños granos rojos por toda la piel.\n" +
                    "\n" +
                    " - En caso de enfermedad crónica:\n" +
                    "\n" +
                    " - Aparecen lesiones gruesas, con aspecto similar al amianto en las orejas, a los dos lados del cuello, los codos, la parte delantera de los corvejones y en la parte dorsal del cuello.\n" +
                    " - Su presencia afecta a la eficiencia de conversión del pienso y ganancia diaria, sobretodo si la carga infectiva es grande.",
            colorTitle = colorInfo,
            image = R.drawable.m2_info_2_sarna_localizaciones)
        Spacer(modifier = Modifier.height(6.dp))

        //Causas / Factores
        ExpandableCard(title = "Causas / Factores",
            description = " - El ácaro se disemina directamente de cerdo a cerdo, ya sea por contacto con la piel o con superficies contaminadas recientemente.\n" +
                    " - El verraco contribuye a mantener la infección en la granja porque está constantemente en contacto directo con la piel de hembras reproductoras y permanece como portador crónico.\n" +
                    " - Si los cerdos se alojan en grupos es más fácil que se contagien.\n" +
                    " - Entrada de cerdos infectados\n" +
                    " - Corrales usados continuamente.\n" +
                    " - Si no se toman medidas de control y tratamiento da lugar a una grave enfermedad.",
            colorTitle = Color.White,
            colorText = Color.White,
            colorBG = colorInfo)
        Spacer(modifier = Modifier.height(6.dp))

        //Diagnostico
        ExpandableCard(title = "Diagnostico",
            description = "Se confirma demostrando la presencia del ácaro. Se toman raspados de las " +
                    "lesiones cutáneas sospechosas y sobretodo de dentro de las orejas. Una cucharilla " +
                    "de café es el instrumento ideal para sacar material del interior de la oreja. Este " +
                    "material se puede colocar en un trozo de papel negro y se deja durante diez minutos." +
                    " Los ácaros de la sarna pueden ser visibles a simple vista, tienen forma redonda y " +
                    "solo 0,5mm de longitud. También existe disponible un ELISA que se realiza a partir " +
                    "de muestras de sangre, aunque su uso no es común.",
            colorTitle = colorInfo)
        Spacer(modifier = Modifier.height(6.dp))

        //Control / Prevencion
        ExpandableCard(title = "Control / Prevencion",
            description = "La sarna es una enfermedad cara, no sólo debido a sus efectos económicos en el cerdo sino también a los costes y necesidad de tratamientos repetidos y daño al equipo de corral.\n" +
                    "\n" +
                    "Ganado adulto\n" +
                    "\n" +
                    " - Examinar los animales reproductores en busca de lesiones crónicas. Identificar esos animales para que reciban tratamiento especial. Estas lesiones crónicas, que se encuentran sobretodo en las orejas, detrás del codo y en las extremidades, pueden ser difíciles de erradicar y permanecen como fuente constante de infección.\n" +
                    " - Trate todos los animales reproductores (primerizas, cerdas y verracos) con foxim. Repetir el tratamiento 10-14 días después. Alternativamente usar ivermectina o doramectina vía inyectable o ivermectina en el pienso cada 4 - 6 meses.\n" +
                    "Cerdos destetados\n" +
                    "\n" +
                    " - Tratar los cerdos el día del destete con foxim usando un dosificador oral o administrar una inyección de ivermectina. Alternativamente medicar el pre-starter con ivermectina durante 7 días o el agua durante los primeros cinco días post-destete. El segundo es mejor si se usa un depósito de agua unido a bebederos tipo cazoleta. La ivermectina ha sido utilizada para realizar inmersiones con éxito.\n" +
                    " - Los cerdos tratados deben trasladarse a corrales limpios que han sido rociados con un parasiticida como por ejemplo amitraz y dejados vacíos por lo menos tres días, preferiblemente cinco o seis.\n" +
                    " - Si la sarna está activa al principio del periodo de crecimiento medicar el pienso con ivermectina durante siete días.\n" +
                    " - Hay programas de erradicación efectivas utilizando inyecciones de ivermectina o doramectina y limpiando y fumigando todos los corrales y pasillos.",
            colorTitle = Color.White,
            colorText = Color.White,
            colorBG = colorInfo)
        Spacer(modifier = Modifier.height(6.dp))

        //Boton VR
        Button(
            onClick = {
                // Navega a la ruta cuando se hace clic en el botón
                navController.navigate("VR-sarna")
            },
            colors = ButtonDefaults.buttonColors(Color.White),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp, vertical = 8.dp)
                .shadow(elevation = 4.dp, shape = RoundedCornerShape(24.dp))
                .border(
                    width = 5.dp, // Ancho del borde
                    color = colorInfo, // Color del borde
                    shape = RoundedCornerShape(24.dp) // Bordes redondeados
                )
                .background(Color.Transparent)
        ) {
            Text(text = "Ver en Realidad Aumentada",
                fontFamily = Itim,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = colorInfo,
                textAlign = TextAlign.Center)
        }
    }
}