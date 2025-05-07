package kabre.m2.sportbrains

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import kabre.m2.sportbrains.Adaptater.ShopAdaptater
import kabre.m2.sportbrains.Manager.LocaleHelper
import kabre.m2.sportbrains.Manager.MusicManager
import kabre.m2.sportbrains.Model.ShopItem
import kabre.m2.sportbrains.Model.UserModel
import kabre.m2.sportbrains.TraitementJson.User
import kabre.m2.sportbrains.databinding.ActivityShopBinding

class Shop : AppCompatActivity() {
    private lateinit var binding: ActivityShopBinding

    private var user: UserModel? = null

    private val userHandler: User by lazy { User() }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShopBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configuration plein écran
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        onBackPressedDispatcher.addCallback(this) {
            // Désactive la touche retour
        }
        binding.backBtn2.setOnClickListener {
            MusicManager.sonClick(context = this@Shop)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        // Liste d'éléments pour la boutique
        val shopItems = listOf(
            ShopItem(0,R.drawable.garnet, 50, 1, 0.0,"Gratuit"),
            ShopItem(1,R.drawable.garnet, 180, 0, 0.99, ""),
            ShopItem(2,R.drawable.garnet, 400, 10, 1.99, ""),
            ShopItem(3,R.drawable.garnet, 700, 15, 5.99,""),
            ShopItem(4,R.drawable.garnet, 1500, 20, 9.99,""),
            ShopItem(5,R.drawable.garnet, 4000, 25, 19.99,""),
            ShopItem(6,R.drawable.garnet, 10000, 30, 49.99,""),
            ShopItem(7,R.drawable.garnet, 50000, 35, 99.99,""),
            ShopItem(8,R.drawable.garnet, 1000000, 55, 499.99,""),
            // Ajoutez d'autres items si nécessaire
        )

        // Initialisation de la RecyclerView avec ShopAdapter
        binding.recyclerView1.apply {
            layoutManager = GridLayoutManager(this@Shop, 2)
            adapter = ShopAdaptater(this@Shop, shopItems) { clickedPosition ->
                // Action lors du clic sur un élément
                // Log.d("ShopActivity", "Item $clickedPosition clicked.")
            }
        }

        user = userHandler.loadUserData(this)

        user?.let {
            // Update score
            binding.currentScore.text = it.score.toString()
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
}
