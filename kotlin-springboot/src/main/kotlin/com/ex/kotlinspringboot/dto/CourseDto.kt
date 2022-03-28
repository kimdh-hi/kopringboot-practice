package com.ex.kotlinspringboot.dto

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

data class CourseDto(

    var id: Long?,
//    @field:NotEmpty(message = "Name cannot be empty.")
    @field:NotBlank(message = "Name cannot be empty.")
    var name: String,
//    @field:NotEmpty(message = "Category cannot be empty")
    @field:NotBlank(message = "Category cannot be empty")
    var category: String,
)