package com.example.submission3.Tv


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
import com.example.submission3.Model.Tv
import com.example.submission3.R
import com.example.submission3.URL.URL_TV
import kotlinx.android.synthetic.main.fragment_tv.*
import kotlinx.android.synthetic.main.fragment_tv.swipeMovie
import org.json.JSONException
import org.json.JSONObject

/**
 * A simple [Fragment] subclass.
 */
class TvFragment : Fragment(), SwipeRefreshLayout.OnRefreshListener {
    private val tvList = ArrayList<Tv>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvTv.layoutManager = LinearLayoutManager(activity)
        rvTv.setHasFixedSize(true)

        swipeMovie.setOnRefreshListener(this)
        swipeMovie.setColorSchemeResources(
            R.color.colorPrimary,
            android.R.color.holo_green_dark,
            android.R.color.holo_orange_dark,
            android.R.color.holo_blue_dark)

        getTv()

    }

    fun getTv(){
        val queue = Volley.newRequestQueue(activity)
        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, URL_TV, null,
            Response.Listener<JSONObject>{ response ->
                tvList.clear()
                try {
                    val array = response.getJSONArray("results")
                    for (i in 0 until array.length()){
                        progressBar.visibility = View.GONE
                        rvTv.visibility = View.VISIBLE
                        val obj = array.getJSONObject(i)
                        tvList.add(
                            Tv(
                                obj.getInt("id"),
                                obj.getString("original_name"),
                                obj.getString("overview"),
                                obj.getString("vote_average"),
                                obj.getString("first_air_date"),
                                obj.getString("poster_path")))
                    }
                    val tvAdapter = TvAdapter(tvList)
                    Log.d("listnya2", array.toString())
                    rvTv.adapter = tvAdapter

                }catch (e : JSONException){
                    e.printStackTrace()
                    Toast.makeText(activity, "error lagi"+ e.toString(), Toast.LENGTH_SHORT).show()
                }
        }, Response.ErrorListener { error ->
            progressBar.visibility  = View.GONE
            Toast.makeText(activity,"Error boss", Toast.LENGTH_SHORT).show()
            Log.i("errornya", error.message)
        })
        queue.add(jsonObjectRequest)
    }

    override fun onRefresh() {
        getTv()
        swipeMovie.isRefreshing = false
    }



}
