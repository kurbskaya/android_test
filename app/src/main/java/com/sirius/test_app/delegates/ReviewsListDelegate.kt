package com.sirius.test_app.delegates

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.hannesdorfmann.adapterdelegates4.AdapterDelegatesManager
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.sirius.test_app.R
import com.sirius.test_app.items.CommonItem
import com.sirius.test_app.items.ReviewsListItem

class ReviewsListDelegate : AbsListItemAdapterDelegate<ReviewsListItem, CommonItem, ReviewsListDelegate.ViewHolder>() {

    override fun isForViewType(item: CommonItem, items: List<CommonItem>, position: Int): Boolean {
        return item is ReviewsListItem
    }

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.item_review_list, parent, false)
        return ViewHolder(item)
    }

    override fun onBindViewHolder(item: ReviewsListItem, viewHolder: ViewHolder, payloads: List<Any>) {
        viewHolder.apply {
            val context = itemView.context
            val manager = AdapterDelegatesManager<List<CommonItem>>()
                .addDelegate(ReviewDelegate())
            recyclerReview.adapter = ListDelegationAdapter(manager).apply {
                items = item.reviewsList
            }
            recyclerReview.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recyclerReview: RecyclerView = itemView.findViewById(R.id.recycler_reviews)
    }
}
