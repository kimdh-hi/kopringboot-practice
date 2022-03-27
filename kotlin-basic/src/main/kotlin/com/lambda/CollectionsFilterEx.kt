package com.lambda

fun main() {

    val multiplyLambda = { x: Int, y: Int ->
        print("$x * $y ... ")
        x * y
    }

    val result1 = multiplyLambda(5, 6)
    println(result1)

    //====================

    val listOf = listOf(1, 2, 3)
    listOf.map {
        print("${it+1} ")
    }
    println()

    //====================

    val calculateResult1 = calculate(10, 5, { a, b -> a + b })
    println(calculateResult1)

    // 파라미터 중 마지막이 lambda 인 경우 구현을 바깥으로 뺄 수 있다. (권장)
    val calculateResult2 = calculate(10, 5) { a, b -> a * b }
    println(calculateResult2)

}

// function 을 인자로 하는 function
fun calculate(a: Int, b: Int, op: (a: Int, b: Int) -> Int): Int {
    return op(a, b)
}