package com.achals.scalaChord.Node

import com.achals.scalaChord.data.{ID}
import com.achals.scalaChord.{ChordActorSystem, Messages}
import akka.actor.{Actor, Props, ActorRef}

object ChordNode{
  
  def apply(name:String) = {
    ActorMaker.make(props(name))
  }
  
  def props(name:String) = Props(classOf[ChordNode], name)
}

class ChordNode(name:String) extends Node with Actor {
	
    val nodeName = name
	val fingerTable:FingerTable = FingerTable()

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
	
	def receive ={
	    case Messages.Join(remote) => {
	      println("Remote is: " + remote)
	      println("Sender is: " + sender.toString)
	      fingerTable.addNode(remote.key.toString(), sender)
	      sender ! Messages.JoinSuccess
	    }
	    case Messages.JoinSuccess => {
	      println("Joining succeeded.")
	    }
    }
	
	def create: Unit = {}
	def join(bootStrap: NodeRef): Unit = {
	}
	def join(actorRef: ActorRef): Unit = {
	  actorRef ! Messages.Join(ID(this.toString()))
	}
	
	def stabilize:Unit = {}
	def notify(possiblePred:NodeRef): Unit = {}
	 
	def fix_fingers:Unit = {}
	def check_predecessor:Unit = {}
	
}