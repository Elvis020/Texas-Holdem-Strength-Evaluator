package com.assignment.cards.actions

import com.assignment.cards.types.TypeAlias.{CardsFromPlayers, SuccessfulCombination}

import scala.collection.mutable.ListBuffer

// Combining comm cards with that of players
case class CombineShuffledCardsWithPlayers(cardFromPlayer: CardsFromPlayers, shuffledCards: SuccessfulCombination) {
  var listBufferOfStrings: ListBuffer[Seq[String]] = new ListBuffer[Seq[String]]()


  // Placing the cards in 4 different positions, you have only done it for one
  val atTheEnd: Seq[String] = for (i <- shuffledCards) yield s"$i$cardFromPlayer"
  listBufferOfStrings += atTheEnd
  val atTheStart = for (i <- shuffledCards) yield s"$cardFromPlayer$i"
  listBufferOfStrings += atTheStart
  val atPosition4To7: Seq[String] = for (i <- shuffledCards) yield new StringBuilder(i).insert(4, cardFromPlayer).toString
  listBufferOfStrings += atPosition4To7
  val atPosition2To5: Seq[String] = for (i <- shuffledCards) yield new StringBuilder(i).insert(2, cardFromPlayer).toString
  listBufferOfStrings += atPosition2To5


  def shuffleDone: Seq[String] = listBufferOfStrings.flatten.toSeq
}
