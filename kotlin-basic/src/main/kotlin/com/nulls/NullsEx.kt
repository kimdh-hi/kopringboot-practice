package com.nulls

class NullMember(
    var id: String?,
    var name: String
)

fun main() {
    val member = NullMember(null, "name")

    println("length=${member.id?.length}") // null 이라면 null을 출력 (null-safe call)
    println("length=${member.id?.length ?: 0}") // null 일 때 대체값 지정 (null-safe + elvis)
    println("length=${member.id!!}") // null 일 때 NPE 발생 (null assertion)
}
