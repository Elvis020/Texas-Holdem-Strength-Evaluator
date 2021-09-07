package com.assignment.cards.actions

// Converts input cards to suits and ranks
class SuitsAndRanks(combo:String) {
  val isEven = (number:Int) => (number & 1) == 0
  def selectingSuits(): String =  for{
    n <- combo
    if(!isEven(combo.indexOf(n)))
  } yield n


  def selectingRanks(): String =  for{
    n <- combo
    if(isEven(combo.indexOf(n)))
  } yield n
}
