package com.assignment.cards.cardRules

import com.assignment.cards.actions.SuitsAndRanks

case class Four_Of_A_Kind(val combo:String) extends SuitsAndRanks(combo){

  override def selectingSuits(): String = super.selectingSuits()
  override def selectingRanks(): String = super.selectingRanks()

  val verify= {
    val gettingRanks= selectingRanks
      .map( x => (x,selectingRanks.count(_ == x)))
      .toSet
    gettingRanks.filter(_._2 == 4).size ==1
  }
}
