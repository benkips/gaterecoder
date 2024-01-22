package com.example.kabetegaterecoder.Network
import com.example.kabetegaterecoder.Models.MyResponse
import retrofit2.http.*

interface ApiInterface {
    companion object{
        const val BASE_URL="http://127.0.0.1:5000/mobiadmin/"
    }


    @POST("addrecord")
    @FormUrlEncoded
    suspend  fun addRecords(
        @Field("fullnames") fullnames: String?,
        @Field("phone") phone: String?,
        @Field("age") age: String?,
        @Field("residence") residence: String?,
        @Field("fellowship") fellowship: String?,
        ): MyResponse

}