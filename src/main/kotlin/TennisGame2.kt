class TennisGame2(private val player1Name: String, private val player2Name: String) : TennisGame {
    var P1point: Int = 0
    var P2point: Int = 0

    override fun getScore(): String {
        var score = ""
        if (P1point == P2point) {
            if (P1point < 4) {
                score = pointsAsText(score, P1point)
                score += "-All"
            }
            if (P1point >= 3)
                score = "Deuce"
        } else {
            var P1res = pointsAsText(score, P1point)
            var P2res = pointsAsText(score, P2point)
            score = "$P1res-$P2res"

            if (P1point > P2point && P2point >= 3) {
                score = "Advantage player1"
            }
            if (P2point > P1point && P1point >= 3) {
                score = "Advantage player2"
            }

            if (P1point >= 4 && P2point >= 0 && P1point - P2point >= 2) {
                score = "Win for player1"
            }
            if (P2point >= 4 && P1point >= 0 && P2point - P1point >= 2) {
                score = "Win for player2"
            }
        }
        return score
    }

    private fun pointsAsText(score: String, points: Int): String {
        var score1 = score
        if (points == 0)
            score1 = "Love"
        if (points == 1)
            score1 = "Fifteen"
        if (points == 2)
            score1 = "Thirty"
        if (points == 3)
            score1 = "Forty"
        return score1
    }

    fun P1Score() {
        P1point++
    }

    fun P2Score() {
        P2point++
    }

    override fun wonPoint(player: String) {
        if (player === "player1")
            P1Score()
        else
            P2Score()
    }
}