/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dialogflow.cx;

// [START dialogflow_webhook]

// TODO: add GSON dependency to Pom file
// (https://mvnrepository.com/artifact/com.google.code.gson/gson/2.8.5)
// TODO: Uncomment the line bellow before running cloud function
// package com.example;

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
    String str = job.getAsJsonObject("fulfillmentInfo").getAsJsonPrimitive("tag").toString();
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
                "{ \"fulfillment_response\": { \"messages\": [ { \"text\": { \"text\": ["
                    + responseText
                    + "] } } ] } }")
            .getAsJsonObject();
    BufferedWriter writer = response.getWriter();
    writer.write(o.toString());
  }
}
// [END dialogflow_webhook]
