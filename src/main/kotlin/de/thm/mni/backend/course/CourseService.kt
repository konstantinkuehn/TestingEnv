package de.thm.mni.backend.course

import org.springframework.stereotype.Service
import java.util.*

@Service
class CourseService  (private val courseRepository: CourseRepository) {
    fun create(course: Course): Course {
        // Fehlerfälle
        //Prüfen ob Titel enthalten ist
        if(course.title == null){
            throw IllegalArgumentException("A Course requires a name");
        }
        //Prüfen ob Beschreibung enthalten ist
        if(course.description == null){
            throw IllegalArgumentException("A Course requires a description    ");
        }
        return courseRepository.save(course);  // das hier würde auch erstmla reichen
        // die fehlerfälle kann man auch im nachinein machen!
    }

    fun findByID(id :Long)  : Optional<Course> {
        return courseRepository.findById(id);
    }
}