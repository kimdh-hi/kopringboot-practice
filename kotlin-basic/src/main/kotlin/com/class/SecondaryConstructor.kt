package com.`class`

class Item() {
    lateinit var name: String

    constructor(name: String): this() {
        this.name = name
    }
}

fun main() {
    val item = Item()
    println(item.name)
}