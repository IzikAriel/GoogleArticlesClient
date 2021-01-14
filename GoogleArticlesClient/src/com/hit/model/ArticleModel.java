package com.hit.model;
import java.util.Observable;

public class ArticleModel extends Observable {

    private Client client;
    private Request<DataModel> request;
    private Response<DataModel> response;

    public ArticleModel() {
        client =new Client();
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Response sendRequest(String key,String algorithm,String action){
        request=client.buildRequest(key,algorithm,action);//build request to send
        response =client.send(request);//send request and accept response from the server
        return response;//return the response from the server
    }
}
