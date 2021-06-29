package com.dynnamicdevz.mvpretrofitsakuraapp.presenter;

import com.dynnamicdevz.mvpretrofitsakuraapp.model.data.JikanResult;

import java.util.List;

public interface Presenter {

    interface JikanPresenter {
        void getJikanResults(String query);
    }

    interface JikanView {
        void displayResults(List<JikanResult> jikanResults);
        void displayError(String error);
    }

}
