package de.thm.mni.backend.address

import de.thm.mni.backend.user.User
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
@Entity
@Table(name="addresses")
class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null;
    var street: String? = null;
    var houseNumber: String? = null;
    var zipCode: String? = null;
    var city: String? = null;

    @OneToOne
    @JoinColumn(name= "user_id", unique = true)
    var user: User? = null

    public  constructor(){

    }

    constructor(zipCode: String?, id: Long?, street: String?, houseNumber: String?, city: String?) {
        this.zipCode = zipCode
        this.id = id
        this.street = street
        this.houseNumber = houseNumber
        this.city = city
    }
}