package de.thm.mni.backend.course

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.Optional

@RestController
class CourseController (private val courseService: CourseService) {
    @PostMapping("/course")
    @ResponseStatus(HttpStatus.CREATED)
    fun createCourse(@RequestBody course: Course): Course {
        return  courseService.create(course);
    }
    @GetMapping("/course/{id}")
    fun getCourse(@PathVariable id: Long): Optional<Course> {
        return courseService.findByID(id);
    }
}