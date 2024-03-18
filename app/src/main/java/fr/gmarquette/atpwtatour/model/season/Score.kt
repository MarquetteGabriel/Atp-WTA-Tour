package fr.gmarquette.atpwtatour.model.season

class Score
{
    var playerOneSetOne: Int = 0
    var playerOneSetTwo: Int = 0
    var playerOneSetThree: Int = 0
    var playerOneSetFour: Int = 0
    var playerOneSetFive: Int = 0
    var playerTwoSetOne: Int = 0
    var playerTwoSetTwo: Int = 0
    var playerTwoSetThree: Int = 0
    var playerTwoSetFour: Int = 0
    var playerTwoSetFive: Int = 0

    constructor(set1: String, set2: String, set3: String, set4: String, set5: String)
    {
        setSetOne(set1)
        setSetTwo(set2)
        setSetThree(set3)
        setSetFour(set4)
        setSetFive(set5)
    }

    constructor()
    {
        playerOneSetOne = 0
        playerOneSetTwo = 0
        playerOneSetThree = 0
        playerOneSetFour = 0
        playerOneSetFive = 0
        playerTwoSetOne = 0
        playerTwoSetTwo = 0
        playerTwoSetThree = 0
        playerTwoSetFour = 0
        playerTwoSetFive = 0
    }

    fun setSetOne(score: String)
    {
        val scores = score.split("-")
        playerOneSetOne = scores[0].toInt()
        playerTwoSetOne = scores[1].toInt()
    }

    fun setSetTwo(score: String)
    {
        val scores = score.split("-")
        playerOneSetTwo = scores[0].toInt()
        playerTwoSetTwo = scores[1].toInt()
    }

    fun setSetThree(score: String)
    {
        val scores = score.split("-")
        playerOneSetThree = scores[0].toInt()
        playerTwoSetThree = scores[1].toInt()
    }

    fun setSetFour(score: String)
    {
        val scores = score.split("-")
        playerOneSetFour = scores[0].toInt()
        playerTwoSetFour = scores[1].toInt()
    }

    fun setSetFive(score: String)
    {
        val scores = score.split("-")
        playerOneSetFive = scores[0].toInt()
        playerTwoSetFive = scores[1].toInt()
    }
}