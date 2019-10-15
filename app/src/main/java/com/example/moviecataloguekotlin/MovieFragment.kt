package com.example.moviecataloguekotlin


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_movie.*

/**
 * A simple [Fragment] subclass.
 */
class MovieFragment : Fragment() {
    private val movieList = ArrayList<Movie>()




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieList.addAll(getListMovie())
        showRv()
    }

    fun getListMovie() :ArrayList<Movie>{
        val dataName = resources.getStringArray(R.array.data_movie)
        val dataDesc = resources.getStringArray(R.array.data_movie_desc)
        val dataScore = resources.getStringArray(R.array.data_movie_score)
        val dataPhoto = resources.getStringArray(R.array.data_movie_photo)
        val dataRelease = resources.getStringArray(R.array.data_movie_release)

        val listMovie = ArrayList<Movie>()
        for (position in dataName.indices){
            val movie = Movie(
                dataName[position],
                dataDesc[position],
                dataScore[position],
                dataRelease[position],
                dataPhoto[position]
            )

            listMovie.add(movie)
        }
        return listMovie
    }

    fun showRv(){
        rvMovie.layoutManager = LinearLayoutManager(activity)
        val movieAdapter = MovieAdapter(movieList)
        rvMovie.adapter = movieAdapter

    }


}
