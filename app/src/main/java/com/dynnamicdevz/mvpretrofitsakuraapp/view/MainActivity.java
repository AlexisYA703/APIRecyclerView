package com.dynnamicdevz.mvpretrofitsakuraapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.dynnamicdevz.mvpretrofitdigimonapp.databinding.ActivityMainBinding;
import com.dynnamicdevz.mvpretrofitsakuraapp.model.data.JikanResponse;
import com.dynnamicdevz.mvpretrofitsakuraapp.model.network.JikanRetrofit;
import com.dynnamicdevz.mvpretrofitsakuraapp.view.adapter.JikanAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    //private ActivityMainMovieBinding binding;
    private ActivityMainBinding binding;
    //private MovieAdapter adapter = new MovieAdapter();
    private JikanAdapter adapter = new JikanAdapter();
    //private MovieRetrofit movieRetrofit = new MovieRetrofit();
    private JikanRetrofit jikanRetrofit = new JikanRetrofit();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.jikanRecyclerview.setAdapter(adapter);



        jikanRetrofit.getSearchResults("sakura")
                .enqueue(new Callback<JikanResponse>() {
                    @Override
                    public void onResponse(Call<JikanResponse> call, Response<JikanResponse> response) {
                        Log.d("TAG_X", " " + call.request().url());
                        adapter.setResults(response.body().getResults());
                    }

                    @Override
                    public void onFailure(Call<JikanResponse> call, Throwable throwable) {
                        Log.d("TAG_X", " OOPS :< " + call.request().url());
                    }
                });

    }

}