package kabre.m2.sportbrains

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kabre.m2.sportbrains.Adaptater.RewardDayAdapter
import kabre.m2.sportbrains.Manager.LocaleHelper
import kabre.m2.sportbrains.Manager.MusicManager
import kabre.m2.sportbrains.TraitementJson.RewardDayTraitement
import kabre.m2.sportbrains.databinding.ActivityRecompenceQuotidienneBinding

class RecompenceQuotidienneActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecompenceQuotidienneBinding

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecompenceQuotidienneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Plein écran
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        // Bouton retour désactivé
        onBackPressedDispatcher.addCallback(this) {}

        binding.back.setOnClickListener {
            MusicManager.sonClick(this)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        // Charger les données depuis le JSON
        val rewardDayList = RewardDayTraitement().loadRewardDaytData(this)

        if (rewardDayList != null) {
            val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
            recyclerView.layoutManager = GridLayoutManager(this, 3)
            recyclerView.adapter = RewardDayAdapter(this@RecompenceQuotidienneActivity,rewardDayList)
        }

        if (!rewardDayList.isNullOrEmpty()) {
            val lastReward = rewardDayList.last()

            val day7Text = findViewById<TextView>(R.id.day7Text)
            val day7Score = findViewById<TextView>(R.id.day7Score)
            val day7Image = findViewById<ImageView>(R.id.day7Image)

            // Met à jour les valeurs dans le layout
            day7Text.text = getString(R.string.jour)+" ${lastReward.id}"
            day7Score.text = "${lastReward.soccer}"

            // Charger l'image
            val imageResId = resources.getIdentifier(
                lastReward.image.removeSuffix(".png"), "drawable", packageName
            )
            if (imageResId != 0) {
                Glide.with(this).load(imageResId).into(day7Image)
            }

            // Optionnel : modifier l'apparence si le statut est "déjà obtenu"
            val day7Layout = findViewById<LinearLayout>(R.id.day7)
            day7Layout.alpha = if (lastReward.status) 0.5f else 1.0f
        }


    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            window.decorView.systemUiVisibility = (
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                            View.SYSTEM_UI_FLAG_FULLSCREEN or
                            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                            View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                            View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    )
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, ExitActivity::class.java))
    }
}
