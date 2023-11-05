package com.example.porcisaludvr.GestionCerdos

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.porcisaludvr.GestionCerdos.viewmodels.CerdosViewModel
import com.example.porcisaludvr.GestionCerdos.viewmodels.MedicamentosViewModel
import com.example.porcisaludvr.GestionCerdos.views.cerdos.CerdosAgregarView
import com.example.porcisaludvr.GestionCerdos.views.cerdos.CerdosEditarView
import com.example.porcisaludvr.GestionCerdos.views.cerdos.CerdosInicioView
import com.example.porcisaludvr.GestionCerdos.views.medicamentos.MedicamentosAgregarView
import com.example.porcisaludvr.GestionCerdos.views.medicamentos.MedicamentosEditarView
import com.example.porcisaludvr.GestionCerdos.views.medicamentos.MedicamentosInicioView

@Composable
fun NavManager(viewModelCerdos: CerdosViewModel,
               viewModelMedicamentos: MedicamentosViewModel){
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
    }
}