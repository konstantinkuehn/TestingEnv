package de.thm.mni.backend.ownership

import de.thm.mni.backend.audiobook.Audiobook
import de.thm.mni.backend.course.Course
import de.thm.mni.backend.user.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class OwnershipController(private val ownershipService: OwnershipService)  {

    @GetMapping("/user/{id}/audiobooks")
    fun getAudioBooks(@PathVariable id: Long): MutableList<Audiobook?> {
        return ownershipService.GetAudioBooksForUserWithId(id);
    }
}