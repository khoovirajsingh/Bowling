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
    fun `calculate score for gutter shots`() {
        scoreFor("-") `should be equal to` 0
        scoreFor("1-") `should be equal to` 1
    }

    @Test
    fun `calculate score for spares`() {
        scoreFor("3/-") `should be equal to` 10
        scoreFor("7/7/7/7/7/7/7/7/7/-") `should be equal to` 146
    }

    @Test
    fun `calculate score for strikes`() {
        scoreFor("X") `should be equal to` 10
        scoreFor("X52") `should be equal to` 24
    }

    @Test
    fun `calculate score for spares and strikes`() {
        scoreFor("1/X1/2") `should be equal to` 54
    }
}