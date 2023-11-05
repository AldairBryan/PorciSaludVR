package com.example.porcisaludvr.GestionCerdos

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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

@Composable
fun NavManager(viewModelCerdos: CerdosViewModel,
               viewModelMedicamentos: MedicamentosViewModel,
               viewModelEspecies: EspeciesViewModel,
               viewModelDiagnosticos: DiagnosticosViewModel,
               viewModelTerapias: TerapiasViewModel){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "gestion_pig"){
        composable("gestion_pig"){
            CerdosInicioView(navController, viewModelCerdos)
        }
        composable("gestion_cerdos_agregar"){
            CerdosAgregarView(navController, viewModelCerdos)
        }
        composable("gestion_cerdos_editar/{id}/{nombre}/{peso}/{fecha_obtencion}/{especieId}", arguments = listOf(
            navArgument("id"){type= NavType.IntType},
            navArgument("nombre"){type= NavType.StringType},
            navArgument("peso"){type= NavType.FloatType},
            navArgument("fecha_obtencion"){type= NavType.StringType},
            navArgument("especieId"){type= NavType.IntType},
            )){
            CerdosEditarView(navController,
                viewModelCerdos,
                it.arguments!!.getInt("id"),
                it.arguments?.getString("nombre"),
                it.arguments?.getDouble("peso"),
                it.arguments?.getString("fecha_obtencion"),
                it.arguments?.getInt("especieId"),)
        }

        //Medicamentos
        composable("gestion_medicamentos"){
            MedicamentosInicioView(navController, viewModelMedicamentos)
        }
        composable("gestion_medicamentos_agregar"){
            MedicamentosAgregarView(navController, viewModelMedicamentos)
        }
        composable("gestion_medicamentos_editar/{id}/{medicamento}/{precio}/{descripcion}", arguments = listOf(
            navArgument("id"){type= NavType.IntType},
            navArgument("medicamento"){type= NavType.StringType},
            navArgument("precio"){type= NavType.FloatType},
            navArgument("descripcion"){type= NavType.StringType},
        )){
            MedicamentosEditarView(navController,
                viewModelMedicamentos,
                it.arguments!!.getInt("id"),
                it.arguments?.getString("medicamento"),
                it.arguments?.getDouble("precio"),
                it.arguments?.getString("descripcion"),
                )
        }

        //Especies
        composable("gestion_especies"){
            EspeciesInicioView(navController, viewModelEspecies)
        }
        composable("gestion_especies_agregar"){
            EspeciesAgregarView(navController, viewModelEspecies)
        }
        composable("gestion_especies_editar/{id}/{especie}/{informacion}", arguments = listOf(
            navArgument("id"){type= NavType.IntType},
            navArgument("especie"){type= NavType.StringType},
            navArgument("informacion"){type= NavType.StringType},
        )){
            EspeciesEditarView(navController,
                viewModelEspecies,
                it.arguments!!.getInt("id"),
                it.arguments?.getString("especie"),
                it.arguments?.getString("informacion")
            )
        }

        //Diagnosticos
        composable("gestion_diagnosticos"){
            DiagnosticosInicioView(navController, viewModelDiagnosticos)
        }
        composable("gestion_diagnosticos_agregar"){
            DiagnosticosAgregarView(navController, viewModelDiagnosticos)
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
                viewModelDiagnosticos,
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
            TerapiasInicioView(navController, viewModelTerapias)
        }
        composable("gestion_terapias_agregar"){
            TerapiasAgregarView(navController, viewModelTerapias)
        }
        composable("gestion_terapias_editar/{id}/{fecha}/{observaciones}/{diagnosticoId}", arguments = listOf(
            navArgument("id"){type= NavType.IntType},
            navArgument("fecha"){type= NavType.IntType},
            navArgument("observaciones"){type= NavType.IntType},
            navArgument("diagnosticoId"){type= NavType.StringType},
        )){
            TerapiasEditarView(navController,
                viewModelTerapias,
                it.arguments!!.getInt("id"),
                it.arguments?.getString("fecha"),
                it.arguments?.getString("observaciones"),
                it.arguments?.getInt("diagnosticoId"),
            )
        }
    }
}