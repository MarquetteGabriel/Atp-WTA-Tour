package fr.gmarquette.atpwtatour.model.players.flags


import android.content.Context
import android.net.Uri
import android.widget.ImageView
import com.squareup.picasso.Picasso
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

class Flags
{
    fun getFlag(country: String, imageView: ImageView, context: Context) {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://flagcdn.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val flagApiService = retrofit.create(FlagsApiService::class.java)

        getCountryCode(country) { countryCode ->
            val call = flagApiService.getFlag(countryCode)
            call.enqueue(object : Callback<ResponseBody> {
                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    if (response.isSuccessful) {
                        val inputStream = response.body()?.byteStream()
                        val file = File.createTempFile("tempImage", null, context.cacheDir)
                        file.outputStream().use { outputStream ->
                            inputStream?.copyTo(outputStream)
                        }

                        val uri = Uri.fromFile(file)
                        Picasso.get().load(uri).into(imageView)
                    }
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {

                }
            })
        }
    }

    fun getCountryCode(country: String, callback: (String) -> Unit) {
        val retrofit = Retrofit.Builder().baseUrl("https://flagcdn.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()

        val flagApiService = retrofit.create(FlagsApiService::class.java)

        val call = flagApiService.getPaysCodes()
        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    val json = response.body()?.string()

                    val countryTable = json.toString().split(",\n")
                    for (tempCountry in countryTable) {
                        var countryName = tempCountry.split(": ")[1].trim('\"')
                        if (countryName == country) {
                            val countryCode = tempCountry.split(": ")[0].replace(" ", "").replace("\n", "").trim('\"')
                            callback(countryCode)
                        }
                    }
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {

            }
        })
    }



    companion object {
        fun getFlag(nationality: String, playerNationality: ImageView, requireContext: Context) {
            val flags = Flags()
            flags.getFlag(nationality, playerNationality, requireContext)
        }
    }

}
