package de.thm.mni.backend.user

import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(
    private val userRepository: UserRepository
) {
    fun create(user: User): User {
        return userRepository.save(user)
    }

    fun getAll(): List<UserDTO> {
        return userRepository.findAll().map { user ->
            UserDTO(
                id = user.id,
                firstName = user.firstName ?: "",
                lastName = user.lastName ?: "",
                email = user.email ?: ""
            )
        }    }

    fun find(id: Long): Optional<User> {
        return userRepository.findById(id)
    }

    fun update(user: User): User {
        return userRepository.save(user)
    }

    fun delete(id: Long) {
        userRepository.deleteById(id)
    }

}

data class UserDTO(
    val id: Long?,
    val firstName: String,
    val lastName: String,
    val email: String
)
