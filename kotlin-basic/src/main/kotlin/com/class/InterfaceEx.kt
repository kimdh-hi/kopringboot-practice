package com.`class`

interface A {
    fun logic() {
        println("logic...")
    }
}

interface B {
    fun logic() {
        println("logic...")
    }
}

class AB: A, B {

    override fun logic() { // 구현할 메서드가 충돌
        super<A>.logic() // 특정 인터페이스의 메서드를 호출
        super<B>.logic()
    }
}

fun main() {
    val ab = AB()

    ab.logic()
}
