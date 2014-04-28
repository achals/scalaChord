package com.achals.scalaChord.http.data

import java.io.ByteArrayOutputStream

case class HttpRequest {
  val requestLine : RequestLine
  val headers : Headers
  val body : ByteArrayOutputStream
}