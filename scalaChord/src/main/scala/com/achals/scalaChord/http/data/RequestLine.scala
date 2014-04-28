package com.achals.scalaChord.http.data

case class RequestLine {
	val method : String
	val protocolVersion : ProtocolVersion
	val uri : String
}