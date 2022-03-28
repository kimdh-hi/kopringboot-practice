package com.ex.kotlinspringboot.controller

import com.ex.kotlinspringboot.service.GreetingService
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@ActiveProfiles("test")
@AutoConfigureMockMvc
@WebMvcTest(GreetingController::class)
class GreetingControllerUnitTest {


    @Autowired
    lateinit var mockMvc: MockMvc

    @MockkBean
    lateinit var greetingService: GreetingService


    @Test
    fun greetingTest() {
        //given
        val name = "kim"
        every {
            greetingService.greeting(any())
        } returns "Hello test profile $name"

        //when
        val result = mockMvc.get("/v1/greetings/{name}", name) {

        }.andExpect {
            status { isOk() }
        }.andDo {
            print()
        }.andReturn()

        //then
        assertEquals("Hello test profile $name", result.response.contentAsString)
    }
}