package com.example.porcisaludvr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform
import com.example.porcisaludvr.BCR.TestPig
import com.example.porcisaludvr.Busqueda.BuscarScreen
import com.example.porcisaludvr.Cuidado.SelectCuidadoScreen
import com.example.porcisaludvr.InfoEnfermedades.NeumoniaInfoScreen
import com.example.porcisaludvr.InfoEnfermedades.PPCInfoScreen
import com.example.porcisaludvr.InfoEnfermedades.SarnaInfoScreen
import com.example.porcisaludvr.InfoEnfermedades.SelectEnfermedadesInfo
import com.example.porcisaludvr.VR.EnfermedadesVRScreen
import com.example.porcisaludvr.VR.SelectEnfermedadesVR
import com.example.porcisaludvr.ui.theme.PorciSaludVRTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PorciSaludVRTheme {
                if (! Python.isStarted()) {
                    Python.start(AndroidPlatform(this));
                }

                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "main_screen") {
                    composable("main_screen") {
                        MainScreen(navController)
                    }
                    composable("select_enfermedad_vr"){
                        SelectEnfermedadesVR(navController)
                    }
                    composable("enfermedades_cerdos"){
                        SelectEnfermedadesInfo(navController)
                    }
                    composable("cuidados_cerdos"){
                        SelectCuidadoScreen(navController)
                    }
                    composable("test_pig"){
                        TestPig(navController)
                    }
                    composable("busqueda"){
                        BuscarScreen(navController)
                    }
                    composable("info_screen") {
                        InfoScreen(navController)
                    }

                    //Realidad Aumentada Screens
                    composable("VR-ppc"){
                        EnfermedadesVRScreen(navController,"ppc")
                    }
                    composable("VR-sarna"){
                        EnfermedadesVRScreen(navController,"sarna")
                    }
                    composable("VR-neumonia"){
                        EnfermedadesVRScreen(navController,"neumonia")
                    }

                    //Informacion de Enfermedades Screens
                    composable("info_enfermedad_ppc"){
                        PPCInfoScreen(navController)
                    }
                    composable("info_enfermedad_sarna"){
                        SarnaInfoScreen(navController)
                    }
                    composable("info_enfermedad_neumonia"){
                        NeumoniaInfoScreen(navController)
                    }
                }
            }
        }
    }
}