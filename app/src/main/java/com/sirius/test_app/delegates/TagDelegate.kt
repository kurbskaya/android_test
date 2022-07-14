package com.sirius.test_app.delegates

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.sirius.test_app.R
import com.sirius.test_app.items.CommonItem
import com.sirius.test_app.items.TagItem

class TagDelegate: AbsListItemAdapterDelegate<TagItem, CommonItem, TagDelegate.ViewHolder>() {

    override fun isForViewType(item: CommonItem, items: List<CommonItem>, position: Int): Boolean {
        return item is TagItem
    }

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.item_tag_member, parent, false)
        return ViewHolder(item)
    }

    override fun onBindViewHolder(item: TagItem, viewHolder: ViewHolder, payloads: List<Any>) {
        viewHolder.count.apply {
            text = item.text
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val count: Button = itemView.findViewById(R.id.tag_name)
    }
}