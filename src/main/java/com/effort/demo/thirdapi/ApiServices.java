package com.effort.demo.thirdapi;

import com.effort.demo.util.RetrofitUtil;
import net.sf.json.JSONObject;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;

import java.io.IOException;

public class ApiServices {

    public static final String host = "http://localhost:8082/api/v2/";

    private static LitchiApi litchiApi;

    static {
        litchiApi = RetrofitUtil.createApiService(LitchiApi.class, host);
    }

    public static Object updateStation(JSONObject json) throws IOException {

        System.out.println(json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),
                json.toString());
        Call<Object> call = litchiApi.update(18L, 311L, requestBody);

        call.execute();
        return "";
    }
}
