package org.example.assignment.presentation

import kotlinx.serialization.Serializable

@Serializable
data class Breach(
    val Name: String,
    val Title: String,
    val Domain: String,
    val BreachDate: String,
    val Description: String
)

