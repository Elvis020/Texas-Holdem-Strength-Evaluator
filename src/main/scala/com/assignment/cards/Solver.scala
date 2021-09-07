package com.assignment.cards

import com.assignment.cards._

object Solver {
  // TODO: implement correct solution logic
  def process(line: String): String = {
    val ErrorPrefix = "Error: "

    line.split("\\s+").toList match {
      case "texas-holdem" :: board :: hands   => SortTexasHoldemCards(hands,board).sorted_cards().mkString(" ")
      case _                                  => ErrorPrefix + "Invalid input"
    }
  }


}
