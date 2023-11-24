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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.porcisaludvr.ExpandableCard
import com.example.porcisaludvr.R
import com.example.porcisaludvr.ui.theme.Itim

@Composable
fun PPCInfoScreen(navController: NavHostController) {

    var colorInfo: Color = Color(0,142,141,255)
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
            painter = painterResource(id = R.drawable.m2_info_1_ppc),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .background(Color.Transparent)
        )

        // Informacion
        ExpandableCard(title = "Informacion",
            description = " Es una enfermedad viral altamente infectocontagiosa de evolución casi siempre fatal que afecta a cerdos de" +
                    "todas las edades y razas, caracterizada por producir" +
                    "hemorragias en los órganos internos y la piel. El" +
                    "trastorno presenta varias formas clínicas que van desde" +
                    "muerte súbita hasta formas inaparentes con síntomas" +
                    "poco manifiestos.\n" +
                    "La enfermedad se transmite por contacto directo (vía" +
                    "respiratoria) o por vía digestiva, los animales enfermos" +
                    "que contagian los alimentos y el agua de bebida con" +
                    "orina, excremento, saliva y otras secreciones por donde" +
                    "eliminan el virus. También puede ser transmitida de" +
                    "forma mecánica por los piojos del cerdo, garrapatas." +
                    "Asimismo las moscas, las gallinas y los pájaros pueden" +
                    "diseminar el mal a otras porquerizas o cerdos vecinos." +
                    "Dada la relativa resistencia del virus en el ambiente" +
                    "los animales pueden infectarse cuando comparten" +
                    "bebederos, comederos o cualquier utensilio, así como" +
                    "instalaciones que hayan tenido contacto con animales." +
                    "enfermos.",
            colorTitle = colorInfo)
        Spacer(modifier = Modifier.height(6.dp))

        //Sintomas
        ExpandableCard(title = "Sintomas",
            description = "En la forma hiperaguda o sobreaguda los cerdos pueden" +
                    "morir sin haberse visto enfermos (muerte súbita), por " +
                    "lo general se presenta a inicio de los brotes.\n" +
                    "La forma aguda es la que más se presenta y se caracteriza" +
                    "por depresión marcada, inapetencia, (algunos cerdos" +
                    "continúan comiendo, pero no la cantidad acostumbrada)," +
                    "fiebre, conjuntivitis permanecen echados y los jóvenes" +
                    "tienden a amontonarse; se miran sofocados y con" +
                    "secreciones por la nariz. Aparecen petequias en la piel" +
                    "del abdomen, cara interna de los muslos, axilas, patas y" +
                    "puntas de las orejas.\n" +
                    "Algunos animales están estreñidos, pero otros presentan" +
                    "diarrea con sangre (disentería) puede presentarse" +
                    "vómito el cual es un signo bastante frecuente. Pueden" +
                    "encontrarse animales con trastornos nerviosos tales" +
                    "como andar de lado, caminar hacia atrás; al caminar" +
                    "arrastran un poco las patas o andan en círculos, otros" +
                    "presentan ceguera, otros pueden manifestar temblores, convulsiones así como rigidez de las extremidades.\n" +
                    "Los animales que sobreviven a la enfermedad quedan" +
                    "con un crecimiento pobre y se mantienen delgados. Las" +
                    "cerdas preñadas abortan o paren camadas de pocas crías" +
                    "o nacidas antes de tiempo que mueren poco después.\n" +
                    "En la forma subaguda o crónica predominan procesos" +
                    "neumónicos, entéricos, fracasos reproductivos y" +
                    "pérdidas neonatales tales como abortos, nacimientos" +
                    "débiles, etc. Se reportan formas ocultas o leves (cepas" +
                    "menos virulentas) en la que los síntomas son leves y" +
                    "confusos.",
            colorBG = colorInfo,
            colorTitle = Color.White,
            colorText = Color.White)
        Spacer(modifier = Modifier.height(6.dp))

        //Lesiones de Necropsia
        ExpandableCard(title = "Lesiones de Necropsia",
            description = "En los animales que mueren de forma sobreaguda puede" +
                    "no mostrar lesiones en los órganos internos. Los cerdos" +
                    "muertos en la forma aguda presentan puntitos rojos que" +
                    "se observan sobre las vísceras, en los ganglios linfáticos" +
                    "y en la superficie de los riñones. Estos puntitos rojos se" +
                    "miran también en la parte interna de la vejiga urinaria. El" +
                    "bazo se observa normal o aumentado de tamaño y en" +
                    "los bordes del órgano pueden aparecer unas manchas" +
                    "ennegrecidas en forma de cuñas o triángulos pequeños" +
                    "(infartos esplénicos)\n" +
                    "En algunos animales muertos con la forma aguda y en la mayoría de los animales muertos con el" +
                    "padecimiento crónico, además de poder encontrar las" +
                    "lesiones descritas se presentan en las amígdalas áreas" +
                    "amarillentas y en la parte interna del intestino grueso" +
                    "se miran unas manchas amarillentas redondeadas de" +
                    "diferentes tamaños (úlceras botonosas). ",
            colorTitle = colorInfo)
        Spacer(modifier = Modifier.height(6.dp))

        //Tratamiento
        ExpandableCard(title = "Tratamiento",
            description = "Para el virus no existe tratamiento, los antibióticos sólo" +
                    "evitan las complicaciones por agentes bacterianos.",
            colorTitle = Color.White,
            colorText = Color.White,
            colorBG = colorInfo)
        Spacer(modifier = Modifier.height(6.dp))

        //Prevencion y control
        ExpandableCard(title = "Prevencion y Control",
            description = "La medida más importante para prevenir la enfermedad" +
                    "es la vacunación a todos los porcinos una o dos veces" +
                    "al año. Algunos tipos de vacunas advierten no vacunar a" +
                    "cerdas preñadas porque pueden abortar.",
            colorTitle = colorInfo)
        Spacer(modifier = Modifier.height(6.dp))

        //PRINCIPALES MEDIDAS Que TOMAR ANTE UN BROTE
        ExpandableCard(title = "Principales medidas que tomar ante un brote",
            description = "\uF076 Vacunar o revacunar a toda la masa.\n" +
                    "\uF076 Aplicar cuarentena en la finca o en la porqueriza" +
                    "tales como evitar la entrada y salida de personas u" +
                    "otros animales a los patios o instalaciones donde se" +
                    "sospeche o diagnostique la enfermedad.\n" +
                    "\uF076 No vender ni comprar nuevos animales hasta" +
                    "controlar la mortalidad.\n" +
                    "\uF076 Sacrificar los animales sospechosos de presentar la" +
                    "forma crónica o los que se hayan recuperado de la" +
                    "enfermedad.\n" +
                    "\uF076 Quemar o enterrar los animales muertos, fetos y" +
                    "placenta de cerdas que aborten.\n" +
                    "\uF076 Desinfectar con formol al 3 % o sosa cáustica al 2" +
                    "% los locales donde permanecieron los animales" +
                    "enfermos o muertos.",
            colorTitle = Color.White,
            colorText = Color.White,
            colorBG = colorInfo)
        Spacer(modifier = Modifier.height(6.dp))

        //Boton VR
        Button(
            onClick = {
                // Navega a la ruta cuando se hace clic en el botón
                navController.navigate("VR-ppc")
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

@Preview
@Composable
fun PPCInfoScreenPreview() {
    // Puedes usar este preview para verificar cómo se ve la pantalla
    PPCInfoScreen(navController = rememberNavController())
}