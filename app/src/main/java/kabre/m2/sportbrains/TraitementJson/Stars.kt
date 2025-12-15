package kabre.m2.sportbrains.TraitementJson

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kabre.m2.sportbrains.Model.NombreEtoile
import java.io.File
import java.io.FileOutputStream
import java.io.InputStreamReader

class Stars {

    // Charger les données JSON des étoiles
    fun loadEtoileData(context: Context, level:Int): List<NombreEtoile> {
        val fileName = "etoileNiveau${level}.json"
        val internalFile = File(context.filesDir, fileName)

        // Si le fichier n'existe pas dans le stockage interne, le copier depuis les assets
        if (!internalFile.exists()) {
            for (i in 1..6){
                copyAssetToInternalStorage(context, "etoileNiveau${i}.json")
            }
        }

        // Charger les données depuis le fichier interne
        val inputStream = internalFile.inputStream()
        val reader = InputStreamReader(inputStream)
        val gson = Gson()
        val type = object : TypeToken<List<NombreEtoile>>() {}.type
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
    fun saveEtoileData(context: Context, etoileList: List<NombreEtoile>, level:Int) {
        val fileName = "etoileNiveau${level}.json"
        val internalFile = File(context.filesDir, fileName)
        val gson = Gson()
        val jsonString = gson.toJson(etoileList)
        internalFile.writeText(jsonString)
    }
}
