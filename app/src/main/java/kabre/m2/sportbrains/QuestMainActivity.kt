package kabre.m2.sportbrains

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kabre.m2.sportbrains.Adaptater.QuestAdaptater
import kabre.m2.sportbrains.Manager.LocaleHelper
import kabre.m2.sportbrains.Manager.MusicManager
import kabre.m2.sportbrains.Model.NombreEtoile
import kabre.m2.sportbrains.Model.QuestModel
import kabre.m2.sportbrains.Model.UserModel
import kabre.m2.sportbrains.TraitementJson.Quest
import kabre.m2.sportbrains.TraitementJson.Stars
import kabre.m2.sportbrains.TraitementJson.User
import kabre.m2.sportbrains.databinding.ActivityQuestMainBinding

class QuestMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuestMainBinding
    private var questList: MutableList<QuestModel> = mutableListOf()  // Liste modifiable des quêtes
    private var user: UserModel? = null  // L'utilisateur actuel

    var etoileList: List<NombreEtoile> = emptyList()

    private val traitementQuest: Quest by lazy { Quest() }
    private val traitementStar: Stars by lazy { Stars() }
    private val userHandler: User by lazy { User() }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase))
    }

    private val questAdapter: QuestAdaptater by lazy { QuestAdaptater { quest: QuestModel ->
        // Logique lors du clic sur un élément
        handleQuestClick(quest)
    } }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        onBackPressedDispatcher.addCallback(this) {
            // Désactive la touche retour
        }
        // Charger les données d'étoiles
        etoileList = traitementStar.loadEtoileData(this, 1)

        // Calculer la somme des étoiles
        val totalStars = etoileList.sumOf { it.NbEtoile }

        // Charger les données utilisateur
        user = userHandler.loadUserData(this)

        // Charger les données JSON depuis le fichier interne ou assets si c'est la première fois
        questList = traitementQuest.loadQuestData(this, user?.score ?: 0, totalStars, user?.scoreDepence ?: 0)?.toMutableList() ?: mutableListOf()

        // Trier les quêtes par status
        val sortedQuest: List<QuestModel> = questList.sortedByDescending { it.status }

        binding.apply {
            backBtn2.setOnClickListener {
                MusicManager.sonClick(context = this@QuestMainActivity)
                navigateToMainActivity()
            }

            questAdapter.differ.submitList(sortedQuest)
            leaderView.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = questAdapter
            }
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
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, ExitActivity::class.java)
        startActivity(intent)
        // Ne pas appeler super.onBackPressed() pour empêcher la fermeture immédiate
    }
    private fun handleQuestClick(quest: QuestModel) {
        when (quest.status) {
            3 -> {
                quest.status = 1  // Changer le status de 3 à 1
                user?.let {
                    userHandler.updateUserScore(it, quest.recompence)  // Ajouter la récompense au score de l'utilisateur
                    userHandler.saveUserDataToInternalStorage(this, it)  // Sauvegarder les nouvelles données utilisateur
                }
                traitementQuest.saveQuestDataToInternalStorage(this, questList) // Sauvegarder les modifications dans le fichier interne
                questAdapter.differ.submitList(questList.sortedByDescending { it.status })
            }
            2 -> {
                navigateToLevelMainActivity()
            }
        }
    }

    private fun navigateToMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun navigateToLevelMainActivity() {
        startActivity(Intent(this, LevelMainActivity::class.java))
        finish()
    }
}
