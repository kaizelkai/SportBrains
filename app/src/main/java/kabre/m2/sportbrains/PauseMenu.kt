package kabre.m2.sportbrains

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import androidx.activity.addCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kabre.m2.sportbrains.Manager.LocaleHelper
import kabre.m2.sportbrains.Manager.MusicManager
import kabre.m2.sportbrains.databinding.ActivityParametreBinding
import kabre.m2.sportbrains.databinding.ActivityPauseMenuBinding

class PauseMenu : AppCompatActivity() {
    private lateinit var binding: ActivityPauseMenuBinding
    private lateinit var musicIcon: ImageView
    private lateinit var sonIcon: ImageView
    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPauseMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set full screen layout
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        onBackPressedDispatcher.addCallback(this) {}

        musicIcon = binding.music  // Initialize the music icon ImageView.
        sonIcon = binding.son

        // Initialize the music icon
        MusicManager.updateMusicIcon(musicIcon)
        MusicManager.updateSonIcon(sonIcon)

        binding.apply {
            back.setOnClickListener {
                MusicManager.sonClick(this@PauseMenu)
                finish()
            }

            music.setOnClickListener {
                MusicManager.sonClick(this@PauseMenu)
                MusicManager.toggleMute()
                MusicManager.updateMusicIcon(musicIcon) // Update icon when muted/unmuted
            }

            son.setOnClickListener {
                MusicManager.sonClick(this@PauseMenu)
                MusicManager.toggleSonMute()
                MusicManager.updateSonIcon(sonIcon) // Update icon when muted/unmuted
            }

            home.setOnClickListener {
                MusicManager.sonClick(this@PauseMenu)
                val intent = Intent(this@PauseMenu, MainActivity::class.java)
                startActivity(intent)
                finish()
            }

        }
    }

    override fun onResume() {
        super.onResume()
        MusicManager.updateMusicIcon(musicIcon) //update the music icon
    }

    override fun onDestroy() {
        //binding.bannerAd.destroy()
        super.onDestroy()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, ExitActivity::class.java)
        startActivity(intent)
        // Ne pas appeler super.onBackPressed() pour empêcher la fermeture immédiate
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