package kabre.m2.sportbrains

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import androidx.activity.addCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration
import kabre.m2.sportbrains.Manager.BannerAds
import kabre.m2.sportbrains.Manager.LocaleHelper
import kabre.m2.sportbrains.Manager.MusicManager
import kabre.m2.sportbrains.databinding.ActivityMainBinding
import kabre.m2.sportbrains.databinding.ActivityParametreBinding

class ParametreActivity : AppCompatActivity() {
    private lateinit var binding: ActivityParametreBinding
    private lateinit var musicIcon: ImageView
    private lateinit var sonIcon: ImageView

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityParametreBinding.inflate(layoutInflater)
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
                MusicManager.sonClick(this@ParametreActivity)
                val intent = Intent(this@ParametreActivity, MainActivity::class.java)
                startActivity(intent)
            }

            music.setOnClickListener {
                MusicManager.sonClick(this@ParametreActivity)
                MusicManager.toggleMute()
                MusicManager.updateMusicIcon(musicIcon) // Update icon when muted/unmuted
            }

            son.setOnClickListener {
                MusicManager.sonClick(this@ParametreActivity)
                MusicManager.toggleSonMute()
                MusicManager.updateSonIcon(sonIcon) // Update icon when muted/unmuted
            }
            language.setOnClickListener {
                MusicManager.sonClick(this@ParametreActivity)
                val intent = Intent(this@ParametreActivity, LangueActivity::class.java)
                startActivity(intent)
            }
        }

        val bannerAds = BannerAds()
        bannerAds.loadBannerAd(this, binding.bannerAd)

        /*MobileAds.initialize(this) {
            Log.d(TAG, "onInitializationComplete")
        }

        MobileAds.setRequestConfiguration(
            RequestConfiguration.Builder()
                .setTestDeviceIds(listOf("PACE TEST DEVICE ID 1 HERE","PACE TEST DEVICE ID 2 HERE"))
                .build()
        )

        val adRequest = AdRequest.Builder().build()
        binding.bannerAd.loadAd(adRequest)

        binding.bannerAd.adListener = object : AdListener() {
            override fun onAdClosed() {
                super.onAdClosed()
                Log.d(TAG,"onAdClosed: ")
            }

            override fun onAdFailedToLoad(p0: LoadAdError) {
                super.onAdFailedToLoad(p0)
                Log.d(TAG,"onAdFailedToLoad: $p0")
            }

            override fun onAdOpened() {
                super.onAdOpened()
                Log.d(TAG,"onAdOpened: ")
            }

            override fun onAdClicked() {
                super.onAdClicked()
                Log.d(TAG,"onAdClicked: ")
            }

            override fun onAdImpression() {
                super.onAdImpression()
                Log.d(TAG,"onAdImpression: ")
            }
        }
        */
    }

    override fun onResume() {
        super.onResume()
        MusicManager.updateMusicIcon(musicIcon) //update the music icon
    }

    override fun onDestroy() {
        binding.bannerAd.destroy()
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