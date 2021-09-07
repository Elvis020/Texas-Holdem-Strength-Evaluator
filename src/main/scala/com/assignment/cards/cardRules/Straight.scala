package com.assignment.cards.cardRules

import com.assignment.cards.actions.SuitsAndRanks
import com.assignment.cards.stringConv

import scala.collection.mutable.ListBuffer

case class Straight( val combo:String) extends SuitsAndRanks(combo){

  override def selectingSuits(): String = super.selectingSuits()

  override def selectingRanks(): String = super.selectingRanks()

  val selectingSeq_2 = selectingSuits()
    .map(x => (x, selectingSuits().count(_ == x)))
    .toSet.count(_._2 == 5) == 1
  val verify3: List[Char] = {
    val selectingSeq = selectingRanks()
      .map( x => (x,selectingRanks().count(_ == x)))
      .toList
    selectingSeq.map(_._1)
  }


  def checkDone: Boolean = {
    var cleanedL = new ListBuffer[Int]()

    for(i <- verify3){
      if(i.isValidChar) cleanedL += stringConv(i)
      else cleanedL += i
    }
    val test_consecutive_1 = for{
      i <- 0 until cleanedL.length-1
    } yield cleanedL(i + 1) - cleanedL(i) == -1
    val test_consecutive_2 = for{
      i <- 0 until cleanedL.length-1
    } yield cleanedL(i + 1) - cleanedL(i) == 1
    !test_consecutive_1.contains(false) | !test_consecutive_2.contains(false)
  }
  def verify(): Boolean = checkDone & !selectingSeq_2
}
