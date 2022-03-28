package com.ex.kotlinspringboot.controller

import com.ex.kotlinspringboot.domain.Course
import com.ex.kotlinspringboot.dto.CourseDto
import com.ex.kotlinspringboot.helper.generateCourseTestData
import com.ex.kotlinspringboot.repository.CourseRepository
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.*

@AutoConfigureMockMvc
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CourseControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    lateinit var objectMapper: ObjectMapper

    @Autowired
    lateinit var courseRepository: CourseRepository

    @BeforeEach
    fun setup() {
        objectMapper = ObjectMapper().registerKotlinModule()
        courseRepository.deleteAll()
        val courseList = generateCourseTestData()
        courseRepository.saveAll(courseList)
    }

    @Test
    fun saveCourseTest() {
        val courseDto = CourseDto(null, "name", "category")
        val courseDtoJson = objectMapper.writeValueAsString(courseDto)
        val uri = "/v1/courses"

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

        assertNotNull(responseContent.id)
    }

    @Test
    fun findCourseListTest() {
        val uri = "/v1/courses"

        val result = mockMvc.get(uri)
            .andExpect {
                status { isOk() }
            }.andDo {
                print()
            }.andReturn()

        val responseContents: List<Course> = objectMapper.readValue<List<Course>>(result.response.contentAsString)

        assertEquals(3, responseContents.size)
    }

    @Test
    fun updateCourseTest() {
        val uri = "/v1/courses/{courseId}"

        val updateName = "updateName"
        val updateCategory = "updateCategory"

        val originalCourse = courseRepository.save(Course("originalName", "originalCategory"))
        val originalCourseId = originalCourse.id
        val updateCourse = CourseDto(null, "updateName", "updateCategory")
        val updateCourseJson = objectMapper.writeValueAsString(updateCourse)

        val result = mockMvc.put(uri, originalCourseId) {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
            content = updateCourseJson
        }.andExpect {
            status { isOk() }
        }.andDo {
            print()
        }.andReturn()


        val responseContent = objectMapper.readValue<CourseDto>(result.response.contentAsString)

        assertNotNull(responseContent.id)
        assertEquals(originalCourseId, responseContent.id)
        assertEquals(updateName, responseContent.name)
        assertEquals(updateCategory, responseContent.category)
    }

    @Test
    fun deleteCourseTest() {
        val uri = "/v1/courses/{courseId}"

        val course = courseRepository.save(Course("deleteCourseName", "deleteCategory"))
        val deleteCourseId = course.id

        mockMvc.delete(uri, deleteCourseId)
            .andExpect {
                status { isOk() }
            }.andDo {
                print()
            }.andReturn()

        assertNull(courseRepository.findByIdOrNull(deleteCourseId))
    }
}



