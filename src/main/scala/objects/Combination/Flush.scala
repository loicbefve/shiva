package objects.Combination

import objects.Card

class Flush( high_card: Card ) extends Combination {

  override def toString: String = {

    s"Flush of ${color_string_map( high_card.color )}" +
    s" ${value_string_map( high_card.value )} high"

  }

}
