package com.example.module_12.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.module_12.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_dish.*

abstract class BasePersonHolder (
    override val containerView: View,
    onItemClicked: (position: Int) -> Unit
    ): RecyclerView.ViewHolder(containerView), LayoutContainer {

//        private val nameTextView: TextView = containerView.findViewById(R.id.nameTextView)
//        private val weightTextView: TextView = containerView.findViewById(R.id.weightTextView)

        init {
            containerView.setOnClickListener {
                onItemClicked(adapterPosition)
            }
        }

        protected fun bindMainInfo(
            name: String,
            avatarLink: String,
            weight: String
        ) {
            nameTextView.text = name
            weightTextView.text = "Вес: ${weight}"

            Glide.with(itemView)
                .load(avatarLink)
                .error(R.drawable.ic_baseline_error)
                .into(avatarImageView)
        }
    }