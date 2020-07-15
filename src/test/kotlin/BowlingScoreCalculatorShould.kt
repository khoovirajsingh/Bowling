import org.junit.jupiter.api.Test
import org.amshove.kluent.`should be equal to`


class BowlingScoreCalculatorShould {
    @Test
    fun `calculate score for pins`() {
        scoreFor("0") `should be equal to` 0
        scoreFor("1") `should be equal to` 1
        scoreFor("23") `should be equal to` 5
    }

    @Test
    internal fun `calculate score for gutter shots`() {
        scoreFor("-") `should be equal to` 0
        scoreFor("1-") `should be equal to` 1
    }
}