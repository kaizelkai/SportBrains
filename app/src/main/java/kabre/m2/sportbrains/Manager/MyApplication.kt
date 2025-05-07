package kabre.m2.sportbrains.Manager

import android.app.Application
import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import java.time.LocalDate

class MyApplication : Application(), Application.ActivityLifecycleCallbacks {

    private var activityCount = 0
    private var isInBackground = false

    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(this)

        // Réinitialisation des progrès si nécessaire dès le lancement
        //resetProgressIfNeeded()
    }

    override fun onActivityStarted(activity: Activity) {
        activityCount++
        if (isInBackground) {
            // L’utilisateur revient dans l’appli
            MusicManager.resumeMusic()
            isInBackground = false
        }
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        if (level == TRIM_MEMORY_UI_HIDDEN) {
            // L'utilisateur a quitté l'application (mise en arrière-plan)
            Log.d("MyApplication", "App en arrière-plan, pause musique")
            MusicManager.pauseMusic()
        }
    }

    override fun onTerminate() {
        super.onTerminate()
        Log.d("MyApplication", "App terminée, arrêt musique")
        MusicManager.stopMusic()
    }

    override fun onActivityStopped(activity: Activity) {
        activityCount--
        if (activityCount == 0) {
            // Plus d’activité visible = appli en arrière-plan
            isInBackground = true
            MusicManager.pauseMusic()
        }
    }

    private fun resetProgressIfNeeded() {
        val prefs = getSharedPreferences("questPrefs", Context.MODE_PRIVATE)
        val lastResetDate = prefs.getString("last_reset_date", "")
        val today = LocalDate.now().toString()

        if (lastResetDate != today) {
            Log.d("MyApplication", "Réinitialisation des progressions (nouvelle journée)")
            QuestRepository.resetAllProgress(applicationContext)
            prefs.edit().putString("last_reset_date", today).apply()
        }
    }


    // Les autres peuvent rester vides
    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {}
    override fun onActivityResumed(activity: Activity) {}
    override fun onActivityPaused(activity: Activity) {}
    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}
    override fun onActivityDestroyed(activity: Activity) {}
}
