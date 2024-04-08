package abhishek.pathak.moviefiner.hilt.viewmodel

import abhishek.pathak.moviefiner.hilt.model.local.MovieDao
import abhishek.pathak.moviefiner.hilt.model.local.Result
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class FavouritesMovieViewModel @Inject constructor(private val movieDao: MovieDao) : ViewModel() {


    private val _favMovies = MutableLiveData<List<Result>>()
    val favMovies: LiveData<List<Result>> = _favMovies

    init {
        _favMovies.value = movieDao.fetchMovie()
    }

    fun add(result: Result) {
        movieDao.insertMovie(result)
    }
}