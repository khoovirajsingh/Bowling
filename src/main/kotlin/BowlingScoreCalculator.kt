fun scoreFor(rolls: String): Int {
    return rolls.foldIndexed(0) { idx, score, roll ->
        score + score(roll) - scoreDiff(rolls, roll, idx)
    }
}

fun scoreDiff(rolls: String, roll: Char, idx: Int): Int {
    return if (roll == '/') score(rolls.previous(idx)) else 0
}

private fun String.previous(idx: Int): Char {
    return if (idx > 0) this[idx-1] else '-'
}

private fun score(roll: Char) =
    when (roll) {
        in '1'..'9' -> String(charArrayOf(roll)).toInt()
        '/' -> 10
        else -> 0
    }
