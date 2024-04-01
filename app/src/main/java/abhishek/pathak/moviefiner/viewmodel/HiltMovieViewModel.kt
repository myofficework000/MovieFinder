package abhishek.pathak.moviefiner.viewmodel

import abhishek.pathak.moviefiner.model.Repository
import abhishek.pathak.moviefiner.model.data.TrendingResponse
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HiltMovieViewModel @Inject constructor(val repository: Repository): ViewModel() {

    val trendingMovie = MutableLiveData<TrendingResponse>()
    val error = MutableLiveData<String>()

    fun getTrendingMovies(){
        viewModelScope.launch{
            val response = repository.getTrendingMovies()
            if (response.isSuccessful){
                trendingMovie.value = response.body()
            }else{
                error.postValue(response.message())
            }
        }
    }
}