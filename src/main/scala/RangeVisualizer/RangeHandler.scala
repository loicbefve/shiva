package RangeVisualizer

import objects.{Board, Card, Flop, Hand}

object RangeHandler {

  def main( args: Array[String] ): Unit = {

    val flop = Flop( Card( "6d" ), Card( "7s" ), Card( "10c" ) )

    val board = Board( flop, null, null )

    val my_hand = Hand( Card( "3d" ), Card( "2s" ) )

  }

}
