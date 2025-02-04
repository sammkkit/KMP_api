package org.example.assignment.di

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.HttpClientEngine
import org.example.assignment.network.BreachRepository
import org.example.assignment.network.createHttpClient
import org.example.assignment.network.getHttpClientEngine
import org.example.assignment.presentation.BreachViewModel
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val AppModule = module {
    single <HttpClientEngine>{ getHttpClientEngine()  }
    single<HttpClient> { createHttpClient(get()) }
    single {
        BreachRepository(get())
    }
    single {
        BreachViewModel(get())
    }
}