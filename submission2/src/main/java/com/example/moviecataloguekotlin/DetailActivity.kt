package com.example.moviecataloguekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.moviecataloguekotlin.Model.Movie
import com.example.moviecataloguekotlin.Model.Tv
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        var getExtraData = intent.getStringExtra("DATA")

        if (getExtraData.equals("movie")){
            val movie = intent.getParcelableExtra(EXTRA_MOVIE) as Movie
            val movieName = movie.movieName
            val movieDesc = movie.movieDesc
            val movieScore = movie.movieScore
            val movieRelease = movie.movieRelease
            val moviePoster = movie.moviePoster

            tvNameDetail.text = movieName
            tvDescription.text = movieDesc
            tvScoreDetail.text = movieScore
            tvReleaseDetail.text = movieRelease
            Glide.with(this@DetailActivity)
                .load(moviePoster)
                .apply(RequestOptions.skipMemoryCacheOf(true))
                .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE))
                .into(ivDetailMovie)
        }

        else if (getExtraData.equals("tv")){
            val tv = intent.getParcelableExtra(EXTRA_MOVIE) as Tv
            val tvName = tv.tvName
            val tvDesc = tv.tvDesc
            val tvScore = tv.tvScore
            val tvRelease = tv.tvRelease
            val tvPoster = tv.tvPoster

            tvNameDetail.text = tvName
            tvDescription.text = tvDesc
            tvScoreDetail.text = tvScore
            tvReleaseDetail.text = tvRelease
            Glide.with(this@DetailActivity)
                .load(tvPoster)
                .apply(RequestOptions.skipMemoryCacheOf(true))
                .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE))
                .into(ivDetailMovie)
        }

    }
}
