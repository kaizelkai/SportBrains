package kabre.m2.sportbrains.Adaptater

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kabre.m2.sportbrains.Model.QuestModel
import kabre.m2.sportbrains.R
import kabre.m2.sportbrains.databinding.ViewholderQuestBinding

class QuestAdaptater(private val onClick: (QuestModel) -> Unit) : RecyclerView.Adapter<QuestAdaptater.ViewHolder>() {

    inner class ViewHolder(val binding: ViewholderQuestBinding) : RecyclerView.ViewHolder(binding.root) {

        // Fonction pour gérer l'affichage des statuts via un Map
        private val statusDrawableMap = mapOf(
            1 to R.drawable.termine,
            2 to R.drawable.aller,
            3 to R.drawable.recuperer
        )

        fun bind(quest: QuestModel) {
            // Description de la quête
            binding.description.text = quest.description

            // Chargement des images de la quête avec Glide
            Glide.with(binding.root.context)
                .load(getDrawableResourceId(quest.questPic, R.drawable.star_on)) // Image par défaut
                .into(binding.questPic)

            // Chargement de l'image de récompense
            Glide.with(binding.root.context)
                .load(getDrawableResourceId(quest.recompencePic, R.drawable.star_on)) // Image par défaut
                .into(binding.recompencePic)

            // Nombre d'objectifs complétés
            binding.completeNb.text = quest.completeNb.toString()

            // Récompense
            binding.recompence.text = quest.recompence.toString()
            binding.currentcCompleteNb.text = quest.currentcCompleteNb.toString()


            // Gestion du statut avec un fallback par défaut
            quest.status.takeIf { statusDrawableMap.containsKey(it) }?.let { status ->
                binding.status.background = binding.root.context.getDrawable(statusDrawableMap[status] ?: R.drawable.aller)
                if (status==1){
                    binding.status.setOnClickListener(null)
                }
            }

            // Clic sur l'élément de la quête
            itemView.setOnClickListener { onClick(quest) }
        }

        // Méthode sécurisée pour obtenir l'ID d'une ressource drawable avec une valeur par défaut
        private fun getDrawableResourceId(resourceName: String?, defaultResId: Int): Int {
            return resourceName?.let {
                val resId = binding.root.resources.getIdentifier(it, "drawable", binding.root.context.packageName)
                if (resId != 0) resId else defaultResId
            } ?: defaultResId
        }
    }

    // Callback pour gérer la différence entre les éléments de la liste
    private val differCallback = object : DiffUtil.ItemCallback<QuestModel>() {
        override fun areItemsTheSame(oldItem: QuestModel, newItem: QuestModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: QuestModel, newItem: QuestModel): Boolean {
            return oldItem == newItem
        }
    }

    // Gestion asynchrone des données avec AsyncListDiffer
    val differ = AsyncListDiffer(this, differCallback)

    // Création de la vue du ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ViewholderQuestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    // Liaison des données avec le ViewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val quest = differ.currentList[position]
        holder.bind(quest)
    }

    // Nombre d'éléments dans la liste
    override fun getItemCount(): Int = differ.currentList.size
}
