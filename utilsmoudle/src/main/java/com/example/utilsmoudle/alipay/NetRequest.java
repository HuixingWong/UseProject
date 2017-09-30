package com.example.utilsmoudle.alipay;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by dogoodsoft on 2017/3/17.
 */

public class NetRequest {

    public static  String myRequest(String url,String body,String out_trade_no,
                                    String total_amount,String buylevelStr,String app_id) throws IOException {

        OkHttpClient client = new OkHttpClient.Builder().build();


        RequestBody formbody = new FormBody.Builder().
                add("body",body).add("out_trade_no",out_trade_no).
                add("total_amount",total_amount).add("buy_level",buylevelStr).add("app_id",app_id).
                build();

        Request request = new Request.Builder().url(url).
                post(formbody).build();


        Response response = client.newCall(request).execute();

        String myres = response.body().string().replace("amp;","");
        return myres;

    }


}
