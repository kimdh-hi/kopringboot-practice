package com.basic

fun main() {

    val flag: Boolean = false

    // if block
    val result = if (flag) { // 마지막 리턴? 되는 값을 변수에 바로 할당 가능
        println("is true")
        flag
    } else {
        println("is false")
        flag
    }
    println(result)

    // when block
    val rank: Int = 3
    val medal = when (rank) {
        1 -> "금메달"
        2 -> "은메달"
        3 -> {
            println("3등 까비")
            "동메달"
        }
        else -> "노메달"
    }
    println("rank=$rank, medal=$medal")
}