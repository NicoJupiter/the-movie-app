package com.gmail.eamosse.imdb.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.gmail.eamosse.imdb.databinding.FragmentMovieListBinding
import kotlinx.android.synthetic.main.fragment_movie_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieListFragment : Fragment() {

    private lateinit var binding: FragmentMovieListBinding
    private val movieViewModel : MovieViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMovieListBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@MovieListFragment
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(movieViewModel) {

            //Permet de recupérer des args dans des fragments
            movieViewModel.getMovies(MovieListFragmentArgs.fromBundle(arguments!!).genreId)

            movies.observe(viewLifecycleOwner, Observer {
                println(it.size)
                binding.movieList.adapter = MovieAdapter(it)
            })

        }

    }


}