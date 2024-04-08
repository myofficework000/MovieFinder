package abhishek.pathak.moviefiner.hilt.model

import abhishek.pathak.moviefiner.hilt.model.Constants.NOWPLAYING_MOVIE_ENDPOINT
import abhishek.pathak.moviefiner.hilt.model.Constants.POPULAR_MOVIE_ENDPOINT
import abhishek.pathak.moviefiner.hilt.model.Constants.TOPRATED_MOVIE_ENDPOINT
import abhishek.pathak.moviefiner.hilt.model.Constants.UPCOMING_MOVIE_ENDPOINT
import abhishek.pathak.moviefiner.model.data.UpcomingResponse
import abhishek.pathak.moviefiner.hilt.model.toprated.TopRatedResponse
import abhishek.pathak.moviefiner.hilt.model.nowplaying.NowplayingMovieResponse
import abhishek.pathak.moviefiner.hilt.model.popular.PopularResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(NOWPLAYING_MOVIE_ENDPOINT)
    fun getNowPlayingMovie(
        @Query("api_key") apiKey: String
    ): Single<NowplayingMovieResponse>
    @GET(POPULAR_MOVIE_ENDPOINT)
    fun getMovie(
        @Query("api_key") apiKey: String
    ): Single<PopularResponse>
    @GET(UPCOMING_MOVIE_ENDPOINT)
    fun getUpcomingMovies(
        @Query("api_key") apiKey: String
    ): Single<UpcomingResponse>
    @GET(TOPRATED_MOVIE_ENDPOINT)
    fun getTopRatedMovies(
        @Query("api_key") apiKey: String
    ): Single<TopRatedResponse>
}
