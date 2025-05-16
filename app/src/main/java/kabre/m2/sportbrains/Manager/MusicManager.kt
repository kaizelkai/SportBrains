package kabre.m2.sportbrains.Manager

import android.animation.Animator
import android.content.Context
import android.media.MediaPlayer
import android.widget.ImageView
import kabre.m2.sportbrains.R

object MusicManager {

    private var mediaPlayer: MediaPlayer? = null
    private lateinit var mediaPlayerSon: MediaPlayer
    private lateinit var coinRSon: MediaPlayer
    var isSonMuted: Boolean = false
        private set
    var isMuted: Boolean = false
        private set

    private var currentContext: Context? = null

    fun sonClick(context: Context) {
        if (!isSonMuted) { // Check if sound effects are muted
            mediaPlayerSon = MediaPlayer.create(context, R.raw.click)
            mediaPlayerSon.start()
        }
    }

    fun coinSon(context: Context) {
        if (!isSonMuted) { // Check if sound effects are muted
            coinRSon = MediaPlayer.create(context, R.raw.coins)
            coinRSon.start()
        }
    }

    fun startMusic(context: Context) {
        currentContext = context
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(context.applicationContext, R.raw.all_music)
            mediaPlayer?.isLooping = true
        }
        if (!isMuted) {
            mediaPlayer?.start()
        }
    }

    fun pauseMusic() {
        if (!isMuted) mediaPlayer?.pause()
    }

    fun resumeMusic() {
        if (!isMuted) mediaPlayer?.start()
    }

    fun stopMusic() {
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
        currentContext = null
    }

    fun toggleMute() {
        isMuted = !isMuted
        if (isMuted) {
            mediaPlayer?.pause()
        } else {
            mediaPlayer?.start()
        }
    }

    fun toggleSonMute() {
        isSonMuted = !isSonMuted
    }

    // Function to update the music icon
    fun updateMusicIcon(imageView: ImageView) {
        imageView.setImageResource(if (isMuted) R.drawable.ic_music_off else R.drawable.ic_music)
    }

    fun updateSonIcon(imageView: ImageView) {
        imageView.setImageResource(if (isSonMuted) R.drawable.ic_volume_off else R.drawable.ic_volume_up)
    }

}
