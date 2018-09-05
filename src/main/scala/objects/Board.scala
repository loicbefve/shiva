package objects

object Board {

  def main( args: Array[String] ): Unit = {

    val flop = Flop( Card( "Qc" ), Card( "8c" ), Card( "9c" ) )

    val board = Board( flop, Card( "Tc" ), Card( "Jc" ) )

    val hand = Hand( Card( "Kc" ), Card( "Ac" ) )

    board.combination( hand )

  }
}

case class Board(
                flop: Flop,
                private var turn: Card = null,
                private var river: Card = null
                ) {

  //TODO: Handle case null, null, the program think it's two same cards

  /** Handle illegal argument */
  if (
    turn == river ||
    flop.toSeq.contains( river ) ||
    flop.toSeq.contains( turn )
  ) {

    throw new IllegalArgumentException(
      "Sorry, a board cant have two times the same card: " +
      s"(${flop.toSeq}, $turn, $river)"
    )

  }

  /**
    * Get all the cards on the board
    *
    * @return A sequence of all the cards on th board
    */
  def get_cards: Seq[Card] = {

    flop.toSeq ++ Seq( turn ) ++ Seq( river )

  }

  /**
    * Find the combo of a hand on a board
    *
    * @param hand : The hand that we want to know the combo
    */
  def combination( hand: Hand ): Unit = {

    val all_cards = Seq(
      hand.card1,
      hand.card2,
    ) ++ get_cards

    val grouped_card_by_value = all_cards
    .groupBy( _.value )

    val grouped_card_by_color = all_cards
    .groupBy( _.color )

    val sorted_card = all_cards
    .sortBy( _.value )

    /** Your highest card */
    val high_card = all_cards
    .map( _.value )
    .max

    /** Your pairs */
    val pairs = grouped_card_by_value
    .filter { case (_, cards) =>
      cards.length == 2
    }
    .keys

    /** Your three of */
    val three = grouped_card_by_value
    .filter { case (value, cards) =>
      cards.length == 3
    }
    .keys

    /** Your full */
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

      val possible_straights = Seq(
        Seq( 14, 2, 3, 4, 5 ),
        Seq( 2, 3, 4, 5, 6 ),
        Seq( 3, 4, 5, 6, 7 ),
        Seq( 4, 5, 6, 7, 8 ),
        Seq( 5, 6, 7, 8, 9 ),
        Seq( 6, 7, 8, 9, 10 ),
        Seq( 7, 8, 9, 10, 11 ),
        Seq( 8, 9, 10, 11, 12 ),
        Seq( 9, 10, 11, 12, 13 ),
        Seq( 10, 11, 12, 13, 14 ),
      )

      /** All the straights */
      val possible_results = possible_straights
      .filter( straight => {
        sorted_card.map( _.value )
        .distinct
        .containsSlice( straight )
      } )

      val result = possible_results
      .filter( result => {
        result.last == possible_results.map( _.last ).max
      } )

      result.headOption.getOrElse( List() )

    }

    val flush = {

      grouped_card_by_color
      .find( color => color._2.length >= 5 )
      .getOrElse( List() )

    }

    println( flush )

  }

}

