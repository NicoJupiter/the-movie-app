package com.gmail.eamosse.imdb.ui.trending

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.gmail.eamosse.imdb.databinding.TrendingFragmentBinding
import com.gmail.eamosse.imdb.ui.trending.adapters.TrendingMovieAdapter
import com.gmail.eamosse.imdb.ui.trending.adapters.TrendingPersonAdapter
import com.gmail.eamosse.imdb.ui.trending.adapters.TrendingTvAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class TrendingFragment : Fragment() {

    private val trendingViewModel: TrendingViewModel by viewModel()
    private lateinit var binding: TrendingFragmentBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        binding = TrendingFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(trendingViewModel) {
            trendingMovies.observe(viewLifecycleOwner, Observer {
                binding.trendingMovies.trendingItems.adapter = TrendingMovieAdapter(it)
            })

            trendingPeople.observe(viewLifecycleOwner, Observer {
                binding.trendingPeople.trendingItems.adapter = TrendingPersonAdapter(it)
            })

            trendingTv.observe(viewLifecycleOwner, Observer {
                binding.trendingTv.trendingItems.adapter = TrendingTvAdapter(it)
            })
        }
    }

}
