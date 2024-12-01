package de.thm.mni.backend.ownership

import de.thm.mni.backend.audiobook.Audiobook
import de.thm.mni.backend.audiobook.AudiobookRepository
import org.springframework.stereotype.Service

@Service
class OwnershipService(private val ownershipRepository: OwnerShipRepository) {

    fun GetAudioBooksForUserWithId(id: Long): MutableList<Audiobook?> {

        var ownerships :MutableIterable<Ownership> = ownershipRepository.findByUserId(id); //alle ownerships vom user

        /*
           return  audiobookRepository.findAllById(ownerships.map())

ownership is from type Ownership but I want a MutableIteratable of Long!
         */
        val audiobooks= ownerships.map { it.book }.toMutableList();
        return audiobooks;
    }
}