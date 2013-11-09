package com.achals.scalaChord.Node

import scala.collection.mutable
import com.achals.scalaChord.data.{ID}
import akka.actor.ActorRef


object FingerTable {
	def apply():FingerTable = {new FingerTable()}
}

class FingerTable() {
  
	val fingerTableMap: mutable.Map[String, NodeRef] = mutable.Map.empty

	def addNode(name:String, node:ActorRef) ={
	  fingerTableMap.+=((name, NodeRef(node, node.toString)))
	}
	/*def successor: ID
	def predecessor:ID
	def number: Int*/
}