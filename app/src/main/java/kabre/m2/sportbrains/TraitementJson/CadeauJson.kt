package kabre.m2.sportbrains.TraitementJson

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kabre.m2.sportbrains.Model.Cadeau
import java.io.File
import java.io.FileOutputStream
import java.io.InputStreamReader

class CadeauJson {

    // Charger les données JSON des étoiles
    fun loadCadeauData(context: Context): List<Cadeau> {
        val fileName = "cadeau.json"
        val internalFile = File(context.filesDir, fileName)

        // Si le fichier n'existe pas dans le stockage interne, le copier depuis les assets
        if (!internalFile.exists()) {
            copyAssetToInternalStorage(context, fileName)
        }

        // Charger les données depuis le fichier interne
        val inputStream = internalFile.inputStream()
        val reader = InputStreamReader(inputStream)
        val gson = Gson()
        val type = object : TypeToken<List<Cadeau>>() {}.type
        return gson.fromJson(reader, type)
    }

    // Fonction pour copier le fichier des assets vers le stockage interne
    private fun copyAssetToInternalStorage(context: Context, fileName: String) {
        val assetFile = context.assets.open(fileName)
        val outFile = File(context.filesDir, fileName)
        val outputStream = FileOutputStream(outFile)

        assetFile.use { input ->
            outputStream.use { output ->
                input.copyTo(output)
            }
        }
    }

    // Fonction pour sauvegarder les données JSON dans le stockage interne
    fun saveCadeauData(context: Context, cadeau: List<Cadeau>) {
        val fileName = "nombreBlocStats.json"
        val internalFile = File(context.filesDir, fileName)
        val gson = Gson()
        val jsonString = gson.toJson(cadeau)
        internalFile.writeText(jsonString)
    }
}