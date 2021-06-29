package com.dynnamicdevz.mvpretrofitsakuraapp.model.network;

import com.dynnamicdevz.mvpretrofitsakuraapp.model.data.MovieResponse;
import com.dynnamicdevz.mvpretrofitsakuraapp.util.Constants;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class MovieRetrofit {

    private MovieRetrofit.MovieService movieService = createRetrofit().create(MovieRetrofit.MovieService.class);

    private Retrofit createRetrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .build();
    }

    public Call<MovieResponse> getSearchResults(String query) {
        return movieService.searchMovie(query);
    }

    interface MovieService {

        @GET(Constants.END_POINT)
        public Call<MovieResponse> searchMovie(@Query(Constants.SEARCH_QUERY) String query);

    }
}
