package com.ex.kotlinspringboot.controller

import com.ex.kotlinspringboot.dto.CourseDto
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MockMvcResultMatchersDsl
import org.springframework.test.web.servlet.post

@AutoConfigureMockMvc
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CourseControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var mapper: ObjectMapper

    @Test
    fun saveCourseTest() {
        val courseDto = CourseDto(null, "name", "category")
        val courseDtoJson = mapper.writeValueAsString(courseDto)
        val url = "/v1/courses"

        val result = mockMvc.post(url) {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
            content = courseDtoJson
        }.andExpect {
            status { isCreated() }

        }.andDo {
            print()
        }.andReturn()

        val responseContent = mapper.readValue(result.response.contentAsString, CourseDto::class.java)

        assertNotNull(responseContent.id)
    }
}



