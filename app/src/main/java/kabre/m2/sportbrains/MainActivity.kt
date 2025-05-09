package kabre.m2.sportbrains

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kabre.m2.sportbrains.Manager.LocaleHelper
import kabre.m2.sportbrains.Manager.MusicManager
import kabre.m2.sportbrains.Model.NombreEtoile
import kabre.m2.sportbrains.Model.QuestModel
import kabre.m2.sportbrains.Model.Tache
import kabre.m2.sportbrains.Model.UserModel
import kabre.m2.sportbrains.TraitementJson.Quest
import kabre.m2.sportbrains.TraitementJson.Stars
import kabre.m2.sportbrains.TraitementJson.Taches
import kabre.m2.sportbrains.TraitementJson.User
import kabre.m2.sportbrains.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var user: UserModel? = null

    private val userHandler: User by lazy { User() }

    private val tacheHandler: Taches by lazy { Taches() }
    private  var taches: List<Tache>? = null

    private val questHandler: Quest by lazy { Quest() }
    private  var quest: List<QuestModel>? = null

    var etoileList: List<NombreEtoile> = emptyList()
    private val traitementStar: Stars by lazy { Stars() }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set full screen layout
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        onBackPressedDispatcher.addCallback(this) {
            // Désactive la touche retour
        }


        binding.apply {

            play.onClickOpen(this@MainActivity, LevelMainActivity::class.java)

            quest.onClickOpen(this@MainActivity, QuestMainActivity::class.java)

            shop.onClickOpen(this@MainActivity, Shop::class.java)

            profileImage.onClickOpen(this@MainActivity, ProfileActivity::class.java)

            tacheQuotidien.onClickOpen(this@MainActivity, TacheQuotidienActivity::class.java)

            parametre.onClickOpen(this@MainActivity, ParametreActivity::class.java)

        }

        // Charger les données d'étoiles
        etoileList = traitementStar.loadEtoileData(this, 1)
        // Charger les données utilisateur depuis le stockage interne ou `assets`
        user = userHandler.loadUserData(this)

        user?.let {
            // Update name
            binding.nomTxt.text = getString(R.string.hello) + ", ${it.name}"
            binding.play.text = getString(R.string.niveau) + " " + it.level

            // Load profile image using Glide
            val imageResourceId = it.pic?.let { pic -> getImageResourceId(pic) }
            imageResourceId?.let { resId ->
                Glide.with(this)
                    .load(resId)
                    .into(binding.profileImage)
            }

            // Update score
            binding.currentScore.text = it.score.toString()
        }
        print("User: $user")
        Log.e("User", "$user")
        tacheCompleted()
        questCompleted()

    }

    fun tacheCompleted() {
        // Calculer la somme des étoiles
        val totalStars = etoileList.sumOf { it.NbEtoile }

        // Recharge la liste mise à jour
        val tacheManager = Taches()
        val tache = tacheManager.loadQuestData(this, user?.score ?: 0, totalStars, user?.scoreDepence ?: 0)

        // Vérifie si au moins une tâche est complétée
        val isTacheComplete = tache?.any { it.progress >= it.max && it.statusss } ?: false

        Log.e("Tâche Completed", "Tâche Completed : $isTacheComplete")

        // Affiche ou masque l'animation selon l'état des tâches
        //binding.lottieBackgroundTache.visibility = if (isTacheComplete) View.VISIBLE else View.INVISIBLE

        if (isTacheComplete) {
            binding.lottieBackgroundTache.visibility = View.VISIBLE
            binding.lottieBackgroundTache.playAnimation()
        } else {
            binding.lottieBackgroundTache.visibility = View.INVISIBLE
            binding.lottieBackgroundTache.cancelAnimation()
        }


    }

    fun questCompleted() {
        val totalStars = etoileList.sumOf { it.NbEtoile }
        val userScore = user?.score ?: 0
        val userScoreDepense = user?.scoreDepence ?: 0

        quest = questHandler.loadQuestData(this, userScore, totalStars, userScoreDepense)?.toMutableList()
            ?: mutableListOf()

        // Debug log
        quest!!.forEach {
            Log.d("QuestCheck", "Tâche: ${it.nom}, status=${it.statusss}, current=${it.progress}, total=${it.max}")
        }

        // Recharge la liste mise à jour
        val questManager = Quest()
        val quest = questManager.loadQuestData(this, user?.score ?: 0, totalStars, user?.scoreDepence ?: 0)

        // Vérifie si au moins une tâche est complétée
        val isTacheComplete = quest?.any { it.progress >= it.max && it.statusss } ?: false

        Log.e("Tâche Completed", "Tâche Completed : $isTacheComplete")

        if (isTacheComplete) {
            binding.lottieBackgroundQuest.visibility = View.VISIBLE
            binding.lottieBackgroundQuest.playAnimation()
        } else {
            binding.lottieBackgroundQuest.visibility = View.INVISIBLE
            binding.lottieBackgroundQuest.cancelAnimation()
        }

    }

    fun View.onClickOpen(context: Context, target: Class<*>) {
        setOnClickListener {
            MusicManager.sonClick(context)
            context.startActivity(Intent(context, target))
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

    // Fonction pour obtenir l'ID de la ressource d'image par son nom
    private fun getImageResourceId(imageName: String): Int {
        return resources.getIdentifier(imageName, "drawable", packageName)
    }

}