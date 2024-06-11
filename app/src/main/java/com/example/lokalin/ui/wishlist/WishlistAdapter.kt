package com.example.lokalin.ui.home

import android.app.Activity
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityOptionsCompat
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lokalin.R
import com.example.lokalin.databinding.ItemCategoryBinding
import com.example.lokalin.databinding.ProductBinding
import com.example.lokalin.databinding.WishlistItemBinding
import com.example.lokalin.ui.categories.CategoriesFragmentDirections
import com.example.lokalin.ui.wishlist.WishlistFragmentDirections
import com.example.response.CategoryResponseItem
import com.example.response.Product
import com.example.response.WishlistResponseItem
import java.text.NumberFormat
import java.util.Locale
class WishlistAdapter :
    ListAdapter<WishlistResponseItem, WishlistAdapter.MyViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            WishlistItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = getItem(position)
        holder.bind(data)
    }

    class MyViewHolder(private val binding: WishlistItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val nameTextView: TextView = itemView.findViewById(R.id.tv_type)
        private val priceTextView: TextView = itemView.findViewById(R.id.tv_price)
        private val brandTextView: TextView = itemView.findViewById(R.id.tv_brand)
        fun bind(data: WishlistResponseItem) {
            nameTextView.text = data.productName
            brandTextView.text = data.brandName
            priceTextView.text = data.unitPrice.toString()

            binding.root.setOnClickListener() {
                val action =
                    WishlistFragmentDirections.actionNavigationWishlistToDetailProductFragment(data.productId!!)
                it.findNavController().navigate(action)
            }
        }

    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<WishlistResponseItem>() {
            override fun areItemsTheSame(
                oldItem: WishlistResponseItem,
                newItem: WishlistResponseItem
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: WishlistResponseItem, newItem: WishlistResponseItem
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}