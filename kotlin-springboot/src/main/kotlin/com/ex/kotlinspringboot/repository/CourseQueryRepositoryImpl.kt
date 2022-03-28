package com.ex.kotlinspringboot.repository

import com.ex.kotlinspringboot.domain.Course
import com.ex.kotlinspringboot.domain.QCourse.*
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class CourseQueryRepositoryImpl(private val query: JPAQueryFactory): CourseQueryRepository {

    override fun findCourseByName(name: String): List<Course> {

        return query.selectFrom(course)
            .where(course.name.contains(name))
            .fetch()
    }

    override fun findCourseByCategory(category: String): List<Course> {

        return query.selectFrom(course)
            .where(course.category.eq(category))
            .fetch()
    }
}