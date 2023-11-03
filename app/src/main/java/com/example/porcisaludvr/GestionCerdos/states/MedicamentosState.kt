package com.example.porcisaludvr.GestionCerdos.states

import com.example.porcisaludvr.GestionCerdos.models.Medicamentos

data class MedicamentosState(
    val listaMedicamentos: List<Medicamentos> = emptyList()
)
