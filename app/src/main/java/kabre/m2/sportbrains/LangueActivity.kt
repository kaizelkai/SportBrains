package kabre.m2.sportbrains

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kabre.m2.sportbrains.Adaptater.LangueAdapter
import kabre.m2.sportbrains.Manager.LocaleHelper
import kabre.m2.sportbrains.Manager.MusicManager
import kabre.m2.sportbrains.Model.Langue
import kabre.m2.sportbrains.databinding.ActivityLangueBinding

class LangueActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLangueBinding
    private lateinit var adapter: LangueAdapter
    private var langues: List<Langue> = listOf()

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase))
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLangueBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        onBackPressedDispatcher.addCallback(this) {}

        binding.back.setOnClickListener {
            MusicManager.sonClick(context = this@LangueActivity)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        val savedLangCode = LocaleHelper.getLanguage(this)
        val selectedNom = when (savedLangCode) {
            "fr" -> "Français"
            "en" -> "English"
            "es" -> "Español"
            "de" -> "Deutsch"
            else -> "Français"
        }

        langues = listOf(
            Langue("Français", selectedNom == "Français"),
            Langue("English", selectedNom == "English"),
            Langue("Español", selectedNom == "Español"),
            Langue("Deutsch", selectedNom == "Deutsch"),
        )

        adapter = LangueAdapter(langues) { selected ->
            val updatedList = langues.map {
                it.copy(isSelected = it.nom == selected.nom)
            }
            langues = updatedList
            adapter.updateList(updatedList)

            val langCode = when (selected.nom) {
                "Français" -> "fr"
                "English" -> "en"
                "Español" -> "es"
                "Deutsch" -> "de"
                else -> "fr"
            }

            println("langCode: $langCode")
            val context = LocaleHelper.setLocale(this, langCode)

            val intent = Intent(context, LangueActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        binding.leaderView.layoutManager = LinearLayoutManager(this)
        binding.leaderView.adapter = adapter
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, ExitActivity::class.java))
    }
}
