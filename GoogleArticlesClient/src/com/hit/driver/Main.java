package com.hit.driver;
import com.hit.controller.Controller;
import com.hit.model.ArticleModel;
import com.hit.view.View;

public class Main{

    public static void main(String[] args){

        View view = new View();
        ArticleModel model=new ArticleModel();
        Controller controller=new Controller(model,view);
        model.addObserver(controller);
    }
}
