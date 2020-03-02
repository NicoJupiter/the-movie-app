package com.gmail.eamosse.imdb.ui.detailMovie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.gmail.eamosse.imdb.databinding.FragmentMovieDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieDetailFragment : Fragment() {

    private lateinit var binding: FragmentMovieDetailBinding
    private val movieDetailViewModel : MovieDetailViewModel by viewModel()
    val args:MovieDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMovieDetailBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@MovieDetailFragment
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        print(args.movieId)
        print("tamer la pute!!!!!!")
        with(movieDetailViewModel) {
            print(args.movieId)
            print("tamer la pute!!!!!!")
            movieDetailViewModel.getMovie(args.movieId)

            movie.observe(viewLifecycleOwner, Observer {
                binding.item = it
            })
        }

    }

}