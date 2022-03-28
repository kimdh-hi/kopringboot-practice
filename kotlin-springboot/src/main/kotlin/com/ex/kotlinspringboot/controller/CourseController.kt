package com.ex.kotlinspringboot.controller

import com.ex.kotlinspringboot.dto.CourseDto
import com.ex.kotlinspringboot.service.CourseService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/v1/courses")
@RestController
class CourseController(private val courseService: CourseService) {

    @PostMapping
    fun saveCourse(@RequestBody courseDto: CourseDto): ResponseEntity<CourseDto> {

        return ResponseEntity(courseService.saveCourse(courseDto), HttpStatus.CREATED)
    }

}