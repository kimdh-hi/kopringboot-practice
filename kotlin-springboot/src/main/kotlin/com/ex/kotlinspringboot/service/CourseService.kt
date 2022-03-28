package com.ex.kotlinspringboot.service

import com.ex.kotlinspringboot.domain.Course
import com.ex.kotlinspringboot.dto.CourseDto
import com.ex.kotlinspringboot.exception.CourseNotFoundException
import com.ex.kotlinspringboot.repository.CourseRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
@Service
class CourseService(private val courseRepository: CourseRepository) {

    @Transactional
    fun saveCourse(courseDto: CourseDto): CourseDto {
        val course = courseDto.let {
            Course(it.name, it.category)
        }

        val savedCourse = courseRepository.save(course)

        return savedCourse.let {
            CourseDto(it.id, it.name, it.category)
        }
    }

    fun findCourseList(): List<CourseDto> {
        return courseRepository.findAll().map {
            CourseDto(it.id, it.name, it.category)
        }
    }

    fun findCourse(courseId: Long): CourseDto {
        val course = courseRepository.findById(courseId)
            .orElseThrow { CourseNotFoundException("courseId not exists. courseId=$courseId") }

        return course.let {
            CourseDto(it.id, it.name, it.category)
        }
    }

    @Transactional
    fun updateCourse(courseId: Long, courseDto: CourseDto): CourseDto {
        val course = courseRepository.findById(courseId)
            .orElseThrow { CourseNotFoundException("courseId not exists. courseId=$courseId") }

        course.update(
            courseDto.name,
            courseDto.category
        )

        return course.let {
            CourseDto(it.id, it.name, it.category)
        }
    }

    @Transactional
    fun deleteCourse(courseId: Long) {

        courseRepository.findById(courseId)
            .orElseThrow { CourseNotFoundException("courseId not exists. courseId=$courseId") }

        courseRepository.deleteById(courseId)
    }
}