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

// [START dialogflow_cx_v3_configure_webhooks_to_set_form_parameter_as_optional_or_required]

// TODO: Change class name to Example
// TODO: Uncomment the line below before running cloud function
// package com.example;

import com.google.cloud.functions.HttpFunction;
import com.google.cloud.functions.HttpRequest;
import com.google.cloud.functions.HttpResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.BufferedWriter;

public class WebhookValidateFormParameter implements HttpFunction {
  @Override
  public void service(HttpRequest request, HttpResponse response) throws Exception {
    JsonObject sessionInfo = new JsonObject();
    JsonObject sessionParameter = new JsonObject();

    sessionParameter.addProperty("order_number", "null");
    sessionInfo.add("parameters", sessionParameter);

    JsonObject parameterObject = new JsonObject();
    parameterObject.addProperty("display_name", "order_number");
    parameterObject.addProperty("required", "true");
    parameterObject.addProperty("state", "INVALID");
    parameterObject.addProperty("value", "123");

    JsonArray parameterInfoList = new JsonArray();
    parameterInfoList.add(parameterObject);

    JsonObject parameterInfoObject = new JsonObject();
    parameterInfoObject.add("parameter_info", parameterInfoList);

    JsonObject pageInfo = new JsonObject();
    pageInfo.add("form_info", parameterInfoObject);

    // Constructs the webhook response object
    JsonObject webhookResponse = new JsonObject();
    webhookResponse.add("page_info", pageInfo);
    webhookResponse.add("session_info", sessionInfo);

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    String jsonResponseObject = gson.toJson(webhookResponse);

    /**
     * { "page_info": { "form_info": { "parameter_info": [ { "display_name": "order_number",
     * "required": "true", "state": "INVALID", "value": "123" } ] } }, "session_info": {
     * "parameters": { "order_number": "null" } } }
     */
    BufferedWriter writer = response.getWriter();

    // Sends the responseObject
    writer.write(jsonResponseObject.toString());
  }
}
// [END dialogflow_cx_v3_configure_webhooks_to_set_form_parameter_as_optional_or_required]
