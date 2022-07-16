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

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.when;

import com.google.cloud.dialogflow.cx.v3beta1.WebhookRequest;
import com.google.cloud.dialogflow.cx.v3beta1.WebhookRequest.FulfillmentInfo;
import com.google.cloud.functions.HttpRequest;
import com.google.cloud.functions.HttpResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class WebhookConfigureSessionParametersIT {

  @Mock HttpRequest request;
  @Mock HttpResponse response;

  BufferedReader jsonReader;
  StringReader stringReader;
  BufferedWriter writerOut;
  StringWriter responseOut;

  @Before
  public void beforeTest() throws IOException {
    MockitoAnnotations.initMocks(this);

    stringReader = new StringReader("{'fulfillmentInfo': {'tag': 'validate-form-parameter'}}");
    jsonReader = new BufferedReader(stringReader);

    responseOut = new StringWriter();
    writerOut = new BufferedWriter(responseOut);

    when(request.getReader()).thenReturn(jsonReader);
    when(response.getWriter()).thenReturn(writerOut);
  }

  @Test
  public void helloHttp_bodyParamsPost() throws IOException, Exception {
    FulfillmentInfo fulfillmentInfo =
        FulfillmentInfo.newBuilder().setTag("configure-session-parameters").build();

    WebhookRequest webhookRequest =
        WebhookRequest.newBuilder().setFulfillmentInfo(fulfillmentInfo).build();

    new WebhookConfigureSessionParameters().service(request, response);
    writerOut.flush();

    JsonObject webhookResponse = new JsonObject();
    JsonObject parameterObject = new JsonObject();
    JsonObject orderParameter = new JsonObject();
    orderParameter.addProperty("order_number", "12345");
    parameterObject.add("parameters", orderParameter);
    webhookResponse.add("session_info", parameterObject);

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    String expectedResponse = gson.toJson(webhookResponse);

    assertThat(responseOut.toString()).isEqualTo(expectedResponse);
  }
}
