package com.ex.kotlinspringboot.repository

import com.ex.kotlinspringboot.config.JpaConfig
import com.ex.kotlinspringboot.helper.generateCourseList
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import

@Import(JpaConfig::class)
@DataJpaTest
class CourseRepositoryIntgTest {

    @Autowired
    lateinit var courseRepository: CourseRepository

    @BeforeEach
    fun setup() {
        courseRepository.deleteAll()
        val generateCourseList = generateCourseList()
        courseRepository.saveAll(generateCourseList)
    }

    @Test
    fun findCourseByNameTest() {
        val targetName = "kotlin"

        val findCourse = courseRepository.findCourseByName(targetName)

        assertNotNull(findCourse)
        assertTrue(findCourse[0].name.contains(targetName))
    }

    @Test
    fun findCourseByCategoryTest() {
        val targetCategory = "backend"

        val findCourse = courseRepository.findCourseByCategory(targetCategory)

        assertNotNull(findCourse)
        findCourse.forEach {
            assertTrue(it.category.equals(targetCategory))
        }
    }
}