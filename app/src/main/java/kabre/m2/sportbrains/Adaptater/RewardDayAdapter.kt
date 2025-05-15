package kabre.m2.sportbrains.Adaptater

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kabre.m2.sportbrains.Model.RewardDay
import kabre.m2.sportbrains.R

class RewardDayAdapter(private val context: Context, private var rewardDayList: List<RewardDay>) :
    RecyclerView.Adapter<RewardDayAdapter.RewardViewHolder>() {

    // On prend seulement les 6 premiers éléments de la liste
    private val visibleList = rewardDayList.take(6)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RewardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_reward_day, parent, false)
        return RewardViewHolder(view)
    }

    override fun onBindViewHolder(holder: RewardViewHolder, position: Int) {
        val reward = visibleList[position]

        // ✅ Utilisation correcte du context stocké
        holder.dayText.text = context.getString(R.string.jour) + " ${reward.id}"
        holder.soccerText.text = "${reward.soccer}"

        val imageResId = context.resources.getIdentifier(
            reward.image.removeSuffix(".png"), "drawable", context.packageName
        )
        if (imageResId != 0) {
            Glide.with(context).load(imageResId).into(holder.rewardImage)
        }

        holder.itemView.alpha = if (reward.status) 0.5f else 1.0f
    }

    override fun getItemCount(): Int = visibleList.size

    class RewardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dayText: TextView = itemView.findViewById(R.id.dayText)
        val soccerText: TextView = itemView.findViewById(R.id.dayScore)
        val rewardImage: ImageView = itemView.findViewById(R.id.dayImage)
    }
    fun updateData(newList: List<RewardDay>) {
        rewardDayList = newList
        notifyDataSetChanged()
    }
}
