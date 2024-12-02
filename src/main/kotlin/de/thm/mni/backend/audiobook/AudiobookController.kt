package de.thm.mni.backend.audiobook

import de.thm.mni.backend.user.User
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class AudiobookController (private val audioBookService : AudiobookService) {

    //Neues Audiobook hinzufügen.
    @PostMapping("/audiobook")
    @ResponseStatus(HttpStatus.CREATED)
    fun createUser(@RequestBody audiobook: Audiobook): Audiobook {
        return audioBookService.create(audiobook)
    }

    // Alle Audiobooks erhalten
    @GetMapping("/audiobooks")
    fun getUsers(): Iterable<Audiobook> {
        return audioBookService.getAll()
    }
    // /audiobook/:id
    @GetMapping("/audiobook/{id}")
    fun getUser(@PathVariable id: Long): Optional<Audiobook> {
        return audioBookService.find(id)
    }

   // /audiobook/:id/users
    //TODO: ?

    //Updaten
    @PutMapping("/audiobook/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody audiobook: Audiobook): Audiobook {
        audiobook.id = id
        return audioBookService.update(audiobook)
    }

    //Löschen
    @DeleteMapping("/audiobook/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteUser(@PathVariable id: Long) {
        audioBookService.delete(id)
    }
}