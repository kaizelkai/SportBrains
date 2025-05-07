package kabre.m2.sportbrains

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kabre.m2.sportbrains.Adaptater.AvatarAdapter
import kabre.m2.sportbrains.Manager.LocaleHelper
import kabre.m2.sportbrains.Manager.MusicManager
import kabre.m2.sportbrains.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase))
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Plein écran
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        // Empêche retour physique
        onBackPressedDispatcher.addCallback(this) {}

        binding.backButton.setOnClickListener {
            MusicManager.sonClick(context = this@ProfileActivity)
            startActivity(Intent(this, MainActivity::class.java))
        }

        val avatarList = listOf(
            R.drawable.person1,
            R.drawable.person2,
            R.drawable.person3,
            R.drawable.person4,
            R.drawable.person5,
            R.drawable.person6,
            R.drawable.person7,
            R.drawable.person8
        )

        val currentProfileImageResId = getCurrentProfileImageResId()
        val defaultSelectedPosition = avatarList.indexOf(currentProfileImageResId).takeIf { it != -1 } ?: 0

        // Affiche l'image de profil actuelle
        Glide.with(this)
            .load(currentProfileImageResId)
            .circleCrop()
            .into(binding.profileImage)

        // Initialise l’adapter avec la position sélectionnée
        val adapter = AvatarAdapter(this, avatarList, defaultSelectedPosition)
        binding.avatarGrid.adapter = adapter

        // Gère les clics sur les avatars
        binding.avatarGrid.setOnItemClickListener { _, _, position, _ ->
            MusicManager.sonClick(context = this@ProfileActivity)
            val selectedImageRes = avatarList[position]

            Glide.with(this)
                .load(selectedImageRes)
                .circleCrop()
                .into(binding.profileImage)

            adapter.setSelectedPosition(position)
            binding.avatarGrid.invalidateViews()

            // Sauvegarde la sélection
            saveProfileImageResId(selectedImageRes)
        }
    }

    private fun getCurrentProfileImageResId(): Int {
        val prefs = getSharedPreferences("profile", MODE_PRIVATE)
        return prefs.getInt("avatar", R.drawable.person4)
    }

    private fun saveProfileImageResId(resId: Int) {
        val prefs = getSharedPreferences("profile", MODE_PRIVATE)
        prefs.edit().putInt("avatar", resId).apply()
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
