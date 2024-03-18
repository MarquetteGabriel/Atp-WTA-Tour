package fr.gmarquette.atpwtatour.accessData.extractApis

import com.google.gson.Gson
import fr.gmarquette.atpwtatour.accessData.apis.TournamentApiService
import fr.gmarquette.atpwtatour.model.season.Surfaces
import fr.gmarquette.atpwtatour.model.season.Tournament
import fr.gmarquette.atpwtatour.model.season.TournamentCategory
import fr.gmarquette.atpwtatour.model.season.tournament.TournamentViewModel
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TournamentsAPI
{
    fun getTournements(year: String, tournamentViewModel: TournamentViewModel) {
        val retrofit = Retrofit.Builder().baseUrl("\"https://ultimate-tennis1.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader(
                        "X-RapidAPI-Key",
                        "d3c1d051demsh2f49cf399bedc69p17eeffjsnf9eba0637dc9"
                    )
                    .addHeader("X-RapidAPI-Host", "ultimate-tennis1.p.rapidapi.com")
                    .build()
                chain.proceed(request)
            }.build()).build()

        val service = retrofit.create(TournamentApiService::class.java)

        var call = service.getATPResults(year)
        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    val json = response.body()?.string()
                    val gson = Gson()
                    val tournamentList: List<Map<String, Any>> =
                        gson.fromJson(json, List::class.java) as List<Map<String, Any>>
                    tournamentList.forEach { tournament ->
                        val dblDrawSize = tournament["DblDrawSize"]
                        val date = tournament["FormattedDate"]
                        val id = tournament["Id"]
                        val io = tournament["IndoorOutdoor"]
                        val location = tournament["Location"]
                        val name = tournament["Name"]
                        val sglDrawSize = tournament["SglDrawSize"]
                        val surface = tournament["Surface"]
                        val priceMoney = tournament["TotalFinancialCommitment"]
                        val category = tournament["Type"]

                        val tournament = Tournament(
                            getCategory(category.toString()),
                            name.toString(),
                            date.toString(),
                            getSurfaces(surface.toString()),
                            getInOut(io.toString()),
                            priceMoney.toString().toInt(),
                            location.toString(),
                            sglDrawSize.toString().toInt(),
                        )
                        tournament.id = id.toString().toInt()
                        tournamentViewModel.addTournament(tournament)

                    }
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
            }
        })
    }

    private fun getCategory(category: String): TournamentCategory {
        return if (category == "UC") {
            TournamentCategory.UNITED_CUP
        } else {
            TournamentCategory.ATP_250
        }
    }

    private fun getSurfaces(surface: String): Surfaces {
        return when (surface) {
            "Hard" -> Surfaces.HARD
            "Clay" -> Surfaces.CLAY
            "Grass" -> Surfaces.GRASS
            "Carpet" -> Surfaces.CARPET
            else -> Surfaces.UNKNOWN
        }
    }

    private fun getInOut(io: String): Surfaces {
        return when (io) {
            "Indoor" -> Surfaces.INDOOR
            "Outdoor" -> Surfaces.OUTDOOR
            else -> Surfaces.UNKNOWN
        }
    }
}