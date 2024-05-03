package com.challenge.postman.tareas.domain

import androidx.lifecycle.LiveData
import com.challenge.postman.tareas.data.TareaDao
import com.challenge.postman.tareas.data.entities.Tarea

class TareasRepository(
    private val dao: TareaDao
) {
    val allTareas: LiveData<List<Tarea>> = dao.getAll()

    fun insertTarea(
        titulo: String,
        descripcion: String,
        imagen: String
    ) {
        val tarea = Tarea(
            titulo = titulo,
            descripcion = descripcion,
            imagen = imagen
        )
        dao.insert(tarea)
    }

    fun updateTarea(tarea: Tarea) {
        dao.update(tarea)
    }

    fun deleteTarea(tarea: Tarea) {
        dao.delete(tarea)
    }
}