package com.ex.kotlinspringboot.repository

import com.ex.kotlinspringboot.domain.Course

interface CourseQueryRepository {

    fun findCourseByName(name: String): List<Course>

    fun findCourseByCategory(category: String): List<Course>
}