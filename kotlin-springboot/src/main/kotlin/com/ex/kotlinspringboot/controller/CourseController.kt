package com.ex.kotlinspringboot.controller

import com.ex.kotlinspringboot.dto.CourseDto
import com.ex.kotlinspringboot.service.CourseService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RequestMapping("/v1/courses")
@RestController
class CourseController(private val courseService: CourseService) {

    @PostMapping
    fun saveCourse(@Valid @RequestBody courseDto: CourseDto): ResponseEntity<CourseDto> {

        return ResponseEntity(courseService.saveCourse(courseDto), HttpStatus.CREATED)
    }

    @GetMapping
    fun findCourseList(): ResponseEntity<List<CourseDto>> {

        val courseList = courseService.findCourseList()

        return ResponseEntity.ok(courseList)
    }

    @GetMapping("/{courseId}")
    fun findCourse(@PathVariable courseId: Long): ResponseEntity<CourseDto> {
        val course = courseService.findCourse(courseId)

        return ResponseEntity.ok(course)
    }

    @PutMapping("/{courseId}")
    fun updateCourse(@PathVariable courseId: Long, @Valid @RequestBody courseDto: CourseDto): ResponseEntity<CourseDto> {
        val updateCourse = courseService.updateCourse(courseId, courseDto)

        return ResponseEntity.ok(updateCourse)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{courseId}")
    fun deleteCourse(@PathVariable courseId: Long) {
        courseService.deleteCourse(courseId)
    }
}