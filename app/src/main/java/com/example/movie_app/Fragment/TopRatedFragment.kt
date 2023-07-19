package com.example.movie_app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movie_app.API.ApiClient
import com.example.movie_app.API.ApiInterface
import com.example.movie_app.Adapter.UpcomingAdapter
import com.example.movie_app.Model.ResultsItem
import com.example.movie_app.Model.UpcomingMovieModel
import com.example.movie_app.databinding.FragmentTopRatedBinding
import retrofit2.Call

class TopRatedFragment : Fragment() {
    var adapter = UpcomingAdapter()
    var page = 1
    var movieList = ArrayList<ResultsItem>()
    lateinit var binding: FragmentTopRatedBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentTopRatedBinding.inflate(layoutInflater)
        binding.nestedsv.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener{ v, scrollX, scrollY, oldScrollX, oldScrollY ->

            if (scrollY == v.getChildAt(0).measuredHeight - v.measuredHeight){

                page++
                callApi(page)
            }
        })

        callApi(page)

        return binding.root

    }

    private fun callApi(page: Int) {
        var api = ApiClient.getApiClient().create(ApiInterface::class.java)
        api.getUpcomingMovies(page).enqueue(object : retrofit2.Callback<UpcomingMovieModel>{
            override fun onResponse(
                call: Call<UpcomingMovieModel>,
                response: retrofit2.Response<UpcomingMovieModel>,
            ) {
                if (response.isSuccessful) {
                    var Topratedlist = response.body()?.results

                    movieList.addAll(Topratedlist as List<ResultsItem>)
                    adapter.setMovies(movieList)
                    binding.rcvUpcoming.layoutManager = LinearLayoutManager(context)
                    binding.rcvUpcoming.adapter = adapter

                }
            }

            override fun onFailure(call: Call<UpcomingMovieModel>, t: Throwable) {

            }
        })
    }
}