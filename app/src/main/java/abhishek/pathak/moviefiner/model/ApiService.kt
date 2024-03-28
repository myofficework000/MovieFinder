package abhishek.pathak.moviefiner.model

import abhishek.pathak.moviefiner.model.data.UpcomingResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("api")
    suspend fun getMovies(
        @Query("page") page: Int
    ): Response<UpcomingResponse>
}
