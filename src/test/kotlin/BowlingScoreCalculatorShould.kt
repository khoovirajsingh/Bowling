import org.junit.jupiter.api.Test
import org.amshove.kluent.`should be equal to`


class BowlingScoreCalculatorShould {
    @Test
    fun `score gutter game`() {
        scoreFor("0") `should be equal to` 0
    }
}