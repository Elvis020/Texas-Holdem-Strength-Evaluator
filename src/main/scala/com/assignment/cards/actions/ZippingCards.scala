package com.assignment.cards.actions

// Splitting the community cards into 3s
case class ZippingCards(cardsSep: SuitsAndRanks) {
  def zipped(): Array[String] = {
    val zip_1 = cardsSep.selectingRanks zip cardsSep.selectingSuits
    val zip_2 = for (i <- zip_1) yield s"${i._1}${i._2}"
    zip_2.toArray
  }
}
