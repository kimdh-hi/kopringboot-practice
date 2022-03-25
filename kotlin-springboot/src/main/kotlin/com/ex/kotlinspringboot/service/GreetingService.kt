package com.ex.kotlinspringboot.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class GreetingService {

    @Value("\${greeting.message}")
    lateinit var message: String

    fun greeting(name: String): String = "$message $name"

}