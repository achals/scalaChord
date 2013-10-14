package com.achals.scalaChord.Node

import com.achals.scalaChord.data.ID
import com.achals.scalaChord.Messages

import akka.actor.{Actor, Props, ActorRef}

object ChordNode{
  def props(name:String) = Props(classOf[ChordNode], name)
}

class ChordNode(name:String) extends Actor {
	
    val nodeName = name
	val FingerTable:FingerTable = FingerTable
	val joiner = context.actorOf(Joiner.props(nodeName + "joiner"))
	
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
	  actorRef ! Messages.Join
	}
	
	def stabilize:Unit = {}
	def notify(possiblePred:ChordNode): Unit = {}
	 
	def fix_fingers:Unit = {}
	def check_predecessor:Unit = {}
	
	def receive ={
	  case Messages.Join(source:ID) => {
	    println(source.key)
	  }
	  case _ => ()
	}
	
}