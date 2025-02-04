package org.example.assignment

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform