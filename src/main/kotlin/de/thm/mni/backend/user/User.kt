package de.thm.mni.backend.user

import de.thm.mni.backend.address.Address
import jakarta.persistence.*

@Entity
@Table(name = "users")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null;
    var firstName: String? = null;
    var lastName: String? = null;
    var email: String? = null;
    var password: String? = null;

    @OneToOne(
        cascade = [(CascadeType.ALL)],
        mappedBy = "user"
    )
    var address: Address? = null;
    protected  constructor(){}

    public  constructor(
        firstName:String,
        lastName:String,
        email:String,
        password:String
    ){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}