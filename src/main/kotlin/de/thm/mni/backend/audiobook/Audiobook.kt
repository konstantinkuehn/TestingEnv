package de.thm.mni.backend.audiobook

import jakarta.persistence.*

@Entity
@Table(name = "audiobooks")
class Audiobook (){
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null;
    var title: String? = null;
    var description: String? = null;

    public  constructor(title: String, description: String):this(){
        this.title = title;
        this.description = description;
    }

}