package com.example.porcisaludvr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
        ButtonItem("Realidad Aumentada", R.drawable.augmented_reality_icon, "realidad_aumentada"),
        ButtonItem("Enfermedades", R.drawable.pig_sick_icon, "enfermedades_cerdos"),
        ButtonItem("Sobre el Cuidado", R.drawable.pig_breeding_icon, "cuidados_cerdos"),
        ButtonItem("¿Esta enfermo?", R.drawable.is_sick_icon, "test_pig"),
        ButtonItem("Noticias", R.drawable.news_icon, "noticias_cerdos"),
        ButtonItem("Sobre  Nosotros", R.drawable.about_us_icon, "info_screen")
    )

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
                        modifier = Modifier
                            .width(GetScreenWidth() / 2)
                            .height(GetScreenHeight()/3)
                            .background(Color.Transparent)
                            .padding(8.dp)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = item.imageResource),
                                contentDescription = null, // Puedes proporcionar una descripción adecuada aquí
                                modifier = Modifier
                                    .size(100.dp)
                                    .padding(4.dp)
                            )
                            Text(text = item.label,
                                fontFamily = Itim,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(211,58,84,255),
                                textAlign = TextAlign.Center)
                        }
                    }
                }
            }
        }
    }
}

data class ButtonItem(val label: String, val imageResource: Int, val route: String)

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