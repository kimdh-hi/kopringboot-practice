package com.collections

fun main() {

    val immutableList = listOf("a", "b", "c")
    println(immutableList)

    val mutableList = mutableListOf("a", "b", "c")
    mutableList.add("d")
    println(mutableList)

    val immutableSet = setOf("a", "a", "b", "b", "c")
    println(immutableSet)

    val immutableMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3)
    println(immutableMap)

    val mutableMap = mutableMapOf("key1" to 1)
    mutableMap["key2"] = 2
    mutableMap["key3"] = 3
    println(mutableMap)
}
