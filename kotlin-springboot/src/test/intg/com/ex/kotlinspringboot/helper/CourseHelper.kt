package com.ex.kotlinspringboot.helper

import com.ex.kotlinspringboot.domain.Course

fun generateCourseList() = listOf(
    Course("course1", "category1"),
    Course("course2", "category2"),
    Course("course3", "category3")
)