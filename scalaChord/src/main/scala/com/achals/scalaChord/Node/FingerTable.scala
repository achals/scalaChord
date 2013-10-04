package com.achals.scalaChord.Node

import scala.collection.mutable
import com.achals.scalaChord.data.ID

object FingerTable {
	def apply() = {
	  //new FingerTable()
	}
}

abstract class FingerTable {
  
	val fingetTableMap: mutable.Map[String, String] = mutable.Map.empty
  
	def successor: ID
	def predecessor:ID
	def number: Int
	
	def FingerTable() = {}
}