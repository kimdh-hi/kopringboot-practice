package com.ex.kotlinspringboot.service

import com.ex.kotlinspringboot.domain.Course
import com.ex.kotlinspringboot.dto.CourseDto
import com.ex.kotlinspringboot.repository.CourseRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
@Service
class CourseService(private val courseRepository: CourseRepository) {

    @Transactional
    fun saveCourse(courseDto: CourseDto): CourseDto {
        val course = courseDto.let {
            Course(null, it.name, it.category)
        }

        val savedCourse = courseRepository.save(course)

        return savedCourse.let {
            CourseDto(it.id, it.name, it.category)
        }
    }
}