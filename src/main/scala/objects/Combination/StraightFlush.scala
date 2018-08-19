package objects.Combination

import objects.Card

class StraightFlush( high_card: Card ) extends Combination {

  override def toString: String = {

    if ( high_card.value != 14 ) {
      s"Straight flush of ${color_string_map( high_card.color )}" +
      s" ${value_string_map( high_card.value )} high"
    } else {

      s"Royal straight flush of ${color_string_map( high_card.color )}"

    }

  }

}
