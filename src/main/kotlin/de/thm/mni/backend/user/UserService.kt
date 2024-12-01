package de.thm.mni.backend.user

import de.thm.mni.backend.audiobook.Audiobook
import de.thm.mni.backend.audiobook.AudiobookRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService (private val userRepository: UserRepository){  // greift aufs repository zu

    fun create(user: User): User{
        if(user.email == null){
            throw IllegalArgumentException("User email cannot be null or blank");
        }
        if(userRepository.existsByEmail(user.email!!)){
            throw IllegalArgumentException("User with email ${user.email} already exists");
        }

        return userRepository.save(user);
    }

    fun findByID(id :Long)  : Optional<User> {
        return userRepository.findById(id);
    }

    fun getAudioBooksForUserWithId(id :Long):MutableIterable<Audiobook>{
       // return audiobookRepository.findAll()
        TODO();
    }

    fun getUserList() : MutableIterable<User> {  // veränderbare Liste, also iterieren = sie abzählen und mutable = wir können die liste durchgehen und währenddessen kann man was löschen daraus
        // wenn da nur Liste stehen würde, dann würde man zum bsp nur die liste durchgehen können aber nichts löschen (?)
        // User (als typ) hat die eigenschaften email, vorname, etc.
        // integer ist ein prmitiver datentyp, der ist einfach allgemein zu beschreiben
        // User ist kein primitiver typ weil man nie alle user für jeden programmierr vorbestimmen kann !
        // Optional, in den klammern kann was drinnen sein oder aber auch nicht, aber bsp steht da user drinnen stehen)
        // generischer typ = für alle fälle gleich
        return userRepository.findAll();
        // muss nocht mehr ins repository geschrieben werden, weil das schon im CRUD repository vom programm ist!
        // wenn da roter fehler dann bitte ins repository schreiben und dort erst definieren!
    }


}