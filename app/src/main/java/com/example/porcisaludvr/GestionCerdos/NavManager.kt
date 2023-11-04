package com.example.porcisaludvr.GestionCerdos

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.porcisaludvr.GestionCerdos.viewmodels.CerdosViewModel
import com.example.porcisaludvr.GestionCerdos.views.cerdos.CerdosInicioView

@Composable
fun NavManager(viewModel: CerdosViewModel){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "gestion_pig"){
        composable("gestion_pig"){
            CerdosInicioView(navController, viewModel)
        }
        composable("gestion_cerdos_agregar"){
            CerdosAgregarView(navController, viewModel)
        }
        composable("gestion_cerdos_editar/{id}/{nombre}/{peso}/{fecha_obtencion}/{especieId}", arguments = listOf(
            navArgument("id"){type= NavType.IntType},
            navArgument("nombre"){type= NavType.StringType},
            navArgument("peso"){type= NavType.FloatType},
            navArgument("fecha_obtencion"){type= NavType.StringType},
            navArgument("especieId"){type= NavType.IntType},
            )){
            CerdosEditarView(navController,
                viewModel,
                it.arguments!!.getInt("id"),
                it.arguments?.getString("nombre"),
                it.arguments?.getDouble("peso"),
                it.arguments?.getString("fecha_obtencion"),
                it.arguments?.getInt("especieId"),)
        }
    }
}