package de.thm.mni.backend.audiobook

import org.springframework.data.repository.CrudRepository

interface AudiobookRepository: CrudRepository<Audiobook, Long> {
}