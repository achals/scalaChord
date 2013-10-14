package com.achals.scalaChord.Node

import akka.actor.{Actor, Props}

import com.achals.scalaChord.Messages
import com.achals.scalaChord.data.ID

object Joiner {
  def props(name:String) = Props(classOf[Joiner], name)
}

class Joiner(name:String) extends Actor {

  val joinerName = name
  def receive = {
    case Messages.Join(remote) => {
      println("Sender is: " + sender.toString)
      sender ! Messages.JoinSuccess
    }
    case Messages.JoinSuccess => {
      println("Joing succeeded.")
    }
  }
  
  def join (bootStrap:ID) = {
    
  }
}