package com.sirius.test_app

import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.sirius.test_app.delegates.*
import com.sirius.test_app.items.*

class DelegatesAdapter : ListDelegationAdapter<List<CommonItem>>() {
    init {
        delegatesManager.addDelegate(HeaderDelegate())
        delegatesManager.addDelegate(TagListDelegate())
        delegatesManager.addDelegate(DescriptionDelegate())
        delegatesManager.addDelegate(ReviewHeaderDelegate())
        delegatesManager.addDelegate(ReviewsSummaryDelegate())
        delegatesManager.addDelegate(ReviewsListDelegate())
    }

    fun setData(items: List<CommonItem>) {
        this.items = items
    }
}