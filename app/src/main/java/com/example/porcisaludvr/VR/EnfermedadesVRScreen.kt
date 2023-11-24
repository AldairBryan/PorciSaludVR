package com.example.porcisaludvr.VR

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.porcisaludvr.ExpandableCard
import com.example.porcisaludvr.R
import com.example.porcisaludvr.ui.theme.Itim
import com.example.porcisaludvr.ui.theme.Translucent
import com.google.ar.core.Config
import io.github.sceneview.ar.ARScene
import io.github.sceneview.ar.node.ArModelNode
import io.github.sceneview.ar.node.ArNode
import io.github.sceneview.ar.node.PlacementMode

@Composable
fun EnfermedadesVRScreen(navController: NavHostController, enfermedad: String) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Transparent
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            val currentModel = remember {
                mutableStateOf(enfermedad)
            }
            ARScreen(currentModel.value)
            var num: Int = 0
            when (enfermedad){
                "ppc" -> { num = 0}
                "sarna" -> { num = 1}
                "neumonia" -> {num = 2}
            }
            Enfermedades(num,modifier = Modifier.align(Alignment.BottomCenter)) {
                currentModel.value = it
            }

        }
    }
}

@Composable
fun Enfermedades(startIndex: Int, modifier: Modifier, onClick:(String)->Unit) {

    val itemsList = listOf(
        Enfermedad("ppc", R.drawable.m1_vr_1_ppc),
        Enfermedad("sarna", R.drawable.m1_vr_2_sarna),
        Enfermedad("neumonia", R.drawable.m1_vr_3_neumonia),
        )
    var currentIndex by remember {
        mutableStateOf(startIndex)
    }
    fun updateIndex(offset:Int){
        currentIndex = (currentIndex+offset + itemsList.size) % itemsList.size
        onClick(itemsList[currentIndex].name)
    }
    Row (modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        IconButton(modifier = Modifier.size(95.dp) ,
            onClick = {
            updateIndex(-1)
        }) {
            Icon(painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24), modifier = Modifier.size(95.dp) ,contentDescription ="previous" )
        }

        CircularImage(imageId = itemsList[currentIndex].imageID)

        IconButton(modifier = Modifier.size(95.dp) ,
            onClick = {
            updateIndex(1)
        }) {
            Icon(painter = painterResource(id = R.drawable.baseline_arrow_forward_ios_24),modifier = Modifier.size(95.dp) , contentDescription ="next")
        }
    }
}

@Composable
fun CircularImage(
    modifier: Modifier=Modifier,
    imageId: Int
) {
    Box(modifier = modifier
        .size(95.dp)
        .clip(CircleShape)
        .border(width = 3.dp, Translucent, CircleShape)
    ){
        Image(painter = painterResource(id = imageId), contentDescription = null, modifier = Modifier.size(95.dp), contentScale = ContentScale.FillBounds)
    }
}

@Composable
fun ARScreen(model:String) {
    val nodes = remember {
        mutableListOf<ArNode>()
    }
    val modelNode = remember {
        mutableStateOf<ArModelNode?>(null)
    }
    val placeModelButton = remember {
        mutableStateOf(false)
    }
    Box(modifier = Modifier.fillMaxSize()){
        ARScene(
            modifier = Modifier.fillMaxSize(),
            nodes = nodes,
            planeRenderer = true,
            onCreate = {arSceneView ->
                arSceneView.lightEstimationMode = Config.LightEstimationMode.DISABLED
                arSceneView.planeRenderer.isShadowReceiver = false
                modelNode.value = ArModelNode(arSceneView.engine, PlacementMode.INSTANT).apply {
                    loadModelGlbAsync(
                        glbFileLocation = "models/${model}.glb",
                        scaleToUnits = 0.8f
                    ){

                    }
                    onAnchorChanged = {
                        placeModelButton.value = !isAnchored
                    }
                    onHitResult = {node, hitResult ->
                        placeModelButton.value = node.isTracking
                    }

                }
                nodes.add(modelNode.value!!)
            },
            onSessionCreate = {
                planeRenderer.isVisible = false
            }
        )
        var colorAux: Color= Color.White
        when (model){
            "ppc" -> {colorAux= Color(0, 142, 141, 255)}
            "sarna" -> { colorAux = Color(137, 73, 136, 255)}
            "neumonia" -> { colorAux = Color(211, 58, 84, 255)}
        }
        if(placeModelButton.value){
            Button(colors = ButtonDefaults.buttonColors(Color.Transparent),
                onClick = {
                modelNode.value?.anchor()
            }, modifier = Modifier.align(Alignment.Center)) {
                showTextTitleHelper(colorGeneral = colorAux, titulo = "Colocar")
            }
        }
    }


    LaunchedEffect(key1 = model){
        modelNode.value?.loadModelGlbAsync(
            glbFileLocation = "models/${model}.glb",
            scaleToUnits = 0.8f
        )
        Log.e("errorloading","ERROR LOADING MODEL")
    }
    Column{
        showTitle(num = model)
        showInformacionEnfermedad(num = model)
    }
}


