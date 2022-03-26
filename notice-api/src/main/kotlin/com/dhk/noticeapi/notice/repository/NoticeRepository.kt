package com.dhk.noticeapi.notice.repository

import com.dhk.noticeapi.notice.domain.Notice
import org.springframework.data.jpa.repository.JpaRepository

interface NoticeRepository: JpaRepository<Notice, Long> {

}