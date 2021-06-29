package com.dynnamicdevz.mvpretrofitsakuraapp.model.network;

import com.dynnamicdevz.mvpretrofitsakuraapp.model.data.JikanResponse;
import com.dynnamicdevz.mvpretrofitsakuraapp.util.Constants;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class JikanRetrofit {

    private JikanService jikanService = createRetrofit().create(JikanService.class);

    private Retrofit createRetrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .build();
    }

    public Call<JikanResponse> getSearchResults(String query) {
        return jikanService.searchJikan(query);
    }

    interface JikanService {

        @GET(Constants.END_POINT)
        public Call<JikanResponse> searchJikan(@Query(Constants.SEARCH_QUERY) String query);

    }

}
