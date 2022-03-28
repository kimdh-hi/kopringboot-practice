package com.ex.kotlinspringboot.helper

import com.ex.kotlinspringboot.domain.Course

fun generateCourseList() = listOf(
    Course("kotlin & springboot course", "backend"),
    Course("jpa master", "backend"),
    Course("java master", "backend"),
    Course("react master", "frontend")
)