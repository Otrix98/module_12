package com.example.module_12

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.module_12.adapters.StuggeredAdapter
import kotlinx.android.synthetic.main.fragment_stuggered.*

class StaggeredGridFragment: Fragment (R.layout.fragment_stuggered) {

    private val images = listOf(
        "https://images.unsplash.com/photo-1593642702909-dec73df255d7?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2100&q=80",
        "https://images.unsplash.com/photo-1594058767387-3cc8babb1db6?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1867&q=80",
        "https://images.unsplash.com/photo-1594236089007-8180d3943012?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1301&q=80",
        "https://images.unsplash.com/photo-1593642532973-d31b6557fa68?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1400&q=80",
        "https://images.unsplash.com/photo-1587717415723-8c89fe42c76c?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=934&q=80"
    )

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initList()
    }

    private fun initList() = with(imageList3) {
        adapter = StuggeredAdapter().apply {
            setImages(images + images + images + images + images)

            addItemDecoration(ItemOffsetDecoration(context))
        }
        setHasFixedSize(true)
        layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL).apply {

                }
            }
        }