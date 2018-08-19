package objects.Combination

class DoublePair( value1: Int, value2: Int) extends Combination {

  override def toString: String =
    s"Double Pair: ${value_string_map(value1)} and ${value_string_map{value2}}"

}
