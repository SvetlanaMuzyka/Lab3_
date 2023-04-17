package disney.character.info.ui.main.contentAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import disney.character.info.databinding.ItemBinding


class ContentViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(item: ContentModel, onClick: (model: ContentModel) -> Unit) {
        with(binding) {
            itemView.setOnClickListener { onClick(item) }
            Glide.with(itemView.context).load(item.image)
                .transform(CenterInside(), RoundedCorners(20)).into(imgContent)
            tvName.text = item.name
        }
    }

    companion object {
        fun create(parent: ViewGroup): ContentViewHolder = ContentViewHolder(
            ItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}