package de.thm.mni.backend.user

import de.thm.mni.backend.audiobook.Audiobook
import org.springframework.boot.autoconfigure.web.ServerProperties
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class UserController(
    private val userService: UserService,
    serverProperties: ServerProperties
) {
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    fun createUser(@RequestBody user: User): User {
        return userService.create(user)
    }

    @GetMapping("/users")
    fun getUsers(): Iterable<UserDTO> {
        return userService.getAll()
    }

    @GetMapping("/users/{id}")
    fun getUser(@PathVariable id: Long): Optional<User> {
        return userService.find(id)
    }

    @GetMapping("/users/{id}/audiobooks")
    fun getAudioBooksByUser(@PathVariable id: Long): List<Audiobook> {
        val user = userService.find(id)
        return if (user.isPresent) {
            user.get().audiobooks.mapNotNull { it.audiobook }
        } else {
            emptyList() // Leere Liste zurückgeben, wenn kein User gefunden wird
        }
    }

    @PutMapping("/users/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody user: User): User {
        user.id = id
        return userService.update(user)
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteUser(@PathVariable id: Long) {
        userService.delete(id)
    }
}