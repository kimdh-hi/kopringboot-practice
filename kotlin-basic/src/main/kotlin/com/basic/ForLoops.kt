package com.basic

fun main() {

    // for loop range
    for (i in 1..10) {
        print("$i ")
    }
    println()

    // step
    for (i in 1..10 step 2) {
        print("$i ")
    }
    println()

    // downTo
    for (i in 10 downTo 1 step 2) {
        print("$i ")
    }
    println()

    // list for loop
    val list = mutableListOf<Int>(1, 2, 3, 4, 5)
    for (item: Int in list) {
        print("$item ")
    }
    println()

    // list index for loop
    for (i in list.indices)  {
        print("${list[i]} ")
    }
    println()

    // list index, value for loop
    for ((idx, value) in list.withIndex()) {
        println("index=$idx, value=$value")
    }

}