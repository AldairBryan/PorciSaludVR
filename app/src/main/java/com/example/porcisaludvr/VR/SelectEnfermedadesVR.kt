package com.example.porcisaludvr.VR

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.porcisaludvr.ButtonItem
import com.example.porcisaludvr.MainScreen
import com.example.porcisaludvr.R
import com.example.porcisaludvr.ui.theme.Itim

@Composable
fun SelectEnfermedadesVR(navController: NavHostController) {
    val listState = rememberLazyListState()
    val buttonItems = listOf(
        ButtonItem("Peste Porcina", R.drawable.augmented_reality_icon, "VR-1",
            Color(252,209,49,255)
        ),
        ButtonItem("Sarna Sarcoptica", R.drawable.sel_vr_sarna, "VR-2",
            Color(211,58,84,255)
        ),
        ButtonItem("Neumonía Enzoótica", R.drawable.sel_vr_neumonia, "VR-3",
            Color(175,180,43,255)
        ),
    )
    LazyColumn(
        state = listState,
        modifier = Modifier.fillMaxSize()
    ) {
        itemsIndexed(buttonItems) {index, buttonItem ->
            Spacer(modifier = Modifier.height(25.dp))
            Box(
                modifier = Modifier
                    .size(240.dp, 48.dp)
                    .shadow(elevation = 4.dp, shape = RoundedCornerShape(24.dp))
                    .background(color = Color.White)
                    .clickable(onClick = {
                        navController.navigate(buttonItem.route)
                    }),
                contentAlignment = Alignment.CenterStart
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 15.dp)
                ) {
                    Text(
                        text = buttonItem.label,
                        fontFamily = Itim,
                        fontSize = 22.sp,
                        color = buttonItem.color,
                        textAlign = TextAlign.Left
                    )
                    Spacer(modifier = Modifier.width(13.dp))
                    Image(
                        painter = painterResource(id = buttonItem.imageResource),
                        contentDescription = "Imagen de la enfermedad",
                        modifier = Modifier
                            .size(30.dp)
                    )
                }
            }
        }
    }
}

data class ButtonItem(val label: String, val imageResource: Int, val route: String, val color: Color)

@Preview
@Composable
fun PreviewMain(){
    val navController = rememberNavController()
    SelectEnfermedadesVR(navController)
}