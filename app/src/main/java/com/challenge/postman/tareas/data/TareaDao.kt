package com.challenge.postman.tareas.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.challenge.postman.tareas.data.entities.Tarea

@Dao
interface TareaDao {
    @Query("SELECT * FROM Tarea")
    fun getAll(): LiveData<List<Tarea>>
    @Query("SELECT * FROM Tarea WHERE titulo = :tituloTarea")
    fun getTareaByTitulo(tituloTarea: String): Tarea
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(tarea: Tarea)
    @Update
    fun update(tarea: Tarea)
    @Delete
    fun delete(tarea: Tarea)
}