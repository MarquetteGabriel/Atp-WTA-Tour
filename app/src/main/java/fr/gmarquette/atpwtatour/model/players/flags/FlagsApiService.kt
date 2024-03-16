package fr.gmarquette.atpwtatour.model.players.flags

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface FlagsApiService
{
    @GET("w40/{countryCode}.png")
    fun getFlag(@Path("countryCode") countryCode: String): Call<ResponseBody>

    @GET("en/codes.json")
    fun getPaysCodes(): Call<ResponseBody>
}