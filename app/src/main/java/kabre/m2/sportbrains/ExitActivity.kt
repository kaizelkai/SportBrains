package kabre.m2.sportbrains

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.activity.addCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kabre.m2.sportbrains.Manager.LocaleHelper
import kabre.m2.sportbrains.Manager.MusicManager
import kabre.m2.sportbrains.databinding.ActivityExitBinding
import kabre.m2.sportbrains.databinding.ActivitySplashBinding

class ExitActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExitBinding

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityExitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Plein écran
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        binding.btnCancel.setOnClickListener {
            MusicManager.sonClick(context = this@ExitActivity)
            finish() // Revenir à l'activité précédente
        }

        binding.btnQuit.setOnClickListener {
            MusicManager.sonClick(context = this@ExitActivity)
            MusicManager.stopMusic()
            finishAffinity() // Fermer complètement l'application
        }

        onBackPressedDispatcher.addCallback(this) {
            // Désactive la touche retour
        }
    }


    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            window.decorView.systemUiVisibility = (
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                            or View.SYSTEM_UI_FLAG_FULLSCREEN
                            or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    )
        }
    }
}