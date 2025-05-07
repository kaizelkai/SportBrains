package kabre.m2.sportbrains

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kabre.m2.sportbrains.Manager.LocaleHelper
import kabre.m2.sportbrains.Manager.MusicManager
import kabre.m2.sportbrains.Model.UserModel
import kabre.m2.sportbrains.TraitementJson.User
import kabre.m2.sportbrains.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var user: UserModel? = null

    private val userHandler: User by lazy { User() }

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

        // Charger les données utilisateur depuis le stockage interne ou `assets`
        user = userHandler.loadUserData(this)

        user?.let {
            // Update name
            binding.nomTxt.text = getString(R.string.hello) + ", ${it.name}"

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