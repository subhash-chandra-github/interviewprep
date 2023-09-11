package com.interviewprep.coreJava;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SFO {



    private int status;
    private String data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public static void main(String[] args) throws Exception {
        URL url = new URL("https://opensky-network.org/api/flights/arrival?airport=KSFO&begin=1664946718&end=1664949718");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        int status = con.getResponseCode();
        System.out.println(status);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        String data = content.toString();
        System.out.println(content.toString());
        Object object=null;
        JSONArray arrayObj=null;
        JSONParser jsonParser=new JSONParser();
        object=jsonParser.parse(data);
        arrayObj=(JSONArray) object;
        for(int i=0;i<arrayObj.size();i++){
            long lastSeen =(long) ((JSONObject) arrayObj.get(0)).get("lastSeen");
           System.out.println(lastSeen);
        }
    }
}
