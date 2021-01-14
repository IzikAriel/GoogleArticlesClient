package com.hit.controller;
import com.hit.model.ArticleModel;
import com.hit.model.DataModel;
import com.hit.model.Response;
import com.hit.view.*;
import java.util.Observable;

public class Controller implements ControllerArt {

    private ArticleModel model;
    private View view;
    private Response<DataModel> response;
    private ArticleView articleView;

    public Controller(ArticleModel model, View view) {
        this.model = model;
        this.view = view;
        view.getListener().addObserver(this);
    }

    public ArticleModel getModel() {
        return model;
    }

    public View getView() {
        return view;
    }

    public void update(Observable Watched, Object arg) {

        String action = "search";
        if (Watched instanceof MainActionListener) {
            long startTime = System.nanoTime();//take the time
            if (((Observer) arg).getSearchBy().equals("Most mentions"))//check which search is selected
                action = "searchByMostMentions";
            else if (((Observer) arg).getSearchBy().equals("Most popular"))
                action = "searchByMostPopular";
            //send request to server
            response = model.sendRequest(((Observer) arg).getKey(), ((Observer) arg).getAlgorithm(), action);
            if (response == null) {
                view.serverNotConnected();
            } else {
                long endTime = System.nanoTime();
                long totalTime = (endTime - startTime);//calculate how much the algorithm take

                if (response.getMessage().equals("Success"))//check if the request is success
                {
                    view.moveToResultsView(response.getData().getFoundArticles(), action, totalTime);
                    view.getResView().getListener().addObserver(this);
                } else {
                    view.error();
                }//print a error messages if not founded results
            }
        }
        else if (Watched instanceof ResultsActionListener) {

                if (arg.toString().equals("close")) {//if push back button return to main view
                    view.dispose();
                    view = new View();
                    view.getListener().addObserver(this);
                } else {

                    response = model.sendRequest((arg).toString(), "", "load");
                    articleView = new ArticleView(response.getData().getTarget());
                }
            }
        }
    }

