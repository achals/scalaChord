package com.achals.scalaChord.http.data

case class ProtocolVersion {
	val PROTOCOL_SEPERATOR : String = "/"
	val VERSION_SEPERATOR = "."

	val minorVersion : Integer
	val majorVersion : Integer
	val protocol : String
	
	def toString() : String = {
	  protocol + PROTOCOL_SEPERATOR + majorVersion + VERSION_SEPERATOR + minorVersion 
	}
}