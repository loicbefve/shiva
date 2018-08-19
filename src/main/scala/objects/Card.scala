package objects

/**
  * Class representing a card
  *
  * @param notation       : The card string notation ex: Ah = As of hearth
  * @param is_out_of_deck : If the card is out of the deck i.e. on the board or
  *                       on one hand
  */
case class Card( notation: String, is_out_of_deck: Boolean = false ) {

  private val notation_value_map = Map(
    "a" -> 14,
    "k" -> 13,
    "q" -> 12,
    "j" -> 11,
    "t" -> 10,
    "9" -> 9,
    "8" -> 8,
    "7" -> 7,
    "6" -> 6,
    "5" -> 5,
    "4" -> 4,
    "3" -> 3,
    "2" -> 2,
  )

  private val card_notations = notation_value_map
  .keys
  .toList

  private val color_notations = Seq( "d", "h", "c", "s" )

  /** Handle illegal argument */
  if (
    notation.length != 2 ||

    !card_notations
    .contains(
      notation
      .headOption
      .getOrElse( "" )
      .toString
      .toLowerCase
    ) ||

    !color_notations
    .contains(
      notation
      .lastOption
      .getOrElse( "" )
      .toString
      .toLowerCase
    )
  ) {

    throw new IllegalArgumentException(
      s"Sorry, this is not a valid card notation: $notation"
    )

  }

  val value: Int = notation_value_map( notation.head.toString.toLowerCase )
  val color: String = notation.last.toString.toLowerCase

}
