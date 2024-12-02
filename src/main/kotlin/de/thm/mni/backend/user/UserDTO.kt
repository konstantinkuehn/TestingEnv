package de.thm.mni.backend.user

data class UserDTO(
    val id: Long?,
    val firstName: String,
    val lastName: String,
    val email: String,
    val address:Address
){

    fun CreateUser():User{
        return User( this.firstName, this.lastName,this.email, this.address)
    }
}