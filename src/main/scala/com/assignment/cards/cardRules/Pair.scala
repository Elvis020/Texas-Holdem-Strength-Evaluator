package com.assignment.cards.cardRules

import com.assignment.cards.actions.SuitsAndRanks

case class Pair(val combo:String) extends SuitsAndRanks(combo){

  override def selectingSuits(): String = super.selectingSuits()
  override def selectingRanks(): String = super.selectingRanks()

  val verify: Boolean = {
    val gettingRanks = selectingRanks()
      .map( x => (x,selectingRanks().count(_ == x)))
      .toSet
    if(gettingRanks.count(_._2 == 2) == 1  & !(gettingRanks.count(_._2 == 3) == 1)) true else false
  }
}
