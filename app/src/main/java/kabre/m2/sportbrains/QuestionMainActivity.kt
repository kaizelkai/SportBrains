package kabre.m2.sportbrains

import android.app.Dialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import androidx.activity.addCallback
import androidx.core.view.isInvisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import kabre.m2.sportbrains.Adaptater.QuestionAdapter
import kabre.m2.sportbrains.Manager.BannerAds
import kabre.m2.sportbrains.Manager.LocaleHelper
import kabre.m2.sportbrains.Model.NombreBlocStats
import kabre.m2.sportbrains.Model.QuestionModel
import kabre.m2.sportbrains.Model.ShopItem
import kabre.m2.sportbrains.Model.UserModel
import kabre.m2.sportbrains.TraitementJson.NumberBlocStats
import kabre.m2.sportbrains.TraitementJson.User
import kabre.m2.sportbrains.databinding.ActivityQuestionMainBinding

class QuestionMainActivity : AppCompatActivity(), QuestionAdapter.Score {
    lateinit var binding: ActivityQuestionMainBinding
    var position: Int = 0
    var receivedList: MutableList<QuestionModel> = mutableListOf()
    var allScore = 0
    var correctAnswersCount = 0  // Variable pour compter les bonnes réponses
    var positionLevel=0
    var currentLevels=0
    lateinit var questionAdapter: QuestionAdapter

    var clickPosition: Int = 0

    private var user: UserModel? = null

    private var numberBlocStats: List<NombreBlocStats> = emptyList()
    private val blocStats: NumberBlocStats by lazy { NumberBlocStats() }

    private val userHandler: User by lazy { User() }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        onBackPressedDispatcher.addCallback(this) {
            // Désactive la touche retour
        }
        positionLevel = intent.getIntExtra("PositonLevel", 0)
        currentLevels = intent.getIntExtra("CurrentLevel", 0)

        receivedList = intent.getParcelableArrayListExtra<QuestionModel>("list")!!.toMutableList()

        binding.apply {

            clickPosition = intent.getIntExtra("ClickPosition", 0)

            progressBar.progress = 1

            updateQuestion()
            rightArrow?.isEnabled = false
            leftArrow?.isEnabled = false
            rightArrow.visibility = View.INVISIBLE
            leftArrow.visibility = View.INVISIBLE
            rightArrow.setOnClickListener {
                !questionAdapter.isNext()
                if (progressBar.progress == 10) {
                    val intent = Intent(this@QuestionMainActivity, VictoryMainActivity::class.java)
                    intent.putExtra("Score", allScore)
                    intent.putExtra("CorrectAnswers", correctAnswersCount)  // Passe le nombre de bonnes réponses
                    startActivity(intent)
                    finish()
                } else {
                    position++
                    progressBar.progress += 1
                    questionNumberTxt.text = "Question ${progressBar.progress}/10"
                    updateQuestion()
                }
                !questionAdapter.isNext()
            }

            leftArrow.setOnClickListener {
                !questionAdapter.isNext()
                if (progressBar.progress > 1) {
                    position--
                    progressBar.progress -= 1
                    questionNumberTxt.text = "Question ${progressBar.progress}/10"
                    updateQuestion()
                }
                !questionAdapter.isNext()
            }

            reponceCorrect.setOnClickListener {
                val validechoix = 150
                val validechoix2 = currentScore.text.toString().toIntOrNull()
                if (validechoix2 != null) {
                    if (validechoix2 >= validechoix!!) {
                        saveUserData(150)
                        showReponceCorrect(0)
                    }
                }
            }

            statBt.setOnClickListener {
                val validechoix = 100
                val validechoix2 = currentScore.text.toString().toIntOrNull()
                if (validechoix2 != null) {
                    if (validechoix2 >= validechoix!!) {
                        saveUserData(100)
                        showStatBt(0)
                    }
                }
            }


            demipanel.setOnClickListener {
                val validechoix = 50
                val validechoix2 = currentScore.text.toString().toIntOrNull()
                if (validechoix2 != null) {
                    if (validechoix2 >= validechoix){
                        saveUserData(50)
                        showDemiPanel(0)
                    }
                }
            }

            backButton.setOnClickListener {
                val intent = Intent(this@QuestionMainActivity, PauseMenu::class.java)
                startActivity(intent)
            }
        }

        // Charger les données utilisateur depuis le stockage interne ou `assets`
        user = userHandler.loadUserData(this)

        user?.let {
            // Update score
            binding.currentScore.text = it.score.toString()
            binding.level.text = getString(R.string.niveau) + " " + it.level
        }

