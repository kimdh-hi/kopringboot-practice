package com.dhk.noticeapi.notice.domain

import com.dhk.noticeapi.user.domain.User
import javax.persistence.*

@Table(name = "tbl_notices")
@Entity
class Notice(
    @Column(nullable = false)
    var title: String,

    @Column(nullable = false)
    var content: String,

    @Column(columnDefinition = "integer default 0")
    var clickCount: Long = 0,

    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    val writer: User,

    @Column(name = "notice_id")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
) {

}