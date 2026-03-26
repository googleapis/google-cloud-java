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
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.Json;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.auth.TestUtils;
import com.google.common.base.Joiner;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Mock transport that handles the necessary steps to exchange an external credential for a GCP
 * access-token.
 */
public class MockExternalAccountCredentialsTransport extends MockHttpTransport {

  private static final String EXPECTED_GRANT_TYPE =
      "urn:ietf:params:oauth:grant-type:token-exchange";
  private static final String ISSUED_TOKEN_TYPE = "urn:ietf:params:oauth:token-type:access_token";
  private static final String AWS_CREDENTIALS_URL = "https://169.254.169.254";
  private static final String AWS_REGION_URL = "https://169.254.169.254/region";
  private static final String AWS_IMDSV2_SESSION_TOKEN_URL = "https://169.254.169.254/imdsv2";
  private static final String METADATA_SERVER_URL = "https://www.metadata.google.com";
  private static final String STS_URL = "https://sts.googleapis.com/v1/token";

  private static final String SUBJECT_TOKEN = "subjectToken";
  private static final String TOKEN_TYPE = "Bearer";
  private static final String ACCESS_TOKEN = "accessToken";
  private static final String AWS_IMDSV2_SESSION_TOKEN = "sessiontoken";
  private static final String SERVICE_ACCOUNT_ACCESS_TOKEN = "serviceAccountAccessToken";
  private static final String AWS_REGION = "us-east-1b";
  private static final Long EXPIRES_IN = 3600L;

  private static final JsonFactory JSON_FACTORY = new GsonFactory();

  static final String SERVICE_ACCOUNT_IMPERSONATION_URL =
      "https://iamcredentials.googleapis.com/v1/projects/-/serviceAccounts/testn@test.iam.gserviceaccount.com:generateAccessToken";

  static final String IAM_ENDPOINT = "https://iamcredentials.googleapis.com";

  private Queue<Boolean> responseSequence = new ArrayDeque<>();
  private Queue<IOException> responseErrorSequence = new ArrayDeque<>();
  private Queue<String> refreshTokenSequence = new ArrayDeque<>();
  private Queue<List<String>> scopeSequence = new ArrayDeque<>();
  private List<MockLowLevelHttpRequest> requests = new ArrayList<>();
  private String expireTime;
  private String metadataServerContentType;
  private String stsContent;

  public void addResponseErrorSequence(IOException... errors) {
    Collections.addAll(responseErrorSequence, errors);
  }

  public void addResponseSequence(Boolean... responses) {
    Collections.addAll(responseSequence, responses);
  }

  public void addRefreshTokenSequence(String... refreshTokens) {
    Collections.addAll(refreshTokenSequence, refreshTokens);
  }

  public void addScopeSequence(List<String>... scopes) {
    Collections.addAll(scopeSequence, scopes);
  }

