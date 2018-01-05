package com.example.javier.consumoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.javier.consumoapp.api.IApi;
import com.example.javier.consumoapp.api.MainController;
import com.example.javier.consumoapp.api.Post;

import java.util.List;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView mTxtJsonRetro;
    private Button mBtnConsumeRetro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        Realm.init(this);

        mTxtJsonRetro = (TextView) findViewById(R.id.txt_jsonRetro);
        mBtnConsumeRetro = (Button)findViewById(R.id.btnCosumeRetro);
        mBtnConsumeRetro.setOnClickListener(this);

        MainController
                .getInstance()
                .createService(IApi.class)
                .listPost()
                .enqueue(
                        new Callback<List<Post>>() {
                            @Override
                            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                                if(response.code() == 200){
                                    mTxtJsonRetro.setText("Cargando...");
                                    Realm realm = Realm.getDefaultInstance();
                                    realm.beginTransaction();
                                    realm.deleteAll();
                                    realm.copyToRealm(response.body());
                                    realm.commitTransaction();

                                }else{
                                    mTxtJsonRetro.setText(response.message());
                                }

                            }

                            @Override
                            public void onFailure(Call<List<Post>> call, Throwable t) {

                                mTxtJsonRetro.setText("Error" + t.getMessage() );
                            }
                        });
    }

    @Override
    public void onClick(View v) {
        Realm realm = Realm.getDefaultInstance();
        Post post = realm.where(Post.class).equalTo("userId",10).findFirst();
        mTxtJsonRetro.setText(post.getmBody());

    }
}
