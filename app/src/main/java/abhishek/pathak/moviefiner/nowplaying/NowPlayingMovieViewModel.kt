package abhishek.pathak.moviefiner.nowplaying

import abhishek.pathak.moviefiner.nowplaying.Constants.API_KEY
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NowPlayingMovieViewModel : ViewModel() {
    private val _nowPlayingLiveData = MutableLiveData<NowplayingMovieResponse>()
    val nowPlayingLiveData: LiveData<NowplayingMovieResponse> = _nowPlayingLiveData
    private val _errorData = MutableLiveData<String>()
    val errorData: LiveData<String> = _errorData
    fun fetchNowPlayingMovieData(){
        val apiService= RetrofitBuilder.getRetrofit().create(ApiService::class.java)
        apiService.getNowPlayingMovie(API_KEY).enqueue(
            object : Callback<NowplayingMovieResponse>{
                override fun onResponse(
                    call: Call<NowplayingMovieResponse>,
                    response: Response<NowplayingMovieResponse>
                ) {
                    _nowPlayingLiveData.value=response.body()
                }

                override fun onFailure(call: Call<NowplayingMovieResponse>, t: Throwable) {
                    _errorData.value=t.message
                }
            }
        )
    }

}