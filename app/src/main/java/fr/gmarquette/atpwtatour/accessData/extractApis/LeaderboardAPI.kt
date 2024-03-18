package fr.gmarquette.atpwtatour.accessData.extractApis

import com.google.gson.Gson
import fr.gmarquette.atpwtatour.Category
import fr.gmarquette.atpwtatour.accessData.apis.LeaderboardApiService
import fr.gmarquette.atpwtatour.model.players.Profile
import fr.gmarquette.atpwtatour.model.players.profile.ProfileViewModel
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LeaderboardAPI
{
    fun getRankings(category: Category, profileViewModel: ProfileViewModel) {
        val retrofit = Retrofit.Builder().baseUrl("https://tennisapi1.p.rapidapi.com/api/tennis/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("X-RapidAPI-Key", "d3c1d051demsh2f49cf399bedc69p17eeffjsnf9eba0637dc9")
                    .addHeader("X-RapidAPI-Host", "tennisapi1.p.rapidapi.com")
                    .build()
                chain.proceed(request)
            }.build()).build()

        val service = retrofit.create(LeaderboardApiService::class.java)

        lateinit var call: Call<ResponseBody>
        if(category == Category.ATP)
        {
            call = service.getATPLeaderboardOfficial()
        }
        else if (category == Category.WTA)
        {
            call = service.getWTALeaderboardOfficial()
        }

        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    val json = response.body()?.string()

                    val gson = Gson()
                    val rankingList: List<Map<String, Any>> = gson.fromJson(json, List::class.java) as List<Map<String, Any>>
                    rankingList.forEach { ranking ->
                        val team = ranking["team"] as Map<*, *>
                        var name = team["name"]
                        val rowName = ranking["rowName"]
                        val points = ranking["points"]
                        val rank = ranking["ranking"]
                        val previousRank = ranking["previousRanking"]
                        val country = ranking["country"] as Map<*, *>
                        val countryCode = country["alpha2"]
                        var firstName = ""

                        val tempName = name.toString().split(" ")
                        for (temp in tempName) {
                            if(!rowName.toString().contains(temp))
                                firstName += temp
                        }
                        name = rowName.toString().replace(firstName, "")
                        if (name.startsWith(" ")) {
                            name = name.substring(1).trim()
                        }

                        var player = profileViewModel.getProfileByNameAndFirstName(firstName, name.toString()).value as Profile
                        if(player == null) {
                            player = Profile(category, firstName, name.toString())
                        }
                        player.codeID = countryCode.toString().lowercase()
                        player.rank.currentRank = rank.toString().toInt()
                        player.rank.previousRank = previousRank.toString().toInt()
                        player.rank.points = points.toString().toInt()
                    }
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {

            }
        })
    }

    fun sortPalyersByRank(profileViewModel: ProfileViewModel) : List<Profile>?{
        val players = profileViewModel.getProfiles().value as List<Profile>
        players?.sortedBy { it.rank.currentRank }
        return players
    }

}