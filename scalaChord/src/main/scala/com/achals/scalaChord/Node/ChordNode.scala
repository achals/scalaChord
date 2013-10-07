package com.achals.scalaChord.Node

import com.achals.scalaChord.data.ID

import akka.actor.Actor

object ChordNode {
  def apply ={
    new ChordNode()
  }
}

class ChordNode extends Actor {
	
	val FingerTable:FingerTable = FingerTable
	
	val joiner = Joiner()
	
	//All temp functions - have to filled in.
	
	def lookup(key:String) :ID = {
	  new ID(key)
	}
	
	def find_successor(key:String) :ID = {
	  new ID(key)
	} 
	def find_predecessor(key:String) :ID = {
	  new ID(key)
	}
	
	def create: Unit = {}
	def join(bootStrap: ChordNode): Unit = {}
	
	def stabilize:Unit = {}
	def notify(possiblePred:ChordNode): Unit = {}
	 
	def fix_fingers:Unit = {}
	def check_predecessor:Unit = {}
	
	def receive ={
	  case _ => ()
	}
	
}