package kabre.m2.sportbrains.TraitementJson

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kabre.m2.sportbrains.Model.RewardDay
import java.io.File
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class RewardDayTraitement {

    private val FILE_NAME = "RewardDayTraitement.json"

    fun loadRewardDaytData(context: Context): List<RewardDay>? {
        val internalFile = File(context.filesDir, FILE_NAME)

        return try {
            val inputStream = if (internalFile.exists()) {
                internalFile.inputStream()
            } else {
                context.assets.open(FILE_NAME).also {
                    val reader = InputStreamReader(it)
                    val rewardDayType = object : TypeToken<List<RewardDay>>() {}.type
                    val rewardDay = Gson().fromJson<List<RewardDay>>(reader, rewardDayType)
                    saveRewardDayDataToInternalStorage(context, rewardDay)
                }
                internalFile.inputStream()
            }

            val reader = InputStreamReader(inputStream)
            val rewardDayType = object : TypeToken<List<RewardDay>>() {}.type
            val rewardDay = Gson().fromJson<List<RewardDay>>(reader, rewardDayType)
            saveRewardDayDataToInternalStorage(context, rewardDay)
            rewardDay
        } catch (e: Exception) {
            Log.e("rewardDayList", "Erreur lors du chargement des rewardDayList", e)
            null
        }
    }

    fun saveRewardDayDataToInternalStorage(context: Context, rewardDayList: List<RewardDay>) {
        try {
            val json = Gson().toJson(rewardDayList)
            context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE).use {
                OutputStreamWriter(it).use { writer -> writer.write(json) }
            }
        } catch (e: Exception) {
            Log.e("rewardDayList", "Erreur lors de la sauvegarde", e)
        }
    }

    fun updateRewardStatus(context: Context, rewardId: Int, newStatus: Boolean): List<RewardDay>? {
        val rewardDayList = loadRewardDaytData(context)?.toMutableList()
        rewardDayList?.find { it.id == rewardId }?.status = newStatus
        rewardDayList?.let { saveRewardDayDataToInternalStorage(context, it) }
        return rewardDayList
    }
}
