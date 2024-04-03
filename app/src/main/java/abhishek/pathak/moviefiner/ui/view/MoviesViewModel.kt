package abhishek.pathak.moviefiner.ui.view

import abhishek.pathak.moviefiner.model.Repository
import abhishek.pathak.moviefiner.model.data.Movie
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MoviesViewModel(private val repository: Repository) : ViewModel() {

    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    val movies: StateFlow<List<Movie>> = _movies.asStateFlow()

    init {
        //fetchMovies()
    }
/*
    private fun fetchMovies() {
        viewModelScope.launch {

            _movies.value = repository.getMovies(1).results
        }
    }*/
}
