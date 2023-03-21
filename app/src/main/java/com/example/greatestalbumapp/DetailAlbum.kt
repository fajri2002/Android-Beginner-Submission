package com.example.greatestalbumapp

import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class DetailAlbum : AppCompatActivity() {
    private lateinit var albumName :TextView
    private lateinit var imgDetailAlbum : ImageView
    private lateinit var albumDesc: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val dataAlbum = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("key_album", Albums::class.java)
        } else {
            intent.getParcelableExtra<Albums>("key_album")
        }

        albumName = findViewById(R.id.detail_album_name)
        albumDesc = findViewById(R.id.detail_album_desc)
        imgDetailAlbum = findViewById(R.id.detail_album_photo)

        albumName.text = dataAlbum?.album_name
        albumDesc.text = dataAlbum?.detail_album_desc
        imgDetailAlbum.setImageResource(dataAlbum!!.album_photo)



    }



}