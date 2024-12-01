package de.thm.mni.backend.audiobook

import de.thm.mni.backend.user.User
import de.thm.mni.backend.user.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class AudiobookService (private val audiobookRepository: AudiobookRepository) {
    fun create(audiobook: Audiobook): Audiobook {
        // Fehlerfälle
        //Prüfen ob Titel enthalten ist
        if(audiobook.title == null){
            throw IllegalArgumentException("A Audiobook requires a title    ");
        }
        //Prüfen ob Beschreibung enthalten ist
        if(audiobook.description == null){
            throw IllegalArgumentException("A Audiobook requires a description    ");
        }

             return audiobookRepository.save(audiobook);  // das hier würde auch erstmla reichen
        // die fehlerfälle kann man auch im nachinein machen!
    }



    fun findByID(id :Long)  : Optional<Audiobook> {
        return audiobookRepository.findById(id);
    }

}