  @Override
  @SuppressWarnings("unchecked")
  public LowLevelHttpRequest buildRequest(final String method, final String url) {
    MockLowLevelHttpRequest request =
        new MockLowLevelHttpRequest(url) {
          @Override
          public LowLevelHttpResponse execute() throws IOException {
            boolean successfulResponse = !responseSequence.isEmpty() && responseSequence.poll();

            if (!responseErrorSequence.isEmpty() && !successfulResponse) {
              throw responseErrorSequence.poll();
            }

            if (AWS_IMDSV2_SESSION_TOKEN_URL.equals(url)) {
              return new MockLowLevelHttpResponse()
                  .setContentType("text/html")
                  .setContent(AWS_IMDSV2_SESSION_TOKEN);
            }
            if (AWS_REGION_URL.equals(url)) {
              return new MockLowLevelHttpResponse()
                  .setContentType("text/html")
                  .setContent(AWS_REGION);
            }
            if (AWS_CREDENTIALS_URL.equals(url)) {
              return new MockLowLevelHttpResponse()
                  .setContentType("text/html")
                  .setContent("roleName");
            }
            if ((AWS_CREDENTIALS_URL + "/" + "roleName").equals(url)) {
              GenericJson response = new GenericJson();
              response.setFactory(JSON_FACTORY);
              response.put("AccessKeyId", "accessKeyId");
              response.put("SecretAccessKey", "secretAccessKey");
              response.put("Token", "token");

              return new MockLowLevelHttpResponse()
                  .setContentType(Json.MEDIA_TYPE)
                  .setContent(response.toString());
            }

            if (METADATA_SERVER_URL.equals(url)) {
              String metadataRequestHeader = getFirstHeaderValue("Metadata-Flavor");
              if (!"Google".equals(metadataRequestHeader)) {
                throw new IOException("Metadata request header not found.");
              }

              if (metadataServerContentType != null && metadataServerContentType.equals("json")) {
                GenericJson response = new GenericJson();
                response.setFactory(JSON_FACTORY);
                response.put("subjectToken", SUBJECT_TOKEN);
                return new MockLowLevelHttpResponse()
                    .setContentType(Json.MEDIA_TYPE)
                    .setContent(response.toString());
              }
              return new MockLowLevelHttpResponse()
                  .setContentType("text/html")
                  .setContent(SUBJECT_TOKEN);
            }
            if (STS_URL.equals(url)) {
              Map<String, String> query = TestUtils.parseQuery(getContentAsString());

              // Store STS content as multiple calls are made using this transport.
              stsContent = getContentAsString();

              assertEquals(EXPECTED_GRANT_TYPE, query.get("grant_type"));
              assertNotNull(query.get("subject_token_type"));
              assertNotNull(query.get("subject_token"));

              GenericJson response = new GenericJson();
              response.setFactory(JSON_FACTORY);
              response.put("token_type", TOKEN_TYPE);
              response.put("expires_in", EXPIRES_IN);
              response.put("access_token", ACCESS_TOKEN);
              response.put("issued_token_type", ISSUED_TOKEN_TYPE);

              if (!refreshTokenSequence.isEmpty()) {
                response.put("refresh_token", refreshTokenSequence.poll());
              }
              if (!scopeSequence.isEmpty()) {
                response.put("scope", Joiner.on(' ').join(scopeSequence.poll()));
              }
              return new MockLowLevelHttpResponse()
                  .setContentType(Json.MEDIA_TYPE)
                  .setContent(response.toPrettyString());
            }

            if (url.contains(IAM_ENDPOINT)) {
              GenericJson query =
                  OAuth2Utils.JSON_FACTORY
                      .createJsonParser(getContentAsString())
                      .parseAndClose(GenericJson.class);
              assertEquals(
                  OAuth2Utils.CLOUD_PLATFORM_SCOPE,
                  ((ArrayList<String>) query.get("scope")).get(0));
              assertEquals(1, getHeaders().get("authorization").size());
              assertTrue(getHeaders().containsKey("authorization"));
              assertNotNull(getHeaders().get("authorization").get(0));

              GenericJson response = new GenericJson();
              response.setFactory(JSON_FACTORY);
              response.put("accessToken", SERVICE_ACCOUNT_ACCESS_TOKEN);
              response.put("expireTime", expireTime);

              return new MockLowLevelHttpResponse()
                  .setContentType(Json.MEDIA_TYPE)
                  .setContent(response.toPrettyString());
            }
            return null;
          }
        };

    this.requests.add(request);
    return request;
  }

  public String getStsContent() {
    return stsContent;
  }

  public MockLowLevelHttpRequest getLastRequest() {
    if (requests.isEmpty()) {
      return null;
    }

    return requests.get(requests.size() - 1);
  }

  public List<MockLowLevelHttpRequest> getRequests() {
    return Collections.unmodifiableList(requests);
  }

  public String getTokenType() {
    return TOKEN_TYPE;
  }

  public String getAccessToken() {
    return ACCESS_TOKEN;
  }

  public String getServiceAccountAccessToken() {
    return SERVICE_ACCOUNT_ACCESS_TOKEN;
  }

  public String getIssuedTokenType() {
    return ISSUED_TOKEN_TYPE;
  }

  public Long getExpiresIn() {
    return EXPIRES_IN;
  }

  public String getSubjectToken() {
    return SUBJECT_TOKEN;
  }

  public String getMetadataUrl() {
    return METADATA_SERVER_URL;
  }

  public String getAwsCredentialsUrl() {
    return AWS_CREDENTIALS_URL;
  }

  public String getAwsRegionUrl() {
    return AWS_REGION_URL;
  }

  public String getAwsImdsv2SessionTokenUrl() {
    return AWS_IMDSV2_SESSION_TOKEN_URL;
  }

  public String getAwsRegion() {
    return AWS_REGION;
  }

  public String getStsUrl() {
    return STS_URL;
  }

  public String getServiceAccountImpersonationUrl() {
    return SERVICE_ACCOUNT_IMPERSONATION_URL;
  }

  public void setExpireTime(String expireTime) {
    this.expireTime = expireTime;
  }

  public void setMetadataServerContentType(String contentType) {
    this.metadataServerContentType = contentType;
  }
}
