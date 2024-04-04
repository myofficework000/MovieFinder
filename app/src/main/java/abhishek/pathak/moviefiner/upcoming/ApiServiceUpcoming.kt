package abhishek.pathak.moviefiner.upcoming

import abhishek.pathak.moviefiner.model.data.UpcomingResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiServiceUpcoming {

    @GET(ConstantsUpcoming.MOVIE_ENDPOINT)
    fun getUpcomingMovies(
        @Query("api_key") apiKey: String
    ): Call<UpcomingResponse>
}