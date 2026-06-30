/*
 * Copyright 2021 Google LLC
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
 *    * Neither the name of Google LLC nor the names of its
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.google.api.client.http.HttpStatusCodes;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.Json;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.auth.TestUtils;
import com.google.common.base.Joiner;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Transport that mocks a basic STS endpoint. */
public final class MockStsTransport extends MockHttpTransport {

  private static final String EXPECTED_GRANT_TYPE =
      "urn:ietf:params:oauth:grant-type:token-exchange";
  private static final String ISSUED_TOKEN_TYPE = "urn:ietf:params:oauth:token-type:access_token";
  private static final String VALID_STS_PATTERN =
      "https:\\/\\/sts.[a-z-_\\.]+\\/v1\\/(token|oauthtoken)";
  private static final String ACCESS_TOKEN = "accessToken";
  private static final String TOKEN_TYPE = "Bearer";
  private static final Long EXPIRES_IN = 3600L;
  private static final String ACCESS_BOUNDARY_SESSION_KEY_VALUE =
      "CPaEhYsKEmQKWAowdHlwZS5nb29nbGVhcGlzLmNvbS9nb29nbGUuY3J5cHRvLnRpbmsuQW"
          + "VzR2NtS2V5EiIaIMx8syvGIGGu5yvrdq/"
          + "I0Q9ZWIR1oqJXFnDFxHuwX4SEGAEQARj2hIWLCiAB";

  private final Queue<IOException> responseErrorSequence = new ArrayDeque<>();
  private final Queue<List<String>> scopeSequence = new ArrayDeque<>();
  private final Queue<String> refreshTokenSequence = new ArrayDeque<>();

  private boolean returnExpiresIn = true;
  private boolean returnAccessBoundarySessionKey = false;
  private String accessBoundarySessionKey = ACCESS_BOUNDARY_SESSION_KEY_VALUE;
  private MockLowLevelHttpRequest request;
  private int requestCount = 0;

  public void addResponseErrorSequence(IOException... errors) {
    Collections.addAll(responseErrorSequence, errors);
  }

  public void addRefreshTokenSequence(String... refreshTokens) {
    Collections.addAll(refreshTokenSequence, refreshTokens);
  }

  public void addScopeSequence(List<String> scopes) {
    Collections.addAll(scopeSequence, scopes);
  }

  @Override
  public LowLevelHttpRequest buildRequest(final String method, final String url) {
    requestCount++;
    this.request =
        new MockLowLevelHttpRequest(url) {
          @Override
          public LowLevelHttpResponse execute() throws IOException {
            // Environment version is prefixed by "aws". e.g. "aws1".
            Matcher matcher = Pattern.compile(VALID_STS_PATTERN).matcher(url);
            if (!matcher.matches()) {
              return makeErrorResponse();
            }

            if (!responseErrorSequence.isEmpty()) {
              throw responseErrorSequence.poll();
            }

            GenericJson response = new GenericJson();
            response.setFactory(new GsonFactory());

            Map<String, String> query = TestUtils.parseQuery(getContentAsString());
            if (!url.contains("v1/oauthtoken")) {
              assertEquals(EXPECTED_GRANT_TYPE, query.get("grant_type"));
              assertNotNull(query.get("subject_token_type"));
              assertNotNull(query.get("subject_token"));

              response.put("token_type", TOKEN_TYPE);
              response.put("access_token", ACCESS_TOKEN);
              response.put("issued_token_type", ISSUED_TOKEN_TYPE);

              if (returnExpiresIn) {
                response.put("expires_in", EXPIRES_IN);
              }
              if (!refreshTokenSequence.isEmpty()) {
                response.put("refresh_token", refreshTokenSequence.poll());
              }
              if (!scopeSequence.isEmpty()) {
                response.put("scope", Joiner.on(' ').join(scopeSequence.poll()));
              }
            } else {
              assertEquals("refresh_token", query.get("grant_type"));

              response.put("access_token", ACCESS_TOKEN);
              response.put("expires_in", EXPIRES_IN);

              if (!refreshTokenSequence.isEmpty()) {
                response.put("refresh_token", refreshTokenSequence.poll());
              }
            }

            if (returnAccessBoundarySessionKey) {
              response.put("access_boundary_session_key", accessBoundarySessionKey);
            }

            return new MockLowLevelHttpResponse()
                .setContentType(Json.MEDIA_TYPE)
                .setContent(response.toPrettyString());
          }
        };
    return this.request;
  }

  private MockLowLevelHttpResponse makeErrorResponse() {
    MockLowLevelHttpResponse errorResponse = new MockLowLevelHttpResponse();
    errorResponse.setStatusCode(HttpStatusCodes.STATUS_CODE_BAD_REQUEST);
    errorResponse.setContentType(Json.MEDIA_TYPE);
    errorResponse.setContent("{\"error\":\"error\"}");
    return errorResponse;
  }

  public MockLowLevelHttpRequest getRequest() {
    return request;
  }

  public String getAccessToken() {
    return ACCESS_TOKEN;
  }

  public String getTokenType() {
    return TOKEN_TYPE;
  }

  public String getIssuedTokenType() {
    return ISSUED_TOKEN_TYPE;
  }

  public Long getExpiresIn() {
    return EXPIRES_IN;
  }

  public String getAccessBoundarySessionKey() {
    return ACCESS_BOUNDARY_SESSION_KEY_VALUE;
  }

  public void setReturnExpiresIn(boolean returnExpiresIn) {
    this.returnExpiresIn = returnExpiresIn;
  }

  public void setAccessBoundarySessionKey(String accessBoundarySessionKey) {
    this.accessBoundarySessionKey = accessBoundarySessionKey;
  }

  public void setReturnAccessBoundarySessionKey(boolean returnAccessBoundarySessionKey) {
    this.returnAccessBoundarySessionKey = returnAccessBoundarySessionKey;
  }

  public int getRequestCount() {
    return requestCount;
  }
}
