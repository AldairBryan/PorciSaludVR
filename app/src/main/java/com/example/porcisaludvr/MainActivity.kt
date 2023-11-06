package com.example.porcisaludvr

import android.content.Context
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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.room.Room
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform
import com.example.porcisaludvr.BCR.TestPig
import com.example.porcisaludvr.GestionCerdos.room.GestionDatabase
import com.example.porcisaludvr.GestionCerdos.viewmodels.CerdosViewModel
import com.example.porcisaludvr.GestionCerdos.viewmodels.DiagnosticosViewModel
import com.example.porcisaludvr.GestionCerdos.viewmodels.EspeciesViewModel
import com.example.porcisaludvr.GestionCerdos.viewmodels.MedicamentosViewModel
import com.example.porcisaludvr.GestionCerdos.viewmodels.TerapiasViewModel
import com.example.porcisaludvr.GestionCerdos.views.cerdos.CerdosAgregarView
import com.example.porcisaludvr.GestionCerdos.views.cerdos.CerdosEditarView
import com.example.porcisaludvr.GestionCerdos.views.cerdos.CerdosInicioView
import com.example.porcisaludvr.GestionCerdos.views.diagnosticos.DiagnosticosAgregarView
import com.example.porcisaludvr.GestionCerdos.views.diagnosticos.DiagnosticosEditarView
import com.example.porcisaludvr.GestionCerdos.views.diagnosticos.DiagnosticosInicioView
import com.example.porcisaludvr.GestionCerdos.views.especies.EspeciesAgregarView
import com.example.porcisaludvr.GestionCerdos.views.especies.EspeciesEditarView
import com.example.porcisaludvr.GestionCerdos.views.especies.EspeciesInicioView
import com.example.porcisaludvr.GestionCerdos.views.medicamentos.MedicamentosAgregarView
import com.example.porcisaludvr.GestionCerdos.views.medicamentos.MedicamentosEditarView
import com.example.porcisaludvr.GestionCerdos.views.medicamentos.MedicamentosInicioView
import com.example.porcisaludvr.GestionCerdos.views.terapias.TerapiasAgregarView
import com.example.porcisaludvr.GestionCerdos.views.terapias.TerapiasEditarView
import com.example.porcisaludvr.GestionCerdos.views.terapias.TerapiasInicioView
import com.example.porcisaludvr.InfoEnfermedades.NeumoniaInfoScreen
import com.example.porcisaludvr.InfoEnfermedades.PPCInfoScreen
import com.example.porcisaludvr.InfoEnfermedades.SarnaInfoScreen
import com.example.porcisaludvr.InfoEnfermedades.SelectEnfermedadesInfo
import com.example.porcisaludvr.VR.EnfermedadesVRScreen
import com.example.porcisaludvr.VR.SelectEnfermedadesVR
import com.example.porcisaludvr.ui.theme.Itim
import com.example.porcisaludvr.ui.theme.PorciSaludVRTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PorciSaludVRTheme {
                if (! Python.isStarted()) {
                    Python.start(AndroidPlatform(this));
                }
                //Inicializacion BD
                val database= Room.databaseBuilder(this, GestionDatabase::class.java, "db_gestion").build()

                val daoCerdos = database.cerdosDao()
                val daoMedicamentos = database.medicamentosDao()
                val daoEspecies = database.especiesDao()
                val daoDiagnosticos = database.diagnosticosDao()
                val daoTerapias = database.terapiasDao()

                val cerdosViewModel = CerdosViewModel(daoCerdos)
                val medicamentosViewModel = MedicamentosViewModel(daoMedicamentos)
                val especiesViewModel = EspeciesViewModel(daoEspecies)
                val diagnosticosViewModel = DiagnosticosViewModel(daoDiagnosticos)
                val terapiasViewModel = TerapiasViewModel(daoTerapias)

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

                    composable("test_pig"){
                        TestPig(navController)
                    }
                    /*composable("gestion_pig"){
                        GeneralCerdosScreen(navController)
                    }*/
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

                    ///BD
                    composable("gestion_pig"){
                        CerdosInicioView(navController, cerdosViewModel)
                    }
                    composable("gestion_cerdos_agregar"){
                        CerdosAgregarView(navController, cerdosViewModel)
                    }
                    composable("gestion_cerdos_editar/{id}/{nombre}/{peso}/{fecha_obtencion}/{especieId}", arguments = listOf(
                        navArgument("id"){type= NavType.IntType},
                        navArgument("nombre"){type= NavType.StringType},
                        navArgument("peso"){type= NavType.FloatType},
                        navArgument("fecha_obtencion"){type= NavType.StringType},
                        navArgument("especieId"){type= NavType.IntType},
                    )){
                        CerdosEditarView(navController,
                            cerdosViewModel,
                            it.arguments!!.getInt("id"),
                            it.arguments?.getString("nombre"),
                            it.arguments?.getDouble("peso"),
                            it.arguments?.getString("fecha_obtencion"),
                            it.arguments?.getInt("especieId"),)
                    }

                    //Medicamentos
                    composable("gestion_medicamentos"){
                        MedicamentosInicioView(navController, medicamentosViewModel)
                    }
                    composable("gestion_medicamentos_agregar"){
                        MedicamentosAgregarView(navController, medicamentosViewModel)
                    }
                    composable("gestion_medicamentos_editar/{id}/{medicamento}/{precio}/{descripcion}", arguments = listOf(
                        navArgument("id"){type= NavType.IntType},
                        navArgument("medicamento"){type= NavType.StringType},
                        navArgument("precio"){type= NavType.FloatType},
                        navArgument("descripcion"){type= NavType.StringType},
                    )){
                        MedicamentosEditarView(navController,
                            medicamentosViewModel,
                            it.arguments!!.getInt("id"),
                            it.arguments?.getString("medicamento"),
                            it.arguments?.getDouble("precio"),
                            it.arguments?.getString("descripcion"),
                        )
                    }

                    //Especies
                    composable("gestion_especies"){
                        EspeciesInicioView(navController, especiesViewModel)
                    }
                    composable("gestion_especies_agregar"){
                        EspeciesAgregarView(navController, especiesViewModel)
                    }
                    composable("gestion_especies_editar/{id}/{especie}/{informacion}", arguments = listOf(
                        navArgument("id"){type= NavType.IntType},
                        navArgument("especie"){type= NavType.StringType},
                        navArgument("informacion"){type= NavType.StringType},
                    )){
                        EspeciesEditarView(navController,
                            especiesViewModel,
                            it.arguments!!.getInt("id"),
                            it.arguments?.getString("especie"),
                            it.arguments?.getString("informacion")
                        )
                    }

                    //Diagnosticos
                    composable("gestion_diagnosticos"){
                        DiagnosticosInicioView(navController, diagnosticosViewModel)
                    }
                    composable("gestion_diagnosticos_agregar"){
                        DiagnosticosAgregarView(navController, diagnosticosViewModel)
                    }
                    composable("gestion_diagnosticos_editar/{id}/{cerdoId}/{estadoId}/{fecha}/{sintomas}/{observaciones}", arguments = listOf(
                        navArgument("id"){type= NavType.IntType},
                        navArgument("cerdoId"){type= NavType.IntType},
                        navArgument("estadoId"){type= NavType.IntType},
                        navArgument("fecha"){type= NavType.StringType},
                        navArgument("sintomas"){type= NavType.StringType},
                        navArgument("observaciones"){type= NavType.StringType},
                    )){
                        DiagnosticosEditarView(navController,
                            diagnosticosViewModel,
                            it.arguments!!.getInt("id"),
                            it.arguments?.getInt("cerdoId"),
                            it.arguments?.getInt("estadoId"),
                            it.arguments?.getString("fecha"),
                            it.arguments?.getString("sintomas"),
                            it.arguments?.getString("observaciones"),
                        )
                    }

                    //Terapias
                    composable("gestion_terapias"){
                        TerapiasInicioView(navController, terapiasViewModel)
                    }
                    composable("gestion_terapias_agregar"){
                        TerapiasAgregarView(navController, terapiasViewModel)
                    }
                    composable("gestion_terapias_editar/{id}/{fecha}/{observaciones}/{diagnosticoId}", arguments = listOf(
                        navArgument("id"){type= NavType.IntType},
                        navArgument("fecha"){type= NavType.IntType},
                        navArgument("observaciones"){type= NavType.IntType},
                        navArgument("diagnosticoId"){type= NavType.StringType},
                    )){
                        TerapiasEditarView(navController,
                            terapiasViewModel,
                            it.arguments!!.getInt("id"),
                            it.arguments?.getString("fecha"),
                            it.arguments?.getString("observaciones"),
                            it.arguments?.getInt("diagnosticoId"),
                        )
                    }
                }
            }
        }
    }
}