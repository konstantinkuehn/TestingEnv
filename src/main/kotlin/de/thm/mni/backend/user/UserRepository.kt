package de.thm.mni.backend.user

import org.springframework.data.repository.CrudRepository

interface UserRepository :CrudRepository<User,Long> {  // braucht NUTZER (USER), der muss existieren

    fun findByEmail(email: String) : User;
    fun existsByEmail(email: String): Boolean;
    fun findByEmailAndPassword(email: String, password: String) : User;
    fun existsByEmailAndPassword(email: String, password: String) : Boolean;
    fun deleteByEmail(email: String);
}