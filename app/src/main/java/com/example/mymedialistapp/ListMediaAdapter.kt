package com.example.mymedialistapp

import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mymedialistapp.databinding.ItemMediaLayoutBinding

class ListMediaAdapter(private val listMedia: ArrayList<MediaData>) :
    RecyclerView.Adapter<ListMediaAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    class ListViewHolder(var binding: ItemMediaLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding =
            ItemMediaLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (title, description, cover) = listMedia[position]
        holder.binding.tvTitle.text = title
        holder.binding.tvDescription.text = description
        Glide.with(holder.itemView.context)
            .load(cover)
            .into(holder.binding.coverItem)
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listMedia[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int = listMedia.size

    interface OnItemClickCallback {
        fun onItemClicked(data: MediaData)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

}