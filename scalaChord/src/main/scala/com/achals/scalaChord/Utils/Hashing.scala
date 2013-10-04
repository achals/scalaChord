package com.achals.scalaChord.Utils

import java.security.{MessageDigest}

trait Hash {
	def hash(source:String):String
}

class ConsistentHash extends Hash {
  def hash(source:String) = {
    val md = MessageDigest.getInstance("SHA1")
    val resultBytes = md.digest(source.getBytes())
    val stringBuffer = new StringBuffer()
    for (i <- 0 until resultBytes.length) {
      stringBuffer.append( Integer.toString((resultBytes(i) & 0xFF) + 0x100, 16).substring(1) )
    }
    stringBuffer.toString()
  }
}