package org.example.assignment.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
//import org.koin.dsl.module

fun initKoin(config: KoinAppDeclaration? = null){
    startKoin {
        config?.invoke(this)
        modules(AppModule)
    }
}