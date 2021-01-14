package com.hit.model;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client{
            Socket myServer;
            Gson gson;
            Response res;

    public Client(){gson = new Gson();}

    public Response send(Request req){
        myServer = null;
        try{
            myServer = new Socket("localhost", 34567);//create new socket and connect to server
            PrintWriter output = new PrintWriter(new OutputStreamWriter(myServer.getOutputStream()));
            Scanner input = new Scanner(new InputStreamReader(myServer.getInputStream()));
            String mes = gson.toJson(req);//get the request and build string to Json
            output.println(mes);//send the string to server
            output.flush();
            Type listType = new TypeToken<Response<DataModel>>() {
            }.getType();
            String response = input.nextLine();//get the response from the server
            res = gson.fromJson(response, listType);//transfer the string from the server to response object
        }
        catch (UnknownHostException e){e.printStackTrace();}
        catch (IOException e){return res;}
            try{myServer.close();}
            catch (IOException e){e.printStackTrace();}
        return res;
    }

    //build request to the server
    public Request<DataModel> buildRequest(String key, String choosenAlgorithm, String action){

        DataModel data = new DataModel(key, choosenAlgorithm);
        data.foundArticles = new ArrayList<>();
        data.target=new HashMap<>();
        return new Request<>(action, data);
    }
}
