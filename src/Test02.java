import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Test02 {
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                postjson();
            }
        }.start();

    }

    private static void postjson() {
        String url02 = "http://192.168.1.4:8080/transportservice/action/GetAllSense";
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();

        RequestBody requestBody = FormBody.create(MediaType.parse("application/json; charset=utf-8"), "");
        Request request = new Request.Builder()
                .url(url02)//请求的url
                .post(requestBody)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.code() == 200) {
                    System.out.println(response.body().string());
                }
            }
        });
    }
}
