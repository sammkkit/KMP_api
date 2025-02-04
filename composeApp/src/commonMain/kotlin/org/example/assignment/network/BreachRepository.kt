package org.example.assignment.network

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.bodyAsText
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.serialization.SerializationException
import org.example.assignment.presentation.Breach
import org.example.assignment.util.NetworkError
import org.example.assignment.util.Result

class BreachRepository(private val client: HttpClient) {
    private val apiUrl = "https://haveibeenpwned.com/api/v2/breaches"

    suspend fun getBreaches(): Result<List<Breach>,NetworkError> {
        return try {
            val response = client.get(urlString = apiUrl)
            val raw = response
            println("RawJson :${raw.body<List<BreachDto>>()}")
            val dtos = response.body<List<BreachDto>>()
            val breaches = dtos.map { it.toBreach() }
            Result.Success(breaches)
        }catch (e:UnresolvedAddressException){
            return Result.Error(NetworkError.NO_INTERNET)
        }catch (e:SerializationException){
            return Result.Error(NetworkError.SERIALIZATION)
        } catch (e: Exception) {
            Result.Error(NetworkError.UNKNOWN)
        }
    }
}