package com.example.videomeme

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MediaAdapter(
    val context: Context,
    listItems: List<dataList>
): RecyclerView.Adapter<MediaAdapter.MyViewHolder>() {
    private var mItemslist: List<dataList> = listItems

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        val titleTextView: TextView = itemView.findViewById(R.id.iv_play)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(context).inflate(R.layout.cardview_media, parent, false)
        ) }

    override fun getItemCount(): Int {
        return mItemslist.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
      val voice = mItemslist[position]
        holder.itemView.findViewById<TextView>(R.id.tv_mediaName).text = voice.name

        holder.titleTextView.setOnClickListener {

            val mediaPlayer = MediaPlayer()
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)
            mediaPlayer.setDataSource(voice.voiceUrl)
            mediaPlayer.prepareAsync()
            mediaPlayer.setOnPreparedListener { mp ->
                mp.start()
            }
        }

    }
}
