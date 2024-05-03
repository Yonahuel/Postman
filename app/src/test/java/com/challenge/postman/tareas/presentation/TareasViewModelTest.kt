package com.challenge.postman.tareas.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.test.internal.runner.junit4.AndroidJUnit4Builder
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.challenge.postman.tareas.data.entities.Tarea
import com.challenge.postman.tareas.domain.TareasRepository
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import javax.inject.Inject

@RunWith(AndroidJUnit4ClassRunner::class)
@HiltAndroidTest
class TareasViewModelTest {
    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var tareasRepository: TareasRepository


    private lateinit var viewModel: TareasViewModel

    @Before
    fun setUp() {
        val owner = Mockito.mock(ViewModelStoreOwner::class.java)
        viewModel = ViewModelProvider(owner)[TareasViewModel::class.java]
        hiltRule.inject()
    }

    @Test
    fun testGetAllTareas() {
        val mockTareas = listOf(
            Tarea(
                1,
                "Tarea 1",
                "Descripción 1",
                false,
                "Url 1"
            ),
            Tarea(
                2,
                "Tarea 2",
                "Descripcion 2",
                true,
                "Url 2"
            )
        )
        val mockTareasLive = MutableLiveData<List<Tarea>>()
        mockTareasLive.value = mockTareas

        Mockito.`when`(tareasRepository.allTareas).thenReturn(mockTareasLive)

        val resultado = viewModel.allTareas

        assertNotNull(resultado.value)
        assertEquals(mockTareas.size, resultado.value?.size)
        assertEquals(mockTareas[0], resultado.value?.get(0))
        assertEquals(mockTareas[1], resultado.value?.get(1))
    }
}