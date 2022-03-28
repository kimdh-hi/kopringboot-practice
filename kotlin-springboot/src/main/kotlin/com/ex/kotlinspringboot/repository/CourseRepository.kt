package com.ex.kotlinspringboot.repository

import com.ex.kotlinspringboot.domain.Course
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface CourseRepository: JpaRepository<Course, Long> {
}