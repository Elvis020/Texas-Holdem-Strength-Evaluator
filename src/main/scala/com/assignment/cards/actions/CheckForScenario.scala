package com.assignment.cards.actions

import com.assignment.cards.cardRules._
import com.assignment.cards.priorityMap
import com.assignment.cards.types.TypeAlias.{CardStrength, Combined5Hands, SuccessfulCombination}

import scala.collection.immutable

// Checking sizes of Vector to see those who passed and rate them
// Pattern match to get the one that follow the rules of winning


case class CheckForScenario(validCards: SuccessfulCombination) {

  def matchingProcess() = {

    // Filtering the valid cards from the shuffle
    val tTwoPair = validCards.filter(Two_Pair(_).verify)
    val tOfAKind = validCards.filter(Three_Of_A_Kind(_).verify == true)
    val tFlush = validCards.filter(Flush(_).verify == true)
    val tFourOfAKind = validCards.filter(Four_Of_A_Kind(_).verify == true)
    val tStraight = validCards.filter(Straight(_).verify == true)
    val tStraightFlush = validCards.filter(StraightFlush(_).verify == true)
    val tFullHouse = validCards.filter(Full_House(_).verify == true)
    val tPair = validCards.filter(Pair(_).verify == true)
    val tHighCard = validCards.filter(High_Card(_).verify == true)


    // Checking the sizes and eliminating the unnecessary card hands
    val sizeList: Map[Combined5Hands, SuccessfulCombination] = Map(
      "Two pairs" -> tTwoPair.distinct,
      "Three of a kind" -> tOfAKind.distinct,
      "Flush" -> tFlush.distinct,
      "Four Of A Kind" -> tFourOfAKind.distinct,
      "Straight" -> tStraight.distinct,
      "Straight Flush" -> tStraightFlush.distinct,
      "Full House" -> tFullHouse.distinct,
      "Pair" -> tPair.distinct,
      "High card" -> tHighCard.distinct)
    for {
      k <- sizeList
      if (k._2.nonEmpty & !k._2.contains(false))
    } yield k._1
  }


  // A map, where the priority is based on the values
  def mappingToPriority(): immutable.Iterable[Option[CardStrength]] = {
    for (p <- matchingProcess()) yield priorityMap.get(p)
  }
}
