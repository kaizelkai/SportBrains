package kabre.m2.sportbrains.Manager

import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.annotation.OptIn
import androidx.media3.common.util.Log
import androidx.media3.common.util.UnstableApi
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import kabre.m2.sportbrains.R


class RewardedRecompenceAds(private val context: Context) {

    companion object {
        private const val TAG = "REWARDED_AD_TAG"
    }

    private var mRewardedAd: RewardedAd? = null

    fun loadRewardAds() {
        MobileAds.initialize(context) {
            android.util.Log.d(BannerAds.TAG, "onInitializationComplete")
        }

        // Configuration des appareils de test
        MobileAds.setRequestConfiguration(
            RequestConfiguration.Builder()
                .setTestDeviceIds(listOf("TEST_DEVICE_ID_1", "TEST_DEVICE_ID_2"))
                .build()
        )

        RewardedAd.load(
            context,
            context.getString(R.string.rewarded_ad_id_test),
            AdRequest.Builder().build(),
            object : RewardedAdLoadCallback() {
                @OptIn(UnstableApi::class)
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    Log.d(TAG, "onAdFailedToLoad: ${adError.message}")
                    mRewardedAd = null
                }

                @OptIn(UnstableApi::class)
                override fun onAdLoaded(rewardedAd: RewardedAd) {
                    Log.d(TAG, "onAdLoaded")
                    mRewardedAd = rewardedAd
                }
            }
        )
    }

    fun showRewardAds(
        updateClaimButtonState: () -> Unit,
        claimDailyReward: (Boolean) -> Unit
    ) {
        val ad = mRewardedAd
        if (ad != null) {
            ad.fullScreenContentCallback = object : FullScreenContentCallback() {
                @OptIn(UnstableApi::class)
                override fun onAdDismissedFullScreenContent() {
                    Log.d(TAG, "onAdDismissedFullScreenContent")
                    mRewardedAd = null
                    loadRewardAds()
                }

                @OptIn(UnstableApi::class)
                override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                    Log.d(TAG, "onAdFailedToShowFullScreenContent: ${p0.message}")
                    mRewardedAd = null
                }

                @OptIn(UnstableApi::class)
                override fun onAdShowedFullScreenContent() {
                    Log.d(TAG, "onAdShowedFullScreenContent")
                }

                @OptIn(UnstableApi::class)
                override fun onAdImpression() {
                    Log.d(TAG, "onAdImpression")
                }
            }

            ad.show(context as Activity) {
                // Récompense accordée ici
                MusicManager.coinSon(context)
                updateClaimButtonState()
                claimDailyReward(false)
                Toast.makeText(context, "Reward Earned!", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(context, "Ad wasn't loaded!", Toast.LENGTH_SHORT).show()
        }
    }

    fun loadAndShowRewardAds(
        updateClaimButtonState: () -> Unit,
        claimDailyReward: (Boolean) -> Unit
    ) {
        val progressDialog = ProgressDialog(context).apply {
            setTitle(context.getString(R.string.rewarded_titre))
            setMessage(context.getString(R.string.rewarded_message))
            setCanceledOnTouchOutside(false)
            show()
        }

        RewardedAd.load(
            context,
            context.getString(R.string.rewarded_ad_id_test),
            AdRequest.Builder().build(),
            object : RewardedAdLoadCallback() {
                @OptIn(UnstableApi::class)
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    Log.d(TAG, "onAdFailedToLoad: ${adError.message}")
                    mRewardedAd = null
                    progressDialog.dismiss()
                    Toast.makeText(context, "context.getString(R.string.failed)", Toast.LENGTH_SHORT).show()
                }

                @OptIn(UnstableApi::class)
                override fun onAdLoaded(rewardedAd: RewardedAd) {
                    Log.d(TAG, "onAdLoaded")
                    mRewardedAd = rewardedAd
                    progressDialog.dismiss()
                    showRewardAds(updateClaimButtonState, claimDailyReward)
                }
            }
        )
    }
}

