package com.sirius.test_app.delegates

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.sirius.test_app.R
import com.sirius.test_app.items.CommonItem
import com.sirius.test_app.items.ReviewsSummaryItem

class ReviewsSummaryDelegate: AbsListItemAdapterDelegate<ReviewsSummaryItem, CommonItem, ReviewsSummaryDelegate.ViewHolder>() {

    override fun isForViewType(item: CommonItem, items: List<CommonItem>, position: Int): Boolean {
        return item is ReviewsSummaryItem
    }

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.item_review_summary, parent, false)
        return ViewHolder(item)
    }

    override fun onBindViewHolder(item: ReviewsSummaryItem, viewHolder: ViewHolder, payloads: List<Any>) {
        viewHolder.apply {
            text1.text = item.estimate.toString()
            text2.text = item.reviewCount
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text1: TextView = itemView.findViewById(R.id.estimate)
        val text2: TextView = itemView.findViewById(R.id.review_count)
    }

}