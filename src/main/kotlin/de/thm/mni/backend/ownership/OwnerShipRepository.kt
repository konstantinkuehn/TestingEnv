package de.thm.mni.backend.ownership

import de.thm.mni.backend.user.User
import org.springframework.data.repository.CrudRepository

interface OwnerShipRepository: CrudRepository<Ownership, Long> {

    fun findByUserId(userID: Long) : MutableIterable<Ownership>;  // hier steht muteblabla ownershit+p weil das unser rückgabewert ist

}