package de.thm.mni.backend.course

import de.thm.mni.backend.user.User
import org.springframework.stereotype.Service
import java.util.*

@Service
class CourseService(private val courseRepository: CourseRepository) {

    fun create(course: Course): Course {
        return courseRepository.save(course);
    }

    fun getAll(): Iterable<Course> {
        return courseRepository.findAll();
    }

    fun find(id: Long): Optional<Course> {
        return courseRepository.findById(id);
    }

    fun update(course: Course): Course {
        return courseRepository.save(course);
    }

    fun delete(id: Long) {
        courseRepository.deleteById(id);
    }

    fun getParticipants(courseId: Long): Iterable<User> {
        //Finde den Kurs über die gelieferte ID
        var course = find(courseId);
        // Wenn ein Kurs mit dieser ID vorhanden ist gebe die Teilnehmer zurück

        if (course.isPresent)
            return course.get().participants;
        //Falls kein Kurs vorhanden ist gebe eine leere Liste zurück
        else return emptyList();

    }

    fun getCoursesWithUser(userId: Long): Iterable<Course> {
       return getAll().filter { course -> course.participants.any{ participant -> participant.id == userId } };
    }
}