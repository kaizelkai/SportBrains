package kabre.m2.sportbrains.Manager

import android.app.Application
import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View

class MyApplication : Application(), Application.ActivityLifecycleCallbacks {

    private var activityCount = 0
    private var isInBackground = false

    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(this)
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

    // Les autres peuvent rester vides
    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {}
    override fun onActivityResumed(activity: Activity) {}
    override fun onActivityPaused(activity: Activity) {}
    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}
    override fun onActivityDestroyed(activity: Activity) {}
}
