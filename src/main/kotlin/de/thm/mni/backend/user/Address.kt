package de.thm.mni.backend.user

import jakarta.persistence.Embeddable

@Embeddable
class Address {
  var street: String? = null
  var houseNumber: String? = null
  var zipCode: String? = null
  var city: String? = null

  constructor() {}

  constructor(street: String, houseNumber: String, zipCode: String, city: String) {
    this.street = street
    this.houseNumber = houseNumber
    this.zipCode = zipCode
    this.city = city
  }
}