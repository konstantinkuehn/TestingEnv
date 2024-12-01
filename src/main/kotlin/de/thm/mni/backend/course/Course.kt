package de.thm.mni.backend.course

import de.thm.mni.backend.user.User
import jakarta.persistence.*

@Entity
@Table(name = "courses")
class Course (){
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id:Long?=null

    var name: String? = null
    var description: String? = null
    @ManyToMany
    @JoinTable(
        name = "pariticpants_courses",
        joinColumns = [JoinColumn(name = "course_id")],
        inverseJoinColumns = [JoinColumn(name = "user_id")]
    )
    var paticipants:MutableList<User> = mutableListOf();
    public  constructor(name:String, description:String):this(){
        this.name = name;
        this.description = description;
    }

}