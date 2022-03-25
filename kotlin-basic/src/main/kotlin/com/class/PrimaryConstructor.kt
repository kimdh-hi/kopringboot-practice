package com.`class`

class Member(
    private val id: Long,
    var name: String,
    private val email: String,
    private val age: Int
) {

    fun printInfo(): Unit {
        println("id=$id, name=$name, email=$email, age=$age")
    }
}

fun main() {
    val member = Member(1, "kim", "kim@gmail.com", 27)
    member.printInfo()

    println("member.name=${member.name}")

    member.name = "lee"
    member.printInfo()

}

