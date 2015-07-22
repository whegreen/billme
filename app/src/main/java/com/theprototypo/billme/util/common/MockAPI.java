package com.theprototypo.billme.util.common;

import android.content.Context;
import android.os.Handler;

import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

import hugo.weaving.DebugLog;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by walesadanto on 15/7/15.
 */
public class MockAPI {

    private static int delay = 1000;

    public MockAPI() {

    }

    public static String loadJSONFromAsset(final Context context, final String fileName)
            throws IOException {
        String json;

        InputStream is = context.getAssets().open("mock/"+fileName);
        int size = is.available();
        byte[] buffer = new byte[size];

        is.read(buffer);
        is.close();

        json = new String(buffer, "UTF-8");

        return json;
    }

    @DebugLog
    public static void callMockAPI(final Context context, final String filePath, final Callback<Object> callback){
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            public void run() {
                try{
                    String json = loadJSONFromAsset(context, filePath + ".json");

                    try {
                        JSONArray result = new JSONArray(json);
                        callback.success(result, null);
                    } catch (JSONException eArray) {
                        try {
                            JSONObject result= new JSONObject(json);
                            callback.success(result, null);
                        } catch (JSONException eObject) {
                            eObject.printStackTrace();
                        }
                        eArray.printStackTrace();
                    }
                } catch (IOException e) {
                    callback.failure(RetrofitError.unexpectedError(filePath, e));
                }
            }
        };
        handler.postDelayed(runnable, delay);
    }

}
