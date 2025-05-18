package kabre.m2.sportbrains.Manager

import android.content.Context
import android.renderscript.ScriptGroup
import android.util.Log
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration


class BannerAds {
    companion object {
        const val TAG = "BANNER_AD_TAG"
    }

    fun loadBannerAd(context: Context, adView: AdView) {
        // Initialiser Mobile Ads
        MobileAds.initialize(context) {
            Log.d(TAG, "onInitializationComplete")
        }

        // Configuration des appareils de test
        MobileAds.setRequestConfiguration(
            RequestConfiguration.Builder()
                .setTestDeviceIds(listOf("TEST_DEVICE_ID_1", "TEST_DEVICE_ID_2"))
                .build()
        )

        // Créer et charger la demande d'annonce
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)

        // Écouter les événements d'annonces
        adView.adListener = object : AdListener() {
            override fun onAdClosed() {
                Log.d(TAG, "onAdClosed")
            }

            override fun onAdFailedToLoad(error: LoadAdError) {
                Log.d(TAG, "onAdFailedToLoad: $error")
            }

            override fun onAdOpened() {
                Log.d(TAG, "onAdOpened")
            }

            override fun onAdClicked() {
                Log.d(TAG, "onAdClicked")
            }

            override fun onAdImpression() {
                Log.d(TAG, "onAdImpression")
            }
        }
    }
}
