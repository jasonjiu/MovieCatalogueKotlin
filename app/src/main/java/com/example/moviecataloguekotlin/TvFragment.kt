package com.example.moviecataloguekotlin


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_tv.*

/**
 * A simple [Fragment] subclass.
 */
class TvFragment : Fragment() {
    private val tvList = ArrayList<Tv>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvList.addAll(getListTv())
        showRv()
    }

    fun getListTv() :ArrayList<Tv>{
        val dataName = resources.getStringArray(R.array.data_tv)
        val dataDesc = resources.getStringArray(R.array.data_tv_desc)
        val dataScore = resources.getStringArray(R.array.data_tv_score)
        val dataPhoto = resources.getStringArray(R.array.data_tv_photo)
        val dataRelease = resources.getStringArray(R.array.data_tv_release)

        val listTv = ArrayList<Tv>()
        for (position in dataName.indices){
            val tv = Tv(
                dataName[position],
                dataDesc[position],
                dataScore[position],
                dataRelease[position],
                dataPhoto[position]
            )

            listTv.add(tv)
            Log.d("tvlist", tv.toString())

        }
        return listTv
    }


    fun showRv(){
        rvTv.layoutManager = LinearLayoutManager(activity)
        val tvAdapter = TvAdapter(tvList)
        rvTv.adapter = tvAdapter
    }


}
