package com.challenge.postman.ordenes.domain.hilt_modules

import com.challenge.postman.ordenes.domain.OrdenesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class OrdenesRepositoryModule {
    @Provides
    @Singleton
    fun provideOrdenesRepository(): OrdenesRepository { return OrdenesRepository() }
}