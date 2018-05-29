package com.effort.demo.thirdapi;

import com.effort.demo.util.RetrofitUtil;
import net.sf.json.JSONObject;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;

import java.io.IOException;

public class LitchiServices {

    public static final String host = "http://localhost:8082/api/v2/";

    private static LitchiDao litchiDao;

    static {
        litchiDao = RetrofitUtil.createApiService(LitchiDao.class, host);
    }

    public static Object updateStation(JSONObject json) throws IOException {

        System.out.println(json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),
                json.toString());
        Call<Object> call = litchiDao.update(18L, 311L, requestBody);

        call.execute();
        return "";
    }
}
