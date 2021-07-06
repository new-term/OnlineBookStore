package com.example.bookstore.Utils;

import android.os.Handler;
import android.os.Message;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.builder.PostFormBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpUtils {
    //请求类型
    public static final int SEARCH = 1;
    public static final int BUY = 2;
    public static final int ADD_TO_CART = 3;

    //请求URL
    public static final String SEARCH_URL = "http://10.0.2.2:8080/OnlineBookStoreServer_war_exploded/search";
    public static final String ADD_TO_CART_URL = "http://10.0.2.2:8080/OnlineBookStoreServer_war_exploded/addtocart";
    public static final String BUY_URL = "http://10.0.2.2:8080/OnlineBookStoreServer_war_exploded/buy";

    /**
     * 以post请求的方式获取数据
     * @param url 请求连接，使用HttpUtils中的静态成员
     * @param values 请求的参数
     * @param handler 返回消息的参数
     */
    public static void getDataByPost(String url, int operation, HashMap<String, String> values, Handler handler){
        //TODO:完成新线程的建立用以进行网络查询
        new Thread(){
            @Override
            public void run() {
                super.run();

                String ret = null;
                try {
                    ret = post(url, values);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Message msg = Message.obtain();
                msg.what = operation;
                msg.obj = ret;
                handler.sendMessage(msg);
            }
        }.start();
    }

    private static String post(String url, HashMap<String, String> values) throws IOException {
        PostFormBuilder builder = OkHttpUtils.post().url(url);
        for(Map.Entry<String, String> entry : values.entrySet()){
            builder = builder.addParams(entry.getKey(), entry.getValue());
        }
        Response response = builder.build().execute();
        assert response.body() != null;
        return response.body().string();
    }
}
