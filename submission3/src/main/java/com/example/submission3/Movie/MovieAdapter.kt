package com.example.submission3.Movie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.submission3.Model.Movie
import com.example.submission3.R
import kotlinx.android.synthetic.main.cv_movie.view.*

class MovieAdapter (private val listMovie: ArrayList<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cv_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int = listMovie.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(listMovie[position])
    }

    inner class MovieViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bind(movie: Movie){
            with(itemView){

                tvMovieName.text = movie.movieName
                tvRelease.text = movie.movieRelease

                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w185"+movie.moviePoster)
                    .apply(RequestOptions.skipMemoryCacheOf(true))
                    .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE))
                    .override(350, 550)
                    .into(ivPoster)

                btn_fav.setOnClickListener {

                }

                tvDetail.setOnClickListener {

                }
            }
        }
    }
}