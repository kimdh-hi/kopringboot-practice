package com.ex.kotlinspringboot.repository

import com.ex.kotlinspringboot.domain.Course
import org.springframework.data.jpa.repository.JpaRepository

interface CourseRepository: JpaRepository<Course, Long>, CourseQueryRepository {

}