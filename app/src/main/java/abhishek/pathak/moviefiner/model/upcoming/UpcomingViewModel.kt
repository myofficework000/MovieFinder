package abhishek.pathak.moviefiner.model.upcoming

import abhishek.pathak.moviefiner.model.api.ApiService
import abhishek.pathak.moviefiner.model.api.Constants.API_KEY
import abhishek.pathak.moviefiner.model.api.RetrofitBuilder
import abhishek.pathak.moviefiner.model.data.UpcomingResponse
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpcomingViewModel : ViewModel() {
    private val _upcomingLiveData = MutableLiveData<UpcomingResponse>()
    val upcomingLiveData: LiveData<UpcomingResponse> = _upcomingLiveData

    private val _errorLiveData = MutableLiveData<String>()
    val errorLiveData: LiveData<String> = _errorLiveData

    fun fetchUpcomingMovieData() {
        val apiService = RetrofitBuilder.getRetrofit().create(ApiService::class.java)
        apiService.getUpcomingMovies(API_KEY).enqueue(object : Callback<UpcomingResponse> {
            override fun onResponse(call: Call<UpcomingResponse>, response: Response<UpcomingResponse>) {
                if (response.isSuccessful) {
                    _upcomingLiveData.value = response.body()
                } else {
                    _errorLiveData.value = "An error occurred: ${response.errorBody()?.string()}"
                }
            }

            override fun onFailure(call: Call<UpcomingResponse>, t: Throwable) {
                _errorLiveData.value = t.message
            }
        })
    }
}
