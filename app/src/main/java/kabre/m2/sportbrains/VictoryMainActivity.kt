package kabre.m2.sportbrains

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.activity.addCallback
import com.airbnb.lottie.LottieDrawable
import kabre.m2.sportbrains.Model.NombreEtoile
import kabre.m2.sportbrains.TraitementJson.Stars
import kabre.m2.sportbrains.TraitementJson.User
import kabre.m2.sportbrains.databinding.ActivityVictoryMainBinding
import kabre.m2.sportbrains.Levels.SportLevel1
import kabre.m2.sportbrains.Manager.LocaleHelper
import kabre.m2.sportbrains.Manager.MusicManager
import kabre.m2.sportbrains.Model.QuestionModel

class VictoryMainActivity : AppCompatActivity() {
    lateinit var binding: ActivityVictoryMainBinding

    private val questionAllsList: SportLevel1 = SportLevel1()

    private val traitementUser: User by lazy { User() }
    private val traitementStars: Stars by lazy { Stars() }

    private var nbEtoile = 0
    private var positionLevel = 0
    private var totalScore = 0
    private var nextLev = 0
    private var currentLevels=0

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVictoryMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configuration plein écran
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        onBackPressedDispatcher.addCallback(this) {
            // Désactive la touche retour
        }
        // Récupérer les données depuis l'intent
        totalScore = intent.getIntExtra("Score", 0)
        val correctAnswers = intent.getIntExtra("CorrectAnswers", 0)
        positionLevel = intent.getIntExtra("PositonLevel", 0)
        currentLevels = intent.getIntExtra("CurrentLevel", 0)

        // Mettre à jour les étoiles en fonction des réponses correctes
        updateStars(correctAnswers)

        binding.apply {
            score.text = totalScore.toString()

            lumiere.visibility = View.VISIBLE
            lumiere.playAnimation()
            lumiere.repeatCount = LottieDrawable.INFINITE // Animation en boucle

            suivant.setOnClickListener {
                MusicManager.sonClick(context = this@VictoryMainActivity)
                drirectionNavigation(QuestionMainActivity::class.java, positionLevel+1)
            }

            accueil.setOnClickListener {
                MusicManager.sonClick(context = this@VictoryMainActivity)
                saveProgressAndNavigate(MainActivity::class.java)
            }

             binding.recommencer.setOnClickListener {
                 MusicManager.sonClick(context = this@VictoryMainActivity)
                drirectionNavigation(QuestionMainActivity::class.java, positionLevel)
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
    private fun updateStars(score: Int) {
        nbEtoile = when {
            score == 10 -> 3
            score >= 8 -> 2
            score >= 5 -> 1
            else -> 0
        }

        // Mettre à jour les icônes des étoiles
        val starsImages = listOf(binding.star1, binding.star2, binding.star3)
        for (i in 0 until 3) {
            val imageRes = if (i < nbEtoile) R.drawable.star_l else R.drawable.star_on
            starsImages[i].setImageResource(imageRes)
        }

        // Déterminer le niveau suivant
        nextLev = if (nbEtoile > 0) 1 else 0
    }

    private fun saveProgressAndNavigate(targetActivity: Class<*>) {
        // Sauvegarder la progression de l'utilisateur et des étoiles
        saveEtoilesData()
        saveUserData()

        // Naviguer vers l'activité spécifiée
        startActivity(Intent(this, targetActivity))
        finish()
    }

    private fun drirectionNavigation(targetActivity: Class<*>,positionLevel:Int) {
        saveEtoilesData()
        saveUserData()

        // Récupérer la liste des questions pour le niveau actuel
        val questionList = getQuestionListForLevel(positionLevel)

        // Créer l'intent pour démarrer QuestionMainActivity
        val intent = Intent(this,targetActivity)
        intent.putParcelableArrayListExtra("list", ArrayList(questionList))
        intent.putExtra("PositonLevel", positionLevel)

        // Démarrer QuestionMainActivity
        startActivity(intent)
        finish()
    }

    private fun saveEtoilesData() {
        val etoilesList = traitementStars.loadEtoileData(this,1).toMutableList()
        val currentEtoile = etoilesList.find { it.id == positionLevel }

        // Mettre à jour les étoiles seulement si la nouvelle valeur est supérieure
        if (currentEtoile != null) {
            if (nbEtoile > currentEtoile.NbEtoile) {
                currentEtoile.NbEtoile = nbEtoile
            }
        } else {
            etoilesList.add(NombreEtoile(positionLevel, nbEtoile))
        }

        // Sauvegarder les changements
        traitementStars.saveEtoileData(this, etoilesList, currentLevels)
    }

    private fun saveUserData() {
        val user = traitementUser.loadUserData(this)

        user?.apply {
            score += totalScore
            if (positionLevel < levelPart)
            {
                levelPart = levelPart
            }else{
                levelPart += nextLev
            }

            if (levelPart >= 20) {
                level++
                levelPart = 0 // Réinitialiser levelPart après une montée de niveau
            }

            // Sauvegarder les données utilisateur
            traitementUser.updateUserData(this@VictoryMainActivity, this)
        }
    }

    private fun getQuestionListForLevel(level: Int): List<QuestionModel> {
        return when (level) {
            0 -> questionAllsList.questionListFoot1()
            1 -> questionAllsList.questionListFoot2()
            2 -> questionAllsList.questionListFoot3()
            3 -> questionAllsList.questionListFoot4()
            4 -> questionAllsList.questionListFoot5()
            5 -> questionAllsList.questionListFoot6()
            6 -> questionAllsList.questionListFoot7()
            7 -> questionAllsList.questionListFoot8()
            8 -> questionAllsList.questionListFoot9()
            9 -> questionAllsList.questionListFoot10()
            10 -> questionAllsList.questionListFoot11()
            11 -> questionAllsList.questionListFoot12()
            12 -> questionAllsList.questionListFoot13()
            13 -> questionAllsList.questionListFoot14()
            14 -> questionAllsList.questionListFoot15()
            15 -> questionAllsList.questionListFoot16()
            16 -> questionAllsList.questionListFoot17()
            17 -> questionAllsList.questionListFoot18()
            18 -> questionAllsList.questionListFoot19()
            19 -> questionAllsList.questionListFoot20()
            else -> emptyList()
        }
    }

}
