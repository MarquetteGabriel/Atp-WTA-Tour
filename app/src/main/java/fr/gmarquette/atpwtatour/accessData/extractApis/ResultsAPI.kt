package fr.gmarquette.atpwtatour.accessData.extractApis

import com.google.gson.Gson
import fr.gmarquette.atpwtatour.accessData.apis.ResultsApiAservice
import fr.gmarquette.atpwtatour.model.players.Profile
import fr.gmarquette.atpwtatour.model.players.profile.ProfileViewModel
import fr.gmarquette.atpwtatour.model.season.Matches
import fr.gmarquette.atpwtatour.model.season.Rounds
import fr.gmarquette.atpwtatour.model.season.Score
import fr.gmarquette.atpwtatour.model.season.Tournament
import fr.gmarquette.atpwtatour.model.season.matches.MatchesViewModel
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ResultsAPI
{
    fun getResults(tournament: Tournament, year: String, profileViewModel: ProfileViewModel, matchesViewModel: MatchesViewModel) {
        val retrofit = Retrofit.Builder().baseUrl("https://ultimate-tennis1.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("X-RapidAPI-Key", "d3c1d051demsh2f49cf399bedc69p17eeffjsnf9eba0637dc9")
                    .addHeader("X-RapidAPI-Host", "ultimate-tennis1.p.rapidapi.com")
                    .build()
                chain.proceed(request)
            }.build()).build()

        val service = retrofit.create(ResultsApiAservice::class.java)

        var call = service.getATPResults(tournament.id.toString(), year)
        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    val json = response.body()?.string()
                    val gson = Gson()
                    val resultList: List<Map<String, Any>> =
                        gson.fromJson(json, List::class.java) as List<Map<String, Any>>
                    resultList.forEach { data ->
                        val firstSet = data["1st Set"]
                        val secondSet = data["2nd Set"]
                        val thirdSet = data["3rd Set"]
                        val fourthSet = data["4th Set"]
                        val fifthSet = data["5th Set"]
                        val location = data["Location"]
                        val loser = data["Loser"]
                        val winner = data["Winner"]
                        val matchLength = data["Match Length"]
                        val round = data["Round"]

                        val match = Matches(
                            profileViewModel.getProfileByFullName(winner.toString()).value as Profile,
                            profileViewModel.getProfileByFullName(loser.toString()).value as Profile,
                            getRounds(round.toString()),
                            getMatchLengh(matchLength.toString()),
                            Score(firstSet.toString(), secondSet.toString(), thirdSet.toString(), fourthSet.toString(), fifthSet.toString()),
                            tournament.name
                        )

                        matchesViewModel.addMatch(match)
                    }
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {

            }

        })
    }

    private fun getMatchLengh(matchLength: String): Int {
        val hours = matchLength.split(":")[0].toInt()
        return hours * 60 + matchLength.split(":")[1].toInt()
    }

    private fun getRounds(round: String): Rounds {
        return when (round) {
            "Final" -> Rounds.FINALS
            "Finals" -> Rounds.FINALS
            "Semifinals" -> Rounds.SEMI_FINALS
            "Semi-Finals" -> Rounds.SEMI_FINALS
            "Quarterfinals" -> Rounds.QUARTER_FINALS
            "Quarter-Finals" -> Rounds.QUARTER_FINALS
            "Round of 16" -> Rounds.R16
            "Round of 32" -> Rounds.R32
            "Round of 64" -> Rounds.R64
            "Round of 128" -> Rounds.R128
            else -> Rounds.QUALIFIER
        }
    }
}