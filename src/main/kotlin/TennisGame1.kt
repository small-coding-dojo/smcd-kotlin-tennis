class TennisGame1(private val player1Name: String, private val player2Name: String) : TennisGame {

    private var m_score1: Int = 0
    private var m_score2: Int = 0

    override fun wonPoint(playerName: String) {
        if (playerName === "player1") {
            m_score1 += 1
        } else {
            m_score2 += 1
        }
    }

    override fun getScore(): String {
        var score = ""
        var tempScore = 0
        if (m_score1 == m_score2) {
            when (m_score1) {
                0 -> score = "Love-All"
                1 -> score = "Fifteen-All"
                2 -> score = "Thirty-All"
                else -> score = "Deuce"
            }
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            val minusResult = m_score1 - m_score2
            if (minusResult == 1) {
                score = "Advantage player1"
            } else if (minusResult == -1) {
                score = "Advantage player2"
            } else if (minusResult >= 2) {
                score = "Win for player1"
            } else {
                score = "Win for player2"
            }
        } else {
            score = scoreText(m_score1) + "-" + scoreText(m_score2);
        }
        return score
    }

    private fun scoreText(tempScore: Int): String {
        var score1 = ""
        when (tempScore) {
            0 -> score1 = "Love"
            1 -> score1 = "Fifteen"
            2 -> score1 = "Thirty"
            3 -> score1 = "Forty"
        }
        return score1
    }
}
