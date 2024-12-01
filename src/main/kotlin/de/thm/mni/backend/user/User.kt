package de.thm.mni.backend.user

import de.thm.mni.backend.audiobook.Audiobook
import de.thm.mni.backend.audiobook.BookOwnership
import jakarta.persistence.*

@Entity
@Table(name = "users")
class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  var id: Long? = null

  @Column(name = "first_name", nullable = false)
  var firstName: String? = null

  @Column(name = "last_name", nullable = false)
  var lastName: String? = null

  @Column(unique = true)
  var email: String? = null

  @Embedded
  var address: Address? = null

  @OneToMany(
    cascade = [CascadeType.ALL],
    mappedBy = "user"
  )
  var audiobooks: MutableList<BookOwnership> = mutableListOf()

  // JPA requires a default constructor
  protected constructor() {}

  public constructor(firstName: String, lastName: String, email: String, address: Address) {
    this.firstName = firstName
    this.lastName = lastName
    this.email = email
    this.address = address
  }

  fun addAudiobook(audiobook: Audiobook) {
    audiobooks.add(BookOwnership(this, audiobook))
  }
}
