/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.showcase.v1beta1.it.util;

import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.json.webtoken.JsonWebSignature;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.auth.TestUtils;
import com.google.auth.oauth2.MockTokenServerTransport;
import java.io.IOException;
import java.util.Map;

public class InterceptingMockTokenServerTransport extends MockTokenServerTransport {
  private MockLowLevelHttpRequest lastRequest;
  private static final JsonFactory JSON_FACTORY = new GsonFactory();

  @Override
  public LowLevelHttpRequest buildRequest(String method, String url) throws IOException {
    MockLowLevelHttpRequest baseRequest = (MockLowLevelHttpRequest) super.buildRequest(method, url);
    lastRequest = baseRequest;
    return baseRequest;
  }

  public String getLastAudienceSent() throws IOException {
    String contentString = lastRequest.getContentAsString();
    Map<String, String> query = TestUtils.parseQuery(contentString);
    String assertion = query.get("assertion");
    JsonWebSignature signature = JsonWebSignature.parse(JSON_FACTORY, assertion);
    String foundTargetAudience = (String) signature.getPayload().get("api_audience");
    return foundTargetAudience;
  }
}
