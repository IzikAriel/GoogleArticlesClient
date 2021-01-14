package com.hit.view;

public class Observer {
    private String key;
    private String algorithm;
    private  String searchBy;

    public String getSearchBy() {
        return searchBy;
    }

    public void setSearchBy(String searchType) {
        this.searchBy = searchType;
    }

    public Observer(String key, String algorithm, String searchBy){
        this.key = key;
        this.algorithm = algorithm;
        this.searchBy = searchBy;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

}
