package com.example.porcisaludvr.VR

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
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
        Enfermedad("ppc", R.drawable.sel_vr_ppc),
        Enfermedad("sarna", R.drawable.sel_vr_sarna),
        Enfermedad("neumonia", R.drawable.sel_vr_neumonia),
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
        IconButton(onClick = {
            updateIndex(-1)
        }) {
            Icon(painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24), contentDescription ="previous" )
        }

        CircularImage(imageId = itemsList[currentIndex].imageID)

        IconButton(onClick = {
            updateIndex(1)
        }) {
            Icon(painter = painterResource(id = R.drawable.baseline_arrow_forward_ios_24), contentDescription ="next")
        }
    }
}

@Composable
fun CircularImage(
    modifier: Modifier=Modifier,
    imageId: Int
) {
    Box(modifier = modifier
        .size(140.dp)
        .clip(CircleShape)
        .border(width = 3.dp, Translucent, CircleShape)
    ){
        Image(painter = painterResource(id = imageId), contentDescription = null, modifier = Modifier.size(140.dp), contentScale = ContentScale.FillBounds)
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
        if(placeModelButton.value){
            Button(onClick = {
                modelNode.value?.anchor()
            }, modifier = Modifier.align(Alignment.Center)) {
                Text(text = "Colocar")
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
    showTitle(num = model)
}

@Composable
fun TextOverlay(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        overflow = TextOverflow.Ellipsis,
        fontSize = 19.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = Itim,
        color = Color.White,
        modifier = modifier
            .background(Color.Black)
            .padding(16.dp)
    )
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
fun showTextTitleHelper(colorGeneral: Color, titulo: String){
    Box(
        modifier = Modifier
            .padding(24.dp)
            .shadow(elevation = 4.dp, shape = RoundedCornerShape(24.dp))
            .border(
                width = 5.dp, // Ancho del borde
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
            )
            Spacer(modifier = Modifier.width(13.dp))
    }
}
data class  Enfermedad(var name:String, var imageID:Int)