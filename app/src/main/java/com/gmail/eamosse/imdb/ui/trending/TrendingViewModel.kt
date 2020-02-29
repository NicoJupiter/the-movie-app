package com.gmail.eamosse.imdb.ui.trending

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gmail.eamosse.idbdata.data.Category
import com.gmail.eamosse.idbdata.data.TrendingMovie
import com.gmail.eamosse.idbdata.data.TrendingPerson
import com.gmail.eamosse.idbdata.data.TrendingTv
import com.gmail.eamosse.idbdata.repository.MovieRepository
import com.gmail.eamosse.idbdata.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TrendingViewModel(private val repository: MovieRepository) : ViewModel() {

    private val _categories: MutableLiveData<List<Category>> = MutableLiveData()
    val categories: LiveData<List<Category>>
        get() = _categories

    private val _trendingMovies: MutableLiveData<List<TrendingMovie>> = MutableLiveData()
    val trendingMovies: LiveData<List<TrendingMovie>>
        get() = _trendingMovies

    private val _trendingPeople: MutableLiveData<List<TrendingPerson>> = MutableLiveData()
    val trendingPeople: LiveData<List<TrendingPerson>>
        get() = _trendingPeople

    private val _trendingTv: MutableLiveData<List<TrendingTv>> = MutableLiveData()
    val trendingTv: LiveData<List<TrendingTv>>
        get() = _trendingTv

    private val _error: MutableLiveData<String> = MutableLiveData()
    val error: LiveData<String>
        get() = _error

    init {
        loadTrendingMovies()
        loadTopCategories()
        loadTrendingPeople()
        loadTrendingTv()
    }

    private fun loadTrendingMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = repository.getTrendingMovies()) {
                is Result.Succes -> {
                    _trendingMovies.postValue(result.data)
                }
                is Result.Error -> {
                    _error.postValue(result.message)
                }
            }
        }
    }

    private fun loadTrendingPeople() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = repository.getTrendingPeople()) {
                is Result.Succes -> {
                    _trendingPeople.postValue(result.data)
                }
                is Result.Error -> {
                    _error.postValue(result.message)
                }
            }
        }
    }

    private fun loadTrendingTv() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = repository.getTrendingTv()) {
                is Result.Succes -> {
                    _trendingTv.postValue(result.data)
                }
                is Result.Error -> {
                    _error.postValue(result.message)
                }
            }
        }
    }

    private fun loadTopCategories() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = repository.getCategories()) {
                is Result.Succes -> {
                    _categories.postValue(result.data)
                }
                is Result.Error -> {
                    _error.postValue(result.message)
                }
            }
        }
    }
}