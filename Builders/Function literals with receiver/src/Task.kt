fun task(): List<Boolean> {
    val isEven: Int.() -> Boolean = { this.rem(2) == 0 }
    val isOdd: Int.() -> Boolean = { this.rem(2) != 0 }

    return listOf(42.isOdd(), 239.isOdd(), 294823098.isEven())
}

/*
  this % 2 == 0
*/
