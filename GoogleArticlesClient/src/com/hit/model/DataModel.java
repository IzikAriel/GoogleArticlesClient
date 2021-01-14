package com.hit.model;
import java.util.ArrayList;
import java.util.HashMap;

public class DataModel {

        String key;
        String message;
        ArrayList<String> foundArticles;
        HashMap<String, String> target;
        String chosenAlgorithm;

        public DataModel(String key, String message, ArrayList<String> foundArticles, HashMap target, String chosenAlgorithm) {
            this.key = key;
            this.message = message;
            this.foundArticles = foundArticles;
            this.target = target;
            this.chosenAlgorithm = chosenAlgorithm;
        }
        public DataModel(String key, String chosenAlgorithm){
          this.key = key;
          this.chosenAlgorithm = chosenAlgorithm;
    }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public ArrayList<String> getFoundArticles() {
            return foundArticles;
        }

        public void setFoundArticles(ArrayList<String> foundArticles) {
            this.foundArticles = foundArticles;
        }

        public HashMap getTarget() {
            return target;
        }

        public void setTarget(HashMap target){this.target = target;}

        public String getChosenAlgorithm() {
            return chosenAlgorithm;
        }

        public void setChosenAlgorithm(String chosenAlgorithm) {
            this.chosenAlgorithm = chosenAlgorithm;
        }
}

