fun scoreFor(rolls: String): Int {
    return rolls.fold(0) { score, roll ->
        score + score(roll)
    }
}

private fun score(roll: Char) = String(charArrayOf(roll)).toInt()