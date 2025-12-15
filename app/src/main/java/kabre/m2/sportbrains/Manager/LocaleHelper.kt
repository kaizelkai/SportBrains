package kabre.m2.sportbrains.Manager

import android.content.Context
import android.content.res.Configuration
import android.preference.PreferenceManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kabre.m2.sportbrains.Model.Tache
import java.io.File
import java.util.*

object LocaleHelper {
    private const val SELECTED_LANGUAGE = "Locale.Helper.Selected.Language"

    fun setLocale(context: Context, language: String): Context {
        persist(context, language)
        return updateResources(context, language)
    }

    fun onAttach(context: Context): Context {
        val lang = getPersistedData(context, Locale.getDefault().language)
        return setLocale(context, lang)
    }

    private fun getPersistedData(context: Context, defaultLanguage: String): String {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        return preferences.getString(SELECTED_LANGUAGE, defaultLanguage) ?: defaultLanguage
    }

    private fun persist(context: Context, language: String) {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        preferences.edit().putString(SELECTED_LANGUAGE, language).apply()
    }

    private fun updateResources(context: Context, language: String): Context {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val config = Configuration(context.resources.configuration)
        config.setLocale(locale)
        return context.createConfigurationContext(config)
    }

    fun getLanguage(context: Context): String {
        return getPersistedData(context, Locale.getDefault().language)
    }
}

object QuestRepository {

    private const val FILE_NAME = "quests.json"

    fun resetAllProgress(context: Context) {
        val file = File(context.filesDir, FILE_NAME)
        if (!file.exists()) return

        val json = file.readText()
        val gson = Gson()
        val type = object : TypeToken<List<Tache>>() {}.type
        val quests: List<Tache> = gson.fromJson(json, type)

        // Réinitialiser le progrès
        val resetQuests = quests.map {
            it.copy(progress = 0)
        }

        // Réécrire dans le fichier
        file.writeText(gson.toJson(resetQuests))
    }
}

