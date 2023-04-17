package disney.character.info.ui.main.contentAdapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ContentAdapter(val onClick: (model: ContentModel) -> Unit) :
    RecyclerView.Adapter<ContentViewHolder>() {

    var contents = mutableListOf<ContentModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder =
        ContentViewHolder.create(parent)

    override fun getItemCount(): Int = contents.size

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
        holder.onBind(contents[position], onClick)
    }

    fun update(list: List<ContentModel>) {
        contents.clear()
        contents.addAll(list)
        notifyDataSetChanged()
    }

    fun getItems() = contents

}