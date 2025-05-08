package kabre.m2.sportbrains.TraitementJson

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kabre.m2.sportbrains.Model.UserModel
import java.io.File
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class User {

    // Fonction pour charger les données utilisateur depuis `assets` ou le stockage interne
    fun loadUserData(context: Context): UserModel? {
        val internalFile = File(context.filesDir, "user.json")

        return if (internalFile.exists()) {
            // Charger depuis le stockage interne
            try {
                val reader = InputStreamReader(internalFile.inputStream())
                val userType = object : TypeToken<List<UserModel>>() {}.type
                val users: List<UserModel> = Gson().fromJson(reader, userType)
                users.firstOrNull() // Retourne le premier utilisateur (ou null si la liste est vide)
            } catch (e: Exception) {
                Log.e("User", "Erreur lors du chargement des données internes", e)
                null
            }
        } else {
            // Charger depuis `assets` et sauvegarder dans le stockage interne
            try {
                context.assets.open("user.json").use { inputStream ->
                    val jsonString = inputStream.bufferedReader().use { it.readText() }
                    val users: List<UserModel> = Gson().fromJson(jsonString, object : TypeToken<List<UserModel>>() {}.type)

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
    fun saveUserDataToInternalStorage(context: Context, users: List<UserModel>) {
        try {
            val jsonString = Gson().toJson(users)
            context.openFileOutput("user.json", Context.MODE_PRIVATE).use { outputStream ->
                OutputStreamWriter(outputStream).use { writer ->
                    writer.write(jsonString)
                }
            }
        } catch (e: Exception) {
            Log.e("User", "Erreur lors de la sauvegarde des données utilisateur", e)
        }
    }

    // Surcharge pour sauvegarder un seul utilisateur en tant que liste
    fun saveUserDataToInternalStorage(context: Context, user: UserModel) {
        saveUserDataToInternalStorage(context, listOf(user)) // Convertir l'utilisateur en liste
    }

    // Fonction pour modifier une ou plusieurs valeurs dans le fichier JSON
    fun updateUserData(context: Context, newUser: UserModel) {
        val internalFile = File(context.filesDir, "user.json")

        if (internalFile.exists()) {
            try {
                val reader = InputStreamReader(internalFile.inputStream())
                val userType = object : TypeToken<List<UserModel>>() {}.type
                val users: MutableList<UserModel> = Gson().fromJson(reader, userType)

                // Trouver l'utilisateur existant par son ID et mettre à jour ses valeurs
                val currentUser = users.find { it.id == newUser.id }
                currentUser?.apply {
                    name = newUser.name ?: name
                    pic = newUser.pic ?: pic
                    score = newUser.score
                    scoreDepence = newUser.scoreDepence
                    level = newUser.level
                    levelPart = newUser.levelPart
                    progressTache = newUser.progressTache
                    questTerminer = newUser.questTerminer
                }

                // Sauvegarder les nouvelles données utilisateur dans la liste
                saveUserDataToInternalStorage(context, users)

            } catch (e: Exception) {
                Log.e("User", "Erreur lors de la mise à jour des données utilisateur", e)
            }
        }
    }

    // Fonction pour mettre à jour le score de l'utilisateur en ajoutant la récompense
    fun updateUserScore(user: UserModel, recompense: Int) {
        user.score += recompense
    }

    fun updateUserScoreBt(user: UserModel, prix: Int) {
        user.score -= prix
    }
}
