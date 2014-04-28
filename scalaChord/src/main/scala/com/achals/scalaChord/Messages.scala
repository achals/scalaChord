package com.achals.scalaChord

import com.achals.scalaChord.Node.FingerTable
import com.achals.scalaChord.data.ID

object Messages {
  case class Join(self:ID)
  case class JoinSuccess
  case class Update(fingerTable: FingerTable)
}