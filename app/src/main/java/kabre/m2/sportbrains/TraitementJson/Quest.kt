package kabre.m2.sportbrains.TraitementJson

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kabre.m2.sportbrains.Model.QuestModel
import kabre.m2.sportbrains.Model.UserModel
import java.io.File
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Quest {

    fun loadQuestData(context: Context, userScore: Int, totalStars: Int, userDepence: Int): List<QuestModel>? {
        val internalFile = File(context.filesDir, "quests.json")

        return if (internalFile.exists()) {
            try {
                val inputStream = internalFile.inputStream()
                val reader = InputStreamReader(inputStream)
                val questType = object : TypeToken<List<QuestModel>>() {}.type
                val quests = Gson().fromJson<List<QuestModel>>(reader, questType)


                updateQuestData(quests, userScore, totalStars, userDepence)

                quests
            } catch (e: Exception) {
                Log.e("Quest", "Erreur lors du chargement des données de quêtes", e)
                null
            }
        } else {
            // Charger depuis `assets` si le fichier n'existe pas dans le stockage interne
            try {
                val inputStream = context.assets.open("quests.json")
                val reader = InputStreamReader(inputStream)
                val questType = object : TypeToken<List<QuestModel>>() {}.type
                val quests = Gson().fromJson<List<QuestModel>>(reader, questType)

                updateQuestData(quests, userScore, totalStars, userDepence)

                // Sauvegarder les données lues dans le fichier interne
                saveQuestDataToInternalStorage(context, quests)
                quests
            } catch (e: Exception) {
                Log.e("Quest", "Erreur lors du chargement des données de quêtes depuis assets", e)
                null
            }
        }
    }

    // Fonction pour sauvegarder la liste des quêtes dans le fichier interne
    fun saveQuestDataToInternalStorage(context: Context, questList: List<QuestModel>) {
        try {
            val jsonString = Gson().toJson(questList)
            context.openFileOutput("quests.json", Context.MODE_PRIVATE).use { outputStream ->
                OutputStreamWriter(outputStream).use { writer ->
                    writer.write(jsonString)
                }
            }
        } catch (e: Exception) {
            Log.e("Quest", "Erreur lors de la sauvegarde des données de quêtes", e)
        }
    }

    // Fonction pour mettre à jour currentcCompleteNb et le statut des quêtes
    private fun updateQuestData(quests: List<QuestModel>, userScore: Int, totalStars: Int, userDepence: Int) {
        quests.forEach { quest ->
            when (quest.condition) {
                1 -> quest.currentcCompleteNb = totalStars
                2 -> quest.currentcCompleteNb = userScore
                3 -> quest.currentcCompleteNb = userDepence
            }
            if (quest.currentcCompleteNb >= quest.completeNb && quest.status == 2) {
                quest.status = 3
            }
        }
    }
}
