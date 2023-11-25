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
fun ManejoEstProduScreen(navHostController: NavHostController){
    var colorInfo: Color = Color(255,135,74,255)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text ="Manejo en los Diferentes Estados Productivos",
            fontFamily = Itim,
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            color = colorInfo,
            textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(16.dp)
        )

        // Informacion
        ExpandableCard(title = "Manejo de Verracos",
            description = "La eficiencia, eficacia y calidad - dependen de alrededor del 50% de la calidad genética de los reproductores utilizados en la explotación, y la otra mitad en función del tipo de sistema de producción y calidad del manejo practicado. Por lo tanto, los porcinos de cría se pueden considerar a lo largo del proceso de producción como una materia prima viva.",
            colorTitle = colorInfo)
        Spacer(modifier = Modifier.height(6.dp))

        //Sintomas
        ExpandableCard(title = "Recepcion y Seleccion",
            description = "Se recomienda el ingreso entre los 6 - 6½ meses de edad, previamente se le otorga una etapa de adaptación de 4-6 semanas antes de su uso. Es deseable desparasitarlo, previa prescripción del médico veterinario y brindarle el confort necesario: alojarlo en un corral limpio con acceso a una fuente de agua permanente y gradualmente (3-5 días) cambiar su alimento. Los verracos utilizados a una edad demasiado temprana pueden tener una vida útil considerablemente más corta y su capacidad de reproducción puede ser menor." +
                    "\nPara su Eleccion: \n" +
                    "- Ser saludable y mostrar adecuado desarrollo corporal.\n" +
                    "- Ser dócil, pero ACTIVO.\n" +
                    "- Mostrar desarrollo normal de los órganos reproductores: Implica No presencia de flacidez " +
                    "en el pene y testículos bien conformados: forma y tamaño normal, parejos y sin defectos.\n" +
                    "- Debe estar libre de defectos hereditarios tales como: hernias umbilicales o escrotales, " +
                    "criptorquidismo.\n" +
                    "- Conformación y apariencia exterior: Buena longitud corporal, patas bien aplomadas, las " +
                    "pezuñas no deben ser débiles y tener rajaduras, constitución fuerte y musculosa. Buen " +
                    "desarrollo de jamones. Mínimo 12 pezones.\n" +
                    "- Cuando camina debe moverse libremente, sin ningún signo de rigidez o cojera",
            colorBG = colorInfo,
            colorTitle = Color.White,
            colorText = Color.White)
        Spacer(modifier = Modifier.height(6.dp))

        //Lesiones de Necropsia
        ExpandableCard(title = "Manejo de hembras reproductivas",
            description = "Caracteristicas:\n" +
                    "- Buena salud y no debe evidenciar signo aparente de enfermedad.\n" +
                    "- Procedencia: Proceder de camadas numerosas y homogéneas.\n" +
                    "- Buen desarrollo abdominal, jamón lleno, buenos aplomos extremidades posteriores " +
                    "desarrolladas, pero no pesadas.\n" +
                    "- Número de tetas: 6- 7 pares de tetas, uniformes y bien repartidas a lo largo del vientre.\n" +
                    "- Cualidades maternales excelentes y capacidad lechera, para ello se tomará como " +
                    "referencia los datos productivos que se puedan obtener de la madre. (Si se cuenta con " +
                    "registros).\n" +
                    "- Rusticidad y resistencia a enfermedades.\n" +
                    "\nConsideraciones:\n" +
                    "El peso y la edad óptima para realizar el primer servicio se estima hacia los 130 kg y de alrededor de 7-8 meses de edad. La vida productiva de una hembra se halla alrededor de los 4-5 años.",
            colorTitle = colorInfo)
        Spacer(modifier = Modifier.height(6.dp))

        //Tratamiento
        ExpandableCard(title = "Primerizas / Adultas",
            description = "Primerizas:\n" +
                    "Es recomendable empezar a trabajarlas hacia el tercer celo: así se asegura un mayor desarrollo del aparato genital. Es preferible, realizar la monta 12 horas después de iniciado el celo. " +
                    "\n\nMarranas: (adultas)'n" +
                    "Se pueden trabajar partir del tercer o quinto día de realizado el destete, siempre y cuando existan signos de celo.",
            colorTitle = Color.White,
            colorText = Color.White,
            colorBG = colorInfo)
        Spacer(modifier = Modifier.height(6.dp))

        //Prevencion y control
        ExpandableCard(title = "Manejo de la Reproduccion",
            description = "La correcta detección del celo es un aspecto crítico del manejo de la cubrición. La manera más generalizada y efectiva para realizar la detección de celos es la visualización de las marranas en presencia del verraco. En la marrana, el celo se presenta con una frecuencia de 19 a 21 días y tiene una duración de dos a tres días." +
                    "\nEl celo se manifiesta con enrojecimiento, hinchazón y secreciones de la vagina. El signo más importante es sin duda que las hembras permanecen quietas, cuando se presiona sobre su lomo se produce el “reflejo de inmovilidad” y, si es el caso, se montan o dejan montar por otras hembras. Precisamente este último signo, es el que permite determinar con exactitud el momento más oportuno para realizar el servicio ya que coincide con la aceptación del macho. Los números de servicios recomendados por celo corresponden a dos; ya que aumenta el porcentaje de preñez y número de lechones nacidos y destetados",
            colorTitle = colorInfo)
        Spacer(modifier = Modifier.height(6.dp))

        //PRINCIPALES MEDIDAS Que TOMAR ANTE UN BROTE
        ExpandableCard(title = "Consideraciones",
            description = "- Estar seguro que la hembra se encuentre en celo\n" +
                    "- Trasladada a la marrana al corral del verraco: es importante dar las máximas condiciones al macho y evitar las situaciones de sumisión. Además es aconsejable disponer de un corral especial para hacer la cubrición, éste tiene que ser espacioso, sin obstáculos, no resbaladizo, con buena temperatura y ventilación. Además que debe ser un ambiente tranquilo." +
                    "\n- Si el verraco no ha sido descolmillado proceder con esta operación a fin que no lastime a " +
                    "la hembra u otros animales.\n" +
                    "- Seleccionar el verraco acorde con el tamaño de la marrana y su salud. Tenemos que buscar tamaños similares. Verracos más viejos y con mucho peso pueden aplastar literalmente a una primeriza, de la misma manera si el verraco es muy joven; es posible que no pueda llegar a alcanzar su “objetivo”. De la misma manera verracos enfermos o vacunados hace poco pueden no hacer bien su trabajo puesto que su calidad seminal se puede ver afectada" +
                    "\n- Asegurarse que el macho adopte una posición adecuada para montar a la marrana con " +
                    "facilidad, si no lo hace, ayudarlo o hacerlo bajar para que pruebe otra vez.\n" +
                    "- Verificar post servicio si se repite el celo o si existe preñez.",
            colorTitle = Color.White,
            colorText = Color.White,
            colorBG = colorInfo)
        Spacer(modifier = Modifier.height(6.dp))

        //Prevencion y control
        ExpandableCard(title = "Manejo de hembras gestantes",
            description = "- Es importante procurar confirmar la gestación de un modo precoz y certero. La detección " +
                    "temprana de hembras no preñadas, permitirá decidir sobre el destino de éstas; así se " +
                    "evitarán aumentar los días no productivos /marrana /año en el criadero. El período en el " +
                    "que las marranas vuelven a repetir celo, se presenta entre los 18 y 23 días después del " +
                    "servicio.\n" +
                    "- La duración de la gestación en la marrana es 3 meses, 3semanas y tres días en promedio.\n" +
                    "- Es preferible que la marrana preñada tenga un corral individual, confortable a fin que " +
                    "tenga acceso a una fuente de agua, se le proporcione alimento y se eviten las peleas al " +
                    "igual que las temperaturas altas.\n" +
                    "- Después de los 30 días de gestación controlar que adelgace o engorde mucho. Se " +
                    "recomienda como alternativa el uso de escalas de condición corporal visual, en el caso " +
                    "del estado de condición corporal al parto debe ser 3.5. La condición corporal de la " +
                    "marrana se puede determinar por medio de valores numéricos que van de 1 a 5 y para esto " +
                    "se debe apoyar la palma de la mano en la columna por delante de la base de la cola y " +
                    "moverla lateralmente de lado a lado. De esta manera se le puede dar una puntuación a la " +
                    "condición corporal.",
            colorTitle = colorInfo)
        Spacer(modifier = Modifier.height(6.dp))

        //PRINCIPALES MEDIDAS Que TOMAR ANTE UN BROTE
        ExpandableCard(title = "Alimento durante gestacion",
            description = "Día 0 a 20: No mayor a 2,0 Kg / día /animal\n" +
                    "Día 20 a 50/55: 2,5- 3 Kg/ día / animal\n" +
                    "Día 50/55 a 85: 2 a 2,5 kg/ día / animal\n" +
                    "Día 85 a 110: Dar de 0.5 a 1 kg., más de alimento por animal.\n" +
                    "Día 110 a 114: restringir el consumo a 2 y 1,5 kg., y aumentar la cantidad de fibra." +
                    "\n\nDurante toda la fase de gestación es importante asegurar una buena provisión de agua limpia y fresca. Las marranas deben estar en la temperatura confort (18 a 20 ºC). Las altas temperaturas producen mortalidad embrionaria y las bajas temperaturas aumentan el consumo y por ende los costos.",
            colorTitle = Color.White,
            colorText = Color.White,
            colorBG = colorInfo,
            image = R.drawable.m3_cuidado_3_alimentacion)
        Spacer(modifier = Modifier.height(6.dp))

        //Prevencion y control
        ExpandableCard(title = "Manejo del parto / Marrana",
            description = "- 1 mes antes del parto: Aplicar calcio de acuerdo a lo que prescriba el médico " +
                    "veterinario.\n" +
                    "- Desparasitar interna y externamente previa prescripción del médico veterinario, " +
                    "por lo menos 3 semanas previas al parto.\n" +
                    "- Limpiar y desinfectar las parideras o jaulas de parto.\n" +
                    "- Baño y desinfección (sobretodo el vientre) de la marrana; para este manejo se " +
                    "puede usar tintura de yodo diluida a manera de té cargado.\n" +
                    "- Se reduce el alimento a 1.5Kg y se incorpora fibra en la dieta (afrecho).\n" +
                    "- Se deberá introducir a las marranas de forma cuidadosa en la paridera, sobre todo " +
                    "si se trata de primerizas, considerando entre cinco o siete días antes de la fecha " +
                    "prevista al parto, para evitar el estrés y así asegurar la aclimatación de la marrana " +
                    "a ese nuevo ambiente",
            colorTitle = colorInfo)
        Spacer(modifier = Modifier.height(6.dp))

        //PRINCIPALES MEDIDAS Que TOMAR ANTE UN BROTE
        ExpandableCard(title = "Signos de Parto",
            description = "Los signos principales de aproximación al parto son los siguientes:\n" +
                    "- La marrana demuestra nerviosismo, inquietud (se acuesta y se levanta de forma " +
                    "continua) y en ocasiones cierta agresividad.\n" +
                    "- Generalmente rehúsa ingerir algún alimento.\n" +
                    "- Se observa inflamación de la vulva y del sistema mamario y relajación del vientre.\n" +
                    "- Formación de cama: Se observa tendencia a preparar el nido o a escarbar los " +
                    "materiales que se usan para la cama.\n" +
                    "- Secreción de leche: Se produce secreción láctea entre las 12-24 horas previas al " +
                    "parto. ",
            colorTitle = Color.White,
            colorText = Color.White,
            colorBG = colorInfo)
        Spacer(modifier = Modifier.height(6.dp))

        //Prevencion y control
        ExpandableCard(title = "Cuidados al mommento de parto",
            description = "- El día del parto ofrecer abundante agua limpia y fresca, NO DAR alimento.\n" +
                    "- Dar tranquilidad a la madre.\n" +
                    "- Las instalaciones: jaula paridera: deben estar limpias y desinfectadas.\n" +
                    "- El parto puede durar 1-4 horas.\n" +
                    "- Los lechones nacen aproximadamente cada 10-15 minutos.\n" +
                    "- Recurrir al médico veterinario, en caso que la vulva emane secreción fétida o mal " +
                    "oliente.\n" +
                    "- Pesar los lechones a los 3 días y luego a las 3 semanas",
            colorTitle = colorInfo)
        Spacer(modifier = Modifier.height(6.dp))

        //PRINCIPALES MEDIDAS Que TOMAR ANTE UN BROTE
        ExpandableCard(title = "Manejo en el crecimiento/engorde",
            description = "Controlar el peso cada tres semanas.\n" +
                    "Los porcinos de engorda se mantienen por lo general en confinamiento. Es necesario " +
                    "clasificar los porcinos de engorda según la edad y peso, para evitar que hayan " +
                    "animales menos fuertes que sean perjudicados en su alimentación.\n" +
                    "\nEl número de animales por corral también tiene importancia en la eficiencia del " +
                    "sistema de engorda. Por esto, se mantienen lotes no mayores de 10 animales en un " +
                    "solo corral.",
            colorTitle = Color.White,
            colorText = Color.White,
            colorBG = colorInfo)
        Spacer(modifier = Modifier.height(6.dp))

        //Prevencion y control
        ExpandableCardTable(title = "Temperatura en corrales",
            colorTitle = colorInfo,
            image = R.drawable.m3_cuidado_3_tmp_1,
            image2 = R.drawable.m3_cuidado_3_tmp_2)
        Spacer(modifier = Modifier.height(6.dp))
    }
}