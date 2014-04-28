package com.achals.scalaChord.http.data

import scala.collection.immutable.HashMap

class Headers {
    val HEADER_SEPERATOR = ": "
	var headers = new HashMap[String, String]

	def addHeader( key : String, value : String ) = {
	  this.headers = this.headers + ((key, value));
	}

	def getHeaders() = {
	  this.headers
	}
}