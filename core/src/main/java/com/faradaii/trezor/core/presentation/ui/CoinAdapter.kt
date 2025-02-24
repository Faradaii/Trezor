package com.faradaii.trezor.core.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.faradaii.trezor.core.R
import com.faradaii.trezor.core.databinding.FragmentItemBinding
import com.faradaii.trezor.core.domain.entities.CoinEntity

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
            binding.name.text = data.name
            binding.symbol.text = data.symbol
            binding.currentPrice.text =
                itemView.context.getString(R.string.currency, data.currentPrice.toString())
            Glide.with(binding.root)
                .load(data.image)
                .apply(RequestOptions().override(150, 150))
                .into(binding.ivLogo)
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