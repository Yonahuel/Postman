package com.challenge.postman.common.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.challenge.postman.tareas.data.entities.Tarea
import com.challenge.postman.tareas.domain.TareasRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    application: Application,
    private val tareasRepository: TareasRepository
): AndroidViewModel(application) {
    val allTareas: LiveData<List<Tarea>> = tareasRepository.allTareas

    fun insertTarea(tarea: Tarea) = viewModelScope.launch {
        tareasRepository.insertTarea(tarea)
    }

    fun updateTarea(tarea: Tarea) = viewModelScope.launch {
        tareasRepository.updateTarea(tarea)
    }

    fun deleteTarea(tarea: Tarea) = viewModelScope.launch {
        tareasRepository.deleteTarea(tarea)
    }
}