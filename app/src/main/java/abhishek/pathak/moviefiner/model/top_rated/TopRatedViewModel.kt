package abhishek.pathak.moviefiner.model.top_rated

import abhishek.pathak.moviefiner.model.api.ApiService
import abhishek.pathak.moviefiner.model.api.Constants
import abhishek.pathak.moviefiner.model.api.RetrofitBuilder
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TopRatedViewModel : ViewModel() {
    private val _topRatedLiveData = MutableLiveData<TopRatedResponse>()
    val topRatedLiveData: LiveData<TopRatedResponse> = _topRatedLiveData
    private val _errorData = MutableLiveData<String>()
    val errorData: LiveData<String> = _errorData
    fun fetchTopRatedMovieData(){
        val apiService= RetrofitBuilder.getRetrofit().create(ApiService::class.java)
        apiService.getTopRatedMovies(Constants.API_KEY).enqueue(
            object : Callback<TopRatedResponse> {
                override fun onResponse(
                    call: Call<TopRatedResponse>,
                    response: Response<TopRatedResponse>
                ) {
                    _topRatedLiveData.value=response.body()
                }

                override fun onFailure(call: Call<TopRatedResponse>, t: Throwable) {
                    _errorData.value=t.message
                }
            }
        )
    }

}