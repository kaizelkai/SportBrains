package kabre.m2.sportbrains

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.WindowManager
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import kabre.m2.sportbrains.Manager.LocaleHelper
import kabre.m2.sportbrains.Manager.MusicManager
import kabre.m2.sportbrains.databinding.ActivitySplashBinding

class ActivitySplash : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    private var progressStatus = 0
    private val handler = Handler(Looper.getMainLooper())

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Démarrer la musique de fond
        MusicManager.startMusic(this)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Plein écran
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        onBackPressedDispatcher.addCallback(this) {
            // Désactive la touche retour
        }
        binding.logoAnimation.setAnimation("bible_logo_animation.json")
        binding.logoAnimation.repeatCount = 0 // 0 = une seule fois
        binding.logoAnimation.playAnimation()

        // Démarrer la progression
        startProgressBar()
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
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, ExitActivity::class.java)
        startActivity(intent)
        // Ne pas appeler super.onBackPressed() pour empêcher la fermeture immédiate
    }

    private fun startProgressBar() {
        val progressBar = binding.progressBar
        val icon = binding.progressIcon
        handler.post(object : Runnable {
            override fun run() {
                if (progressStatus <= 96) {
                    progressBar.progress = progressStatus

                    // Calcule la nouvelle position en X
                    val progressBarWidth = progressBar.width
                    val max = progressBar.max
                    val progressRatio = progressStatus.toFloat() / max
                    val newX = progressBar.left + progressBarWidth * progressRatio - icon.width / 2

                    icon.translationX = newX

                    // Rotation continue
                    icon.rotation = icon.rotation + 10f

                    progressStatus += 1
                    handler.postDelayed(this, 30)
                }
                else {
                    // Quand terminé, démarrer l'activité suivante
                    handler.post {
                        val intent = Intent(this@ActivitySplash, MainActivity::class.java) // ou autre activité
                        startActivity(intent)
                        finish()
                    }
                }
            }
        })
    }
}
