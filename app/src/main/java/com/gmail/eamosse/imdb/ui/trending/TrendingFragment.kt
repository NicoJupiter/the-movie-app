package com.gmail.eamosse.imdb.ui.trending

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.gmail.eamosse.imdb.R
import com.gmail.eamosse.imdb.databinding.TrendingFragmentBinding

class TrendingFragment : Fragment() {

    private lateinit var trendingViewModel: TrendingViewModel
    private lateinit var binding: TrendingFragmentBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        trendingViewModel =
                ViewModelProviders.of(this).get(TrendingViewModel::class.java)

        binding = TrendingFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }
}
