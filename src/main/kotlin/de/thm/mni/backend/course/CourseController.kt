package de.thm.mni.backend.course

import de.thm.mni.backend.user.User
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class CourseController(private val courseService: CourseService) {

    // Kurs erstellen
    @PostMapping("/course")
    @ResponseStatus(HttpStatus.CREATED)
    fun createUser(@RequestBody course: Course): Course {
        return courseService.create(course)
    }


    //courses liefere alle Kurse zurück
    @GetMapping("/courses")
    fun getUsers(): Iterable<Course> {
        return courseService.getAll()
    }
    //course/:id liefert einen Kurs mit ID zurück
    @GetMapping("/course/{id}")
    fun getUser(@PathVariable id: Long): Optional<Course> {
        return courseService.find(id)
    }
    //course/:id/users
    @GetMapping("/courses/{courseId}/users")
    fun getUsers(@PathVariable courseId: Long): Iterable<User> {
        return  courseService.getParticipants(courseId);
    }
    //  /user/:id/courses/
    @GetMapping("/user/{userId}/courses")
    fun getAllCoursesForUser(@PathVariable userId: Long): Iterable<Course> {
        return courseService.getCoursesWithUser(userId);
    }

    // Kurs überarbeiten
    @PutMapping("/course/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody course: Course): Course {
        course.id = id
        return courseService.update(course)
    }


    // Kurs löschen
    @DeleteMapping("/course/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteUser(@PathVariable id: Long) {
        courseService.delete(id)
    }

}