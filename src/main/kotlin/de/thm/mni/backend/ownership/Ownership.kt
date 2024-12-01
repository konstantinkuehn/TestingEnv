package de.thm.mni.backend.ownership

import de.thm.mni.backend.audiobook.Audiobook
import de.thm.mni.backend.user.User
import jakarta.persistence.*
import java.awt.print.Book
import java.time.Instant

@Entity
@Table(name="Ownership")
class Ownership(){

    @EmbeddedId
    var id:OwnerShipID? =null;
    @ManyToOne
    @JoinColumn(name="user_id", insertable = false, updatable = false)
    var user:User? = null;
    @ManyToOne
    @JoinColumn(name="book_id", insertable = false, updatable = false)
    var book: Audiobook? = null

    @Column(name="acquisitionDate")
    var acquisitionDate: Instant? = Instant.now();
    public  constructor(user: User,audiobook: Audiobook) : this() {
        this.user = user;
        this.book = audiobook;
        this.id = OwnerShipID(user.id!!,audiobook.id!!)
    }
}