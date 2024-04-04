package abhishek.pathak.moviefiner.upcoming

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitUpcoming {
    private lateinit var retrofit: Retrofit

    fun getRetrofit(): Retrofit {
        if(!RetrofitUpcoming::retrofit.isInitialized){
            retrofit= Retrofit.Builder()
                .addConverterFactory(
                    GsonConverterFactory.create()
                )
                .baseUrl(ConstantsUpcoming.BASE_URL)
                .build()
        }
        return retrofit
    }
}