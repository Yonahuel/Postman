package com.challenge.postman.tareas.domain.hilt_modules

import com.challenge.postman.tareas.data.TareaDao
import com.challenge.postman.tareas.domain.TareasRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class TareasRepositoryModule {
    @Provides
    @Singleton
    fun provideTareasRepository(dao: TareaDao): TareasRepository { return TareasRepository(dao) }
}