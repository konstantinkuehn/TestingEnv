package de.thm.mni.backend.test

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController()
class TestController(
  private val testService: TestService,
) {

  @PostMapping("/initialize")
  fun initialize() {
    testService.initializeTestState()
  }
}