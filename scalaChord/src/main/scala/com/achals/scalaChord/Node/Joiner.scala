package com.achals.scalaChord.Node

import akka.actor.Actor

import com.achals.scalaChord.Messages
import com.achals.scalaChord.data.ID

object Joiner {
  def apply() = {
    new Joiner()
  }
}

class Joiner extends Actor {

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