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
        Question("Pregunta 1", listOf("Opción A", "Opción B", "Opción C")),
        Question("Pregunta 2", listOf("Opción A", "Opción B", "Opción C")),
        Question("Pregunta 3", listOf("Opción A", "Opción B", "Opción C")),
        // Agrega más preguntas aquí
    )

    fun onNextClicked(selectedAnswer: String) {
        respuesta += selectedAnswer
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
    var customAnswer by remember {
        mutableStateOf("")
    }
    var isAnswerSelected by remember { mutableStateOf(false) }

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
                        isAnswerSelected = true
                    }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = option)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = "Respuesta personalizada" == selectedAnswer,
                onClick = {
                    selectedAnswer = "Respuesta personalizada"
                    customAnswer=""
                }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Otra respuesta")

            Spacer(modifier = Modifier.width(16.dp))

            if ("Respuesta personalizada" == selectedAnswer) {
                    OutlinedTextField(
                    value = customAnswer,
                    onValueChange = {
                        customAnswer = it
                        isAnswerSelected = it.isNotBlank()
                    },
                    label = { Text("Ingresa tu respuesta") },
                    modifier = Modifier
                        .weight(1f)
                        .padding(4.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (isAnswerSelected) {
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