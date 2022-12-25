package org.telegram.bot;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;

public class CommonMethods {
    public static final String url = "http://freegenerator.ru/compliment";
    private final Filter requestFilter = new RequestLoggingFilter();
    private final Filter responseFiler = new ResponseLoggingFilter();

    private Response requestCompliment(Boolean maleSex){
        String payload = "";
        if(maleSex){
            payload = "type=compliment&sex=0&long_val=1";
        } else {
            payload = "type=compliment&sex=1&long_val=1";
        }
        return RestAssured
                .with()
//                .filters(requestFilter, responseFiler)
                .baseUri(url)
                .header("Content-type", "application/x-www-form-urlencoded; charset=UTF-8")
                .and()
                .body(payload)
                .post();
    }

    public String getMaleCompliment(){
        Gson desGson = new Gson();
        String jsonString = requestCompliment(true).then().extract().htmlPath().getString("html.body");
        ComplimentObject jsonCompliment = desGson.fromJson(jsonString, ComplimentObject.class);
        return jsonCompliment.getText();
    }

    public String getFemaleCompliment(){
        Gson desGson = new Gson();
        String jsonString = requestCompliment(false).then().extract().htmlPath().getString("html.body");
        ComplimentObject jsonCompliment = desGson.fromJson(jsonString, ComplimentObject.class);
        return jsonCompliment.getText();
    }
}
