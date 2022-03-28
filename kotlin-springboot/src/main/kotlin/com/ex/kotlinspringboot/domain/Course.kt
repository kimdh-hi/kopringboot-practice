package com.ex.kotlinspringboot.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "courses")
@Entity
class Course (name: String, category: String) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(nullable = false)
    var name = name
        private set

    @Column(nullable = false)
    var category = category
        private set

    fun update(name: String, category: String) {
        if (name.isNotEmpty()) this.name = name
        if (category.isNotEmpty()) this.category = category
    }
}