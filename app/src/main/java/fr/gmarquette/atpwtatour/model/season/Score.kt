package fr.gmarquette.atpwtatour.model.season

class Score
{
    var playerOneSetOne: String = ""
    var playerOneSetTwo: String = ""
    var playerOneSetThree: String = ""
    var playerOneSetFour: String = ""
    var playerOneSetFive: String = ""
    var playerTwoSetOne: String = ""
    var playerTwoSetTwo: String = ""
    var playerTwoSetThree: String = ""
    var playerTwoSetFour: String = ""
    var playerTwoSetFive: String = ""

    var playerOneSetOneTieBreak: String = ""
    var playerOneSetTwoTieBreak: String = ""
    var playerOneSetThreeTieBreak: String = ""
    var playerOneSetFourTieBreak: String = ""
    var playerOneSetFiveTieBreak: String = ""
    var playerTwoSetOneTieBreak: String = ""
    var playerTwoSetTwoTieBreak: String = ""
    var playerTwoSetThreeTieBreak: String = ""
    var playerTwoSetFourTieBreak: String = ""
    var playerTwoSetFiveTieBreak: String = ""

    constructor(set1: String, set2: String, set3: String, set4: String, set5: String)
    {
        setSetOne(set1)
        setSetTwo(set2)
        setSetThree(set3)
        setSetFour(set4)
        setSetFive(set5)
    }

    constructor(set1: String, set2: String, set3: String, set4: String)
    {
        setSetOne(set1)
        setSetTwo(set2)
        setSetThree(set3)
        setSetFour(set4)
        setSetFive("")
    }

    constructor(set1: String, set2: String, set3: String)
    {
        setSetOne(set1)
        setSetTwo(set2)
        setSetThree(set3)
        setSetFour("")
        setSetFive("")
    }

    constructor(set1: String, set2: String)
    {
        setSetOne(set1)
        setSetTwo(set2)
        setSetThree("")
        setSetFour("")
        setSetFive("")
    }

    constructor(set1: String)
    {
        setSetOne(set1)
        setSetTwo("")
        setSetThree("")
        setSetFour("")
        setSetFive("")
    }

    constructor()
    {
        playerOneSetOne = ""
        playerOneSetTwo = ""
        playerOneSetThree = ""
        playerOneSetFour = ""
        playerOneSetFive = ""
        playerTwoSetOne = ""
        playerTwoSetTwo = ""
        playerTwoSetThree = ""
        playerTwoSetFour = ""
        playerTwoSetFive = ""

        playerOneSetOneTieBreak = ""
        playerOneSetTwoTieBreak = ""
        playerOneSetThreeTieBreak = ""
        playerOneSetFourTieBreak = ""
        playerOneSetFiveTieBreak = ""
        playerTwoSetOneTieBreak = ""
        playerTwoSetTwoTieBreak = ""
        playerTwoSetThreeTieBreak = ""
        playerTwoSetFourTieBreak = ""
        playerTwoSetFiveTieBreak = ""
    }

    private fun setSet(result: String) : Set
    {
        val scores = result.split("-")
        if(result.isNotEmpty())
        {
            if(hasTieBreakValue(scores[0]))
            {
                val tieBreakScores = scores[0].split(" ")
                return if(tieBreakScores[0].toInt() == 7) {
                    Set(tieBreakScores[0], scores[1], tieBreakScores[1])
                } else {
                    Set(tieBreakScores[1], scores[1], tieBreakScores[0])
                }
            }
            else if (hasTieBreakValue(scores[1]))
            {
                val tieBreakScores = scores[1].split(" ")
                return if(tieBreakScores[0].toInt() == 7) {
                    Set(scores[0], tieBreakScores[0], tieBreakScores[1])
                } else {
                    Set(scores[0], tieBreakScores[1], tieBreakScores[0])
                }
            }
            return Set(scores[0], scores[1], "")
        }
        return Set("","", "")
    }

    fun setSetOne(score: String)
    {
        val set = setSet(score)
        playerOneSetOne = set.playerOne
        playerTwoSetOne = set.playerTwo
        if(set.tieBreakValue != "")
        {
            if(playerOneSetOne.toInt() !=  7)
            {
                playerOneSetOneTieBreak = set.tieBreakValue.toString()
            }
            else
            {
                playerTwoSetOneTieBreak = set.tieBreakValue.toString()
            }
        }
        else {
            playerOneSetFiveTieBreak = ""
            playerTwoSetFiveTieBreak = ""
        }
    }

