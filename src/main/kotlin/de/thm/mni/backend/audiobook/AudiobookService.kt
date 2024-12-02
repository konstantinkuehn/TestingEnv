package de.thm.mni.backend.audiobook

import org.springframework.stereotype.Service
import java.util.*

@Service
class AudiobookService (private val audiobookRepository: AudiobookRepository) {
    fun create(audiobook: Audiobook): Audiobook {
        return audiobookRepository.save(audiobook);
    }

    fun getAll(): Iterable<Audiobook> {
        return audiobookRepository.findAll()
    }

    fun find(id: Long): Optional<Audiobook> {
       return audiobookRepository.findById(id)
    }

    fun update(audiobook: Audiobook): Audiobook {
        return audiobookRepository.save(audiobook);
    }

    fun delete(id: Long) {
      audiobookRepository.deleteById(id)
    }

}