package com.uzias.virtualwallet.core.util

fun jsonFromResource(resource: String, javaClazz: Class<Any>) : String =
        javaClazz.classLoader.getResourceAsStream(resource).bufferedReader().use { it.readText() }