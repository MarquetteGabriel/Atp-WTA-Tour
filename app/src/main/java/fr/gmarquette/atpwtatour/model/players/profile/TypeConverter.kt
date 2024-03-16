package fr.gmarquette.atpwtatour.model.players.profile

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import fr.gmarquette.atpwtatour.model.players.Career
import fr.gmarquette.atpwtatour.model.players.Rank
import java.io.ByteArrayOutputStream
import java.lang.reflect.Type

class TypeConverter
{

    private val gson = Gson()

    @TypeConverter
    fun fromBitmap(bitmap: Bitmap): ByteArray {
        val outputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
        return outputStream.toByteArray()
    }

    @TypeConverter
    fun toBitmap(byteArray: ByteArray): Bitmap {
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
    }

    @TypeConverter
    fun careerToString(career: Career?): String? {
        return gson.toJson(career)
    }

    @TypeConverter
    fun stringToCareer(careerString: String?): Career? {
        if (careerString.isNullOrEmpty()) {
            return null
        }
        val type: Type = object : TypeToken<Career>() {}.type
        return gson.fromJson(careerString, type)
    }

    @TypeConverter
    fun rankToString(rank: Rank?): String? {
        return gson.toJson(rank)
    }

    @TypeConverter
    fun stringToRank(rankString: String?): Rank? {
        if (rankString.isNullOrEmpty()) {
            return null
        }
        val type: Type = object : TypeToken<Rank>() {}.type
        return gson.fromJson(rankString, type)
    }
}