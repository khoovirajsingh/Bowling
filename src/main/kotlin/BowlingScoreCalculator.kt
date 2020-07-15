private const val SPARE = '/'
private const val MISS = '-'
private const val STRIKE = 'X'

fun scoreFor(rolls: String): Int {
    return rolls.foldIndexed(0) { idx, score, roll ->
        score + score(roll) - spareDiff(rolls, roll, idx) + bonus(rolls, roll, idx)
    }
}

fun bonus(rolls: String, roll: Char, idx: Int): Int {
    return when (roll) {
        SPARE -> score(rolls.next(idx))
        STRIKE -> {
            val next = rolls.next(idx + 1)
            score(rolls.next(idx)) + score(next) - spareDiff(rolls, next, idx + 2)
        }
        else -> 0
    }
}

private fun String.next(idx: Int): Char {
    return if (idx < length - 1) this[idx + 1] else MISS
}

fun spareDiff(rolls: String, roll: Char, idx: Int): Int {
    return if (roll == SPARE) score(rolls.previous(idx)) else 0
}

private fun String.previous(idx: Int): Char {
    return if (idx > 0) this[idx - 1] else MISS
}

private fun score(roll: Char) =
    when (roll) {
        in '1'..'9' -> String(charArrayOf(roll)).toInt()
        SPARE, STRIKE -> 10
        else -> 0
    }
