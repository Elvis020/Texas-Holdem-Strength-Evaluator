package com.assignment.cards

import com.assignment.cards.actions._
import com.assignment.cards.types.TypeAlias.{CardStrength, CardsFromPlayers}

import scala.collection.mutable.ListBuffer

case class SortTexasHoldemCards(hands: Seq[String], board: String) {

  // Taking in the community cards
  val step_1 = new SuitsAndRanks(board)

  // Shuffling the community cards
  val step_2: ZippingCards = ZippingCards(step_1)


  val step_3 = PossibleCombinationsOfCards(step_2).shuffleCards()


  // Taking one hand at a time
  for (hand <- hands) {

    // Mixing shuffled community cards with players hands
    val step_4 = CombineShuffledCardsWithPlayers(hand, step_3).shuffleDone

    // Passing the results of the combined cards to check for the scenarios they output
    val step_5: CheckForScenario = CheckForScenario(step_4)

    // Taking the best card in for each player, best ==  min number(This is based on the priorityMap mapping)
    val step_6: Option[CardStrength] =
      step_5
        .mappingToPriority()
        .min



    // Mapping player cards to results and adding to a Map collection
    playersScoresMap += (hand -> step_6.get)

  }

  // Sorting the hands in the map
  val sorting_players_hand = playersScoresMap
    .toSeq
    .sortBy(_._2)
    .reverse
    .map(i => (i._1, (i._2)))
    .groupBy(_._2)
    .toSeq
    .sortBy(_._1)
    .reverse

  // Sorting the cards again to get
  def sorted_cards(): List[Any] = {
    var final_sorted_list: ListBuffer[Any] = ListBuffer[Any]()

    def sortingByRanks(rs: Seq[CardsFromPlayers]): Seq[(CardsFromPlayers, (Int, Int))] = {
      val ranks_sorted = for {
        h <- rs
      } yield (h, (new SuitsAndRanks(h)
        .selectingRanks()
        .toList
        .map(stringConv(_))
        .max, new SuitsAndRanks(h)
        .selectingRanks()
        .toList
        .map(stringConv(_))
        .sum))
      ranks_sorted.sortBy(_._2)
    }

    // Further sorting by hand
    for (j <- sorting_players_hand) {
      if (j._2.size > 2) {
        sortingByRanks(j._2.map(_._1)).foreach(p => final_sorted_list += p._1)
      }
      else j._2.map(_._1).foreach(p => final_sorted_list += p)
    }

    val final_with_conflicting_cards: ListBuffer[String] =
      for (h <- final_sorted_list) yield new SuitsAndRanks(h.toString).selectingRanks()

    if (final_with_conflicting_cards.toList.distinct.size != final_with_conflicting_cards.toList.size) {
      val conflicting_cards_sorted: ListBuffer[String] = ListBuffer[String]()
      for (j <- final_with_conflicting_cards.indices) {

        if ((j + 1) != final_with_conflicting_cards.size) {
          if (final_with_conflicting_cards(j) == final_with_conflicting_cards(j + 1)) conflicting_cards_sorted += ("" + final_sorted_list(j + 1) + "=" + final_sorted_list(j))
          else {
            if (j != 0) {
              if (final_with_conflicting_cards(j) == final_with_conflicting_cards(j - 1)) conflicting_cards_sorted
              else conflicting_cards_sorted += final_sorted_list(j).toString
            }
            else conflicting_cards_sorted += final_sorted_list(j).toString
          }
        }
        else conflicting_cards_sorted += final_sorted_list(j).toString
      }
      conflicting_cards_sorted.toList
    }
    else final_sorted_list.toList
  }
}
