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
import com.sirius.test_app.items.ReviewItem
import com.sirius.test_app.showIconRound

class ReviewDelegate: AbsListItemAdapterDelegate<ReviewItem, CommonItem, ReviewDelegate.ViewHolder>() {

    override fun isForViewType(item: CommonItem, items: List<CommonItem>, position: Int): Boolean {
        return item is ReviewItem
    }

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.item_review, parent, false)
        return ViewHolder(item)
    }

    override fun onBindViewHolder(item: ReviewItem, viewHolder: ViewHolder, payloads: List<Any>) {
        viewHolder.apply {
            photo.showIconRound(item.review.userImage)
            name.text = item.review.userName
            date.text = item.review.date
            review.text = item.review.message
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val photo: ImageView = itemView.findViewById(R.id.photo)
        val name: TextView = itemView.findViewById(R.id.name)
        val date: TextView = itemView.findViewById(R.id.date)
        val review: TextView = itemView.findViewById(R.id.text_review)
    }
}