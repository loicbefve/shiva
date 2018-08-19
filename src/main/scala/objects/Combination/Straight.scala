package objects.Combination

import objects.Card

class Straight( high_card: Card ) extends Combination {

  override def toString: String = {

    s"Straight ${value_string_map( high_card.value )} high"

  }

}
