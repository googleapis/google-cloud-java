/*
 * Copyright 2018, Google Inc. All rights reserved.
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

import static com.google.auth.oauth2.IamUtils.IAM_ID_TOKEN_ENDPOINT_FORMAT;

import com.google.api.client.http.HttpStatusCodes;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.Json;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.auth.TestUtils;
import com.google.common.io.BaseEncoding;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

/** Transport that simulates the IAMCredentials server for access tokens. */
public class MockIAMCredentialsServiceTransport extends MockHttpTransport {

  private static class ServerResponse {
    private final int statusCode;
    private final String response;
    private final boolean repeatServerResponse;

    public ServerResponse(int statusCode, String response, boolean repeatServerResponse) {
      this.statusCode = statusCode;
      this.response = response;
      this.repeatServerResponse = repeatServerResponse;
    }
  }

  private static final String DEFAULT_IAM_ACCESS_TOKEN_ENDPOINT =
      "https://iamcredentials.%s/v1/projects/-/serviceAccounts/%s:generateAccessToken";
  private static final String IAM_SIGN_ENDPOINT =
      "https://iamcredentials.%s/v1/projects/-/serviceAccounts/%s:signBlob";

  private final Deque<ServerResponse> serverResponses;

  private String targetPrincipal;
  private byte[] signedBlob;
  private String iamAccessTokenEndpoint;

  private String accessToken;
  private String expireTime;

  private String idToken;

  private String universeDomain;

  private RegionalAccessBoundary regionalAccessBoundary;

  private MockLowLevelHttpRequest request;

  MockIAMCredentialsServiceTransport(String universeDomain) {
    this.universeDomain = universeDomain;
    this.serverResponses = new ArrayDeque<>();
  }

  // Store the number of requests that are sent to the Mock Server. This is used to track the
  // number of retries attempts made to ensure that retry boundaries are respected.
  private int numRequests;

  public MockIAMCredentialsServiceTransport() {
    this.serverResponses = new ArrayDeque<>();
  }

