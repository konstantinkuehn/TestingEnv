package de.thm.mni.backend.user

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class UserController(private val userService: UserService) {  // braucht den Service, greift darauf zu
    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    fun createUser(@RequestBody user: User): User {
        return userService.create(user);
    }
    @GetMapping("/user/{id}")
    fun getUser(@PathVariable id: Long): Optional<User> {
        return  userService.findByID(id);
    }

    @GetMapping("/users")
    fun getUsers(): MutableIterable<User> {
        return userService.getUserList();

    }



}