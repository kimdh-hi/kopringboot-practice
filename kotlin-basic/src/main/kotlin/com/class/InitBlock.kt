package com.`class`

class InitBlockMember(
    var name: String,
    var age: Int
) {

    init {
        println("member init... with name=$name, age=$age")
    }

    fun printInfo() {
        println("name: $name, age: $age")
    }
}

fun main() {
    val initBlockMember = InitBlockMember("name", 27)
    initBlockMember.printInfo()
}

