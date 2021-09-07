package com.assignment.cards.actions

// Creating all possible combinations of community cards in 3s
case class PossibleCombinationsOfCards(listOfStr: ZippingCards) {
  def shuffleCards(): Seq[String] = {
    val cards = listOfStr.zipped()
    val pairedCards = for {
      i <- cards.indices
      j <- 1 until cards.size
      k <- 2 until cards.size
      if (cards(i) != cards(j) & cards(j) != cards(k) & cards(i) != cards(k))
    } yield s"${cards(i)}${cards(j)}${cards(k)}"
    pairedCards
  }
}
