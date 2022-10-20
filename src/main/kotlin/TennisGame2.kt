class TennisGame2(private val player1Name: String, private val player2Name: String) : TennisGame {
    private var p1point: Int = 0
    private var p2point: Int = 0

    override fun getScore(): String {
        var score = ""
        if (p1point == p2point) {
            if (p1point < 4) {
                score = pointsAsText(score, p1point)
                score += "-All"
            }
            if (p1point >= 3) {
                score = "Deuce"
            }
        } else {
            score = nameAsText(score)
            score = scoreTextForAdvantage(score)
            score = scoreTextForFinishedGame(score)
        }

        return score
    }

    private fun nameAsText(score: String): String {
        var score1 = score
        val p1res = pointsAsText(score1, p1point)
        val p2res = pointsAsText(score1, p2point)
        score1 = "$p1res-$p2res"
        return score1
    }

    private fun scoreTextForFinishedGame(score: String): String {
        var score1 = score
        if (p1point >= 4 && p2point >= 0 && p1point - p2point >= 2) {
            score1 = "Win for $player1Name"
        }
        if (p2point >= 4 && p1point >= 0 && p2point - p1point >= 2) {
            score1 = "Win for $player2Name"
        }
        return score1
    }

    private fun scoreTextForAdvantage(score: String): String {
        var score1 = score
        if (p2point in 3 until p1point) {
            score1 = "Advantage $player1Name"
        }
        if (p1point in 3 until p2point) {
            score1 = "Advantage $player2Name"
        }
        return score1
    }

    private fun pointsAsText(score: String, points: Int): String {
        return when (points) {
            0 -> "Love"
            1 -> "Fifteen"
            2 -> "Thirty"
            3 -> "Forty"
            else -> score
        }
    }

    private fun p1Score() {
        p1point++
    }

    private fun p2Score() {
        p2point++
    }

    override fun wonPoint(playerName: String) {
        if (playerName === "$player1Name") {
            p1Score()
        } else {
            p2Score()
        }
    }
}