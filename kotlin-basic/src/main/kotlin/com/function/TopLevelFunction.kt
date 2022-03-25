package com.function


fun generateRandomValue(from: Int=0, to: Int=100): Int = (from .. to).random()

fun generateSmallRandomValue(): Int = (0 .. 50).random()

fun generateBigRandomValue(): Int = (51 .. 100).random()

fun main() {
    val random = generateRandomValue()
    println(random)

    val generateRandomValue = generateRandomValue(generateSmallRandomValue(), generateBigRandomValue())
    println(generateRandomValue)
}