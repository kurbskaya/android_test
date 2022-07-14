package com.sirius.test_app.delegates

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.sirius.test_app.R
import com.sirius.test_app.items.CommonItem
import com.sirius.test_app.items.ReviewHeaderItem

class ReviewHeaderDelegate: AbsListItemAdapterDelegate<ReviewHeaderItem, CommonItem, ReviewHeaderDelegate.ViewHolder>() {

    override fun isForViewType(item: CommonItem, items: List<CommonItem>, position: Int): Boolean {
        return item is ReviewHeaderItem
    }

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.item_reveiew_header, parent, false)
        return ViewHolder(item)
    }

    override fun onBindViewHolder(item: ReviewHeaderItem, viewHolder: ViewHolder, payloads: List<Any>) {
        viewHolder.apply {
            text1.text = item.header
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text1: TextView = itemView.findViewById(R.id.text2)
    }

}