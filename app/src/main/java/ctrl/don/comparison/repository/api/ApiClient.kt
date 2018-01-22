package ctrl.don.comparison.repository.api

import android.util.Log
import com.google.gson.GsonBuilder
import ctrl.don.comparison.repository.helper.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by GideonST on 1/22/2018.
 */

class ApiClient {
    private var mApiInterface: ApiInterface ?= null


    fun getApiInterface(): ApiInterface? {
        if (mApiInterface == null) {

            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

            val client = OkHttpClient.Builder()
                    .connectTimeout(10000, TimeUnit.SECONDS)
                    .writeTimeout(10000, TimeUnit.SECONDS)
                    .readTimeout(10000, TimeUnit.SECONDS)

            client.addInterceptor(loggingInterceptor)


            val gBuilder = GsonBuilder()
                    .setLenient()
                    .serializeNulls()
                    .create()

            val retrofit = Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .client(client.build())
                    .addConverterFactory(GsonConverterFactory.create(gBuilder))
                    .build()

            mApiInterface = retrofit.create(ApiInterface::class.java)
            Log.d("GIDEON", Constants.BASE_URL)
        }
        return mApiInterface
    }


}