package com.assignment.cards.cardRules

import com.assignment.cards.actions.SuitsAndRanks

case class Two_Pair(val combo:String) extends SuitsAndRanks(combo){

  override def selectingSuits(): String = super.selectingSuits()
  override def selectingRanks(): String = super.selectingRanks()

  val verify = {
    val gettingRanks = selectingRanks()
      .map( x => (x,selectingRanks().count(_ == x)))
      .toSet
    if(gettingRanks.filter(_._2 == 2).size == 2) true else false
  }
}
