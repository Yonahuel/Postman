package com.challenge.postman.tareas.domain

import android.app.Application
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.runner.AndroidJUnit4
import com.challenge.postman.tareas.data.TareaDao
import com.challenge.postman.tareas.data.entities.Tarea
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

@RunWith(AndroidJUnit4ClassRunner::class)
@HiltAndroidTest
class TareasRepositoryTest {
    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var application: Application

    @Inject
    lateinit var tareaDao: TareaDao

    @Inject
    lateinit var tareasRepository: TareasRepository

    @Before
    fun setUp() {
        hiltRule.inject()
    }

    @Test
    fun testInsertTarea() {
        val tarea = Tarea(
            titulo = "Tarea test",
            descripcion = "Descripcion test",
            imagen = "Url"
        )

        runBlocking {
            tareasRepository.insertTarea(
                titulo = "Tarea 1",
                descripcion = "Descripcion test",
                imagen = "Url"
            )
            val insertedTarea = tareaDao.getTareaByTitulo("Tarea test")
            assertEquals(tarea, insertedTarea)
        }
    }
}