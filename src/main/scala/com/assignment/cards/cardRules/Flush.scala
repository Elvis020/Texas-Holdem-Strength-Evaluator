package com.assignment.cards.cardRules

import com.assignment.cards.actions.SuitsAndRanks

case class Flush(val combo:String) extends SuitsAndRanks(combo){

  override def selectingSuits(): String = super.selectingSuits()
  override def selectingRanks(): String = super.selectingRanks()

  val verify= {
    val gettingSuits = {selectingSuits()
      .map( x => (x,selectingSuits().count(_ == x)))
      .toSet
    }
    gettingSuits.filter(_._2 == 5).size ==1 & !(Straight(combo).checkDone )
  }
}
