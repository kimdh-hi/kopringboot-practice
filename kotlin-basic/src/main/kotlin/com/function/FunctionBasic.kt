package com.function

import java.time.LocalDate

fun main() {
    val sumTwoValue = sumTwoValue(1, 2)
    println(sumTwoValue)

    val sumTwoValueV2 = sumTwoValueV2(1, 2)
    println(sumTwoValueV2)

    val sumValues = sumValues(1, 2, 3)
    println(sumValues)

    val sumWithDefaultValue = sumWithDefaultValue(10)
    println(sumWithDefaultValue)

    printMemberInfo(name="kim", age=27)
}

fun sumTwoValue(a: Int, b: Int): Int {
    return a + b
}


fun sumTwoValueV2(a: Int, b: Int): Int = a + b

// vararg 가변인자
fun sumValues(vararg nums: Int): Int {
    var result: Int = 0
    for (num: Int in nums) {
        result +=  num
    }
    return result
}

// default value
fun sumWithDefaultValue(a: Int, b: Int=10): Int = a + b

// default value & named parameter
fun printMemberInfo(name: String, age: Int, registrationDate: LocalDate = LocalDate.now()): Unit {
    println(
        "name: $name, age: $age, registrationDate: $registrationDate"
    )
}
