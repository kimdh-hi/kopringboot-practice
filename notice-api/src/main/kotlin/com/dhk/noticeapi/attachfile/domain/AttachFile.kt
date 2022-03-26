package com.dhk.noticeapi.attachfile.domain

import javax.persistence.*

@Table(name = "tbl_attach_files")
@Entity
class AttachFile(
    @Column(nullable = false) var originalFileName: String,

    @Column(nullable = false) var saveFilePath: String,

    @Column(name = "attach_file_id")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
)