package de.thm.mni.backend.test

import de.thm.mni.backend.audiobook.Audiobook
import de.thm.mni.backend.audiobook.AudiobookRepository
import de.thm.mni.backend.course.Course
import de.thm.mni.backend.course.CourseRepository
import de.thm.mni.backend.user.Address
import de.thm.mni.backend.user.User
import de.thm.mni.backend.user.UserRepository
import org.springframework.stereotype.Service

@Service
class TestService(
  private val audiobookRepository: AudiobookRepository,
  private val courseRepository: CourseRepository,
  private val userRepository: UserRepository
) {

  fun initializeTestState() {
    // Create and save users
    val address1 = Address(street = "123 Main St", houseNumber = "1", zipCode = "62701", city = "Springfield")
    val address2 = Address(street = "456 Elm St", houseNumber = "2", zipCode = "62565", city = "Shelbyville")
    var user1 = User(firstName = "John", lastName = "Doe", email = "john.doe@example.com", address = address1)
    var user2 = User(firstName = "Jane", lastName = "Smith", email = "jane.smith@example.com", address = address2)

    // Reassign to get the generated ID
    user1 = userRepository.save(user1)
    user2 = userRepository.save(user2)

    // Create and save courses
    val course1 = Course(title = "Kotlin Basics", description = "Learn the basics of Kotlin.")
    val course2 = Course(title = "Spring Boot", description = "Introduction to Spring Boot.")

    course1.participants.add(user1)
    course1.participants.add(user2)
    courseRepository.save(course1)
    courseRepository.save(course2)

    // Create and save audiobooks
    var audiobook1 = Audiobook(title = "Kotlin for Beginners", description = "An introduction to Kotlin.")
    var audiobook2 = Audiobook(title = "Advanced Spring Boot", description = "Deep dive into Spring Boot.")

    // Reassign to get the generated ID
    audiobook1 = audiobookRepository.save(audiobook1)
    audiobook2 = audiobookRepository.save(audiobook2)

    // Add audiobooks to users
    user1.addAudiobook(audiobook1)
    user1.addAudiobook(audiobook2)
    user2.addAudiobook(audiobook2)

    userRepository.saveAll(listOf(user1, user2))
  }
}