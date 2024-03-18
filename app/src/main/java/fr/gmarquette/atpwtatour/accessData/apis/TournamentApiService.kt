package fr.gmarquette.atpwtatour.accessData.apis

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface TournamentApiService
{
    @GET("tournament_list/atp/{year}/atpgs")
    fun getATPResults(@Path("year") year: String): Call<ResponseBody>
}