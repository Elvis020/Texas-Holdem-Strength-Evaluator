package com.assignment.cards.cardRules

import com.assignment.cards.actions.SuitsAndRanks

case class High_Card(val combo:String) extends SuitsAndRanks(combo){

  override def selectingSuits(): String = super.selectingSuits()
  override def selectingRanks(): String = super.selectingRanks()
  val _3_of_aKind = Three_Of_A_Kind(combo).verify
  val _2_Pair = Two_Pair(combo).verify
  val _1_Pair = Pair(combo).verify
  val _Flush = Flush(combo).verify
  val _4_of_a_Kind = Four_Of_A_Kind(combo).verify
  val _Full_House = Full_House(combo).verify
  val _Straight = Straight(combo).verify
  val _Straight_Flush= StraightFlush(combo).verify

  val verify: Boolean =
    !_3_of_aKind &
      !_2_Pair &
      ! _1_Pair &
      ! _Flush &
      !_4_of_a_Kind &
      !_Full_House &
      !_Straight &
      !_Straight_Flush
}