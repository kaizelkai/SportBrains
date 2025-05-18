package kabre.m2.sportbrains
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.media.MediaPlayer
import android.nfc.Tag
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.addCallback
import androidx.annotation.OptIn
import androidx.appcompat.app.AppCompatActivity
import androidx.media3.common.util.Log
import androidx.media3.common.util.UnstableApi
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import kabre.m2.sportbrains.Adaptater.RewardDayAdapter
import kabre.m2.sportbrains.Manager.LocaleHelper
import kabre.m2.sportbrains.Manager.MusicManager
import kabre.m2.sportbrains.Manager.RewardedRecompenceAds
import kabre.m2.sportbrains.Model.RewardDay
import kabre.m2.sportbrains.Model.UserModel
import kabre.m2.sportbrains.TraitementJson.RewardDayTraitement
import kabre.m2.sportbrains.TraitementJson.User
import kabre.m2.sportbrains.databinding.ActivityRecompenceQuotidienneBinding
import java.util.Calendar

class RecompenceQuotidienneActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecompenceQuotidienneBinding
    private lateinit var sharedPreferences: SharedPreferences
    private var rewardDayList: List<RewardDay>? = null
    private var rewardDayAdapter: RewardDayAdapter? = null
    private var lastReward: RewardDay? = null
    private var claimRewardTextView: TextView? = null
    private var nextRewardTimer: CountDownTimer? = null
    private var nextRewardTimeTextView: TextView? = null
    private var btnVideoReward: TextView? = null
    private val PREFS_NAME = "RewardPrefs"
    private val LAST_CLAIMED_DATE_KEY = "lastClaimedDate"
    private var user: UserModel? = null
    private val userHandler: User by lazy { User() }


    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase))
    }

    @OptIn(UnstableApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecompenceQuotidienneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

        // Plein écran
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        user = userHandler.loadUserData(this)

        // Bouton retour désactivé
        onBackPressedDispatcher.addCallback(this) {}

        binding.back.setOnClickListener {
            MusicManager.sonClick(this)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        claimRewardTextView = findViewById(R.id.claimReward)
        nextRewardTimeTextView = findViewById(R.id.nextRewardTime)
        btnVideoReward = findViewById(R.id.btn_video_reward)


        loadRewardData()

        claimRewardTextView?.setOnClickListener {
            MusicManager.sonClick(this)
            claimDailyReward(true)
            MusicManager.coinSon(this)
        }
        btnVideoReward?.setOnClickListener {
            MusicManager.pauseMusic()
            val rewardedAds = RewardedRecompenceAds(this)
            rewardedAds.loadAndShowRewardAds(
                updateClaimButtonState = {
                    updateClaimButtonState()
                },
                claimDailyReward = { isDouble ->
                    claimDailyReward(isDouble)
                }
            )
            MusicManager.startMusic(this)
        }

        updateClaimButtonState()


    }


    private fun loadRewardData() {
        rewardDayList = RewardDayTraitement().loadRewardDaytData(this)

        rewardDayList?.let { list ->
            val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
            recyclerView.layoutManager = GridLayoutManager(this, 3)
            rewardDayAdapter = RewardDayAdapter(this@RecompenceQuotidienneActivity, list.take(6))
            recyclerView.adapter = rewardDayAdapter

            lastReward = list.lastOrNull()

            lastReward?.let { last ->
                val day7Text = findViewById<TextView>(R.id.day7Text)
                val day7Score = findViewById<TextView>(R.id.day7Score)
                val day7Image = findViewById<ImageView>(R.id.day7Image)
                val day7Layout = findViewById<LinearLayout>(R.id.day7)

                day7Text.text = getString(R.string.jour) + " ${last.id}"
                day7Score.text = "${last.soccer}"

                val imageResId = resources.getIdentifier(
                    last.image.removeSuffix(".png"), "drawable", packageName
                )
                if (imageResId != 0) {
                    Glide.with(this).load(imageResId).into(day7Image)
                }
                day7Layout.alpha = if (last.status) 0.5f else 1.0f
            }
        }
    }

    @OptIn(UnstableApi::class)
    private fun claimDailyReward(typeClick: Boolean) {
        val lastClaimedDate = sharedPreferences.getLong(LAST_CLAIMED_DATE_KEY, 0)
        val currentDate = Calendar.getInstance().timeInMillis
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = lastClaimedDate

        val lastClaimedDay = calendar.get(Calendar.DAY_OF_YEAR)
        val currentDay = Calendar.getInstance().get(Calendar.DAY_OF_YEAR)

        if (lastClaimedDate == 0L || currentDay > lastClaimedDay) {
            rewardDayList?.let { list ->
                // Find the first reward that hasn't been claimed (status is false)
                val nextRewardToClaim = list.find { !it.status }

                nextRewardToClaim?.let { reward ->
                    // Update the status to true
                    val updatedList = RewardDayTraitement().updateRewardStatus(this, reward.id, true)
                    updatedList?.let {
                        rewardDayList = it
                        rewardDayAdapter?.updateData(it.take(6))

                        // Update the last reward view if it was the claimed one
                        if (reward.id == lastReward?.id) {
                            findViewById<LinearLayout>(R.id.day7)?.alpha = 0.5f
                            lastReward = reward.copy(status = true)
                        }
                        user?.apply {
                            if (typeClick) {
                                this.score += reward.soccer
                            } else {
                                this.score += (reward.soccer * 3) + 150
                            }
                            userHandler.updateUserData(this@RecompenceQuotidienneActivity, this)
                        }

                        // Save the current date as the last claimed date
                        sharedPreferences.edit().putLong(LAST_CLAIMED_DATE_KEY, currentDate).apply()

                        // You would typically add the 'reward.soccer' to the user's balance here
                        Log.d("RewardClaimed", "Récompense du jour ${reward.id} réclamée: ${reward.soccer}")
                        updateClaimButtonState() // Update button state after claiming
                    }
                } ?: run {
                    // All rewards have been claimed for the initial 7 days
                    Log.d("RewardClaimed", "Toutes les récompenses ont déjà été réclamées.")
                    updateClaimButtonState()
                }
            }
        } else {
            // Reward already claimed today
            Log.d("RewardClaimed", "Récompense déjà réclamée aujourd'hui.")
            updateClaimButtonState()
        }
    }

    private fun updateClaimButtonState() {
        val lastClaimedDate = sharedPreferences.getLong(LAST_CLAIMED_DATE_KEY, 0)
        val currentDate = Calendar.getInstance().timeInMillis
        val calendarLastClaimed = Calendar.getInstance()
        calendarLastClaimed.timeInMillis = lastClaimedDate
        val lastClaimedDay = calendarLastClaimed.get(Calendar.DAY_OF_YEAR)
        val currentDay = Calendar.getInstance().get(Calendar.DAY_OF_YEAR)

        val nextRewardToClaim = rewardDayList?.find { !it.status }

        if (nextRewardToClaim != null && (lastClaimedDate == 0L || currentDay > lastClaimedDay)) {
            claimRewardTextView?.isEnabled = true
            btnVideoReward?.isEnabled = true
            claimRewardTextView?.text = getString(R.string.reclamation_soulignee)
            stopNextRewardTimer()
            nextRewardTimeTextView?.visibility = View.GONE
        } else {
            claimRewardTextView?.isEnabled = false
            btnVideoReward?.isEnabled = false
            claimRewardTextView?.text = getString(R.string.recompense_reclamee)
            startNextRewardTimer()
        }
    }

    private fun startNextRewardTimer() {
        val lastClaimedDate = sharedPreferences.getLong(LAST_CLAIMED_DATE_KEY, 0)
        if (lastClaimedDate > 0) {
            val calendarLastClaimed = Calendar.getInstance()
            calendarLastClaimed.timeInMillis = lastClaimedDate
            calendarLastClaimed.add(Calendar.DAY_OF_YEAR, 1) // Set to the next day

            val currentTime = Calendar.getInstance().timeInMillis
            val timeLeft = calendarLastClaimed.timeInMillis - currentTime

            if (timeLeft > 0) {
                nextRewardTimeTextView?.visibility = View.VISIBLE
                nextRewardTimer = object : CountDownTimer(timeLeft, 1000) {
                    override fun onTick(millisUntilFinished: Long) {
                        val hours = (millisUntilFinished / (1000 * 60 * 60))
                        val minutes = (millisUntilFinished % (1000 * 60 * 60)) / (1000 * 60)
                        val seconds = (millisUntilFinished % (1000 * 60)) / 1000
                        nextRewardTimeTextView?.text = String.format("%02d:%02d:%02d", hours, minutes, seconds)
                    }

                    override fun onFinish() {
                        nextRewardTimeTextView?.visibility = View.GONE
                        updateClaimButtonState() // Re-enable the claim button
                    }
                }.start()
            } else {
                nextRewardTimeTextView?.visibility = View.GONE
                updateClaimButtonState() // Re-enable the claim button if the time has passed
            }
        } else {
            nextRewardTimeTextView?.visibility = View.GONE
        }
    }

    private fun stopNextRewardTimer() {
        nextRewardTimer?.cancel()
        nextRewardTimer = null
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

    override fun onDestroy() {
        super.onDestroy()
        stopNextRewardTimer()
    }

}