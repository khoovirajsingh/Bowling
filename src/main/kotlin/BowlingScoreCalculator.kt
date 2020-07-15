fun scoreFor(rolls: String): Int {
    return rolls.fold(0) { score, roll ->
        score + score(roll)
    }
}

private fun score(roll: Char) =
    when (roll) {
        in '1'..'9' -> String(charArrayOf(roll)).toInt()
        else -> 0
    }
