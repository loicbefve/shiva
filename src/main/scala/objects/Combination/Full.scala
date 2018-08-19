package objects.Combination

class Full( three_of_value: Int, pair_value: Int ) extends Combination {

  override def toString: String =
    s"A full of ${value_string_map(three_of_value)}" +
    s" by the ${value_string_map(pair_value)}"

}
