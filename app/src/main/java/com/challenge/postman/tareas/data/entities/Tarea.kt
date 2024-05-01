package com.challenge.postman.tareas.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Tarea(
    @PrimaryKey
    var id: Int = 0,
    @ColumnInfo
    var titulo: String?,
    @ColumnInfo
    var descripcion: String?,
    @ColumnInfo
    var completado: Boolean = false
)