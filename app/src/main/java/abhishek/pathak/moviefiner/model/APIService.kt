package abhishek.pathak.moviefiner.model

import abhishek.pathak.moviefiner.model.data.TrendingResponse
import abhishek.pathak.moviefiner.model.data.UpcomingResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET("trending/movie/day")
    suspend fun getTrendingMovies(
        @Query("api_key") apiKey: String
    ): Response<TrendingResponse>

    @GET("api")
    suspend fun getMovies(
        @Query("page") page: Int
    ): Response<UpcomingResponse>



    companion object{
        const val API_KEY = "80eabe189b9e4e5ca80503483808a53b"
    }
}