@Composable
fun showTitle (num: String){
    var textTitle: String = ""
    var colorText: Color = Color(0,142,255,141)

    when (num){
        "ppc" -> { textTitle = "Peste Porcina"
        colorText= Color(0, 142, 141, 255)}
        "sarna" -> { textTitle = "Sarna Sarcoptica"
        colorText = Color(137, 73, 136, 255)}
        "neumonia" -> { textTitle = "Neumonía Enzoótica"
        colorText = Color(211, 58, 84, 255)}
    }
    showTextTitleHelper(colorGeneral = colorText, titulo = textTitle)
}

@Composable
fun showInformacionEnfermedad(num: String){
    var descriptionEnfermedad: String = ""
    var colorText: Color = Color(0,142,255,141)
    when (num){
        "ppc" -> { descriptionEnfermedad = "La PPC es una enfermedad viral altamente contagiosa, los sintomas incluyen: " +
                "Anorexia, los cerdos dejan de comer; Cojera y debilidad en las extremidades; Hemorragias en la piel y las mucosas" +
                "y Trastornos respiratorios"
            colorText= Color(0, 142, 141, 255)}
        "sarna" -> { descriptionEnfermedad = "La sarna sarcoptica es una infección parasitaria de la piel en cerdos, causada por el" +
                " ácaro Sarcoptes scabiei. Los síntomas son : Picazón intensa y constante; Pérdida de pelo y erupciones " +
                "cutáneas; Engrosamiento de la piel; Costras y heridas por rascado; Pérdida de peso debido a la incomodidad y el " +
                "estrés; Costras en las orejas y extremidades."
            colorText = Color(137, 73, 136, 255)}
        "neumonia" -> { descriptionEnfermedad = "La neumonía enzoótica es una enfermedad respiratoria. Los sintomas son: " +
                "Tos persistente y grave; Dificultad respiratoria, con respiración rápida y superficial; Fiebre; " +
                "Secreciones nasales y oculares; Disminución del apetito; Letargo y " +
                "Reducción del crecimiento y ganancia de peso en cerdos jóvenes. "
            colorText = Color(211, 58, 84, 255)}
    }
    ExpandableCard(title = "Informacion", description = descriptionEnfermedad, colorTitle = colorText,
        colorText = colorText, colorBG = Color.Transparent, colorBorder = colorText,
        titleFontSize = 23.sp, descriptionFontSize = 15.sp)
}
@Composable
fun showTextTitleHelper(colorGeneral: Color, titulo: String){
    Box(
        modifier = Modifier
            .padding(horizontal = 32.dp, vertical = 8.dp)
            .shadow(elevation = 4.dp, shape = RoundedCornerShape(24.dp))
            .border(
                width = 4.dp, // Ancho del borde
                color = colorGeneral, // Color del borde
                shape = RoundedCornerShape(24.dp) // Bordes redondeados
            )
            .background(Color.Transparent),
        contentAlignment = Alignment.CenterStart
    ) {
            Text(
                text = titulo,
                fontFamily = Itim,
                fontSize = 22.sp,
                color = colorGeneral,
                textAlign = TextAlign.Left,
                modifier = Modifier.padding(10.dp,5.dp)
                    .background(Color.Transparent)
            )
    }
}
data class  Enfermedad(var name:String, var imageID:Int)