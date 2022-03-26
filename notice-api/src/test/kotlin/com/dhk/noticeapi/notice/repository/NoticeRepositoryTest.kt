package com.dhk.noticeapi.notice.repository

import com.dhk.noticeapi.notice.domain.Notice
import com.dhk.noticeapi.user.domain.User
import com.dhk.noticeapi.user.repository.UserRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class NoticeRepositoryTest {

    @Autowired
    lateinit var noticeRepository: NoticeRepository

    @Autowired
    lateinit var userRepository: UserRepository

    @Test
    fun createNoticeTest() {
        val user = User("kim", "kim@gmail.com", "kim123")
        val savedUser = userRepository.save(user)

        val notice = Notice("title", "content", writer = user)
        val savedNotice = noticeRepository.save(notice)

        assertNotNull(savedNotice)
        assertNotNull(savedNotice.id)
        assertEquals(savedUser.id, savedNotice.writer.id)
    }
}