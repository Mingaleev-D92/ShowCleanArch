package com.example.showcleanarch.di

import com.example.showcleanarch.data.repository.ShowRepositoryImpl
import com.example.showcleanarch.domain.repository.ShowRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * @author : Mingaleev D
 * @data : 08.10.2023
 */


@Module
@InstallIn(SingletonComponent::class)
abstract class ShowRepositoryModule {

   @Binds
   abstract fun provideShowRepositoryBinds(repository: ShowRepositoryImpl):ShowRepository
}