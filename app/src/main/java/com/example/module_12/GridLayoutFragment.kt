package com.example.module_12

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.example.module_12.adapters.GridAdapter
import kotlinx.android.synthetic.main.fragment_gridlayout.*

class GridLayoutFragment: Fragment (R.layout.fragment_gridlayout) {

    private val images = listOf(
        "https://www.nastol.com.ua/download.php?img=201507/2560x1600/nastol.com.ua-142466.jpg",
        "https://www.nastol.com.ua/download.php?img=201705/1680x1050/nastol.com.ua-225408.jpg",
        "https://avatars.mds.yandex.net/get-pdb/2384956/f1829b16-c5d1-449b-a7c8-fb42d9077765/s1200?webp=false",
        "https://answit.com/wp-content/uploads/2017/01/full-hd.jpg",
        "https://f.vividscreen.info/soft/996257f054c145a169e6138ffe95b6e2/Beautiful-Night-Cityscape-2880x1920.jpg",
        "https://masyamba.ru/ветряная-мельница-картинки/48-мельница-картинки.jpg"
    )

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initList()
    }

    private fun initList() = with(imageList2) {
        adapter = GridAdapter().apply {
            setImages(images + images + images + images + images)

            val divider = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
            addItemDecoration(divider)
            addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.HORIZONTAL))
        }
        setHasFixedSize(true)
        layoutManager = GridLayoutManager(requireContext(), 3).apply {
          spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
              override fun getSpanSize(position: Int): Int {
                  return if ( position % 3 == 0) 2 else 1
              }
          }
        }
    }
}