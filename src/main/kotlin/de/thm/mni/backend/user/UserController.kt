package de.thm.mni.backend.user

import de.thm.mni.backend.audiobook.Audiobook
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class UserController(
    private val userService: UserService
) {
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    fun createUser(@RequestBody user: UserDTO): UserDTO {
        return userService.create(user)
    }

    @GetMapping("/users")
    fun getUsers(): Iterable<UserDTO> {
        return userService.getAll()
    }

  //  /user/:id/audiobooks
    @GetMapping("/users/{id}/audiobooks")
    fun getAudibooksForUser(@PathVariable id:Long):Iterable<Audiobook>{
        return userService.getAudiobooksForUser(id);
    }

    // /audiobook/:id/users
    @GetMapping("/audiobook/{audioBookId}/users")
    fun getUsersForAudiobook(@PathVariable audioBookId: Long):Iterable<UserDTO>{
        return userService.GetUsersThatOwnAudiobook(audioBookId);
    }

    @GetMapping("/users/{id}")
    fun getUser(@PathVariable id: Long): Optional<UserDTO> {
        return userService.find(id)
    }

    @PutMapping("/users/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody user: UserDTO): UserDTO {
        var newUser = UserDTO(id=id, firstName = user.firstName, lastName = user.lastName , email = user.email, address = user.address )
        return userService.update(newUser)
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteUser(@PathVariable id: Long) {
        userService.delete(id)
    }
}