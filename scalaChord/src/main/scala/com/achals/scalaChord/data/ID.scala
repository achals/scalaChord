package com.achals.scalaChord.data

object ID {
  def apply(key:String):ID = new ID(key)
}

class ID (input:String){

  //val intValue:Integer = input.toInt
  val key:String = input
  
  override def toString() = key

}