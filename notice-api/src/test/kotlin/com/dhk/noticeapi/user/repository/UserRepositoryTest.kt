package com.dhk.noticeapi.user.repository

import com.dhk.noticeapi.notice.domain.Notice
import com.dhk.noticeapi.user.domain.User
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.data.repository.findByIdOrNull

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var em: TestEntityManager

    @Test
    fun createUser() {
        val user = User(name = "kim", email = "kim@gmail.com", password = "kim123")
        val savedUser = userRepository.save(user)

        assertNotNull(savedUser)
        assertEquals(1L, savedUser.id)
    }

    @Test
    fun updateUser() {
        val user = User(name = "kim", email = "kim@gmail.com", password = "kim123")
        val savedUser = userRepository.save(user)
        em.flush()
        em.clear()

        val findUser = userRepository.findByIdOrNull(savedUser.id)
        findUser.let {
            it?.name = "lee"
            it?.password = "lee123"
        }

        em.flush()
        em.clear()

        val updateUser = userRepository.findByIdOrNull(savedUser.id)

        assertEquals("lee", updateUser?.name)
        assertEquals("lee123", updateUser?.password)
    }
}