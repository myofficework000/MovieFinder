package abhishek.pathak.moviefiner.model.api

import abhishek.pathak.moviefiner.model.api.Constants.NOWPLAYING_MOVIE_ENDPOINT
import abhishek.pathak.moviefiner.model.api.Constants.POPULAR_MOVIE_ENDPOINT
import abhishek.pathak.moviefiner.model.api.Constants.TOPRATED_MOVIE_ENDPOINT
import abhishek.pathak.moviefiner.model.api.Constants.UPCOMING_MOVIE_ENDPOINT
import abhishek.pathak.moviefiner.model.data.UpcomingResponse
import abhishek.pathak.moviefiner.model.top_rated.TopRatedResponse
import abhishek.pathak.moviefiner.nowplaying.NowplayingMovieResponse
import abhishek.pathak.moviefiner.popular.PopularResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(NOWPLAYING_MOVIE_ENDPOINT)
    fun getNowPlayingMovie(
        @Query("api_key") api_key: String
    ): Call<NowplayingMovieResponse>
    @GET(POPULAR_MOVIE_ENDPOINT)
    fun getMovie(
        @Query("api_key") api_key: String
    ): Call<PopularResponse>
    @GET(UPCOMING_MOVIE_ENDPOINT)
    fun getUpcomingMovies(
        @Query("api_key") apiKey: String
    ): Call<UpcomingResponse>
    @GET(TOPRATED_MOVIE_ENDPOINT)
    fun getTopRatedMovies(
        @Query("api_key") apiKey: String
    ): Call<TopRatedResponse>
}
