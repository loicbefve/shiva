package objects

object Board {

  def main( args: Array[String] ): Unit = {

    val flop = Flop( Card( "8c" ), Card( "8s" ), Card( "9S" ) )

    val board = Board( flop )

    val hand = Hand( Card( "8h" ), Card( "9h" ) )

    board.combination( hand )

  }
}

case class Board(
                flop: Flop,
                turn: Option[Card] = None,
                river: Option[Card] = None
                ) {

  /** Handle illegal argument */
  if (
    turn.getOrElse( "turn" ) == river.getOrElse( "river" ) ||
    flop.toSeq.contains( river.getOrElse( "river" ) ) ||
    flop.toSeq.contains( turn.getOrElse( "turn" ) )
  ) {

    throw new IllegalArgumentException(
      "Sorry, a board cant have two times the same card: " +
      s"(${flop.toSeq}, $turn, $river)"
    )

  }

  def get_cards: Seq[Card] = {

    flop.toSeq ++ turn ++ river
  }

  def combination( hand: Hand ): Unit = {

    val all_card = Seq(
      hand.card1,
      hand.card2,
    ) ++ get_cards

    val grouped_card_by_value = all_card
    .groupBy( _.value )

    val grouped_card_by_color = all_card
    .groupBy( _.color )

    val sorted_card = all_card
    .sortBy( _.value )

    val high_card = all_card
    .map( _.value )
    .max

    val pairs = grouped_card_by_value
    .filter { case (_, cards) =>
      cards.length == 2
    }
    .keys

    val three = grouped_card_by_value
    .filter { case (value, cards) =>
      cards.length == 3
    }
    .keys

    val full = {

      if ( pairs.nonEmpty && three.nonEmpty ) {
        val top_pair = pairs
        .max

        val top_three = three
        .max

        (
        top_three,
        top_pair
        )

      }

    }

    val straight = {

      val possible_straight = Seq( 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 )

      for ( i <- sorted_card ) {

        val current_index = sorted_card.indexOf( i )

        sorted_card

        for ( j <- current_index to current_index + 5 ) {

          if ( sorted_card( j + 1 ).value == sorted_card( j ).value + 1 ) {}

        }

      }

    }

    println( full )
  }

}
