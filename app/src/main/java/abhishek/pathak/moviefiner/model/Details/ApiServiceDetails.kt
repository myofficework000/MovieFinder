package abhishek.pathak.moviefiner.model.Details

import abhishek.pathak.moviefiner.nowplaying.Constants.DETAILS_ENDPOINT
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServiceDetails {
    @GET("${DETAILS_ENDPOINT}/{movieId}")
    fun getMovieDetails(
        @Path("movieId") movieId: String,
        @Query("api_key") api_key: String

    ): Call<MovieDetailsResponse>
}
