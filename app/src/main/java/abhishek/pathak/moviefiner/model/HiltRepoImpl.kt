package abhishek.pathak.moviefiner.model

import abhishek.pathak.moviefiner.model.APIService.Companion.API_KEY
import abhishek.pathak.moviefiner.model.data.UpcomingResponse
import javax.inject.Inject

class HiltRepoImpl @Inject constructor(val apiService: APIService): Repository{
    override suspend fun getMovies(page: Int): UpcomingResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getTrendingMovies()  = apiService.getTrendingMovies(API_KEY)

}