package com.achals.scalaChord.Node

import com.achals.scalaChord.data.{ID}

abstract class Node {

	def lookup(key:String) :ID

	def find_successor(key:String) :ID

	def find_predecessor(key:String) :ID

	def create: Unit

	def join(bootStrap: NodeRef): Unit

	def stabilize:Unit
	def notify(possiblePred:NodeRef): Unit
	 
	def fix_fingers:Unit
	def check_predecessor:Unit

}