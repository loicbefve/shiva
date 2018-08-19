package objects.Combination

abstract class Combination {

  val value_string_map = Map(
    14 -> "As",
    13 -> "Kings",
    12 -> "Queens",
    11 -> "Jacks",
    10 -> "10",
    9 -> "9",
    8 -> "8",
    7 -> "7",
    6 -> "6",
    5 -> "5",
    4 -> "4",
    3 -> "3",
    2 -> "2",
  )

  val color_string_map = Map(
    "s" -> "Spines",
    "c" -> "Clubs",
    "h" -> "Heart",
    "d" -> "Diamond"
  )


}
