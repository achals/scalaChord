package com.achals.scalaChord.Node

import com.achals.scalaChord.data.{ID}
import com.achals.scalaChord.{ChordActorSystem, Messages}
import akka.actor.{Actor, Props, ActorRef}
import com.achals.scalaChord.Utils.{ConsistentHash, Hash}

object ChordNode{
  
  def apply(name:String) = {
    ActorMaker.make(props(name))
  }
  
  def props(name:String) = Props(classOf[ChordNode], name)
}

class ChordNode(name:String) extends Actor {
	
    //Initialize finger tables and names.
    val nodeName = name
	val fingerTable:FingerTable = FingerTable()
	val selfRef = NodeRef(self, new ConsistentHash().hash(self.path.toString()))
	
	//All temp functions - have to filled in.
	def lookup(key:String) :ID = {
	  new ID(key)
    }
    
	def find_successor(key:String) : NodeRef = {
	  NodeRef(null, null)
	} 
	def find_predecessor(key:String) :ID = {

	  val nodeRef = fingerTable.closest_preceeding_finger(key)
	  
	  new ID(fingerTable.predecessor.nodeId)
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
	  bootStrap.nodeRef ! Messages.Join
	}
	def join(actorRef: ActorRef): Unit = {
	  actorRef ! Messages.Join(ID(this.toString()))
	}
	
	def stabilize:Unit = {}
	def notify(possiblePred:NodeRef): Unit = {}
	 
	def fix_fingers:Unit = {}
	def check_predecessor:Unit = {}
	
}