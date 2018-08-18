package objects

import scala.collection.mutable.ArrayBuffer

case class Deck() {

  private val deck_cards = ArrayBuffer[Card]()

  for( i <- 1 to 13 ; j <- ('d', 'h', 's', 'c') ){
    deck_cards += Card(i,j)
  }







}
