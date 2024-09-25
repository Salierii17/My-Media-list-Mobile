package com.example.mymedialistapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
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
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("title", title)
            intent.putExtra("description", description)
            intent.putExtra("cover", cover)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = listMedia.size

    interface OnItemClickCallback {
        fun onItemClicked(data: MediaData)
//        fun onItemClicked(Intent)
    }

    interface OnItemClickListeener {
        fun onItemClicked(data: MediaData)
//        fun onItemClicked(Intent)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

}