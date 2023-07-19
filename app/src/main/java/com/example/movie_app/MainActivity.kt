package com.example.movie_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.movie_app.Fragment.NowPlayingFragment
import com.example.movie_app.Fragment.PopularFragment
import com.example.movie_app.Fragment.TopRatedFragment
import com.example.movie_app.Fragment.UpcomingFragment
import com.example.movie_app.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var Type = arrayOf("Now Playing","Popular","TopRated","Up Coming")
        var Fragments = arrayOf(NowPlayingFragment(), PopularFragment(), TopRatedFragment(),UpcomingFragment())
        loadFragment(NowPlayingFragment())
        binding.bottomnav.setOnNavigationItemSelectedListener(object : BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {

                when (item.itemId) {
                    R.id.nowplaying -> {
                        loadFragment(NowPlayingFragment())
                    }
                }
                when (item.itemId) {
                    R.id.popular -> {
                        loadFragment(PopularFragment())
                    }
                }
                when (item.itemId) {
                    R.id.toprated -> {
                        loadFragment(TopRatedFragment())
                    }
                }
                when (item.itemId) {
                    R.id.upcoming -> {
                        loadFragment(UpcomingFragment())
                    }
                }
                return true
            }
        })
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frame, fragment)
            .commit()
    }
}