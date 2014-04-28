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

	def successor: NodeRef= NodeRef(null, "")
	def predecessor: NodeRef= NodeRef(null, "")
	def minDistance(seed:String) = {
	  (res: String, a:String) => {
		  val seedVal: Int = Integer.parseInt(seed, 16)
		  val resVal: Int = Integer.parseInt(res, 16)
		  val aVal: Int = Integer.parseInt(a, 16)
		  if ((seedVal - resVal).abs > (aVal - seedVal).abs)
		  	aVal
          else resVal
	  }
	}
	def closest_preceeding_finger (key: String) = {

	  fingerTableMap.keySet.reduceLeft(minDistance(key))
}