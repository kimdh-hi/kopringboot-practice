package com.`class`

class GetterSetterMember() {
    var name: String = ""
        get() { // custom getter
            println("name field getter called...")
            return field
        }
    var age: Int = 1
        set(value) { // custom setter
            println("age field setter called...")
            if (value < 1) {
                throw IllegalArgumentException("$value is too small for Member age.")
            } else {
                field = value
            }
        }

    constructor(name: String, age: Int): this() {
        this.name = name
        this.age = age
    }
}

fun main() {
    val member = GetterSetterMember("name", 27)
    println(member.name)
    println(member.age)

    member.age = -1
}
