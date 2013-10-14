package com.achals.scalaChord

import akka.actor.{ActorRef, ActorSystem, Props}

import com.achals.scalaChord.Node.ChordNode
import com.achals.scalaChord.data.ID

/**
 * @author Achal Shah
 */
object App {
  
  def main(args : Array[String]) {
    val system = ActorSystem("testSystem")

    val actor1 = system.actorOf(ChordNode.props("actor1"))
    println (actor1.toString())
    val actor2 = system.actorOf(ChordNode.props("actor2"))
    println(actor2.toString)
    
    actor1 ! Messages.Join(ID(actor2.toString))
  }

}
