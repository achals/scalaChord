package com.achals.scalaChord.Node

import com.achals.scalaChord.data.ID
import com.achals.scalaChord.{ChordActorSystem, Messages}

import akka.actor.{Actor, Props, ActorRef}

object ChordNode{
  
  def apply(name:String) = {
    new ChordNode(name)
  }
  
  def props(name:String) = Props(classOf[ChordNode], name)
}

class ChordNode(name:String) {
	
    val nodeName = name
	val FingerTable:FingerTable = FingerTable
	val joiner = ChordActorSystem.getActor(Joiner.props(nodeName + "joiner"))
	
	val actorRef = joiner.toString
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
	def join(bootStrap: ChordNode): Unit = {
	}
	def join(actorRef: ActorRef): Unit = {
	  actorRef ! Messages.Join(ID(this.actorRef))
	}
	
	def stabilize:Unit = {}
	def notify(possiblePred:ChordNode): Unit = {}
	 
	def fix_fingers:Unit = {}
	def check_predecessor:Unit = {}
	
}