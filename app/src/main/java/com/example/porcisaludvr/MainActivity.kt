package com.example.porcisaludvr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.porcisaludvr.ui.theme.Itim
import com.example.porcisaludvr.ui.theme.PorciSaludVRTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PorciSaludVRTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "main_screen") {
                    composable("main_screen") {
                        MainScreen(navController)
                    }
                    composable("info_screen") {
                        InfoScreen(navController)
                    }
                }
            }
        }
    }
}

@Composable
fun MainScreen(navController: NavHostController) {
    val listState = rememberLazyListState()
    val buttonItems = listOf(
        ButtonItem("Realidad Aumentada", R.drawable.augmented_reality_icon, "realidad_aumentada",Color(252,209,49,255)),
        ButtonItem("Enfermedades", R.drawable.pig_sick_icon, "enfermedades_cerdos",Color(211,58,84,255)),
        ButtonItem("Sobre el Cuidado", R.drawable.pig_breeding_icon, "cuidados_cerdos",Color(175,180,43,255)),
        ButtonItem("¿Esta enfermo?", R.drawable.is_sick_icon, "test_pig",Color(156,52,194,255)),
        ButtonItem("Noticias", R.drawable.news_icon, "noticias_cerdos",Color(143,201,195,255)),
        ButtonItem("Sobre  Nosotros", R.drawable.about_us_icon, "info_screen",Color(0,200,0,255))
    )
    Spacer(modifier = Modifier.height(25.dp))
    LazyColumn(
        state = listState,
        modifier = Modifier.fillMaxSize()
    ) {
        itemsIndexed(buttonItems.chunked(2)) { rowIndex, rowItems ->
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {

                for ((index, item) in rowItems.withIndex()) {
                    Button(
                        onClick = {
                            // Navega a la ruta cuando se hace clic en el botón
                            navController.navigate(item.route)
                        },
                        colors = ButtonDefaults.buttonColors(Color.Transparent),
                        modifier = Modifier
                            .width((GetScreenWidth()/ 2)-8.dp)
                            .height((GetScreenHeight()/3)-75.dp)
                            .border(
                                width = 5.dp, // Ancho del borde
                                color = item.color, // Color del borde
                                shape = RoundedCornerShape(16.dp) // Bordes redondeados
                            )
                            .background(Color.Transparent)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally

                        ) {
                            Image(
                                painter = painterResource(id = item.imageResource),
                                contentDescription = "icon", // Puedes proporcionar una descripción adecuada aquí
                                modifier = Modifier
                                    .size(100.dp)
                            )
                            Text(text = item.label,
                                fontFamily = Itim,
                                fontSize = 19.sp,
                                fontWeight = FontWeight.Bold,
                                color = item.color,
                                textAlign = TextAlign.Center)
                        }
                    }
                }
            }
            if (rowIndex < buttonItems.chunked(2).size - 1) {
                Spacer(modifier = Modifier.height(25.dp)) // Ajusta la altura según tus necesidades
            }
        }
    }
}

data class ButtonItem(val label: String, val imageResource: Int, val route: String, val color:Color)

@Preview
@Composable
fun PreviewMain(){
    val navController = rememberNavController()
    MainScreen(navController)
}

@Composable
fun GetScreenWidth(): Dp {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp

    // Si deseas obtener el ancho en píxeles, puedes usar:
    // val screenWidthPixels = screenWidth.toPx().toInt()

    return screenWidth.dp
}
@Composable
fun GetScreenHeight(): Dp {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp

    // Si deseas obtener el ancho en píxeles, puedes usar:
    // val screenWidthPixels = screenWidth.toPx().toInt()

    return screenHeight.dp
}