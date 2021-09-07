# Cards Strength Evaluator

# Requirements
* Scala
* sbt
* Editor(IntelliJ preferably)

## Structure of Codebase
For main code: src -> main -> scala -> com.assignment.cards
For unit tests: test -> scala -> com.assignment.cards

## Description
Developing an algorithm for sorting poker hands(Texas hold'em) according to their strength.

### Card Game(Texas Hold'em)
You should support one to three poker game types (more is better):
* Texas Hold'em - input is a board of 5 cards, and multiple hands of 2 cards each.

  A value of a Texas Hold'em hand is the best possible value out of all possible subsets of
  5 cards from the 7 cards which are formed by 5 board cards and 2 hand cards.

  See [Texas Hold'em rules](https://en.wikipedia.org/wiki/Texas_hold_%27em).

### Poker Structure
The game is packaged into: Actions, CardRules,GameTypes,Types and a type alias package

### Hand Value

The hand values for 5 cards are as follows (in descending order - from strongest to weakest):

* `Straight Flush` - a `Straight` (see below) which is also a `Flush` (see below)
* `Four of a kind` - Four cards of the same rank
* `Full House` - a combination of `Three of a kind` and a `Pair`
* `Flush` - 5 cards of the same suit
* `Straight` - a sequence of 5 cards of consecutive rank (note an exception - `A` can both precede `2` and follow `K`)
* `Three of a kind` - three cards with the same rank
* `Two pairs` - two `Pair`-s
* `Pair` - two cards of the same rank
* `High card` - the "fallback" in case no other hand value rule applies

In case of ties the ranks of the cards forming the combinations decide the highest value.

In case of further ties, the ranks of the remaining cards decide the highest value.

All suits are considered equal in strength.

When comparing `Full House`-s, the `Three of a kind` rank comparison is more important than the `Pair` rank
comparison, for example, `QQQ88 > 999KK`, `KKK77 > QQQJJ` and `KKK77 > KKK66`.


### How program is organised
In the class, SortTexasHoldemCards, the solution is broken down into steps. 
With a sorted function doing the final sort.
All the functions in the steps are in the actions package.

It includes the algorithm for sorting the cards in various scenarios
Also, the algorithm for the card rules(Straight, Flush etc) can be found in the card rules package

#### Examples

Example input:
```
texas-holdem 4cKs4h8s7s Ad4s Ac4d As9s KhKd 5d6d
texas-holdem 2h3h4h5d8d KdKs 9hJh
```

Example output:
```
Ac4d=Ad4s 5d6d As9s KhKd
KdKs 9hJh
```