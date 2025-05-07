package kabre.m2.sportbrains

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kabre.m2.sportbrains.Adaptater.TacheAdapter
import kabre.m2.sportbrains.Manager.LocaleHelper
import kabre.m2.sportbrains.Manager.MusicManager
import kabre.m2.sportbrains.Model.NombreEtoile
import kabre.m2.sportbrains.Model.Tache
import kabre.m2.sportbrains.Model.UserModel
import kabre.m2.sportbrains.TraitementJson.Stars
import kabre.m2.sportbrains.TraitementJson.Taches
import kabre.m2.sportbrains.TraitementJson.User
import kabre.m2.sportbrains.databinding.ActivityTacheQuotidienBinding
import java.io.File

class TacheQuotidienActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTacheQuotidienBinding
    private var completedTasks = 0
    private var currentCoin = 0
    private var user: UserModel? = null
    private val userManager: User by lazy { User() }

    var etoileList: List<NombreEtoile> = emptyList()
    private val tacheManager: Taches by lazy { Taches() }
    private val traitementStar: Stars by lazy { Stars() }
    private lateinit var tacheList: MutableList<Tache>

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTacheQuotidienBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        onBackPressedDispatcher.addCallback(this) {}

        user = userManager.loadUserData(this)
        user?.let {
            currentCoin = it.score
            binding.currentScore.text = currentCoin.toString()
        }
        // Charger les données d'étoiles
        etoileList = traitementStar.loadEtoileData(this, 1)

        // Calculer la somme des étoiles
        val totalStars = etoileList.sumOf { it.NbEtoile }
        // Charger les données JSON depuis le fichier interne ou assets si c'est la première fois
        tacheList = tacheManager.loadQuestData(this, user?.score ?: 0, totalStars, user?.scoreDepence ?: 0)?.toMutableList() ?: mutableListOf()

        val tacheSize = tacheList.size
        binding.taskMainProgress.max = 13
        binding.taskMainProgressText.text = "${13-tacheSize} / 13"
        binding.taskMainProgress.progress = 13-tacheSize
        if (tacheSize==0){
            binding.taskMainTitle.text = getString(R.string.Bravo)
            binding.taskMainProgressText.text = "13 / 13"
        }

        binding.leaderView.layoutManager = LinearLayoutManager(this)
        binding.leaderView.adapter = TacheAdapter(
            tacheList,
            onTacheCompleted = { completed ->
                completedTasks += completed
                binding.taskMainProgressText.text = "$completedTasks / 13"
                binding.taskMainProgress.progress = completedTasks

                if (completedTasks == 13) {
                    binding.taskMainTitle.text = getString(R.string.Bravo)
                    binding.currentScore.text = currentCoin.toString()
                    currentCoin+=100
                    saveUserData()
                }
            },
            recompense = { recompenseAjoute ->
                currentCoin += recompenseAjoute
                binding.currentScore.text = currentCoin.toString()
                saveUserData()
            },
            context = this
        )

        binding.backButton.setOnClickListener {
            MusicManager.sonClick(context = this)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    private fun saveUserData() {
        user?.apply {
            score = currentCoin
            userManager.updateUserData(this@TacheQuotidienActivity, this)
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
