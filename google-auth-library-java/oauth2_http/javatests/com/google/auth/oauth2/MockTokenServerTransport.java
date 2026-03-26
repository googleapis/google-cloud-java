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

import static com.google.auth.TestUtils.WORKFORCE_IDENTITY_FEDERATION_TOKEN_SERVER_URI;

import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.Json;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.json.webtoken.JsonWebSignature;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.auth.TestUtils;
import com.google.auth.oauth2.UserAuthorizer.ClientAuthenticationType;
import com.google.common.util.concurrent.Futures;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/** Mock transport to simulate providing Google OAuth2 access tokens */
public class MockTokenServerTransport extends MockHttpTransport {

  public static final String REFRESH_TOKEN_WITH_USER_SCOPE = "refresh_token_with_user.email_scope";
  static final JsonFactory JSON_FACTORY = new GsonFactory();
  int buildRequestCount;
  final Map<String, String> clients = new HashMap<String, String>();
  final Map<String, String> refreshTokens = new HashMap<String, String>();
  final Map<String, String> grantedScopes = new HashMap<String, String>();
  final Map<String, String> serviceAccounts = new HashMap<String, String>();
  final Map<String, String> gdchServiceAccounts = new HashMap<String, String>();
  final Map<String, String> codes = new HashMap<String, String>();
  final Map<String, Map<String, String>> additionalParameters =
      new HashMap<String, Map<String, String>>();
  URI tokenServerUri = OAuth2Utils.TOKEN_SERVER_URI;
  private IOException error;
  private final Queue<Future<LowLevelHttpResponse>> responseSequence = new ArrayDeque<>();
  private int expiresInSeconds = 3600;
  private MockLowLevelHttpRequest request;
  private ClientAuthenticationType clientAuthenticationType;
  private PKCEProvider pkceProvider;

  public MockTokenServerTransport() {}

  public URI getTokenServerUri() {
    return tokenServerUri;
  }

  public void setTokenServerUri(URI tokenServerUri) {
    this.tokenServerUri = tokenServerUri;
  }

  public void setClientAuthType(ClientAuthenticationType type) {
    this.clientAuthenticationType = type;
  }

  public void setPkceProvider(PKCEProvider pkceProvider) {
    this.pkceProvider = pkceProvider;
  }

  public void addAuthorizationCode(
      String code,
      String refreshToken,
      String accessToken,
      String grantedScopes,
      Map<String, String> additionalParameters) {
    codes.put(code, refreshToken);
    refreshTokens.put(refreshToken, accessToken);
    this.grantedScopes.put(refreshToken, grantedScopes);

    if (additionalParameters != null) {
      this.additionalParameters.put(code, additionalParameters);
    }
  }

  public void addClient(String clientId, String clientSecret) {
    clients.put(clientId, clientSecret);
  }

  public void addRefreshToken(String refreshToken, String accessTokenToReturn) {
    refreshTokens.put(refreshToken, accessTokenToReturn);
  }

  public void addRefreshToken(
      String refreshToken, String accessTokenToReturn, String grantedScopes) {
    refreshTokens.put(refreshToken, accessTokenToReturn);
    this.grantedScopes.put(refreshToken, grantedScopes);
  }

  public void addServiceAccount(String email, String accessToken) {
    serviceAccounts.put(email, accessToken);
  }

  public void addGdchServiceAccount(String serviceIdentityName, String accessToken) {
    gdchServiceAccounts.put(serviceIdentityName, accessToken);
  }

  public String getAccessToken(String refreshToken) {
    return refreshTokens.get(refreshToken);
  }

  public void setError(IOException error) {
    this.error = error;
  }

  public void addResponseErrorSequence(IOException... errors) {
    for (IOException error : errors) {
      responseSequence.add(Futures.<LowLevelHttpResponse>immediateFailedFuture(error));
    }
  }

  public void addResponseSequence(LowLevelHttpResponse... responses) {
    for (LowLevelHttpResponse response : responses) {
      responseSequence.add(Futures.immediateFuture(response));
    }
  }

  public void addResponseSequence(Future<LowLevelHttpResponse> response) {
    responseSequence.add(response);
  }

  public void setExpiresInSeconds(int expiresInSeconds) {
    this.expiresInSeconds = expiresInSeconds;
  }

  public MockLowLevelHttpRequest getRequest() {
    return request;
  }

