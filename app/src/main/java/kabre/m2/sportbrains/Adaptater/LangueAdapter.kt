package kabre.m2.sportbrains.Adaptater

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kabre.m2.sportbrains.Model.Langue
import kabre.m2.sportbrains.R

class LangueAdapter(
    private var langues: List<Langue>,
    private val onLangueClick: (Langue) -> Unit
) : RecyclerView.Adapter<LangueAdapter.LangueViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LangueViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.viewholder_langue, parent, false)
        return LangueViewHolder(view)
    }

    override fun onBindViewHolder(holder: LangueViewHolder, position: Int) {
        holder.bind(langues[position])
    }

    override fun getItemCount(): Int = langues.size

    fun updateList(newList: List<Langue>) {
        langues = newList
        notifyDataSetChanged()
    }

    inner class LangueViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val langueText: TextView = itemView.findViewById(R.id.french_option)
        private val langueCheck: ImageView = itemView.findViewById(R.id.imageView)

        fun bind(langue: Langue) {
            langueText.text = langue.nom
            langueCheck.setImageResource(
                if (langue.isSelected) android.R.drawable.checkbox_on_background
                else android.R.drawable.checkbox_off_background
            )

            itemView.setOnClickListener { onLangueClick(langue) }
        }
    }
}
