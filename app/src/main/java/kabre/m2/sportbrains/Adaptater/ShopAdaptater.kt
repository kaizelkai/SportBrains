package kabre.m2.sportbrains.Adaptater

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kabre.m2.sportbrains.R
import kabre.m2.sportbrains.databinding.ViewShopPanelBinding
import kabre.m2.sportbrains.Model.ShopItem

class ShopAdaptater(
    private val context: Context,
    private val shopItems: List<ShopItem>,
    private val onItemClicked: (Int) -> Unit
) : RecyclerView.Adapter<ShopAdaptater.ShopViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopViewHolder {
        val binding = ViewShopPanelBinding.inflate(LayoutInflater.from(context), parent, false)
        return ShopViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {
        holder.bind(shopItems[position])
    }

    override fun getItemCount(): Int = shopItems.size

    inner class ShopViewHolder(private val binding: ViewShopPanelBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                onItemClicked(adapterPosition)
                showPaymentDialog(shopItems[adapterPosition])
            }
        }

        private fun showPaymentDialog(item: ShopItem) {
            // Crée la boîte de dialogue
            val dialog = Dialog(context)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.shop_choose_payment)

            // Configure `currentScore` pour afficher le prix
            val currentScoreTextView = dialog.findViewById<TextView>(R.id.currentScore)
            currentScoreTextView.text = "$${item.formattedPrice}"

            // Configure l'action du bouton Annuler pour fermer la boîte de dialogue
            val cancelButton = dialog.findViewById<TextView>(R.id.annuler)
            cancelButton.setOnClickListener {
                dialog.dismiss()
            }

            dialog.show()
        }

        fun bind(item: ShopItem) {

            if (item.discountText==0){
                binding.imageView.setImageResource(item.imageResId)
                binding.textView2.text = item.price.toString()
                binding.textView3.text = ""
                binding.textView6.text = "$${item.formattedPrice}"
            }
            else if (item.metode=="Gratuit"){
                binding.imageView.setImageResource(item.imageResId)
                binding.textView2.text = item.price.toString()
                binding.textView3.text = ""
                binding.textView6.text = "${item.metode}"
            }
            else{
                binding.imageView.setImageResource(item.imageResId)
                binding.textView2.text = item.price.toString()
                binding.textView3.text = "${item.discountText.toString()}% OFF"
                binding.textView6.text = "$${item.formattedPrice}"
            }

        }
    }

}