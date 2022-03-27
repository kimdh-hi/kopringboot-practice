package com.lambda


fun main() {
    val list = listOf(listOf(1, 2, 3), listOf(4, 5, 6))

    val mapResult = list.map { outer ->
        outer.map { inner ->
            inner.toDouble()
        }
    }
    // [[1,2,3], [4,5,6]] -> [[1.0, 2.0, 3.0], [4.0, 5.0, 6.0]]
    println(mapResult)


    val flatMapResult = list.flatMap { outer ->
        outer.map { inner ->
            inner.toDouble()
        }
    }
    // [[1,2,3], [4,5,6]] -> [1.0, 2.0, 3.0, 4.0, 5.0, 6.0]
    println(flatMapResult)
}