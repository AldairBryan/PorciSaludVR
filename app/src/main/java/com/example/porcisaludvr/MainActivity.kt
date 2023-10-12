package com.example.porcisaludvr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
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
    val buttons = listOf(
        ButtonItem("Realidad Aumentada", R.drawable.ic_launcher_foreground, "ruta_boton1"),
        ButtonItem("Enfermedades", R.drawable.ic_launcher_foreground, "ruta_boton2"),
        ButtonItem("Sobre el Cuidado", R.drawable.ic_launcher_foreground, "ruta_boton3"),
        ButtonItem("¿Esta enfermo?", R.drawable.ic_launcher_foreground, "ruta_boton4"),
        ButtonItem("Noticias", R.drawable.ic_launcher_foreground, "ruta_boton5"),
        ButtonItem("Sobre Nosotros", R.drawable.ic_launcher_foreground, "info_screen")
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

        }
        buttons.forEach { button ->
            Button(
                onClick = {
                    navController.navigate(button.route)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(imageVector = ImageVector.vectorResource(id = button.imageResource), contentDescription = null)
                    Text(text = button.label, fontFamily = Itim)
                }
            }
        }
    }
}

data class ButtonItem(val label: String, val imageResource: Int, val route: String)