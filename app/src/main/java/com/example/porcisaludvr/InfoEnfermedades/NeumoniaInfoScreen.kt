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
fun NeumoniaInfoScreen(navController: NavHostController) {
    var colorInfo: Color = Color(211,58,84,255)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text ="Neumonia Enzootica Porcina",
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
                .size(200.dp)
                .background(Color.Transparent)
        )

        // Informacion
        ExpandableCard(title = "Informacion",
            description = "Se estima estar presente en el 90 % de las granjas y en un 80 % de " +
                    "los cerdos a nivel mundial siendo la enfermedad más prevalente y económicamente " +
                    "importante en la producción porcina actual. \nEsta bacteria reside en los cilios " +
                    "de las células epiteliales del tracto respiratorio, cuando coloniza los destruye " +
                    "aumentando la secreción de moco lo que favorece la colonización de otros gérmenes " +
                    "patógenos sobre todo P. multocida o A. hyoneumoniae. Durante su colonización en el " +
                    "tracto respiratorio M. hyoneumoniae provoca un efecto inmunodepresivo que potencializa " +
                    "el efecto lesional de la neumonía por el virus PRRS, el virus Aujeszky, y la neumonía producida " +
                    "por A. pleuroneumoniae. \nPLEURONEUMONÍA PORCINA. \nEnfermedad de mayor impacto económico asociada " +
                    "al CRP causada por Actinomices pleuroneumoniae con más de 15 serotipos patógenos los " +
                    "cuales presentan varios factores de virulencia que las hacen difícil de controlar o " +
                    "eliminar por los mecanismos inmunológicos normales. \nCerdos portadores sanos o crónicos " +
                    "juegan un papel importante en la transmisión de la enfermedad. \nNEUMONÍA POR SALMONELLA. \n" +
                    "Causada por Salmonella spp la que por vía sanguínea (septicemia) invaden los pulmones; " +
                    "la cepa más aislada de pulmones afectados es S. cholerasuis variedad Kunzandor. " +
                    "Generalmente se presenta en cerdos después del destete y menores de cinco meses. Morbilidad " +
                    "menor del 10 % y alta mortalidad en cerdos no tratados. Los cerdos afectados presentan además " +
                    "la clínica y lesiones descrita en la salmonelosis septicémica. \nNEUMONÍA VERMINOSA PORCINA. \n" +
                    "Por la presencia y acción de larvas migratorias de A. suum o por la presencia y acción de " +
                    "Metrastrongylus spp en los bronquios pulmonares) los que crean las condiciones favorables " +
                    "para la colonización de otros agentes patógenos.",
            colorTitle = colorInfo)
        Spacer(modifier = Modifier.height(6.dp))

        //Sintomas
        ExpandableCard(title = "Sintomas",
            description = "El cuadro clínico varía en dependencia de la patogenicidad de " +
                    "los agentes infecciosos que interactúan y del estado inmunológico del grupo. " +
                    "Por lo que se aprecian formas sobreagudas, agudas y crónicas en la que aparecen: \n" +
                    " - Muerte súbita (casos sobreagudos y agudos)\n  - Falta de apetito (anorexia) \n" +
                    " - Fiebre (amontonamiento) \n - Aumento de la sed (polidipsia) \n - Postración " +
                    " - Aumento de la frecuencia respiratoria (disnea) \n - Estornudos \n - Tos, " +
                    "que puede ser seca o húmeda la que se hace más evidente al excitar al grupo. \n - " +
                    "Secreciones nasales que al inicio suelen ser acuosas (serosas) y mas tarde mucosas " +
                    "(catarrales) o con pus (purulentas). \n - Adelgazamiento progresivo o retraso en el crecimiento.",
            colorBG = colorInfo,
            colorTitle = Color.White,
            colorText = Color.White)
        Spacer(modifier = Modifier.height(6.dp))

        //Lesiones de Necropsia
        ExpandableCard(title = "Lesiones Generales",
            description = "Cerca del 50 % de los cerdos aparentemente sanos que llegan al destace a " +
                    "nivel mundial presentan lesiones de neumonía asociadas a M. hyoneumoneae.\n" +
                    "Los cadáveres pueden presentar buen estado nutricional en casos de muertes " +
                    "súbitas y algunos casos agudos aunque por lo general presentan de regular a mal " +
                    "estado nutricional. Algunas deformaciones del hocico (casos de rinitis atrófica " +
                    "o de rinitis por cuerpo de inclusión) así como cantidades variables de secreciones nasales.\n" +
                    "A la apertura de las cavidades las lesiones principales acontecen a nivel de los " +
                    "pulmones (derecho, izquierdo o en los dos) afectándose sobre todo los lóbulos anteriores," +
                    " los cuales están disminuidos de tamaño y endurecidos (consolidación) con lobulillos de" +
                    " color rosado intenso que alternan con lobulillos de color gris o rojo brillante; al corte " +
                    "mantienen el aspecto y al apretarlos sale catarro por los bronquios. (Neumonía fibrinosa o crupal)",
            colorTitle = colorInfo)
        Spacer(modifier = Modifier.height(6.dp))

        //Tratamiento
        ExpandableCard(title = "Diagnostico",
            description = "a) Análisis clínico epidemiológico\n" +
                    "\n - Cerdos jóvenes destetados o en la etapa de preceda" +
                    "y ceba que mueren súbitamente con lesiones de" +
                    "neumonía o sin ellas." +
                    "\n - Diseminación rápida del trastorno dentro del grupo." +
                    "\n - Aparición después de traslados, reagrupaciones," +
                    "introducción de nuevos reemplazos, deficiencias en " +
                    "el manejo cualquier efecto estresante." +
                    "\nb) Análisis de laboratorio \n - Envío de cerdos enfermos o muertos al laboratorio, " +
                    "fragmento de pulmón o hisopos nasales y amigdalianos con secreciones para aislamiento " +
                    "e identificación viral o bacteriana en animales no tratados. \nEn dependencia del análisis " +
                    "clínico epidemiológico, del cuadro lesional encontrado en las necropsias y del aislamiento " +
                    "y la identificación de los agentes se caracteriza la enfermedad ya sea neumonía enzoótica " +
                    "porcina, pleura neumonía porcina o neumonía por salmonera y se establece al tratamiento " +
                    "y las medidas para contrarrestar la enfermedad.",
            colorTitle = Color.White,
            colorText = Color.White,
            colorBG = colorInfo)
        Spacer(modifier = Modifier.height(6.dp))

        //Tratamiento
        ExpandableCard(title = "Prevencion y Control",
            description = "Aplicar 31 antibióticos de amplio espectro. Entre los más recomendados se " +
                    "encuentran las Penicilinas, Amoxicilina, Fosfomicina, Tilocina, Tilmicosia, Tulatromicina," +
                    " el Florfenicol, Ceftiofol sódico y la Tiamulina, entre otros",
            colorTitle = colorInfo)
        Spacer(modifier = Modifier.height(6.dp))

        //Control y Profilaxis
        ExpandableCard(title = "Control y Profilaxis",
            description = "Dada la etiología multifactorial del CRP para el control de la enfermedad se requieren" +
                    " mejorar las prácticas de manejo, diseño de instalaciones, aplicación de medidas de bioseguridad" +
                    " para evitar que aparezcan otros casos así como fortalecer la inmunidad del rebaño con el uso de" +
                    " vacunas eficaces.\n" +
                    "a) Dentro de las medidas generales tenemos: \n - Adoptar sistemas de crianza cerrados “todos dentro/" +
                    "todos fuera” y de “unidades múltiples de producción” reduce el contacto entre animales de distintas " +
                    "categorías así como la introducción de cepas nuevas. \n - Tratamiento estratégico con antibióticos " +
                    "de amplio espectro en el concentrado o el agua de bebida (quimioprofilaxis) durante 4 ó 5 días luego con" +
                    " un período de descanso y volver a repetirlo han dado resultados en lechones destetados o cerdas " +
                    "primíparas después del parto. \n - Planes de vacunación. Vacunas independientes o combinadas con " +
                    "varios agentes implicados han dado resultado en marranas gestantes. Las vacunas aplicadas a lactantes " +
                    "deberá ir acorde a la desaparición de los anticuerpos maternos por lo general a parir de la sexta semana " +
                    "de vida o según indique el fabricante. \n - Revisión de los programas de manejo para reducir las " +
                    "condiciones generadoras de estrés. \n - Separar o eliminar los animales enfermos de los sanos. Con la" +
                    " eliminación de los animales enfermos o desmedrados eliminamos los posibles diseminadores dentro de la piara. " +
                    "\n - Extremar las medidas higiénicas y de desinfección en instalaciones. " +
                    "\n - Evitar la entrada de nuevos animales y la venta de animales hasta controlar el brote. " +
                    "(cuarentena de la granja).",
            colorTitle = Color.White,
            colorText = Color.White,
            colorBG = colorInfo)
        Spacer(modifier = Modifier.height(6.dp))

        //Boton VR
        Button(
            onClick = {
                // Navega a la ruta cuando se hace clic en el botón
                navController.navigate("VR-neumonia")
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