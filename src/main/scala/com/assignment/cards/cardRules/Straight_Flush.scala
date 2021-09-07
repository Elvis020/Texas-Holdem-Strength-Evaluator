package com.assignment.cards.cardRules

import com.assignment.cards.actions.SuitsAndRanks

case class StraightFlush(val combo:String) extends SuitsAndRanks(combo){
  override def selectingSuits(): String = super.selectingSuits()
  override def selectingRanks(): String = super.selectingRanks()
  val verify:Boolean = {
    val gettingSuits = {
      selectingSuits
        .map( x => (x,selectingSuits.count(_ == x)))
        .toSet
    }
    Straight(combo).checkDone  & (gettingSuits.filter(_._2 == 5).size ==1)
  }


}
