package de.thm.mni.backend.course

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CourseRepository: CrudRepository<Course, Long> {
    fun findByTitle(title: String): Course
    fun existsByTitle(title: String): Boolean
    fun deleteByTitle(title: String)
}