package ctrl.don.comparison.repository.api

import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by GideonST on 1/22/2018.
 */
interface ApiInterface {
    //SPECIFIED DEVICE LIST
    @GET("getdevice")
    fun getDevice(@Query("token") token: String,
                    @Query("device") device: String,
                    @Query("brand") brand: String,
                    @Query("position") position: String)


    //LATEST DEVICE LIST
    @GET("getdevice")
    fun getLatest(@Query("token") token: String,
                    @Query("brand") device: String,
                    @Query("limit") brand: String)


}