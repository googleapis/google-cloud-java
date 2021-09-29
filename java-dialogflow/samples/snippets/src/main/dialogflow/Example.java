package com.example;

import com.google.cloud.functions.HttpFunction;
import com.google.cloud.functions.HttpRequest;
import com.google.cloud.functions.HttpResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedWriter;

public class Example implements HttpFunction {

  public void service(HttpRequest request, HttpResponse response) throws Exception {
    JsonParser parser = new JsonParser();
    Gson gson = new GsonBuilder().create();

    JsonObject job = gson.fromJson(request.getReader(), JsonObject.class);
    String str =
        job.getAsJsonObject("queryResult")
            .getAsJsonObject("intent")
            .getAsJsonPrimitive("displayName")
            .toString();
    JsonObject o = null;
    String a = '"' + "Default Welcome Intent" + '"';
    String b = '"' + "get-agent-name" + '"';
    String responseText = "";

    if (str.equals(a)) {
      responseText = '"' + "Hello from a Java GCF Webhook" + '"';
    } else if (str.equals(b)) {
      responseText = '"' + "My name is Flowhook" + '"';
    } else {
      responseText = '"' + "Sorry I didn't get that" + '"';
    }

    o =
        parser
            .parse(
                "{\"fulfillmentMessages\": [ { \"text\": { \"text\": [ "
                    + responseText
                    + " ] } } ] }")
            .getAsJsonObject();

    BufferedWriter writer = response.getWriter();
    writer.write(o.toString());
  }
}
