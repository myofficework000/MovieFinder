package abhishek.pathak.moviefiner.model

import abhishek.pathak.moviefiner.model.data.UpcomingResponse

interface Repository {
    suspend fun getMovies(page: Int): UpcomingResponse
}