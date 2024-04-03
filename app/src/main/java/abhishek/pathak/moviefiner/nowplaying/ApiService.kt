package abhishek.pathak.moviefiner.nowplaying

import abhishek.pathak.moviefiner.nowplaying.Constants.NOWPLAYING_MOVIE_ENDPOINT
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
interface ApiService {
    @GET(NOWPLAYING_MOVIE_ENDPOINT)
    fun getNowPlayingMovie(
        @Query("api_key") api_key: String
    ): Call<NowplayingMovieResponse>
}
