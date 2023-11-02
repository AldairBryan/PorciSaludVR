package com.example.porcisaludvr.BCR

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun TestPig (navController: NavHostController){
    var respuesta by remember {
        mutableStateOf("")
    }
    var currentQuestionIndex by remember { mutableStateOf(0) }
    val questions = listOf(
        Question("1. ¿El cerdo presenta signos de Fiebre?", listOf("Si","No")),
        Question("2. ¿El cerdo padece de Diarrea?", listOf("Si","No")),
        Question("3. ¿El cerdo presenta anorexia?", listOf("Si","No")),
        Question("4. ¿El cerdo experimenta estreñimiento?", listOf("Si","No")),
        Question("5. ¿El cerdo presenta vómitos?", listOf("Si","No")),
        Question("6. ¿El cerdo tiene dificultad para respirar (disnea)?", listOf("Si","No")),
        Question("7. ¿El cerdo presenta problemas de reproducción, como abortos, partos prematuros o malformaciones en las crías?", listOf("Si","No")),
        Question("8. ¿El cerdo muestra comezón o picor en la piel?", listOf("Si","No")),
        Question("9. ¿La piel del cerdo está roja y caliente al tacto?", listOf("Si","No")),
        Question("10. ¿La piel del cerdo se encuentra seca, áspera y agrietada?", listOf("Si","No")),
        Question("11. ¿El cerdo tiene heridas profundas en la piel?", listOf("Si","No")),
        Question("12. ¿El cerdo se frota contra superficies de manera inusual? ¿El cerdo se rasca frecuentemente en las orejas, cuello y cabeza?", listOf("Si","No")),
        Question("13. ¿El cerdo está experimentando estrés?", listOf("Si","No")),
        Question("14. ¿El cerdo presenta alopecia (ausencia de pelo) en las orejas y el cuello?", listOf("Si","No")),
        Question("15. ¿El cerdo tiene lesiones en la nariz?", listOf("Si","No")),
        Question("16. ¿El cerdo muestra signos de depresión?", listOf("Si","No")),
        Question("17. ¿El cerdo presenta escalofríos?", listOf("Si","No")),
        Question("18. ¿El cerdo camina de manera rígida?", listOf("Si","No")),
        Question("19. ¿El cerdo tiene manchas rojas en la piel?, como en el abdomen, las orejas y la parte interna", listOf("Si","No")),
        Question("20. ¿El cerdo sufre de hemorragias en la piel?", listOf("Si","No")),
        Question("21. ¿El cerdo tiene conjuntivitis con ojos rojos? (Enrojecimiento y/o secrecion en los ojos)", listOf("Si","No")),
        Question("22. ¿El cerdo ha tenido convulsiones?", listOf("Si","No")),
        Question("23. ¿El cerdo muestra ataxia, es decir, falta de coordinación y trastornos nerviosos?", listOf("Si","No")),
        Question("24. ¿El cerdo tose de manera anormal?", listOf("Si","No")),
    )

    fun onNextClicked(selectedAnswer: String) {
        respuesta += selectedAnswer+":"
        currentQuestionIndex++
    }

    fun procesarString(input: String): String {
        val javaInstace = JCollibriHelper()
        return javaInstace.analizarCaso(input)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        if (currentQuestionIndex < questions.size) {
            QuestionItem(questions[currentQuestionIndex]){ answer ->
                onNextClicked(answer)
            }
        } else {
            Log.d("INFO","respuestas: "+respuesta)
            respuesta= procesarString(respuesta)
            Text(
                text = "Puntuación Final: $respuesta",
            )
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuestionItem(question: Question, onNextClicked: (String) -> Unit) {
    var selectedAnswer by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = question.text,)

        Spacer(modifier = Modifier.height(8.dp))

        question.options.forEach { option ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
            ) {
                RadioButton(
                    selected = option == selectedAnswer,
                    onClick = {
                        selectedAnswer = option
                    }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = option)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (selectedAnswer.isNotBlank()) {
                    onNextClicked(selectedAnswer)
                    selectedAnswer = ""
                }
            },
            enabled = selectedAnswer.isNotBlank()
        ) {
            Text(text = "Siguiente")
        }
    }
}

data class Question(val text: String, val options: List<String>)