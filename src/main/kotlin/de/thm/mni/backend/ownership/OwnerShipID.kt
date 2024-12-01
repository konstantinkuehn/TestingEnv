package de.thm.mni.backend.ownership

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.io.Serializable

@Embeddable
class OwnerShipID() : Serializable {
    @Column(name = "user_id")
    var userID: Long? = null;

    @Column(name = "audibook_id")
    var audioBookID: Long? = null;

    public constructor(userID: Long, audookID: Long):this() {
        this.userID = userID;
        this.audioBookID = audookID;
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as OwnerShipID

        if (userID != other.userID) return false
        if (audioBookID != other.audioBookID) return false

        return true
    }

    override fun hashCode(): Int {
        var result = userID?.hashCode() ?: 0
        result = 31 * result + (audioBookID?.hashCode() ?: 0)
        return result
    }

}