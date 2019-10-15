package com.example.moviecataloguekotlin.Movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.moviecataloguekotlin.DetailActivity
import com.example.moviecataloguekotlin.Model.Movie
import com.example.moviecataloguekotlin.R
import kotlinx.android.synthetic.main.cv_movie.view.*

class MovieAdapter (private val listMovie: ArrayList<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cv_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int = listMovie.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(listMovie[position])
    }

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(movie: Movie){
            with(itemView){
                Glide.with(itemView.context)
                    .load(movie.moviePoster)
                    .apply(RequestOptions.skipMemoryCacheOf(true))
                    .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE))
                    .override(350, 550)
                    .into(ivPoster)

                tvMovieName.text = movie.movieName
                tvRelease.text = movie.movieRelease

                var position =  adapterPosition

                btn_fav.setOnClickListener {

                }

                tvDetail.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_MOVIE, listMovie[position])
                    intent.putExtra("DATA", "movie")
                    itemView.context.startActivity(intent)
                }

            }
        }
    }

}