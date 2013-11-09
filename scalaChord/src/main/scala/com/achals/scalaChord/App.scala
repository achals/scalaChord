package com.achals.scalaChord

import com.achals.scalaChord.Node.ChordNode
import com.achals.scalaChord.data.ID

/**
 * @author Achal Shah
 */
object App {
  
  def main(args : Array[String]) {
    val node1 = ChordNode("node1")
    val node2 = ChordNode("node2")
    
    node1.tell(Messages.Join(ID(node2.toString)), node1)
    ()
  }

}
