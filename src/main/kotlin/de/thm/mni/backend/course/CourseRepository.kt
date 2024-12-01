package de.thm.mni.backend.course

import org.springframework.data.repository.CrudRepository

interface CourseRepository : CrudRepository<Course, Long>{
}