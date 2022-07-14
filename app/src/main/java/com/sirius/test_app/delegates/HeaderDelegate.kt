package com.sirius.test_app.delegates

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.sirius.test_app.R
import com.sirius.test_app.items.CommonItem
import com.sirius.test_app.items.HeaderItem
import com.sirius.test_app.showIcon

class HeaderDelegate: AbsListItemAdapterDelegate<HeaderItem, CommonItem, HeaderDelegate.ViewHolder>() {

    override fun isForViewType(item: CommonItem, items: List<CommonItem>, position: Int): Boolean {
        return item is HeaderItem
    }

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.item_header, parent, false)
        return ViewHolder(item)
    }

    override fun onBindViewHolder(item: HeaderItem, viewHolder: ViewHolder, payloads: List<Any>) {
        viewHolder.apply {
            logoImage.showIcon(item.logo)
            text.text = item.header
            count.text = item.count
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val logoImage: ImageView = itemView.findViewById(R.id.logo)
        val text: TextView = itemView.findViewById(R.id.header_text)
        val count: TextView = itemView.findViewById(R.id.counr_text)
    }

}