  @Override
  public LowLevelHttpRequest buildRequest(String method, String url) throws IOException {
    buildRequestCount++;
    if (error != null) {
      throw error;
    }
    int questionMarkPos = url.indexOf('?');
    final String urlWithoutQuery = (questionMarkPos > 0) ? url.substring(0, questionMarkPos) : url;
    final String query = (questionMarkPos > 0) ? url.substring(questionMarkPos + 1) : "";

    if (!responseSequence.isEmpty()) {
      request =
          new MockLowLevelHttpRequest(url) {
            @Override
            public LowLevelHttpResponse execute() throws IOException {
              try {
                return responseSequence.poll().get();
              } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                throw (IOException) cause;
              } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Unexpectedly interrupted");
              }
            }
          };
      return request;
    }

    if (urlWithoutQuery.equals(tokenServerUri.toString())) {
      request =
          new MockLowLevelHttpRequest(url) {
            @Override
            public LowLevelHttpResponse execute() throws IOException {

              if (!responseSequence.isEmpty()) {
                try {
                  return responseSequence.poll().get();
                } catch (ExecutionException e) {
                  Throwable cause = e.getCause();
                  throw (IOException) cause;
                } catch (InterruptedException e) {
                  Thread.currentThread().interrupt();
                  throw new RuntimeException("Unexpectedly interrupted");
                }
              }

              String content = this.getContentAsString();
              Map<String, String> query = TestUtils.parseQuery(content);
              String accessToken = null;
              String refreshToken = null;
              String grantedScopesString = null;
              boolean generateAccessToken = true;

              String foundId = query.get("client_id");
              boolean isUserEmailScope = false;
              if (foundId != null) {
                if (!clients.containsKey(foundId)) {
                  throw new IOException("Client ID not found.");
                }
                String foundSecret = query.get("client_secret");
                String expectedSecret = clients.get(foundId);
                if ((foundSecret == null || !foundSecret.equals(expectedSecret))) {
                  throw new IOException("Client secret not found.");
                }
                String grantType = query.get("grant_type");
                if (grantType != null && grantType.equals("authorization_code")) {
                  String foundCode = query.get("code");
                  if (!codes.containsKey(foundCode)) {
                    throw new IOException("Authorization code not found");
                  }
                  refreshToken = codes.get(foundCode);
                } else {
                  refreshToken = query.get("refresh_token");
                }
                if (!refreshTokens.containsKey(refreshToken)) {
                  throw new IOException("Refresh Token not found.");
                }
                if (refreshToken.equals(REFRESH_TOKEN_WITH_USER_SCOPE)) {
                  isUserEmailScope = true;
                }
                accessToken = refreshTokens.get(refreshToken);

                if (grantedScopes.containsKey(refreshToken)) {
                  grantedScopesString = grantedScopes.get(refreshToken);
                }
                validateAdditionalParameters(query);
              } else if (query.containsKey("grant_type")) {
                String grantType = query.get("grant_type");
                String assertion = query.get("assertion");
                JsonWebSignature signature = JsonWebSignature.parse(JSON_FACTORY, assertion);
                if (OAuth2Utils.GRANT_TYPE_JWT_BEARER.equals(grantType)) {
                  String foundEmail = signature.getPayload().getIssuer();
                  if (!serviceAccounts.containsKey(foundEmail)) {}
                  accessToken = serviceAccounts.get(foundEmail);
                  String foundTargetAudience =
                      (String) signature.getPayload().get("target_audience");
                  String foundScopes = (String) signature.getPayload().get("scope");
                  if ((foundScopes == null || foundScopes.length() == 0)
                      && (foundTargetAudience == null || foundTargetAudience.length() == 0)) {
                    throw new IOException("Either target_audience or scopes must be specified.");
                  }

                  if (foundScopes != null && foundTargetAudience != null) {
                    throw new IOException(
                        "Only one of target_audience or scopes must be specified.");
                  }
                  if (foundTargetAudience != null) {
                    generateAccessToken = false;
                  }

                  // For GDCH scenario
                } else if (OAuth2Utils.TOKEN_TYPE_TOKEN_EXCHANGE.equals(grantType)) {
                  String foundServiceIdentityName = signature.getPayload().getIssuer();
                  if (!gdchServiceAccounts.containsKey(foundServiceIdentityName)) {
                    throw new IOException(
                        "GDCH Service Account Service Identity Name not found as issuer.");
                  }
                  accessToken = gdchServiceAccounts.get(foundServiceIdentityName);
                  String foundApiAudience = (String) signature.getPayload().get("api_audience");
                  if ((foundApiAudience == null || foundApiAudience.length() == 0)) {
                    throw new IOException("Api_audience must be specified.");
                  }
                } else {
                  throw new IOException("Service Account Email not found as issuer.");
                }
              } else {
                throw new IOException("Unknown token type.");
              }

              // Create the JSON response
              // https://developers.google.com/identity/protocols/OpenIDConnect#server-flow
              GenericJson responseContents = new GenericJson();
              responseContents.setFactory(JSON_FACTORY);
              responseContents.put("token_type", "Bearer");
              responseContents.put("expires_in", expiresInSeconds);
              if (generateAccessToken) {
                responseContents.put("access_token", accessToken);
                if (refreshToken != null) {
                  responseContents.put("refresh_token", refreshToken);
                }
                if (grantedScopesString != null) {
                  responseContents.put("scope", grantedScopesString);
                }
              }
              if (isUserEmailScope || !generateAccessToken) {
                responseContents.put("id_token", ServiceAccountCredentialsTest.DEFAULT_ID_TOKEN);
              }
              String refreshText = responseContents.toPrettyString();

              return new MockLowLevelHttpResponse()
                  .setContentType(Json.MEDIA_TYPE)
                  .setContent(refreshText);
            }
          };
      return request;
    } else if (urlWithoutQuery.equals(OAuth2Utils.TOKEN_REVOKE_URI.toString())) {
      request =
          new MockLowLevelHttpRequest(url) {
            @Override
            public LowLevelHttpResponse execute() throws IOException {
              Map<String, String> parameters = TestUtils.parseQuery(this.getContentAsString());
              String token = parameters.get("token");
              if (token == null) {
                throw new IOException("Token to revoke not found.");
              }
              // Token could be access token or refresh token so remove keys and values
              refreshTokens.values().removeAll(Collections.singleton(token));
              refreshTokens.remove(token);
              return new MockLowLevelHttpResponse().setContentType(Json.MEDIA_TYPE);
            }
          };
      return request;
    }
    if (urlWithoutQuery.equals(WORKFORCE_IDENTITY_FEDERATION_TOKEN_SERVER_URI.toString())) {
      request =
          new MockLowLevelHttpRequest(url) {
            @Override
            public LowLevelHttpResponse execute() throws IOException {

              if (!responseSequence.isEmpty()) {
                try {
                  return responseSequence.poll().get();
                } catch (ExecutionException e) {
                  Throwable cause = e.getCause();
                  throw (IOException) cause;
                } catch (InterruptedException e) {
                  Thread.currentThread().interrupt();
                  throw new RuntimeException("Unexpectedly interrupted");
                }
              }

              String content = this.getContentAsString();
              Map<String, String> query = TestUtils.parseQuery(content);

              // Validate required fields.
              if (!query.containsKey("code")
                  || !query.containsKey("client_id")
                  || !query.containsKey("redirect_uri")
                  || !query.containsKey("grant_type")) {
                throw new IOException("Invalid request, missing one or more fields.");
              }

              String clientId = query.get("client_id");
              if (!clients.containsKey(clientId)) {
                throw new IOException("Client ID not registered.");
              }

              if (!clients.containsKey(query.get("client_id"))) {
                throw new IOException("Client ID not registered.");
              }

              String grantType = query.get("grant_type");
              if (!grantType.equals("authorization_code")) {
                throw new IOException("Invalid grant_type. Must be authorization_code.");
              }

              if (pkceProvider != null && !query.containsKey("code_verifier")) {
                throw new IOException("Code verifier must be provided.");
              }

              validateAdditionalParameters(query);

              // Generate response.
              String refreshToken = codes.get(query.get("code"));
              String accessToken = getAccessToken(refreshToken);
              GenericJson responseContents = new GenericJson();
              responseContents.setFactory(JSON_FACTORY);
              responseContents.put("token_type", "Bearer");
              responseContents.put("expires_in", expiresInSeconds);
              responseContents.put("access_token", accessToken);
              responseContents.put("refresh_token", refreshToken);

              if (query.containsKey("scopes")) {
                responseContents.put("scope", query.get("scopes"));
              }

              String refreshText = responseContents.toPrettyString();

              return new MockLowLevelHttpResponse()
                  .setContentType(Json.MEDIA_TYPE)
                  .setContent(refreshText);
            }
          };
      return request;
    }
    return super.buildRequest(method, url);
  }

  private void validateAdditionalParameters(Map<String, String> query) {
    if (additionalParameters.containsKey(query.get("code"))) {
      Map<String, String> additionalParametersMap = additionalParameters.get(query.get("code"));
      for (Map.Entry<String, String> entry : additionalParametersMap.entrySet()) {
        String key = entry.getKey();
        String expectedValue = entry.getValue();
        if (!query.containsKey(key)) {
          throw new IllegalArgumentException("Missing additional parameter: " + key);
        } else {
          String actualValue = query.get(key);
          if (!expectedValue.equals(actualValue)) {
            throw new IllegalArgumentException(
                "For additional parameter "
                    + key
                    + ", Actual value: "
                    + actualValue
                    + ", Expected value: "
                    + expectedValue);
          }
        }
      }
    }
  }
}
