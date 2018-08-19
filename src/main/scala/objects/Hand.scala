package objects

case class Hand( card1: Card, card2: Card ) {

  /** Handle illegal arguments */
  if ( card1 == card2 ) {
    throw new IllegalArgumentException(
      s"You can't have two times the same card: ($card1, $card2)"
    )
  }

}
