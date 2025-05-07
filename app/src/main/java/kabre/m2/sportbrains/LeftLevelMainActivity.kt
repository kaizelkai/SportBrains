package kabre.m2.sportbrains

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.activity.addCallback
import androidx.recyclerview.widget.GridLayoutManager
import kabre.m2.sportbrains.Adaptater.LevelAdaptater
import kabre.m2.sportbrains.Manager.LocaleHelper
import kabre.m2.sportbrains.Manager.MusicManager
import kabre.m2.sportbrains.Model.Niveau
import kabre.m2.sportbrains.Model.NombreEtoile
import kabre.m2.sportbrains.Model.UserModel
import kabre.m2.sportbrains.TraitementJson.Levels
import kabre.m2.sportbrains.TraitementJson.Stars
import kabre.m2.sportbrains.TraitementJson.User
import kabre.m2.sportbrains.databinding.ActivityLeftLevelMainBinding
import kabre.m2.sportbrains.databinding.ActivityLevelMainBinding

class LeftLevelMainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLeftLevelMainBinding
    private var user: UserModel? = null

    private val traitementUser: User by lazy { User() }
    private val traitementStar: Stars by lazy { Stars() }
    private val traitementNiveau: Levels by lazy { Levels() }

    var niveau: List<Niveau> = emptyList()
    var etoileList: List<NombreEtoile> = emptyList()
    private var nextAvailableLevel = 0
    var totalLevels=0
    var currentLevels=0
    var valideNext=0

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLeftLevelMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Plein écran
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        onBackPressedDispatcher.addCallback(this) {
            // Désactive la touche retour
        }
        currentLevels = intent.getIntExtra("CurrentLevel", 0)

        // Gestion du bouton retour
        binding.backBtn.setOnClickListener {
            MusicManager.sonClick(context = this@LeftLevelMainActivity)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        binding.leftLevelArrow.setOnClickListener{
            MusicManager.sonClick(context = this@LeftLevelMainActivity)
            val intent = Intent(this, LevelMainActivity::class.java)
            intent.putExtra("CurrentLevel", currentLevels-1)
            startActivity(intent)
            finish()
        }
        binding.rightLevelArrow.setOnClickListener{
            MusicManager.sonClick(context = this@LeftLevelMainActivity)
            val intent = Intent(this, RightLevelMainActivity::class.java)
            intent.putExtra("CurrentLevel", currentLevels+1)
            startActivity(intent)
            finish()
        }
        if (valideNext==1)
        {
            binding.rightLevelArrow.visibility= View.GONE
        }
        if (currentLevels==1)
        {
            binding.leftLevelArrow.visibility= View.GONE
        }
        niveau = traitementNiveau.loadEtoileData(this)


        // Charger les données utilisateur depuis le stockage interne ou `assets`
        user = traitementUser.loadUserData(this)
        user?.let {
            val currentLevel = niveau.find {niveauLevel ->
                if (currentLevels != 0){
                    niveauLevel.level == currentLevels
                }else{
                    niveauLevel.level == it.level
                }
            }
            currentLevel?.let {max ->
                if ( it.level <= currentLevels ){
                    valideNext=1
                }
                binding.niveau.text = getString(R.string.niveau) + " ${currentLevels}"
                nextAvailableLevel = it.levelPart
                totalLevels = max.maxLevelPart
            }

        }


        val quizList = (1..totalLevels).map { it.toString() }

        // Charger les données d'étoiles
        etoileList = traitementStar.loadEtoileData(this, currentLevels)

        // Calculer la somme des étoiles
        val totalStars = etoileList.sumOf { it.NbEtoile }

        // Mise à jour des TextViews
        binding.allStar.text = (totalLevels * 3).toString()  // Total possible d'étoiles
        binding.currentStar.text = totalStars.toString()  // Étoiles actuelles

        // Initialisation de la RecyclerView avec les niveaux
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(this@LeftLevelMainActivity, 4)
            adapter = LevelAdaptater(quizList, this@LeftLevelMainActivity, nextAvailableLevel, etoileList,currentLevels) { clickedPosition ->
                // Action lors du clic sur un niveau (peut être modifié selon votre logique)
                // Log.d("LevelMainActivity", "Niveau $clickedPosition cliqué.")
            }
        }
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