package fr.gmarquette.atpwtatour.accessData.apis

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ResultsApiAservice
{
    @GET("tournament_results/{tournamentID}/{year}")
    fun getATPResults(@Path("tournamentID") tournamentID: String, @Path("year") year: String): Call<ResponseBody>
}