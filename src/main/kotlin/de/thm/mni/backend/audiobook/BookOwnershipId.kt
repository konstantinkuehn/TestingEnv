package de.thm.mni.backend.audiobook

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.io.Serializable
import java.util.Objects

@Embeddable
class BookOwnershipId: Serializable {
  @Column(name = "user_id")
  var userId: Long? = null

  @Column(name = "audiobook_id")
  var audiobookId: Long? = null

  constructor() {}

  constructor(userId: Long, audiobookId: Long) {
    this.userId = userId
    this.audiobookId = audiobookId
  }

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (other !is BookOwnershipId) return false

    if (userId != other.userId) return false
    if (audiobookId != other.audiobookId) return false

    return true
  }

  override fun hashCode(): Int {
    return Objects.hash(userId, audiobookId)
  }
}