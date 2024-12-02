package de.thm.mni.backend.audiobook

import de.thm.mni.backend.user.User
import jakarta.persistence.*
import java.time.Instant

@Entity
@Table(name = "book_ownership")
class BookOwnership {
  @EmbeddedId
  var id: BookOwnershipId? = null

  @ManyToOne
  @JoinColumn(name = "user_id", insertable = false, updatable = false)
  var user: User? = null

  @ManyToOne
  @JoinColumn(name = "audiobook_id", insertable = false, updatable = false)
  var audiobook: Audiobook? = null

  @Column(name = "acquisition_date")
  var acquisitionDate: Instant? = Instant.now()

  protected constructor() {}

  public constructor(user: User, audiobook: Audiobook) {
    this.user = user
    this.audiobook = audiobook
    this.id = BookOwnershipId(user.id!!, audiobook.id!!)
  }
}