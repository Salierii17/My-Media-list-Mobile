package com.example.mymedialistapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.mymedialistapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        val title = intent.getStringExtra("title")
        val description = intent.getStringExtra("description")
        val cover = intent.getIntExtra("cover", 0)

        binding.tvTitle.text = title
        binding.tvDescription.text = description
        Glide.with(binding.root)
            .load(cover)
            .into(binding.imgCover)


    }
}