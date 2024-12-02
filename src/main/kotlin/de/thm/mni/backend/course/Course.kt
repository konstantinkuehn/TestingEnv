package de.thm.mni.backend.course

import de.thm.mni.backend.user.User
import jakarta.persistence.*

@Entity
@Table(name = "courses")
class Course {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  var id: Long? = null
  var title: String? = null
  var description: String? = null

  @ManyToMany
  @JoinTable(
    name = "course_participants",
    joinColumns = [JoinColumn(name = "course_id")],
    inverseJoinColumns = [JoinColumn(name = "user_id")]
  )
  var participants: MutableList<User> = mutableListOf()

  protected constructor() {}

  public constructor(
    title: String,
    description: String,
  ) {
    this.title = title
    this.description = description
  }
}