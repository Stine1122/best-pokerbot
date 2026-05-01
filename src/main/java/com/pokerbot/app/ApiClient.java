package com.pokerbot.app;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ApiClient {
    private final OkHttpClient client = new OkHttpClient();

    public String get(String url, String apiKey) throws Exception {
        Request request = new Request.Builder()
                .url(url)
                .header("authorization", apiKey)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
