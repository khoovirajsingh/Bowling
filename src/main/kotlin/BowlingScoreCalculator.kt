private const val SPARE = '/'
private const val MISS = '-'

fun scoreFor(rolls: String): Int {
    return rolls.foldIndexed(0) { idx, score, roll ->
        score + score(roll) - scoreDiff(rolls, roll, idx) + bonus(rolls, roll, idx)
    }
}

fun bonus(rolls: String, roll: Char, idx: Int): Int {
    return if (roll == SPARE) score(rolls.next(idx)) else 0
}

private fun String.next(idx: Int): Char {
    return if (idx < length - 1) this [idx + 1] else MISS
}

fun scoreDiff(rolls: String, roll: Char, idx: Int): Int {
    return if (roll == SPARE) score(rolls.previous(idx)) else 0
}

private fun String.previous(idx: Int): Char {
    return if (idx > 0) this[idx-1] else MISS
}

private fun score(roll: Char) =
    when (roll) {
        in '1'..'9' -> String(charArrayOf(roll)).toInt()
        SPARE -> 10
        else -> 0
    }
