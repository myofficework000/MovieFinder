//package abhishek.pathak.moviefiner.model.movie_detail
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//
//class DetailsViewModel : ViewModel() {
//    private val _detailsLiveData = MutableLiveData<MovieDetailsResponse>()
//    val detailsLiveData: LiveData<MovieDetailsResponse> = _detailsLiveData
//
//    private val _errorData = MutableLiveData<String>()
//    val errorData: LiveData<String> = _errorData
//
//    fun fetchMovieDetails(movieId: String) {
//        val apiService= RetrofitBuilder.getRetrofit().create(ApiServiceDetails::class.java)
//        apiService.getMovieDetails(movieId,API_KEY).enqueue(
//            object : Callback<MovieDetailsResponse>{
//                override fun onResponse(
//                    call: Call<MovieDetailsResponse>,
//                    response: Response<MovieDetailsResponse>
//                ) {
//                    _detailsLiveData.value=response.body()
//                }
//
//                override fun onFailure(call: Call<MovieDetailsResponse>, t: Throwable) {
//                    _errorData.value=t.message
//                }
//            }
//        )
//    }
//
//}
//
//
