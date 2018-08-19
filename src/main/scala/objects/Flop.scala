package objects

case class Flop( card_1: Card, card_2: Card, card_3: Card ) {

  /** Handle illegal argument */
  if ( Seq( card_1, card_2, card_3 ).distinct.length != 3 ) {
    throw new IllegalArgumentException(
      s"Sorry, you can't have two same cards:" +
      s" ($card_1, $card_2, $card_3)"
    )
  }

  def toSeq: Seq[Card] = Seq( card_1, card_2, card_3 )

}
