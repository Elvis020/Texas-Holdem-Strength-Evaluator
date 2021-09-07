package com.assignment

import com.assignment.cards.actions.SuitsAndRanks
import com.assignment.cards.types.TypeAlias.{CardStrength, CardsFromPlayers, Combined5Hands}

package object cards {
  var playersScoresMap: Map[CardsFromPlayers, CardStrength] = Map()
  var playersScoresMap_Omaha: Map[CardsFromPlayers, CardStrength] = Map()
  var playersScoresMap_5cards: Map[CardsFromPlayers, CardStrength] = Map()




  // A map of the cards and the strength using a Map
  val priorityMap: Map[Combined5Hands, CardStrength] = Map(
    ("Straight Flush", 1),
    ("Four of a kind", 2),
    ("Full House",3),
    ("Flush",4),
    ("Straight",5),
    ("Three of a kind",6),
    ("Two pairs",7),
    ("Pair",8),
    ("High card",9)
  )

  def stringConv(s:Char):Int =s match{
    case 'A' => 1
    case '2' => 2
    case '3' => 3
    case '4' => 4
    case '5' => 5
    case '6' => 6
    case '7' => 7
    case '8' => 8
    case '9' => 9
    case 'T' => 10
    case 'J' => 11
    case 'Q' => 12
    case 'K' => 13
  }

}
