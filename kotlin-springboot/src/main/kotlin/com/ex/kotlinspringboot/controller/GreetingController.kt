package com.ex.kotlinspringboot.controller

import com.ex.kotlinspringboot.service.GreetingService
import mu.KLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/v1/greetings")
@RestController
class GreetingController(private val greetingService: GreetingService) {

    companion object: KLogging()

    @GetMapping("/{name}")
    fun greeting(@PathVariable name: String): String {
        logger.info("name: $name")
        return greetingService.greeting(name)
    }
}