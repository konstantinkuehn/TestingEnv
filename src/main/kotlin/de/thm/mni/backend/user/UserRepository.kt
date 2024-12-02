package de.thm.mni.backend.user

import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {
    fun findByEmail(email: String): User
    fun existsByEmail(email: String): Boolean
    fun deleteByEmail(email: String)
}