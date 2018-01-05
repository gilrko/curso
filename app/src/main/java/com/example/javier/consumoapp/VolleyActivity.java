package com.example.javier.consumoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class VolleyActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String URL = "http://jsonplaceholder.typicode.com/posts/1";
    private TextView mTxtJsonVolley;
    private Button mBtnConsumeVolley;
    private RequestQueue mRequestQueue;
    private StringRequest mRequest;
    public static final String TAG = "MyTag";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);


        mTxtJsonVolley = (TextView) findViewById(R.id.txt_jsonVolley);
        mBtnConsumeVolley = (Button)findViewById(R.id.btnCosumeVolley);
        mBtnConsumeVolley.setOnClickListener(this);

        mRequestQueue = Volley.newRequestQueue(this);

        mRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                mTxtJsonVolley.setText(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                mTxtJsonVolley.setText("Error" + error.getMessage());

            }
        });
        mRequest.setTag(TAG);

    }

    @Override
    public void onClick(View v) {

        mRequestQueue.add(mRequest);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mRequestQueue != null){
            mRequestQueue.cancelAll(TAG);
        }
    }
}
