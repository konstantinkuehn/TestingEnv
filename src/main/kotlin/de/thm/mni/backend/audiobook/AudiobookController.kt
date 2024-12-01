package de.thm.mni.backend.audiobook

import de.thm.mni.backend.user.User
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class AudiobookController (private val audiobookService: AudiobookService){
    @PostMapping("/audiobook")
    @ResponseStatus(HttpStatus.CREATED)
    fun createAudiobook(@RequestBody audiobook: Audiobook): Audiobook {

        return  audiobookService.create(audiobook);
    }


    @GetMapping("/audiobook")
    fun getAudiobook(@PathVariable id: Long): Optional<Audiobook> {
        return  audiobookService.findByID(id);
    }
}