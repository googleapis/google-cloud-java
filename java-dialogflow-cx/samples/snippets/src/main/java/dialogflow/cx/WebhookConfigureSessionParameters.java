/*
 * Copyright 2022 Google LLC
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

// The following snippet is used in https://cloud.google.com/dialogflow/cx/docs/concept/webhook
// Configures a webhook to set a session parameter

// [START dialogflow_cx_v3_webhook_configure_session_parameters]

// TODO: Change class name to Example
// TODO: Uncomment the line below before running cloud function
// package com.example;

import com.google.cloud.functions.HttpFunction;
import com.google.cloud.functions.HttpRequest;
import com.google.cloud.functions.HttpResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.io.BufferedWriter;

public class WebhookConfigureSessionParameters implements HttpFunction {
  @Override
  public void service(HttpRequest request, HttpResponse response) throws Exception {
    JsonObject orderParameter = new JsonObject();
    orderParameter.addProperty("order_number", "12345");

    JsonObject parameterObject = new JsonObject();
    parameterObject.add("parameters", orderParameter);

    // Creates webhook response object
    JsonObject webhookResponse = new JsonObject();
    webhookResponse.add("session_info", parameterObject);

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    String jsonResponseObject = gson.toJson(webhookResponse);

    /** { "session_info": { "parameters": { "order_number": "12345" } } } */
    BufferedWriter writer = response.getWriter();
    // Sends the webhookResponseObject
    writer.write(jsonResponseObject.toString());
  }
}
// [END dialogflow_cx_v3_webhook_configure_session_parameters]
