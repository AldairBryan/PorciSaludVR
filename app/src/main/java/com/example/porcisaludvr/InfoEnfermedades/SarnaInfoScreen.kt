package com.example.porcisaludvr.InfoEnfermedades

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.porcisaludvr.ExpandableCard

@Composable
fun SarnaInfoScreen(navController: NavHostController){
ExpandableCard(title = "Test", description = "asdasdd",
    colorBG = Color(211,58,84,255),
    colorText= Color.White)
}