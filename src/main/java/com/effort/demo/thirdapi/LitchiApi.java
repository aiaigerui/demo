package com.effort.demo.thirdapi;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface LitchiApi {

    @POST("station/{stationId}")
    Call<Object> update(@Path("stationId") Long stationId,
                        @Query("token") Long token, @Body RequestBody body);
}
