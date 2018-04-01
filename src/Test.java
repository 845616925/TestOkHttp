import com.google.gson.Gson;
import okhttp3.*;

import java.awt.print.Book;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        String url = "https://free-api.heweather.com/s6/weather/forecast?";
        String url02="http://ip:port/transportservice/action/GetAllSense.do";
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
//location=taiyuan&key=6dbe7b45f3fc40708e8c4649cf877c4a
        RequestBody body = new FormBody.Builder()
                .add("location", "taiyuan")
                .add("key", "6dbe7b45f3fc40708e8c4649cf877c4a")
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Call call = okHttpClient.newCall(request);
        try {
            Response response = call.execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
