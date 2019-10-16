package com.example.submission3.Movie


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.submission3.Model.Movie
import com.example.submission3.R
import com.example.submission3.URL.URL_MOVIE
import kotlinx.android.synthetic.main.fragment_movie.*
import org.json.JSONException
import org.json.JSONObject
import kotlin.collections.ArrayList

/**
 * A simple [Fragment] subclass.
 */
class MovieFragment : Fragment() , SwipeRefreshLayout.OnRefreshListener {

    private val movieList = ArrayList<Movie>()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvMovie.layoutManager = LinearLayoutManager(activity)
        rvMovie.setHasFixedSize(true)

        swipeMovie.setOnRefreshListener(this)
        swipeMovie.setColorSchemeResources(
            R.color.colorPrimary,
            android.R.color.holo_green_dark,
            android.R.color.holo_orange_dark,
            android.R.color.holo_blue_dark)

        getMovie()

    }

    fun getMovie(){
        val queue = Volley.newRequestQueue(activity)
        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, URL_MOVIE, null,
            Response.Listener<JSONObject>{ response ->
                movieList.clear()
                Log.d("responnya", response.toString())
                try {
                    val array = response.getJSONArray("results")
                    for (i in 0 until array.length()){
                        progressBar.visibility = View.GONE
                        rvMovie.visibility = View.VISIBLE
                        val obj : JSONObject = array.getJSONObject(i)
                        movieList.add(
                            Movie(
                                obj.getInt("id"),
                                obj.getString("original_title"),
                                obj.getString("overview"),
                                obj.getString("vote_average"),
                                obj.getString("release_date"),
                                obj.getString("poster_path")))
                    }
                    val movieAdapter = MovieAdapter(movieList)
                    Log.d("listnya", array.toString())
                    rvMovie.adapter = movieAdapter

                }catch (e : JSONException){
                    e.printStackTrace()
                    Toast.makeText(activity, "error lagi"+ e.toString(), Toast.LENGTH_SHORT).show()
                }
        },Response.ErrorListener {error ->
            progressBar.visibility = View.GONE
            Toast.makeText(activity, "That didn't work!" + error.message, Toast.LENGTH_SHORT).show()
            Log.i("errornya apa", error.message)
            })
        queue.add(jsonObjectRequest)
    }

    override fun onRefresh() {
        getMovie()
        swipeMovie.isRefreshing = false
    }


}
