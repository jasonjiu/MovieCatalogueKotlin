package com.example.moviecataloguekotlin

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.moviecataloguekotlin.Movie.MovieFragment
import com.example.moviecataloguekotlin.Tv.TvFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nav_view.setOnNavigationItemSelectedListener(mOnNavigationSelectedListener)

        if(savedInstanceState == null){
            nav_view.selectedItemId = R.id.navigation_movie
        }

    }

    private val mOnNavigationSelectedListener = object : BottomNavigationView.OnNavigationItemSelectedListener{
        override fun onNavigationItemSelected(item: MenuItem): Boolean {
            val fragment: Fragment
            when(item.itemId){
                R.id.navigation_movie->{
                    fragment = MovieFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.container_layout, fragment, fragment.javaClass.simpleName)
                        .commit()

                    return true
                }
                R.id.navigation_tv->{
                    fragment = TvFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.container_layout, fragment, fragment.javaClass.simpleName)
                        .commit()

                    return true
                }
            }
            return false
        }

    }


}
