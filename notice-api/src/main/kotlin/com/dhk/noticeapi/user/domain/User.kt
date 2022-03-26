package com.dhk.noticeapi.user.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "tbl_users")
@Entity
class User (
    @Column(nullable = false, length = 50) var name: String,
    @Column(nullable = false, length = 50, unique = true) val email: String,
    @Column(nullable = false, length = 100) var password: String,

    @Id @GeneratedValue
    @Column(name = "user_id")
    var id: Long? = null
) {

    override fun toString(): String {
        return "User(id=$id, name='$name', email='$email', password='$password')"
    }
}