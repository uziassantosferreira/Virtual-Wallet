package com.uzias.virtualwallet.core.domain

interface UseCase<T> {
    fun run(): T
}