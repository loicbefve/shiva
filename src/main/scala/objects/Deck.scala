package objects

case class Deck( ) {

  private val symbols = Seq( "a", "k", "q", "j", "t", "9", "8", "7", "6", "5", "4", "3", "2" )
  private val colors = Seq( "d", "h", "s", "c" )

  val deck_cards: Seq[Card] = symbols
  .flatMap( symbol => {
    colors.map( color => {
      Card( symbol + color )
    }
    )
  }
  )

}
