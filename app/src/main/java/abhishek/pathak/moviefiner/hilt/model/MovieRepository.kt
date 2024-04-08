package abhishek.pathak.moviefiner.hilt.model

import abhishek.pathak.moviefiner.hilt.model.Constants.API_KEY
import javax.inject.Inject

class MovieRepository @Inject constructor(private val apiService: ApiService) {

    fun getPopularMovie() = apiService.getMovie(API_KEY)
    fun getUpcomingMovie() = apiService.getUpcomingMovies(API_KEY)
    fun getNowPlayingMovie() = apiService.getNowPlayingMovie(API_KEY)
    fun getTopRatedMovie()=apiService.getTopRatedMovies(API_KEY)
}