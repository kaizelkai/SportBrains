package kabre.m2.sportbrains.Adaptater

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import kabre.m2.sportbrains.R

class AvatarAdapter(
    private val context: Context,
    private val avatars: List<Int>,
    private var selectedPosition: Int
) : BaseAdapter() {

    fun setSelectedPosition(position: Int) {
        selectedPosition = position
        notifyDataSetChanged()
    }

    override fun getCount(): Int = avatars.size

    override fun getItem(position: Int): Any = avatars[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val imageView = if (convertView == null) {
            ImageView(context).apply {
                layoutParams = ViewGroup.LayoutParams(200, 200)
                scaleType = ImageView.ScaleType.CENTER_CROP
                setPadding(8, 8, 8, 8)
            }
        } else {
            convertView as ImageView
        }

        // Réinitialise le background avant d'en appliquer un nouveau
        imageView.background = null

        if (position == selectedPosition) {
            imageView.background = context.getDrawable(R.drawable.navy_menu_background4)
        } else {
            imageView.background = context.getDrawable(R.drawable.navy_menu_background)
        }

        Glide.with(context)
            .load(avatars[position])
            .circleCrop()
            .into(imageView)

        return imageView
    }

}
