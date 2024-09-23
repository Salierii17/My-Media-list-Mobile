package com.example.mymedialistapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvMedia: RecyclerView
    private val list = arrayListOf<MediaData>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMedia = findViewById(R.id.rv_media_list)
        rvMedia.setHasTransientState(true)

        list.addAll(getListMedia())
        showRecylerList()
    }

    private fun getListMedia(): ArrayList<MediaData> {
        val dataTitle = resources.getStringArray(R.array.data_title)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataCover = resources.obtainTypedArray(R.array.data_cover)
        val listMedia = ArrayList<MediaData>()
        for (i in dataTitle.indices) {
            val media = MediaData(dataTitle[i], dataDescription[i], dataCover.getResourceId(i, -1))
            listMedia.add(media)
        }
        return listMedia
    }

    private fun showRecylerList() {
        rvMedia.layoutManager = LinearLayoutManager(this)
        val listMediaAdapter = ListMediaAdapter(list)
        rvMedia.adapter = listMediaAdapter

        listMediaAdapter.setOnItemClickCallback(object : ListMediaAdapter.OnItemClickCallback {
            override fun onItemClicked(data: MediaData) {
                showSelectedMedia(data)
            }
        })
    }
    private fun showSelectedMedia(data: MediaData) {
        Toast.makeText(this, "You choose " + data.title, Toast.LENGTH_SHORT).show()
    }

}