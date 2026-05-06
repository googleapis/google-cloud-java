/*
 * Copyright 2015, Google Inc. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *    * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *
 *    * Neither the name of Google Inc. nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.google.auth.oauth2;

import com.google.api.client.http.HttpStatusCodes;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.Json;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.auth.http.AuthHttpConstants;
import java.io.IOException;

/** Mock transport to simulate an http server that checks tokens */
public class MockTokenCheckingTransport extends HttpTransport {

  public static final String SUCCESS_CONTENT = "{\"key\":\"value\"}";

  private final MockTokenServerTransport tokenServer;
  private final String refreshToken;

  public MockTokenCheckingTransport(MockTokenServerTransport tokenServer, String refreshToken) {
    this.tokenServer = tokenServer;
    this.refreshToken = refreshToken;
  }

  @Override
  public MockLowLevelHttpRequest buildRequest(String method, String url) throws IOException {
    return new MockLowLevelHttpRequest() {
      @Override
      public MockLowLevelHttpResponse execute() throws IOException {
        String credentialValue = getFirstHeaderValue(AuthHttpConstants.AUTHORIZATION);
        String correctAccessToken = tokenServer.getAccessToken(refreshToken);
        if (credentialValue == null) {
          return makeErrorResponse();
        }
        if (!credentialValue.startsWith(OAuth2Utils.BEARER_PREFIX)) {
          return makeErrorResponse();
        }
        String actualAccessToken = credentialValue.substring(OAuth2Utils.BEARER_PREFIX.length());
        if (!correctAccessToken.equals(actualAccessToken)) {
          return makeErrorResponse();
        } else {
          return makeSuccessResponse();
        }
      }
    };
  }

  private MockLowLevelHttpResponse makeErrorResponse() {
    MockLowLevelHttpResponse errorResponse = new MockLowLevelHttpResponse();
    errorResponse.addHeader("custom_header", "value");
    errorResponse.setStatusCode(HttpStatusCodes.STATUS_CODE_UNAUTHORIZED);
    errorResponse.setContentType(Json.MEDIA_TYPE);
    errorResponse.setContent("{\"error\":\"invalid credentials\"}");
    return errorResponse;
  }

  private MockLowLevelHttpResponse makeSuccessResponse() {
    MockLowLevelHttpResponse successResponse = new MockLowLevelHttpResponse();
    successResponse.addHeader("custom_header", "value");
    successResponse.setStatusCode(HttpStatusCodes.STATUS_CODE_OK);
    successResponse.setContentType(Json.MEDIA_TYPE);
    successResponse.setContent(SUCCESS_CONTENT);
    return successResponse;
  }
}
