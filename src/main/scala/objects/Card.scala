package objects

/**
  * Class representing a card
  * @param value: The value of the card. As = 1
  * @param color: The color character: (h, d, c, s)
  * @param is_out_of_deck: If the card is out of the deck i.e. on the board or
  *                      on a hand
  */
case class Card( notation: String ) {

  private val notation_value_map = Map(
    'a' -> 14,
    'k' -> 13,
    'q' -> 12,
    'j' -> 11,
    't' -> 10,
    '9' -> 9,
    '8' -> 8,
    '7' -> 7,
    '6' -> 6,
    '5' -> 5,
    '4' -> 4,
    '3' -> 3,
    '2' -> 2,
  )

  private val card_notation = notation_value_map
    .keys
    .toList

  private val color_notation = Seq('d', 'h', 'c', 's')

  /** Handle illegal argument */
  if(
    notation.length != 2 ||

      !card_notation
        .contains(
          notation
            .headOption
            .getOrElse("\0")
        ) ||

      !color_notation
        .contains(
          notation
            .lastOption
            .getOrElse("\0")
        )
  ){

    throw new IllegalArgumentException(
      s"Sorry, this is not a valid card notation: $notation"
    )

  }

  val value: Int = notation_value_map(notation.head)
  val color: Char = notation.last

}
