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
import com.example.porcisaludvr.ExpandableCard
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

        // Descripcion
        ExpandableCard(title = "Descripcion",
            description = """
            Es una enfermedad viral altamente infectocontagiosa
            de evolución casi siempre fatal que afecta a cerdos de
todas las edades y razas, caracterizada por producir
hemorragias en los órganos internos y la piel. El
trastorno presenta varias formas clínicas que van desde
muerte súbita hasta formas inaparentes con síntomas
poco manifiestos.
La enfermedad se transmite por contacto directo (vía
respiratoria) o por vía digestiva, los animales enfermos
que contagian los alimentos y el agua de bebida con
orina, excremento, saliva y otras secreciones por donde
eliminan el virus. También puede ser transmitida de
forma mecánica por los piojos del cerdo, garrapatas.
Asimismo las moscas, las gallinas y los pájaros pueden
diseminar el mal a otras porquerizas o cerdos vecinos.
Dada la relativa resistencia del virus en el ambiente
los animales pueden infectarse cuando comparten
bebederos, comederos o cualquier utensilio, así como
instalaciones que hayan tenido contacto con animales
enfermos.
            """.trimIndent(),
            colorBG = Color.White,
            colorText = colorInfo)
        Spacer(modifier = Modifier.height(6.dp))

        //Sintomas
        ExpandableCard(title = "Sintomas",
            description = """
            En la forma hiperaguda o sobreaguda los cerdos pueden
morir sin haberse visto enfermos (muerte súbita), por
lo general se presenta a inicio de los brotes.
La forma aguda es la que más se presenta y se caracteriza
por depresión marcada, inapetencia, (algunos cerdos
continúan comiendo, pero no la cantidad acostumbrada),
fiebre, conjuntivitis permanecen echados y los jóvenes
tienden a amontonarse; se miran sofocados y con
secreciones por la nariz. Aparecen petequias en la piel
del abdomen, cara interna de los muslos, axilas, patas y
puntas de las orejas.
Algunos animales están estreñidos, pero otros presentan
diarrea con sangre (disentería) puede presentarse
vómito el cual es un signo bastante frecuente. Pueden
encontrarse animales con trastornos nerviosos tales
como andar de lado, caminar hacia atrás; al caminar
arrastran un poco las patas o andan en círculos, otros
presentan ceguera, otros pueden manifestar temblores, 
            """.trimIndent(),
            colorBG = colorInfo,
            colorText = Color.White)

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