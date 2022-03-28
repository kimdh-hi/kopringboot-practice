package com.ex.kotlinspringboot.helper

import com.ex.kotlinspringboot.dto.CourseDto

fun generateCourseDtoList() = listOf(
    CourseDto(1L, "name1", "category1"),
    CourseDto(2L, "name2", "category1"),
    CourseDto(3L, "name3", "category2"),
    CourseDto(4L, "name4", "category2"),
    CourseDto(5L, "name5", "category3")

)
