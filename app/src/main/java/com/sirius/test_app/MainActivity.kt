package com.sirius.test_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sirius.test_app.items.*
import com.squareup.picasso.Picasso


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerList: RecyclerView
    private val dataModel = DataModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val to: ImageView = findViewById(R.id.picture_first)
        Picasso.with(this).load(dataModel.image).into(to)

        recyclerList = findViewById(R.id.recycler_common)
        recyclerList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = createAdapter().apply { showData() }
        }
    }

    private fun createAdapter(): DelegatesAdapter {
        return DelegatesAdapter()
    }

    private fun DelegatesAdapter.showData() {
        val data = mutableListOf<CommonItem>().apply {
            add(HeaderItem(dataModel.logo, dataModel.name, dataModel.gradeCnt))
            val lst1 = dataModel.tags.map { TagItem(it) }
            add(TagListItem(lst1))
            add(DescriptionItem(dataModel.description))
            add(ReviewHeaderItem("Review & Ratings"))
            add(ReviewsSummaryItem("70M Reviews", dataModel.rating))
            val lst2 = dataModel.reviews.map { ReviewItem(it) }
            add(ReviewsListItem(lst2))

        }
        setData(data)
    }

}