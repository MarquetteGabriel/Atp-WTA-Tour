package fr.gmarquette.atpwtatour.accessData.apis;

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

interface LeaderboardApiService
{
    @GET("rankings/atp")
    fun getATPLeaderboardOfficial(): Call<ResponseBody>

    @GET("rankings/wta")
    fun getWTALeaderboardOfficial(): Call<ResponseBody>
}
