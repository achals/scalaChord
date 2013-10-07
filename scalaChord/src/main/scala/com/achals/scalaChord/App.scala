package com.achals.scalaChord

import akka.actor.ActorRef
import com.achals.scalaChord.Node.ChordNode

/**
 * @author Achal Shah
 */
object App {
  
  def main(args : Array[String]) {
	  val actor1 = ChordNode
	  println (actor1.toString())
	  val actor2 = ChordNode
  }

}
