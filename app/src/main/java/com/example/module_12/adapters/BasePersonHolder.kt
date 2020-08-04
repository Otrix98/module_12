package com.example.module_12.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.module_12.FoodRepository
import com.example.module_12.ListFragment
import com.example.module_12.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.item_dish.*

abstract class BasePersonHolder (
    override val containerView: View,
    private val onItemClicked: (id: Long) -> Unit
    ): RecyclerView.ViewHolder(containerView), LayoutContainer {

        private var currentId: Long? = null



        init {
            containerView.setOnClickListener {
                onItemClicked(itemId)
            }
        }

        protected fun bindMainInfo(
            id: Long,
            name: String,
            avatarLink: String,
            weight: String
        ) {
            containerView.setOnLongClickListener {
                (id.toInt())
                true
            }
            containerView.setOnClickListener {
                currentId?.let { onItemClicked(it) }
            }
            currentId = id
            nameTextView.text = name
            weightTextView.text = "Вес: ${weight}"

            Glide.with(itemView)
                .load(avatarLink)
                .error(R.drawable.ic_baseline_error)
                .into(avatarImageView)
        }
    }