        numberBlocStats = blocStats.loadNumberBlocStatsData(this)

        // Récupérer chaque type de boost dans la liste
        val demiBoost = numberBlocStats.firstOrNull { it.type == "demi" }
        val correctBoost = numberBlocStats.firstOrNull { it.type == "correct" }
        val statBoost = numberBlocStats.firstOrNull { it.type == "stat" }

        demiBoost?.let {
            if (it.nombre == 0) {
                binding.demipanelNbPrix.visibility = View.VISIBLE
                binding.demipanelNb.visibility = View.GONE
            } else {
                binding.demipanelNbPrix.visibility = View.GONE
                binding.demipanelNb.text = it.nombre.toString()
                binding.demipanelNb.visibility = View.VISIBLE
            }
        }

        correctBoost?.let {
            if (it.nombre == 0) {
                binding.reponceCorrectNbPrix.visibility = View.VISIBLE
                binding.reponceCorrectNb.visibility = View.GONE
            } else {
                binding.reponceCorrectNbPrix.visibility = View.GONE
                binding.reponceCorrectNb.text = it.nombre.toString()
                binding.reponceCorrectNb.visibility = View.VISIBLE
            }
        }

        statBoost?.let {
            if (it.nombre == 0) {
                binding.statBtNbPrix.visibility = View.VISIBLE
                binding.statBtNb.visibility = View.GONE
            } else {
                binding.statBtNbPrix.visibility = View.GONE
                binding.statBtNb.text = it.nombre.toString()
                binding.statBtNb.visibility = View.VISIBLE
            }
        }
        val bannerAds = BannerAds()
        bannerAds.loadBannerAd(this, binding.bannerAd)

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
    private fun saveUserData(prix: Int) {
        val user = userHandler.loadUserData(this)

        user?.apply {
            score -= prix
            binding.currentScore.text = this.score.toString()
            // Sauvegarder les données utilisateur
            userHandler.updateUserData(this@QuestionMainActivity, this)
        }
    }
    private fun showReponceCorrect(nombre: Int) {
        // Crée la boîte de dialogue
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.reponse_corect_panel)

        // Configure `currentScore` pour afficher le prix
        val currentScoreTextView = dialog.findViewById<TextView>(R.id.currentResp)
        currentScoreTextView.text = nombre.toString()

        dialog.show()
    }

    private fun showDemiPanel(nombre: Int) {
        // Crée la boîte de dialogue
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.demi_reponse_panel)

        // Configure `currentScore` pour afficher le prix

        val currentResp1 = dialog.findViewById<TextView>(R.id.currentResp1)
        val currentResp2 = dialog.findViewById<TextView>(R.id.currentResp2)
        currentResp1.text = nombre.toString()
        currentResp2.text = nombre.toString()

        dialog.show()
    }

    private fun showStatBt(nombre: Int) {
        // Crée la boîte de dialogue
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.statistique_panel)

        dialog.show()
    }
    fun updateQuestion() {
        binding.questionTxt.text = receivedList[position].question
        //val drawableResourceId: Int = binding.root.resources.getIdentifier(
        //    receivedList[position].picPath,
        //    "drawable",
         //   binding.root.context.packageName
        //)
        //Glide.with(this@QuestionMainActivity)
         //   .load(drawableResourceId)
          //  .centerCrop()
           // .apply(RequestOptions.bitmapTransform(RoundedCorners(60)))
            //.into(binding.pic)
        loadAnswers()
    }

    private fun loadAnswers() {
        val users: MutableList<String> = mutableListOf()
        receivedList[position].answer_1?.let { users.add(it) }
        receivedList[position].answer_2?.let { users.add(it) }
        receivedList[position].answer_3?.let { users.add(it) }
        receivedList[position].answer_4?.let { users.add(it) }

        if (receivedList[position].clikedAnswer != null) users.add(receivedList[position].clikedAnswer!!)

        questionAdapter = QuestionAdapter(receivedList[position].correctAnswer!!, users, this, this)
        questionAdapter.differ.submitList(users)
        binding.questionList.apply {
            layoutManager = LinearLayoutManager(this@QuestionMainActivity)
            adapter = questionAdapter
        }
    }

    override fun amount(number: Int, clickedAnswer: String) {
        allScore += number
        receivedList[position].clikedAnswer = clickedAnswer

        // Si la réponse est correcte (score > 0), incrémente correctAnswersCount
        if (number > 0) {
            correctAnswersCount++
        }
    }
}
