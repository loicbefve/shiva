package objects.Combination

case class Pair( value: Int ) extends Combination {

  override def toString: String = s"Pair: ${value_string_map( value )}"

}
