package com.dhk.noticeapi.attachfile.repository

import com.dhk.noticeapi.attachfile.domain.AttachFile
import org.springframework.data.jpa.repository.JpaRepository

interface AttachFileRepository: JpaRepository<AttachFile, Long> {
}