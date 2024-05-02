package com.challenge.postman.tareas.domain

import androidx.lifecycle.LiveData
import com.challenge.postman.tareas.data.TareaDao
import com.challenge.postman.tareas.data.entities.Tarea
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class TareasRepository(
    private val dao: TareaDao
) {
    val allTareas: LiveData<List<Tarea>> = dao.getAll()

    suspend fun insertTarea(tarea: Tarea) {
        dao.insert(tarea)
    }

    suspend fun updateTarea(tarea: Tarea) {
        dao.update(tarea)
    }

    suspend fun deleteTarea(tarea: Tarea) {
        dao.delete(tarea)
    }
}