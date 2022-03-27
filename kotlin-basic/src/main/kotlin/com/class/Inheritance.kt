package com.`class`

open class SuperMember(val name: String) {

    open fun info() {
        println("SubMember name: $name")
    }
}

class SubMember(
    name: String,
    val age: Int): SuperMember(name) {

    override fun info() {
        println("SubMember name: $name, age: $age")
    }
}

fun main() {
    val superMember = SuperMember("lee")
    superMember.info()
    val subMember = SubMember("kim", 27)
    subMember.info()
}