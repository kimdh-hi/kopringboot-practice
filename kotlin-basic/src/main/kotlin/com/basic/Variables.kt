package com.basic

fun main() {
    // immutable
    val name: String = "kim"
    println(name)
    // name = "update" // immutable => compile error

    // mutable
    var age: Int = 27
    age = 10 // mutable => ok
    println(age)

    // print formatting
    println("name=$name, name length=${name.length}, age=$age")
}