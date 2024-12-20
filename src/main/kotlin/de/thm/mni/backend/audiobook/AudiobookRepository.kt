package de.thm.mni.backend.audiobook

import org.springframework.data.repository.CrudRepository

interface AudiobookRepository: CrudRepository<Audiobook, Long> {
    fun findByTitle(title: String): Audiobook
    fun existsByTitle(title: String): Boolean
    fun deleteByTitle(title: String)
}