package kabre.m2.sportbrains.TraitementJson

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kabre.m2.sportbrains.Model.Tache
import java.io.File
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Taches {

    private val FILE_NAME = "taches_quotidiennes.json"

    fun loadQuestData(context: Context, niveauTerminer: Int, etoileObtenu: Int, pieceObtenu: Int, pieceDepencer: Int): List<Tache>? {
        val internalFile = File(context.filesDir, FILE_NAME)

        return try {
            val inputStream = if (internalFile.exists()) {
                internalFile.inputStream()
            } else {
                context.assets.open(FILE_NAME).also {
                    val reader = InputStreamReader(it)
                    val tacheType = object : TypeToken<List<Tache>>() {}.type
                    val tache = Gson().fromJson<List<Tache>>(reader, tacheType)
                    saveQuestDataToInternalStorage(context, tache)
                }
                internalFile.inputStream()
            }

            val reader = InputStreamReader(inputStream)
            val tacheType = object : TypeToken<List<Tache>>() {}.type
            val taches = Gson().fromJson<List<Tache>>(reader, tacheType)
            updateQuestData(taches, niveauTerminer, etoileObtenu, pieceObtenu, pieceDepencer)
            saveQuestDataToInternalStorage(context, taches)
            taches
        } catch (e: Exception) {
            Log.e("Quest", "Erreur lors du chargement des tâches", e)
            null
        }
    }

    private fun updateQuestData(taches: List<Tache>, niveauTerminer: Int, etoileObtenu: Int, pieceObtenu: Int, pieceDepencer: Int) {
        taches.forEach { tache ->
            when (tache.condition) {
                1 -> tache.progress = niveauTerminer
                2 -> tache.progress = etoileObtenu
                3 -> tache.progress = pieceObtenu
                4 -> tache.progress = pieceDepencer
            }
            if (tache.progress >= tache.max && !tache.statusss) {
                tache.statusss = true
            }
        }
    }

    fun saveQuestDataToInternalStorage(context: Context, tacheList: List<Tache>) {
        try {
            val json = Gson().toJson(tacheList)
            context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE).use {
                OutputStreamWriter(it).use { writer -> writer.write(json) }
            }
        } catch (e: Exception) {
            Log.e("Taches", "Erreur lors de la sauvegarde", e)
        }
    }

}


