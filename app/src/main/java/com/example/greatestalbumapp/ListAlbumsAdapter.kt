package com.example.greatestalbumapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.util.Log

class ListAlbumsAdapter(private val listAlbums: ArrayList<Albums>) : RecyclerView.Adapter<ListAlbumsAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_album_name)
        val tvRelease: TextView = itemView.findViewById(R.id.tv_album_release)
//        val tvAlbumDesc: TextView = itemView.findViewById(R.id.detail_album_desc)


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_albums, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listAlbums.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (album_name, release_date, detail_desc, album_photo) = listAlbums[position]
        holder.imgPhoto.setImageResource(album_photo)
        holder.tvName.text = album_name
        holder.tvRelease.text = release_date
//        holder.tvAlbumDesc.text = detail_desc

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailAlbum::class.java)
            intentDetail.putExtra("key_album", listAlbums[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
            Log.d("DetailAlbum", "Tes")
        }

    }


}