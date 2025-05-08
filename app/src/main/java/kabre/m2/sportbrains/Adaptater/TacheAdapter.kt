package kabre.m2.sportbrains.Adaptater

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Context
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.view.animation.DecelerateInterpolator
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import kabre.m2.sportbrains.Model.Tache
import kabre.m2.sportbrains.R
import java.io.OutputStreamWriter

class TacheAdapter(
    private val jsonFileName: String,
    private val tacheList: MutableList<Tache>,
    private val onTacheCompleted: (Int) -> Unit,
    private val recompense: (Int) -> Unit,
    private val context: Context
) : RecyclerView.Adapter<TacheAdapter.TacheViewHolder>() {

    inner class TacheViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textFaith: TextView = view.findViewById(R.id.text_faith)
        val progressFaith: ProgressBar = view.findViewById(R.id.progress_faith)
        val textScore: TextView = view.findViewById(R.id.text_score)
        val iconGift: ImageView = view.findViewById(R.id.icon_gift1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TacheViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.viewholder_taches_quotidien, parent, false)
        return TacheViewHolder(view)
    }

    override fun onBindViewHolder(holder: TacheViewHolder, position: Int) {
        val tache = tacheList[position]
        val questName = context.getString(
            context.resources.getIdentifier(tache.nom, "string", context.packageName)
        )
        holder.textFaith.text = questName
        holder.progressFaith.max = tache.max
        holder.textScore.text = "${tache.progress}/${tache.max}"

        val progressAnim = ObjectAnimator.ofInt(holder.progressFaith, "progress", 0, tache.progress)
        progressAnim.duration = 1500
        progressAnim.interpolator = DecelerateInterpolator()

        progressAnim.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {}
            override fun onAnimationEnd(animation: Animator) {
                val pos = holder.adapterPosition
                if (pos != RecyclerView.NO_POSITION) {
                    val currentTache = tacheList[pos]
                    if (currentTache.progress >= currentTache.max) {
                        holder.itemView.startAnimation(AnimationUtils.loadAnimation(context, R.anim.zoom_in))
                        holder.iconGift.setImageResource(R.drawable.check)
                        holder.itemView.setBackgroundResource(R.drawable.navy_background_green)

                        val mediaPlayer = MediaPlayer.create(context, R.raw.coins)
                        mediaPlayer.setOnCompletionListener { it.release() }
                        mediaPlayer.start()

                        holder.itemView.postDelayed({
                            val finalPos = holder.adapterPosition
                            if (finalPos != RecyclerView.NO_POSITION) {
                                val removed = tacheList.removeAt(finalPos)
                                notifyItemRemoved(finalPos)
                                notifyItemRangeChanged(finalPos, tacheList.size)
                                onTacheCompleted(1)
                                recompense(removed.recompence)
                                saveTachesToStorage()
                            }
                        }, 600)
                    } else {
                        holder.iconGift.setImageResource(R.drawable.coins)
                        holder.itemView.setBackgroundResource(R.drawable.navy_background)
                    }
                }
            }

            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {}
        })

        progressAnim.start()
    }

    override fun getItemCount(): Int = tacheList.size

    private fun saveTachesToStorage() {
        try {
            val json = Gson().toJson(tacheList)
            context.openFileOutput(jsonFileName, Context.MODE_PRIVATE).use {
                OutputStreamWriter(it).use { writer -> writer.write(json) }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
