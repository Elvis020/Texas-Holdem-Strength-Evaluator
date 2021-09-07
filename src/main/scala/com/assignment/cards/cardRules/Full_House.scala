package com.assignment.cards.cardRules

import com.assignment.cards.actions.SuitsAndRanks

case class Full_House( val combo:String) extends SuitsAndRanks(combo){

  override def selectingSuits(): String = super.selectingSuits()
  override def selectingRanks(): String = super.selectingRanks()

  val verify = {
    val gettingRanks = selectingRanks
      .map( x => (x,selectingRanks.count(_ == x)))
      .toSet
    (gettingRanks.filter(_._2 == 2).size ==1) &  (gettingRanks.filter(_._2 == 3).size ==1)
  }
}
