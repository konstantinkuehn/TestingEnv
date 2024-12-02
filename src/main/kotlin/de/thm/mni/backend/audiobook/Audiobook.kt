package de.thm.mni.backend.audiobook

import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "audiobooks")
class Audiobook {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  var id: Long? = null
  var title: String? = null
  var description: String? = null

  protected constructor() {}

  public constructor(
    title: String,
    description: String,
  ) {
    this.title = title
    this.description = description
  }
}