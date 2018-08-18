package objects

/**
  * Class representing a card
  * @param value: The value of the card. As = 1
  * @param color: The color character: (h, d, c, s)
  * @param is_out_of_deck: If the card is out of the deck i.e. on the board or
  *                      on a hand
  */
case class Card( value: Int, color: Char, is_out_of_deck: Boolean = false ) {



}
