package com.achals.scalaChord

import akka.actor.{ActorSystem, Props, ActorRef}

object ChordActorSystem {
	val actorSystem = ActorSystem("ChordActorSystem")
	
	def getActor(props:Props):ActorRef = {
		this.actorSystem.actorOf(props)
	}
}