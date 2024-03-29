package abhishek.pathak.moviefiner

import abhishek.pathak.moviefiner.popular.ApiServicePopular
import abhishek.pathak.moviefiner.popular.ConstantsPopular
import abhishek.pathak.moviefiner.popular.PopularResponse
import abhishek.pathak.moviefiner.popular.RetrofitBuilder
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PopularViewModel : ViewModel() {
    private val _popularLiveData = MutableLiveData<PopularResponse>()
    val popularLiveData: LiveData<PopularResponse> = _popularLiveData
    private val _errorData = MutableLiveData<String>()
    val errorData: LiveData<String> = _errorData
    fun fetchUpcomingMovieData() {
        val apiService = RetrofitBuilder.getRetrofit().create(ApiServicePopular::class.java)
        apiService.getMovie(ConstantsPopular.API_KEY).enqueue(
            object : Callback<PopularResponse> {
                override fun onResponse(
                    call: Call<PopularResponse>,
                    response: Response<PopularResponse>
                ) {
                    Log.e("data",response.body().toString())
                    _popularLiveData.value = response.body()
                }

                override fun onFailure(call: Call<PopularResponse>, t: Throwable) {
                    _errorData.value = t.message
                }
            }
        )
    }
}
