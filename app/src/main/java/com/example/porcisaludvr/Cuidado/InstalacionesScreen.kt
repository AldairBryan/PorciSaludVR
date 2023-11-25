package com.example.porcisaludvr.Cuidado

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
fun InstalacionesScreen(navHostController: NavHostController){
    var colorInfo: Color =  Color(0,142,141,255)
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

        // Informacion
        ExpandableCard(title = "Diseño",
            description = "Debe ir orientado a:\n" +
                    "- Evitar la transmisión de enfermedades y diseminación de plagas.\n" +
                    "- Tener una apropiada limpieza y desinfección.\n" +
                    "- Delimitar las instalaciones del criadero.\n" +
                    "- Diferenciar por módulos los diferentes estados productivos de la crianza. (Reproducción," +
                    "maternidad, crecimiento y acabado).\n" +
                    "- Cubrir las necesidades de espacio vital en los animales de acuerdo a la etapa de crianza:" +
                    "lo cual orientará en la proyección del tamaño de las instalaciones, número de equipos a" +
                    "utilizar.\n" +
                    "- Adecuada protección de los animales que se encuentren en estos alojamientos frente a las" +
                    "condiciones climáticas (frescas en el verano y proporcionar suficiente calor en el" +
                    "invierno) y las contingencias adversas.\n" +
                    "- Prevenir intoxicaciones y/o enfermedades en los operarios directos.\n" +
                    "- Evitar la contaminación ambiental.\n" +
                    "- Facilitar la distribución de los alimentos.",
            colorTitle = colorInfo)
        Spacer(modifier = Modifier.height(6.dp))

        //Sintomas
        ExpandableCard(title = "Ubicacion",
            description = "Se recomienda construir las instalaciones en un terreno adecuadamente drenado y con el abastecimiento necesario del servicio de agua. La orientación de los vientos es tomada en cuenta para evitar los malos olores y generar ventilación: En climas cálidos y templados se sugiere ubicar las instalaciones con su eje más largo en dirección Este – Oeste, para evitar que los rayos solares penetren y se mantenga lo más fresco posible." +
                    "\nEn climas fríos el eje más largo se ubicará de Norte a Sur, así los rayos solares penetrarán en la mañana como en la tarde y regularán la temperatura del interior",
            colorBG = colorInfo,
            colorTitle = Color.White,
            colorText = Color.White)
        Spacer(modifier = Modifier.height(6.dp))

        //Lesiones de Necropsia
        ExpandableCard(title = "Materiales de Construccion",
            description = "a) Paredes: En la medida de lo posible fácil de ser lavadas y desinfectadas. Se recomienda NO UTILIZAR material que pudiera oxidarse o producir daños en los animales." +
                    "\n\nb) Pisos: Libres de material que pudiera lastimar a los animales. Si se considera el material noble, no deben ser muy lisos o pulidos, de tal manera que los animales no resbalen y se caigan. Al igual que las paredes deben permitir ser fácilmente lavados y/o higienizados. El piso de los corrales debe contar con una inclinación suficiente que no permita la acumulación de excretas e incremento de humedad. Un 3-4% de desnivel es lo óptimo. En la construcción del piso no se deben escatimar recursos; cuando éstos se hacen muy delgados, hay filtración de humedad y fácilmente se hacen huecos que se llenan de agua y desperdicios, convirtiéndose en un foco de infección permanente. El grosor o espesor recomendado en pisos de concreto es de 20-30 cm. Desde el punto de vista de higiene No son recomendables los pisos de tierra.Se sugiere que las construcciones sean trabajadas con los materiales propios de la región y sean adaptados a los tipos de instalaciones requeridas." +
                    "\n\nc) Techos: Los materiales que se pueden utilizar son los que estén al alcance de los productores pudiendo ser de: tejas, paja, palma, tablillas de madera o malla arpillera sellada por brea, etc. Un tejado sin aislamiento en un clima caluroso puede convertir la instalación en un verdadero horno. Por lo tanto, lo ideal es colocar bajo el tejado un material no conductor del calor (aislante). La altura de los techos en su parte más baja medirá: 1.80 – 2 metros y en la parte más alta de 2 a 2.5 metros. Como regla general en las construcciones, el área techada corresponde al 100% del área del corral. La inclinación del techo puede estar entre el 20% y el 30%" +
                    "\n\nd) Puertas: El ancho no debe ser menor de 1 metro, con suficiente espacio para que pueda entrar una carretilla, en caso usar una para la distribución del alimento o para sacar desechos y favorecer la limpieza." +
                    "\n\ne) Cama: Se implementa para compensar la pérdida de calor. El material más usado lo constituye la paja, si se opta por trabajarlo, es imprescindible que la superficie del suelo sea lisa para facilitar la retirada de heces. El inconveniente higiénico constituye la aparición de parásitos y otros agentes infecciosos. Finalmente, se debe evitar formaciones de hongos en la paja, a fin de no presentar futuras intoxicaciones en el caso que se ingiera este material por parte de los animales." +
                    "\nOtro material que se utiliza es la viruta sin embargo cabe la posibilidad que genere neumonías en edades tempranas de los lechones, por lo que se recomienda evaluar previamente su uso",
            colorTitle = colorInfo)
        Spacer(modifier = Modifier.height(6.dp))

        //Tratamiento
        ExpandableCard(title = "Higiene de Instalaciones",
            description = "- Las paredes, pisos y drenajes se deben mantener limpios.\n" +
                    "- Al sacar los animales para venta o cambio de corral; las instalaciones deben quedar" +
                    "lavadas, desinfectadas y encaladas y dejarlas por lo menos 3 días libres.\n" +
                    "- Cada 30 días como máximo, desinfectar los alrededores del corral, utilizando productos" +
                    "para control de garrapatas, pulgas y ácaros de la sarna, mediante bomba de mochila o " +
                    "aspersión, para ello se utilizará el equipo y protección adecuados y se respetará las " +
                    "dosificaciones que daten en las etiquetas del producto a elegir.\n" +
                    "- Realizar control sobre ratas cada tres meses con productos inocuos al medio ambiente y " +
                    "con Registro sanitario vigente emitido por la autoridad correspondiente.\n" +
                    "- Recolectar el estiércol y orina provenientes de la limpieza diaria de los pisos y " +
                    "almacenarlos en un pozo construido fuera del corral para su debido aprovechamiento: " +
                    "como abono orgánico o para alimentar un biodigestor",
            colorTitle = Color.White,
            colorText = Color.White,
            colorBG = colorInfo)
        Spacer(modifier = Modifier.height(6.dp))

        //Prevencion y control
        ExpandableCard(title = "Equipos",
            description = "Son todos los instrumentos utilizados para satisfacer las necesidades del manejo de los " +
                    "porcinos en sus distintas etapas, tales como:" +
                    "\n- Bebederos: Se recomienda trabajar un material que se pueda limpiar y desinfectar con facilidad. Adaptables de acuerdo a la edad de los animales. NO SE RECOMIENDA trabajar llantas, ya que resultan anti higiénicas. " +
                    "\n\n- Comederos: Deben ser dispuestos en cantidad suficiente para que todos los porcinos tengan acceso y puedan comer tranquilamente, no originen desperdicios de comida, que sea fácil la colocación del alimento, al igual que su lavado limpieza y desinfección. NO SE RECOMIENDA EL USO DE LLANTAS, ya que genera el desperdicio del alimento y son anti higiénicas. No deben quedar junto a los bebederos, para evitar el desperdicio de comida por fermentación.",
            colorTitle = colorInfo)
        Spacer(modifier = Modifier.height(6.dp))

        ExpandableCard(title = "Modulo de Reporoduccion",
            description = "Instalaciones para Hembras \n" +
                    "\n\n- Marranas: Máximo 10 animales por corral. Área recomendada por cada animal: 3m2 - 4m2 . " +
                    "\n- Hembras de primer servicio (Primerizas): Máximo 15 animales por corral, son mantenidas en este ambiente durante el primer mes de gestación. Área recomendada por animal es: 1.64 m2 . " +
                    "\n- Hembras gestantes: Máximo 10 animales por corral. Área recomendada por animal: 2.25 m2" +
                    "\n\nInstalaciones para Machos \nSe sugiere que los corrales se ubiquen y construyan de forma tal que los machos puedan darse la vuelta y además les permita tener contacto audio-visual y olfativo con el resto de sementales. El local destinado para los machos debe estar separado de las hembras. El ambiente debe contar con una temperatura ambiente de 20ºC. Se recomienda que el área destinada al verraco sea de 3.5 m de largo por 2.5 metros de ancho. El comedero puede ser tradicional en concreto y el bebedero tipo chupete. El área debe permanecer cercada en pared de concreto con una altura mínima de 1.10 metros de alto. " +
                    "\n- Verracos: Máximo: 1 animal por corral: Área recomendada por animal: 6-10m2 " +
                    "\n- Área de monta: Tamaño de corral destinado a la monta: 9m² para cubrir a las hembras que entren en celo.",
            colorTitle = Color.White,
            colorText = Color.White,
            colorBG = colorInfo)
        Spacer(modifier = Modifier.height(6.dp))
        //Prevencion y control
        ExpandableCard(title = "Modulo de Maternidad",
            description = "Constituye lo más delicado del diseño y ejecución, alberga a los animales en las fases de desarrollo en las que están más indefensos. El parto y cría de los lechones con su madre es la fase de mayor importancia dentro de la crianza porcina." +
                    "\nLa instalación más usada en esta etapa es la JAULA PARIDERA: la cual, presenta la función de contener a la hembra y evitar o disminuir el aplastamiento de los lechones por parte de su madre. La inversión en la construcción de buenas jaulas parideras, se recupera por la obtención de un mayor número de lechones por camada, siendo éste uno de los factores que más contribuye a reducir los gastos de producción; sin embargo las instalaciones para la parición deben adaptarse a la alternativa de crianza adoptada por el productor (pudiendo ser de madera o fierro de construcción). El tiempo que estarán las hembras en estas instalaciones va desde una semana antes del parto hasta que ocurra el destete." +
                    "\nSe recomienda que en promedio las jaulas tengan un espacio para las hembras de:\n" +
                    "Ancho: 0.55 a 0.60 m\n" +
                    "Largo de 2.10 m\n" +
                    "Altura de 0.90 m;\n" +
                    "Teniendo un espacio mínimo a cada lado de 0,45 m y si se mantienen los lechones durante" +
                    "toda la lactancia en la jaula, este espacio debe ser de 0.60 m." +
                    "\nEs importante considerar el alto de la barra inferior, que puede ser fija o móvil y no debe estar a menos de 0.28 m con respecto al piso, además la jaula debe de tener un comedero y un bebedero para la marrana, el cual estará a una altura de: 0.70 m y otro para los lechones, el cual se hallará a una altura de 0.25m" +
                    "\n\nLechones: Área recomendada por animal: Hasta 10 Kg: 0.10 m2\n",
            colorTitle = colorInfo)
        Spacer(modifier = Modifier.height(6.dp))

        //PRINCIPALES MEDIDAS Que TOMAR ANTE UN BROTE
        ExpandableCard(title = "Alternativas",
            description = "Alternativas al uso de las jaulas parideras: La construcción de corrales con material reciclable como lo son las parihuelas en los que se arman divisiones tipo cobertizos para ubicar a los lechones para que duerman y aprendan a comer en esa zona, resulta una alternativa. Las dimensiones a considerar deben respetar el espacio vital mínimo. En el tipo de crianza de traspatio, esta alternativa se plantea puesto que el pequeño productor ha generado la idea que las jaulas parideras podrían contribuir a incrementar el estrés en las marranas y por consiguiente disminuir la producción láctea.",
            colorTitle = Color.White,
            colorText = Color.White,
            colorBG = colorInfo)
        Spacer(modifier = Modifier.height(6.dp))

        ExpandableCard(title = "Corrales de Engorde",
            description = "Los corrales de engorde deberán estar muy bien ventilados, con una altura adecuada de los techos; y comederos para que tengan acceso al alimento en todo momento así como acceso permanente al agua fresca para bebida. Los porcinos permanecerán en estas instalaciones de 11 a 12 semanas y es aquí donde se hace la mayor inversión en alimento." +
                    "\nDe preferencia las instalaciones de engorde deberán estar lo más lejos posible de las otras " +
                    "aéreas de producción." +
                    "\n Se dispondrán los animales destetados en corrales hasta los 20Kg, para luego pasar a los " +
                    "módulos de crecimiento y acabado hasta su comercialización.\n" +
                    "- En el caso de los animales hasta 20Kg: Se sugiere considerar un área por animal de 0.20 " +
                    "m2\n" +
                    "- En el caso de los animales de crecimiento: 20 Kg- 50Kg: Se sugiere considerar un área " +
                    "de 0.20-0.80 m2\n" +
                    "- En el caso de los animales de engorde- acabado: 50 Kg- 70 Kg: Se sugiere considerar un " +
                    "área por animal de: 1m2\n" +
                    "- Esta área (corrales) es delimitada con pared de concreto de 0.90 - 1.10 m de altura. " +
                    "- Son recomendados los comederos tradicionales en cemento en razón de 0.35 cm de\n" +
                    "comedero por cada animal, o los comederos tipo tolva.\n" +
                    "- Los bebederos pueden ser de nivel o de chupón. Se utiliza un bebedero de chupón por " +
                    "cada 10 animales. Las alturas recomendadas son: Lechón hasta 20 Kg: 0.25m, " +
                    "Crecimiento y engorde-Acabado: 0.45 m",
            colorTitle = colorInfo)
        Spacer(modifier = Modifier.height(6.dp))
    }
}