    fun setSetTwo(score: String)
    {
        val set = setSet(score)
        playerOneSetTwo = set.playerOne.toString()
        playerTwoSetTwo = set.playerTwo.toString()
        if(set.tieBreakValue != "")
        {
            if(playerOneSetTwo.toInt() !=  7)
            {
                playerOneSetTwoTieBreak = set.tieBreakValue.toString()
            }
            else
            {
                playerTwoSetTwoTieBreak = set.tieBreakValue.toString()
            }
        }
        else {
            playerOneSetFiveTieBreak = ""
            playerTwoSetFiveTieBreak = ""
        }
    }

    fun setSetThree(score: String)
    {
        val set = setSet(score)
        playerOneSetThree = set.playerOne.toString()
        playerTwoSetThree = set.playerTwo.toString()
        if(set.tieBreakValue != "")
        {
            if(playerOneSetThree.toInt() !=  7)
            {
                playerOneSetThreeTieBreak = set.tieBreakValue.toString()
            }
            else
            {
                playerTwoSetThreeTieBreak = set.tieBreakValue.toString()
            }
        }
        else {
            playerOneSetFiveTieBreak = ""
            playerTwoSetFiveTieBreak = ""
        }
    }

    fun setSetFour(score: String)
    {
        val set = setSet(score)
        playerOneSetFour = set.playerOne.toString()
        playerTwoSetFour = set.playerTwo.toString()
        if(set.tieBreakValue != "")
        {
            if(playerOneSetFour.toInt() !=  7)
            {
                playerOneSetFourTieBreak = set.tieBreakValue.toString()
            }
            else
            {
                playerTwoSetFourTieBreak = set.tieBreakValue.toString()
            }
        }
        else {
            playerOneSetFiveTieBreak = ""
            playerTwoSetFiveTieBreak = ""
        }
    }

    fun setSetFive(score: String)
    {
        val set = setSet(score)
        playerOneSetFive = set.playerOne.toString()
        playerTwoSetFive = set.playerTwo.toString()
        if(set.tieBreakValue != "")
        {
            if(playerOneSetFive.toInt() !=  7)
            {
                playerOneSetFiveTieBreak = set.tieBreakValue.toString()
            }
            else
            {
                playerTwoSetFiveTieBreak = set.tieBreakValue.toString()
            }
        }
        else {
            playerOneSetFiveTieBreak = ""
            playerTwoSetFiveTieBreak = ""
        }
    }

    private fun hasTieBreakValue(score: String): Boolean
    {
        val regex = Regex("\\d+\\s\\d+")
        return regex.containsMatchIn(score)
    }

    fun getResult() : Int
    {
        var player1count = 0
        var player2count = 0
        if(playerOneSetOne.isNotEmpty() && playerTwoSetOne.isNotEmpty())
        {
            if(playerOneSetOne.toInt() > playerTwoSetOne.toInt()) player1count++ else player2count++
        }
        if(playerOneSetTwo.isNotEmpty() && playerTwoSetTwo.isNotEmpty())
        {
            if(playerOneSetTwo.toInt() > playerTwoSetTwo.toInt()) player1count++ else player2count++
        }
        if(playerOneSetThree.isNotEmpty() && playerTwoSetThree.isNotEmpty())
        {
            if(playerOneSetThree.toInt() > playerTwoSetThree.toInt()) player1count++ else player2count++
        }
        if(playerOneSetFour.isNotEmpty() && playerTwoSetFour.isNotEmpty())
        {
            if(playerOneSetFour.toInt() > playerTwoSetFour.toInt()) player1count++ else player2count++
        }
        if(playerOneSetFive.isNotEmpty() && playerTwoSetFive.isNotEmpty())
        {
            if(playerOneSetFive.toInt() > playerTwoSetFive.toInt()) player1count++ else player2count++
        }

        return if(player1count > player2count) 0 else 1
    }

    fun isLive() : Boolean
    {
        //TODO: Implement this method
        return false
    }

    data class Set(val playerOne: String, val playerTwo: String, val tieBreakValue: String)
}