package de.thm.mni.backend.user

import de.thm.mni.backend.audiobook.Audiobook
import de.thm.mni.backend.audiobook.BookOwnership
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun create(user: UserDTO): UserDTO {
        return userRepository.save(user.CreateUser()).createDTO();
    }

    fun getAll(): List<UserDTO> {
        return userRepository.findAll().map{ user-> user.createDTO(); }
    }

    fun find(id: Long): Optional<UserDTO> {
        var user =  userRepository.findById(id);
        return user.map{ u -> u.createDTO(); }
    }

    fun update(user: UserDTO): UserDTO {
        return userRepository.save(user.CreateUser()).createDTO()
    }

    fun delete(id: Long) {
        userRepository.deleteById(id)
    }

    fun getAudiobooksForUser(id: Long): Iterable<Audiobook> {
        var user = userRepository.findById(id)

        if(user.isPresent) {
            return user.get().audiobooks.map{it.audiobook!!}.asIterable()
        }else
            return emptyList()
    }

    fun GetUsersThatOwnAudiobook(audioBookId: Long): Iterable<UserDTO> {
        return  userRepository.findAll().filter { user -> user.audiobooks.any {book -> book.audiobook?.id == audioBookId } }.map { user -> user.createDTO(); }
    }

}