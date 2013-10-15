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

    val actor1 = ChordNode("actor1")
    //println (actor1.toString())
    val actor2 = ChordNode("actor2")
    //println(actor2.toString)
    
    actor1.join(actor2.joiner)
    ()
  }

}
