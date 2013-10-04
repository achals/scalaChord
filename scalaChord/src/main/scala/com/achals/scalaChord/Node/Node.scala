package com.achals.scalaChord.Node

import com.achals.scalaChord.data.ID

abstract class Node {
	val FingerTable:FingerTable
	
	def lookup(key:String) : ID
	
	def find_successor(key:String):ID
	def find_predecessor(key:String):ID
	
	def create: Unit
	def join(bootStrap: Node): Unit
	
	def stabilize:Unit
	def notify(possiblePred:Node): Unit
	
	def fix_fingers:Unit
	def check_predecessor:Unit
	
}