package com.github.jw3.gpsd4s

import com.typesafe.config.ConfigFactory
import org.scalatest.{Matchers, WordSpec}

class ProtocolSpec extends WordSpec with Matchers {
  val config = ConfigFactory.load("models.conf")

  "deserialization" should {
    "round trip" when {
      "TPV" in {

      }
    }
  }

  "serialization" should {
    "round trip" when {
      "TPV" in {

      }
    }
  }
}
