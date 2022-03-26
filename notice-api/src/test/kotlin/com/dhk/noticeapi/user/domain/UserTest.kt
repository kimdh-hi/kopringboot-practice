package com.dhk.noticeapi.user.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class UserTest {

    @Test
    fun createUser() {
        val user = User(name = "kim", email = "kim@gmail.com", password = "kim1234")

        println(user)

        assertNotNull(user)
    }
}

