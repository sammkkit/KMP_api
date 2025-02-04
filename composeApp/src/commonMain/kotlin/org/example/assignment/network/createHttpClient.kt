package org.example.assignment.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


expect fun getHttpClientEngine(): HttpClientEngine

fun createHttpClient(engine: HttpClientEngine):HttpClient{
    return HttpClient(engine){
        install(ContentNegotiation){
            json(
                json = Json {
                    ignoreUnknownKeys=true
                }
            )
        }
    }
}