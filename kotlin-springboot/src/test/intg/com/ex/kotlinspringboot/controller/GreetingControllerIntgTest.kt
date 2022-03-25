package com.ex.kotlinspringboot.controller

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get


@ActiveProfiles("test")
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GreetingControllerIntgTest {


    @Autowired
    lateinit var mockMvc: MockMvc

    @DisplayName("GET /v1/greetings/{name}")
    @Test
    fun greetingTest() {
        val name = "kim"

        val result = mockMvc.get("/v1/greetings/{name}", name) {

        }.andExpect {
            status { isOk() }
        }.andDo {
            print()
        }.andReturn()

        assertEquals("Hello test profile $name", result.response.contentAsString)
    }
}