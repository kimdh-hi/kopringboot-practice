package com.ex.kotlinspringboot.controller

import com.ex.kotlinspringboot.domain.Course
import com.ex.kotlinspringboot.dto.CourseDto
import com.ex.kotlinspringboot.helper.generateCourseDtoList
import com.ex.kotlinspringboot.service.CourseService
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import io.mockk.just
import io.mockk.runs
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.*

@WebMvcTest(controllers = [CourseController::class])
@AutoConfigureMockMvc
class CourseControllerUnitTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @MockkBean
    lateinit var courseService: CourseService

    lateinit var objectMapper: ObjectMapper

    @BeforeEach
    fun setup() {
        objectMapper = ObjectMapper().registerKotlinModule()
    }


    @Test
    fun saveCourseTest() {
        val uri = "/v1/courses"
        val courseDto = CourseDto(null, "name", "category")
        val courseDtoJson = objectMapper.writeValueAsString(courseDto)

        every {
            courseService.saveCourse(any())
        } returns(CourseDto(1L, "name", "category"))

        val result = mockMvc.post(uri) {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
            content = courseDtoJson
        }.andExpect {
            status { isCreated() }
        }.andDo {
            print()
        }.andReturn()

        val responseContent = objectMapper.readValue(result.response.contentAsString, CourseDto::class.java)

        Assertions.assertNotNull(responseContent.id)
    }



    @Test
    fun saveCourseTest_validation_blankBody() {
        val uri = "/v1/courses"
        val courseDto = CourseDto(null, " ", " ")
        val courseDtoJson = objectMapper.writeValueAsString(courseDto)

        courseDto.id = 1L
        every {
            courseService.saveCourse(any())
        } returns (courseDto)

        val result = mockMvc.post(uri) {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
            content = courseDtoJson
        }.andExpect {
            status { isBadRequest() }
        }.andDo {
            print()
        }.andReturn()
    }


    @Test
    fun findCoursesTest() {
        val uri = "/v1/courses"

        val courseList = generateCourseDtoList()

        every { courseService.findCourseList() }
            .returnsMany(courseList)

        val result = mockMvc.get(uri)
            .andExpect {
                status { isOk() }
            }.andDo {
                print()
            }.andReturn()

        val responseContents: List<Course> = objectMapper.readValue(result.response.contentAsString)

        Assertions.assertEquals(courseList.size, responseContents.size)
    }

    @Test
    fun updateCourseTest() {
        val uri = "/v1/courses/{courseId}"
        val originalCourseId = 1L
        val updateName = "updateName"
        val updateCategory = "updateCategory"

        val courseDtoJson = objectMapper.writeValueAsString(CourseDto(null, updateName, updateCategory))

        every {
            courseService.updateCourse(any(), any())
        }.returns(CourseDto(1L, updateName, updateCategory))

        val result = mockMvc.put(uri, originalCourseId) {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
            content = courseDtoJson
        }.andExpect {
            status { isOk() }
        }.andDo {
            print()
        }.andReturn()

        val responseContent = objectMapper.readValue<CourseDto>(result.response.contentAsString)

        Assertions.assertNotNull(responseContent.id)
        Assertions.assertEquals(originalCourseId, responseContent.id)
        Assertions.assertEquals(updateName, responseContent.name)
        Assertions.assertEquals(updateCategory, responseContent.category)
    }

    @Test
    fun deleteCourseTest() {
        val uri = "/v1/courses/{courseId}"
        val courseId = 1L

        every { courseService.deleteCourse(any()) } just runs

        mockMvc.delete(uri, courseId)
            .andExpect {
                status { isNoContent() }
            }.andDo {
                print()
            }.andReturn()


        verify(atMost = 1) { courseService.deleteCourse(any()) }
    }
}