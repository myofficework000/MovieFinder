package abhishek.pathak.moviefiner.popular

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServicePopular{

    @GET(ConstantsPopular.MOVIE_ENDPOINT)
    fun getMovie(
        @Query("api_key") api_key: String
    ): Call<PopularResponse>
}