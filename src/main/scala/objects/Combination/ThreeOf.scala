package objects.Combination

class ThreeOf( value: Int ) extends Combination {

  override def toString: String = s"A three of ${value_string_map( value )}"

}
