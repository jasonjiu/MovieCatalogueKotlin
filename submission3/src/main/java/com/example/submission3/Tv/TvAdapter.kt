package com.example.submission3.Tv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.submission3.Model.Tv
import com.example.submission3.R
import kotlinx.android.synthetic.main.cv_movie.view.*

class TvAdapter(private val tvList: ArrayList<Tv>) : RecyclerView.Adapter<TvAdapter.TvViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cv_movie, parent, false)
        return TvViewHolder(view)
    }

    override fun getItemCount(): Int = tvList.size

    override fun onBindViewHolder(holder: TvViewHolder, position: Int) {
        holder.bind(tvList[position])
    }

    inner class TvViewHolder(view : View) : RecyclerView.ViewHolder(view){
        fun bind(tv : Tv){
            with(itemView){
                tvMovieName.text = tv.tvName
                tvRelease.text = tv.tvRelease
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w185"+tv.tvPoster)
                    .apply(RequestOptions.skipMemoryCacheOf(true))
                    .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE))
                    .override(350, 550)
                    .into(ivPoster)

                tvDetail.setOnClickListener {

                }

                btn_fav.setOnClickListener {

                }

            }
        }
    }
}