  public void setTargetPrincipal(String targetPrincipal) {
    this.targetPrincipal = targetPrincipal;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public void setExpireTime(String expireTime) {
    this.expireTime = expireTime;
  }

  public void setSignedBlob(byte[] signedBlob) {
    this.signedBlob = signedBlob;
  }

  // Enqueue the status code + message. Each request to the mock server will pop off the
  // status code + message in the order it was enqueued
  public void addStatusCodeAndMessage(int responseCode, String message) {
    addStatusCodeAndMessage(responseCode, message, false);
  }

  // repeat to ensure simulate scenarios where retrying returns the same status over and over.
  // Setting repeat will result in this status code being returned until the connection is
  // terminated.
  public void addStatusCodeAndMessage(int responseCode, String message, boolean repeat) {
    serverResponses.offer(new ServerResponse(responseCode, message, repeat));
  }

  public void setIdToken(String idToken) {
    this.idToken = idToken;
  }

  public void setAccessTokenEndpoint(String accessTokenEndpoint) {
    this.iamAccessTokenEndpoint = accessTokenEndpoint;
  }

  public void setRegionalAccessBoundary(RegionalAccessBoundary regionalAccessBoundary) {
    this.regionalAccessBoundary = regionalAccessBoundary;
  }

  public MockLowLevelHttpRequest getRequest() {
    return request;
  }

  int getNumRequests() {
    return numRequests;
  }

  @Override
  public LowLevelHttpRequest buildRequest(String method, String url) throws IOException {
    String iamAccessTokenFormattedUrl =
        iamAccessTokenEndpoint != null
            ? iamAccessTokenEndpoint
            : String.format(
                DEFAULT_IAM_ACCESS_TOKEN_ENDPOINT, universeDomain, this.targetPrincipal);
    String iamSignBlobformattedUrl =
        String.format(IAM_SIGN_ENDPOINT, universeDomain, this.targetPrincipal);
    String iamIdTokenformattedUrl =
        String.format(IAM_ID_TOKEN_ENDPOINT_FORMAT, universeDomain, this.targetPrincipal);
    ServerResponse serverResponse = serverResponses.poll();
    // Status code was configured to be repeated until connection is terminated
    if (serverResponse.repeatServerResponse) {
      serverResponses.offerFirst(serverResponse);
    }
    if (url.equals(iamAccessTokenFormattedUrl)) {
      this.request =
          new MockLowLevelHttpRequest(url) {
            @Override
            public LowLevelHttpResponse execute() throws IOException {
              if (serverResponse.statusCode != HttpStatusCodes.STATUS_CODE_OK) {
                return new MockLowLevelHttpResponse()
                    .setStatusCode(serverResponse.statusCode)
                    .setContentType(Json.MEDIA_TYPE)
                    .setContent(serverResponse.response);
              }

              // Create the JSON response
              GenericJson refreshContents = new GenericJson();
              refreshContents.setFactory(OAuth2Utils.JSON_FACTORY);
              refreshContents.put("accessToken", accessToken);
              refreshContents.put("expireTime", expireTime);
              String refreshText = refreshContents.toPrettyString();
              return new MockLowLevelHttpResponse()
                  .setContentType(Json.MEDIA_TYPE)
                  .setContent(refreshText);
            }
          };
    } else if (url.equals(iamSignBlobformattedUrl)) {
      this.request =
          new MockLowLevelHttpRequest(url) {
            @Override
            public LowLevelHttpResponse execute() throws IOException {
              BaseEncoding base64 = BaseEncoding.base64();
              GenericJson refreshContents = new GenericJson();
              refreshContents.setFactory(OAuth2Utils.JSON_FACTORY);

              if (serverResponse.statusCode != HttpStatusCodes.STATUS_CODE_OK) {
                return new MockLowLevelHttpResponse()
                    .setStatusCode(serverResponse.statusCode)
                    .setContent(TestUtils.errorJson(serverResponse.response));
              }
              refreshContents.put("signedBlob", base64.encode(signedBlob));
              String refreshText = refreshContents.toPrettyString();
              return new MockLowLevelHttpResponse()
                  .setContentType(Json.MEDIA_TYPE)
                  .setContent(refreshText);
            }
          };
    } else if (url.equals(iamIdTokenformattedUrl)) {
      this.request =
          new MockLowLevelHttpRequest(url) {
            @Override
            public LowLevelHttpResponse execute() throws IOException {
              if (serverResponse.statusCode != HttpStatusCodes.STATUS_CODE_OK) {
                return new MockLowLevelHttpResponse()
                    .setStatusCode(serverResponse.statusCode)
                    .setContentType(Json.MEDIA_TYPE)
                    .setContent(serverResponse.response);
              }

              GenericJson refreshContents = new GenericJson();
              refreshContents.setFactory(OAuth2Utils.JSON_FACTORY);
              refreshContents.put("token", idToken);
              String tokenContent = refreshContents.toPrettyString();
              return new MockLowLevelHttpResponse()
                  .setContentType(Json.MEDIA_TYPE)
                  .setContent(tokenContent);
            }
          };
    } else if (url.endsWith("/allowedLocations")) {
      request =
          new MockLowLevelHttpRequest(url) {
            @Override
            public LowLevelHttpResponse execute() throws IOException {
              if (regionalAccessBoundary == null) {
                return new MockLowLevelHttpResponse().setStatusCode(404);
              }
              GenericJson responseJson = new GenericJson();
              responseJson.setFactory(OAuth2Utils.JSON_FACTORY);
              responseJson.put("encodedLocations", regionalAccessBoundary.getEncodedLocations());
              responseJson.put("locations", regionalAccessBoundary.getLocations());
              String content = responseJson.toPrettyString();
              return new MockLowLevelHttpResponse()
                  .setContentType(Json.MEDIA_TYPE)
                  .setContent(content);
            }
          };
      return request;
    } else {
      return super.buildRequest(method, url);
    }
    numRequests++;

    return this.request;
  }
}
