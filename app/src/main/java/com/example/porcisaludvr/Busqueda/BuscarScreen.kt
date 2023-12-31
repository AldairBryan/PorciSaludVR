package com.example.porcisaludvr.Busqueda

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.porcisaludvr.ui.theme.Itim

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuscarScreen(navController: NavHostController) {
    var searchQuery by remember { mutableStateOf("") }
    var allSelectedTags by remember { mutableStateOf(setOf<String>()) }

    val modules = listOf(
        Module("Peste Porcina Clasica",
            setOf("Peste Porcina Clasica", "Peste","Enfermedad","Sintoma",
                "Enfermedad viral","Infectocontagiosa","Hemorragias","Transmisión directa","Transmisión vía digestiva",
                "Contacto directo","Respiratorio","Piojos del cerdo","Garrapatas","Transmisión mecánica","Moscas","Gallinas",
                "Pájaros","Resistencia del virus en el ambiente","Bebederos compartidos","Comederos compartidos","Síntomas clínicos",
                "Muerte súbita","Depresión","Inapetencia","Fiebre","Conjuntivitis","Amontonamiento de cerdos jóvenes","Sofocación",
                "Secreciones nasales","Petequias en la piel", "Estreñimiento", "Diarrea con sangre", "Vómito", "Trastornos nerviosos",
                "Ceguera", "Temblores", "Convulsiones", "Rigidez de extremidades", "Crecimiento pobre", "Aborto en cerdas preñadas",
                "Forma subaguda o crónica", "Procesos neumónicos", "Fracasos reproductivos", "Pérdidas neonatales", "Lesiones de necropsia",
                "Puntitos rojos en órganos internos", "Ganglios linfáticos afectados", "Riñones afectados",
                "Bazo normal o aumentado de tamaño", "Infartos esplénicos", "Áreas amarillentas en las amígdalas",
                "Úlceras botonosas en el intestino grueso", "Tratamiento", "Antibióticos", "Prevención y control", "Vacunación",
                "Cerdas preñadas y vacunación", "Medidas durante un brote", "Cuarentena",
                "Control de entrada y salida de personas y animales", "No vender ni comprar nuevos animales",
                "Sacrificio de animales sospechosos o recuperados", "Eliminación de animales muertos, fetos y placentas",
                "Desinfección con formol y sosa cáustica"),
            Color(0,142,141,255),"info_enfermedad_ppc"),

        Module("Sarna Sarcoptica",
            setOf("Sarna", "Sarna Sarcoptica","Enfermedad","Sintoma", "Ácaro Sarcoptes scabiei var. Suis",
                "Picazón", "Cambios en la piel", "Cerdas reproductoras", "Pérdidas económicas", "Ganancia de peso diaria",
                "Índice de conversión", "Producción de leche", "Parasitosis externas", "Ciclo biológico",
                "Reproducción del parásito", "Larvas", "Ninfas", "Adulto", "Hembra del ácaro", "Huevos",
                "Supervivencia en el ambiente", "Contagio", "Portadores asintomáticos", "Entrada del parásito a la finca",
                "Contagio por contacto directo", "Contagio por instalaciones contaminadas", "Superficie interna de las orejas",
                "Síntomas clínicos", "Prurito", "Engrosamiento de la piel", "Heridas profundas", "Rascado y frotamiento",
                "Estrés en los cerdos", "Disminución de la ganancia diaria", "Aumento del índice de conversión",
                "Disminución de la tasa de fertilidad", "Lesiones", "Diagnóstico", "Raspa de piel", "Sangre",
                "Examen microscópico", "Investigaciones serológicas", "Diferenciación de otras enfermedades de la piel",
                "Tratamiento y control", "Pulverización con Amitraz", "Rociado con Lindano, Malatión, o solución de clordano",
                "Aplicación de vertido dorsal con fosmet o foxím", "Vía subcutánea con ivermectina", "Dosificación",
                "Tratamientos de mantenimiento", "Efecto sobre parásitos adultos y larvarios", "Prevención de la enfermedad",
                "Baños o pulverizaciones periódicas", "Tratamientos antes del parto y la cubrición"),
            Color(137,73,136,255),"info_enfermedad_sarna"),

        Module("Neumonia Enzootica",
            setOf("Neumonia", "Neumonia Enzootica","Enfermedad","Sintoma","NEP", "Prevalencia", "Impacto económico",
                "Cilios de las células epiteliales", "Moco", "Gérmenes patógenos", "Virus PRRS", "Virus Aujeszky",
                "Actinomices pleuroneumoniae", "Pleuroneumonía porcina", "Salmonella spp", "Neumonía por Salmonella",
                "Morbilidad", "Mortalidad", "Síntomas generales del CRP", "Anorexia", "Fiebre", "Polidipsia",
                "Postración", "Disnea", "Estornudos", "Tos", "Secreciones nasales", "Adelgazamiento",
                "Lesiones generales del CRP", "Neumonía asociada a M. hyoneumoniae", "Rinitis atrófica",
                "Rinitis por cuerpo de inclusión", "Diagnóstico", "Análisis clínico epidemiológico", "Análisis de laboratorio",
                "Fragmento de pulmón", "Hisopos nasales", "Tratamiento", "Antibióticos de amplio espectro", "Penicilinas",
                "Amoxicilina", "Fosfomicina", "Tilocina", "Tilmicosina", "Tulatromicina", "Florfenicol", "Ceftiofol sódico",
                "Tiamulina", "Control y profilaxis", "Sistemas de crianza cerrados", "Quimioprofilaxis", "Planes de vacunación",
                "Marranas gestantes", "Anticuerpos maternos", "Estrés", "Separación de animales enfermos", "Medidas higiénicas",
                "Desinfección", "Cuarentena de la granja"),
            Color(211,58,84,255),"info_enfermedad_neumonia"),

        Module("Instalaciones",
            setOf("Instalaciones y Diseño", "Evitar transmisión de enfermedades y plagas", "Apropiada limpieza y desinfección",
                "Delimitar instalaciones", "Diferenciar por módulos según estados productivos", "Cubrir necesidades de espacio vital",
                "Protección climática", "Prevención de intoxicaciones", "Evitar contaminación ambiental",
                "Facilitar distribución de alimentos", "Ubicación", "Terreno drenado y abastecimiento de agua",
                "Orientación según clima", "Materiales de Construcción", "Paredes lavables y desinfectables", "Pisos seguros y lavables",
                "Techos con aislamiento", "Puertas amplias", "Cama para compensar pérdida de calor", "Higiene de Instalaciones",
                "Mantener paredes, pisos y drenajes limpios", "Limpieza al sacar animales", "Desinfección regular", "Control de plagas",
                "Manejo del estiércol", "Equipos", "Bebederos y comederos limpios", "Módulo de Reproducción", "Especificaciones para hembras y machos",
                "Separación de machos y hembras", "Temperatura ambiente y dimensiones recomendadas", "Módulo de Maternidad",
                "Importancia de las jaulas parideras", "Dimensiones recomendadas para jaulas", "Alternativas a las jaulas parideras",
                "Módulo de Crecimiento y Acabado", "Ventilación adecuada", "Dimensiones recomendadas por etapa",
                "Distancia de otras áreas de producción", "Uso de comederos y bebederos específicos"),
            Color(0,142,141,255),"cuidado_instalaciones"),

        Module("Manejo Est. Productivos",
            setOf("Manejo de verracos", "Calidad genética", "Adaptación y recepción", "Características del verraco",
                "Edad óptima para servicios", "Control de primeras montas", "Evitar sobreuso del verraco",
                "Manejo de hembras reproductivas", "Características de las hembras", "Peso y edad óptima para el servicio",
                "Marranas primerizas y adultas", "Manejo de la reproducción", "Detección de celo",
                "Traslado de la marrana al corral del verraco", "Manejo de hembras gestantes", "Confirmación de la gestación",
                "Cantidades de alimento en gestación", "Manejo del parto", "Preparativos antes del parto",
                "Desparasitación y limpieza de las parideras", "Manejo en el crecimiento y engorde", "Control de peso",
                "Confinamiento en porcinos de engorda", "Clasificación por edad y peso", "Temperatura en corrales", "Destete"),
            Color(255,135,74,255),"cuidado_manejo"),

        Module("Sanidad",
            setOf("Sanidad en crianza de porcinos", "Enfermedades comunes", "Zoonosis en porcinos", "Programa de vacunación",
                "Certificado de vacunación", "Uso racional de medicamentos", "Consideraciones en el uso de fármacos",
                "Desinfección de equipos", "Almacenamiento de medicamentos", "Manejo de jeringas", "Eliminación de desechos",
                "Cadena de frío para vacunas", "Programa sanitario de manejo", "Tratamientos según la edad", "Castración y descolmillado",
                "Desparasitación y baño contra sarna", "Control de peso y selección", "Programa de inmunización en PPC",
                "Vacunación en diferentes categorías", "Frecuencia de vacunación en verracos"),
            Color(94,190,124,255),"cuidado_sanidad"),

        Module("Bienestar Animal",
            setOf("Bienestar animal", "Libre de hambre y sed", "Agua fresca", "Alimentación balanceada",
                "Mantener salud y vigor", "Libre de incomodidad", "Entorno adecuado", "Zona de descanso confortable"
                , "Prevención", "Rápido diagnóstico y tratamiento",
                 "Suficiente espacio", "Compañía e interés de otros porcinos",
                 "Manejo sin maltrato", "Ausencia de agresión", "Bienestar en la crianza"),
            Color(137,73,136,255),"cuidado_bienestar"),

        Module("Suministro de Agua",
            setOf("Suministro de agua", "Funciones del agua", "Tejidos corporales", "Procesos nutritivos",
                "Secreción de leche", "Regulación de temperatura", "Indispensable para la vida", "Falta de agua",
                "Pérdida de agua corporal", "Calidad del agua", "Consumo de alimentos", "Agua fresca y limpia",
                "Tóxicos en el agua", "Fuentes contaminadas", "Cloro libre", "Variaciones en el consumo", "Sal en la ración",
                "Minerales y medicamentos", "Temperatura del agua", "Área del corral", "Número de alimentaciones", "Tipo de ración",
                "Requerimiento de agua", "Hembras en lactación", "Hembras en gestación", "Verracos", "Lechones", "Crecimiento",
                "Engorde y acabado"),
            Color(197, 182, 22,255),"cuidado_suministro_agua"),

        Module("Suministro de Alimento",
            setOf("Suministro de alimento", "Alimentación fresca", "Ración anterior", "Requerimientos nutricionales",
                "Contaminantes", "Dieta balanceada", "Desempeño animal", "Pérdidas nutricionales", "Costos en alimentación",
                "Subproductos y residuos", "Riesgo sanitario", "Crianza familiar", "Traspatio", "Suplementos alimenticios",
                "Aditivos", "Vitaminas", "Harinas procesadas", "Pasturas leguminosas", "Sementales", "Hembras gestantes",
                "Alimento de gestación", "Condición de carnes", "Hembras lactantes", "Alimento de lactancia", "Lechones en lactancia",
                "Preiniciador", "Alimento de levante", "Alimento de engorde", "Peso de mercado", "Destete"),
            Color(0, 201, 203,255),"cuidado_suministro_alimento"),

        Module("Manejo de Plagas",
            setOf("Manejo integrado de plagas", "Residuos líquidos", "Residuos sólidos", "Limpieza diaria",
                "Cloración de corrales", "Descanso entre ciclos de crianza", "Desinfección de corrales", "Desratización",
                "Frecuencia de desinsectación", "Impacto ambiental", "Insecticidas", "Rodenticidas", "Medio ambiente",
                "Control de plagas", "Manejo de residuos", "Higiene en corrales", "Desinfectantes", "Ciclo de crianza",
                "Buenas prácticas", "Salud animal", "Prevención de enfermedades", "Saneamiento ambiental", "Manejo sostenible",
                "Control de vectores", "Protección del medio ambiente", "Manejo responsable", "Desinfección periódica",
                "Control de roedores", "Buen manejo ambiental", "Medidas de saneamiento"),
            Color(159, 105, 191,255),"cuidado_plagas"),

        Module("Bienestar del Trabajador",
            setOf("Trabajador", "Bienestar del Trabajador", "Seguridad ocupacional", "Prevención de riesgos laborales",
                "Agroindustria", "Riesgos laborales en la agroindustria", "Factores físicos","Factores químicos", "Factores biológicos",
                "Factores psicosocials", "Enfermedades broncopulmonares", "Intoxicación por agroquímicos", "fertilizantespesticidas", "Radiación solar",
                "Riesgo ergonómico", "Políticas preventivas de salud", "Seguridad en el trabajo"),
            Color(211,58,84,255),"cuidado_trabajador"),

    )

    val filteredModules = modules.filter { module ->
        module.name.contains(searchQuery, ignoreCase = true) ||
                module.tags.any { it.contains(searchQuery, ignoreCase = true) }
    }

    // Filtrar tags para que no aparezcan en "Tags de Búsqueda" si ya están seleccionados
    val filteredTags = modules.flatMap { it.tags }
        .distinct()
        .filter { it.contains(searchQuery, ignoreCase = true) || searchQuery.isBlank() }
        .filterNot { it in allSelectedTags }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Barra de búsqueda
        OutlinedTextField(
            value = searchQuery,
            onValueChange = {
                searchQuery = it
                // No hay cambio en los tags seleccionados al cambiar la búsqueda
            },
            label = {
                Text(
                    text="Ingrese su busqueda",
                    fontFamily = Itim,
                    color = Color(143,201,195,255),
                    fontWeight = FontWeight.Bold,)
                    },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    tint = Color(143,201,195,255)
                    ) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            textStyle = TextStyle(
                fontFamily = Itim,
                fontWeight = FontWeight.Bold,
                color = Color(143,201,195,255)
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0,142,141,255), // Cambia Color(255, 0, 0) al color deseado cuando está enfocado
                unfocusedBorderColor = Color(0,142,141,255) // Cambia Color(0, 0, 255) al color deseado cuando no está enfocado
        )
        )

        // Texto para indicar los Tags Seleccionados
        if (allSelectedTags.isNotEmpty()) {
            Text(text="Tags Seleccionados:",
                color=Color(0,142,141,255),
                fontFamily = Itim,
                fontWeight = FontWeight.Bold)
            // Barra de tags seleccionados
            SelectedTagsBar(
                selectedTags = allSelectedTags,
                modules = modules,
                onTagRemove = { tag ->
                    allSelectedTags -= tag
                }
            )
        }

        if (searchQuery.isNotBlank() && filteredTags.isEmpty()) {
            Text("Tags de Búsqueda:",
                color=Color(0,142,141,255),
                fontFamily = Itim,
                fontWeight = FontWeight.Bold)
            Text("Sin tags coincidentes encontrados",
                color=Color(0,142,141,255),
                fontFamily = Itim,
                fontWeight = FontWeight.Bold)
        } else  {
            // Texto para indicar los Tags de Búsqueda
            if (searchQuery.isNotBlank() && filteredTags.isNotEmpty() ) {
                Text("Tags de Búsqueda:",
                    color=Color(0,142,141,255),
                    fontFamily = Itim,
                    fontWeight = FontWeight.Bold)
                // Barra de tags de búsqueda
                TagBar(
                    tags = filteredTags,
                    selectedTags = allSelectedTags,
                    modules = modules,
                    onTagClick = { tag ->
                        // Alternar la selección de tag
                        allSelectedTags = if (tag in allSelectedTags) {
                            allSelectedTags - tag
                        } else {
                            allSelectedTags + tag
                        }
                        // Limpiar la búsqueda al agregar un tag
                        searchQuery = ""
                    }
                )
            }
        }

        if(searchQuery.isEmpty() && filteredTags.isNotEmpty()){
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                Text(text = "Resultados:",
                    color=Color(0,142,141,255),
                    fontFamily = Itim,
                    fontWeight = FontWeight.Bold)
                ModuleList(modules = filteredModules, selectedTags = allSelectedTags, navController= navController)

            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SelectedTagsBar(
    modules: List<Module>,
    selectedTags: Set<String>,
    onTagRemove: (String) -> Unit
) {
    FlowRow( modifier = Modifier
            .padding(8.dp)
    ) {
        selectedTags.forEach { tag ->
            val module = modules.find { tag in it.tags }
            if (module != null) {
                TagChip(
                    tag = tag,
                    isSelected = true,
                    onTagClick = { onTagRemove(tag) },
                    color = module.color
                )
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TagBar(
    modules: List<Module>,
    tags: List<String>,
    selectedTags: Set<String>,
    onTagClick: (String) -> Unit
) {
    FlowRow (modifier = Modifier
        .padding(8.dp)
        .verticalScroll(rememberScrollState())) {
        tags.forEach { tag ->
            val module = modules.find { tag in it.tags }
            if (module != null) {
                TagChip(
                    tag = tag,
                    isSelected = tag in selectedTags,
                    onTagClick = { onTagClick(tag)},
                    color = module.color
                )
            }
        }
    }
}

@Composable
fun TagChip(
    tag: String,
    isSelected: Boolean,
    color: Color,
    onTagClick: () -> Unit
) {
    OutlinedButton(
        onClick = { onTagClick() },
        modifier = Modifier
            .padding(end = 8.dp)
            .height(32.dp),
        border = BorderStroke(2.dp,color = if (isSelected) Color.Transparent else color),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = if (isSelected) color else Color.White,
            contentColor = Color.White
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(text = tag, fontFamily = Itim,color = if (isSelected) Color.White else color)
            if (isSelected) {
                // Mostrar la "X" para eliminar el tag
                Icon(imageVector = Icons.Default.Close, contentDescription = null)
            }
        }
    }
}

@Composable
fun ModuleList(
    modules: List<Module>,
    selectedTags: Set<String>,
    navController: NavHostController
) {
    // Mostrar módulos en función de los tags seleccionados
    modules.forEach { module ->
        if (module.tags.any { it in selectedTags } || selectedTags.isEmpty()) {
            crearBoton(texto = module.name, color = module.color, route = module.route, navController = navController)
        }
    }
}
@Composable
fun crearBoton(texto: String, color: Color, route: String, navController: NavHostController){
    Button(
        onClick = {
            navController.navigate(route)
        },
        colors = ButtonDefaults.buttonColors(Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp, vertical = 8.dp)
            .shadow(elevation = 4.dp, shape = RoundedCornerShape(24.dp))
            .border(
                width = 5.dp, // Ancho del borde
                color = color, // Color del borde
                shape = RoundedCornerShape(24.dp) // Bordes redondeados
            )
            .background(Color.Transparent)
    ) {
        Text(text = texto,
            fontFamily = Itim,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = color,
            textAlign = TextAlign.Center)
    }
}

data class Module(val name: String, val tags: Set<String>, val color: Color,val route: String)