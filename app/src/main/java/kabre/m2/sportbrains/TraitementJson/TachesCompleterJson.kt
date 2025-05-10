package kabre.m2.sportbrains.TraitementJson

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kabre.m2.sportbrains.Model.CompleteTache
import java.io.File
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class TachesCompleterJson {
    private val FILE_NAME = "Tache_Complete.json"

    fun loadUserData(context: Context): CompleteTache? {
        val internalFile = File(context.filesDir, FILE_NAME)

        return if (internalFile.exists()) {
            // Charger depuis le stockage interne
            try {
                val reader = InputStreamReader(internalFile.inputStream())
                val userType = object : TypeToken<List<CompleteTache>>() {}.type
                val users: List<CompleteTache> = Gson().fromJson(reader, userType)
                users.firstOrNull() // Retourne le premier utilisateur (ou null si la liste est vide)
            } catch (e: Exception) {
                Log.e("User", "Erreur lors du chargement des données internes", e)
                null
            }
        } else {
            // Charger depuis `assets` et sauvegarder dans le stockage interne
            try {
                context.assets.open(FILE_NAME).use { inputStream ->
                    val jsonString = inputStream.bufferedReader().use { it.readText() }
                    val users: List<CompleteTache> = Gson().fromJson(jsonString, object : TypeToken<List<CompleteTache>>() {}.type)

                    // Sauvegarder les données dans le stockage interne
                    if (users.isNotEmpty()) {
                        saveUserDataToInternalStorage(context, users)
                    }
                    users.firstOrNull() // Retourne le premier utilisateur (ou null si la liste est vide)
                }
            } catch (e: Exception) {
                Log.e("User", "Erreur lors du chargement des données depuis les assets", e)
                null
            }
        }
    }

    // Fonction pour sauvegarder une liste d'utilisateurs dans le fichier interne
    fun saveUserDataToInternalStorage(context: Context, users: List<CompleteTache>) {
        try {
            val jsonString = Gson().toJson(users)
            context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE).use { outputStream ->
                OutputStreamWriter(outputStream).use { writer ->
                    writer.write(jsonString)
                }
            }
        } catch (e: Exception) {
            Log.e("User", "Erreur lors de la sauvegarde des données utilisateur", e)
        }
    }

    // Fonction pour modifier une ou plusieurs valeurs dans le fichier JSON
    fun updateUserData(context: Context, newTache: CompleteTache) {
        val internalFile = File(context.filesDir, FILE_NAME)

        if (internalFile.exists()) {
            try {
                val reader = InputStreamReader(internalFile.inputStream())
                val userType = object : TypeToken<List<CompleteTache>>() {}.type
                val users: MutableList<CompleteTache> = Gson().fromJson(reader, userType)

                // Trouver l'utilisateur existant par son ID et mettre à jour ses valeurs
                val currentUser = users.find { it.id == newTache.id }
                currentUser?.apply {
                    niveauTerminer = newTache.niveauTerminer ?: niveauTerminer
                    etoileObtenu = newTache.etoileObtenu ?: etoileObtenu
                    pieceDepencer = newTache.pieceDepencer
                    pieceObtenu = newTache.pieceObtenu
                    progressTache = newTache.progressTache
                }

                // Sauvegarder les nouvelles données utilisateur dans la liste
                saveUserDataToInternalStorage(context, users)

            } catch (e: Exception) {
                Log.e("User", "Erreur lors de la mise à jour des données utilisateur", e)
            }
        }
    }
}