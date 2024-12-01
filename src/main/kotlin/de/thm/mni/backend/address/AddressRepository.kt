package de.thm.mni.backend.address

import org.springframework.data.repository.CrudRepository

interface AddressRepository :CrudRepository<Address,Long> {
}