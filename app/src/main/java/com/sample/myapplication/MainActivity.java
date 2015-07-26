package com.sample.myapplication;

import android.os.Bundle;
import android.os.StrictMode;

import com.sample.myapplication.model.Product;
import com.sample.myapplication.network.BaseSequenceType;
import com.sample.myapplication.network.DRActivity;
import com.sample.myapplication.network.NetworkRequest;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends DRActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
//        Config config = Data.getConfig("的反馈是", 27);
//        Toast.makeText(this, config.toString(), Toast.LENGTH_SHORT).show();

        NetworkRequest.getInstance().list(new Callback<BaseSequenceType<Product>>() {


            @Override
            public void success(BaseSequenceType<Product> productBaseSequenceType, Response response) {
                System.out.println("success");
                System.out.println(productBaseSequenceType.state + " " + productBaseSequenceType.message);
                List<Product> products = productBaseSequenceType.getList();

                for (Product product : products) {
                    System.out.println(product);
                }
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

}
