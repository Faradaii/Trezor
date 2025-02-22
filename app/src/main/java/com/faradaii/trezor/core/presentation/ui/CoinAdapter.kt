package com.faradaii.trezor.core.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.faradaii.trezor.core.domain.entities.CoinEntity
import com.faradaii.trezor.databinding.FragmentItemBinding

class CoinAdapter : ListAdapter<CoinEntity, CoinAdapter.ListViewHolder>(DIFF_CALLBACK) {

    var onItemClick: ((CoinEntity) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(
            FragmentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ListViewHolder(private var binding: FragmentItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: CoinEntity) {
            binding.itemNumber.text = data.name
        }

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(getItem(bindingAdapterPosition))
            }
        }
    }

    companion object {
        val DIFF_CALLBACK: DiffUtil.ItemCallback<CoinEntity> =
            object : DiffUtil.ItemCallback<CoinEntity>() {
                override fun areItemsTheSame(oldItem: CoinEntity, newItem: CoinEntity): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(oldItem: CoinEntity, newItem: CoinEntity): Boolean {
                    return oldItem == newItem
                }
            }
    }
}