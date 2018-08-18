package objects

case class Range( seq_of_card: Seq[Card] ) {

  /** Handle illegal arguent */
  if( seq_of_card.length > 169 ){
    throw new IllegalArgumentException(
      "Sorry, you can't have a range containing more than 169 hand"
    )
  }

}
