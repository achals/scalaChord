package com.achals.scalaChord.Node

import akka.actor.{Props, ActorSystem, ActorRef}

object ActorMaker {
  
  val system = ActorSystem()
  
  def make(props:Props): ActorRef = {
    system.actorOf(props)
  }

  def make(props:Props, name:String): ActorRef = {
    system.actorOf(props, name)
  }
  
}