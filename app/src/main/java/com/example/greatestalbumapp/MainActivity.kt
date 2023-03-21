package com.example.greatestalbumapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvAlbums: RecyclerView
    private val list = ArrayList<Albums>()

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.aboutme_page ->{
                val aboutmePage = Intent(this, AboutActivity::class.java)
                startActivity(aboutmePage)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvAlbums = findViewById(R.id.rv_albums)
        rvAlbums.setHasFixedSize(true)

        list.addAll(getListAlbums())
        showRecyclerList()

    }

    private fun getListAlbums(): ArrayList<Albums> {
        val dataAlbumName = resources.getStringArray(R.array.data_album_name)
        val dataAlbumRelease = resources.getStringArray(R.array.data_album_release)
        val dataAlbumDesc = resources.getStringArray(R.array.data_detail_album)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listAlbum = ArrayList<Albums>()

        for (i in dataAlbumName.indices) {
            val albums = Albums(dataAlbumName[i], dataAlbumRelease[i], dataAlbumDesc[i], dataPhoto.getResourceId(i, -1))
            listAlbum.add(albums)
        }
        return listAlbum
    }

    private fun showRecyclerList() {
        rvAlbums.layoutManager = LinearLayoutManager(this)
        val listAlbumsAdapter = ListAlbumsAdapter(list)
        rvAlbums.adapter = listAlbumsAdapter

    }
}