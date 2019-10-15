package com.example.moviecataloguekotlin

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.cv_movie.view.*

class TvAdapter (private val listTv : ArrayList<Tv>): RecyclerView.Adapter<TvAdapter.TvViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cv_movie, parent, false)
        return TvViewHolder(view)
    }

    override fun getItemCount(): Int = listTv.size

    override fun onBindViewHolder(holder: TvViewHolder, position: Int) {
        holder.bind(listTv[position])
    }

    inner class TvViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(tv: Tv){
            with(itemView){
                Glide.with(itemView.context)
                    .load(tv.tvPoster)
                    .apply(RequestOptions.skipMemoryCacheOf(true))
                    .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE))
                    .override(350, 550)
                    .into(ivPoster)

                tvMovieName.text = tv.tvName
                tvRelease.text = tv.tvRelease

                tvDetail.setOnClickListener{
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_MOVIE, listTv[adapterPosition])
                    intent.putExtra("DATA", "tv")
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}