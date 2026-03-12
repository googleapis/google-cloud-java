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

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.UrlEncodedContent;
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.JsonParser;
import com.google.api.client.util.GenericData;
import com.google.api.core.InternalApi;
import com.google.common.base.Joiner;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;

/**
 * Implements the OAuth 2.0 token exchange based on <a
 * href="https://tools.ietf.org/html/rfc8693">RFC 8693</a>.
 *
 * <p>This class handles the process of exchanging one type of token for another using the Security
 * Token Service (STS). It constructs and sends the token exchange request to the STS endpoint and
 * parses the response to create an {@link StsTokenExchangeResponse} object.
 *
 * <p>Use the {@link #newBuilder(String, StsTokenExchangeRequest, HttpRequestFactory)} method to
 * create a new builder for constructing an instance of this class.
 */
public final class StsRequestHandler {
  private static final String TOKEN_EXCHANGE_GRANT_TYPE =
      "urn:ietf:params:oauth:grant-type:token-exchange";
  private static final String PARSE_ERROR_PREFIX = "Error parsing token response.";

  private final String tokenExchangeEndpoint;
  private final StsTokenExchangeRequest request;
  private final HttpRequestFactory httpRequestFactory;

  @Nullable private final HttpHeaders headers;
  @Nullable private final String internalOptions;

  private final int connectTimeout;
  private final int readTimeout;

  /**
   * Internal constructor.
   *
   * @return an StsTokenExchangeResponse instance if the request was successful
   */
  private StsRequestHandler(Builder builder) {
    this.tokenExchangeEndpoint = builder.tokenExchangeEndpoint;
    this.request = builder.request;
    this.httpRequestFactory = builder.httpRequestFactory;
    this.headers = builder.headers;
    this.internalOptions = builder.internalOptions;
    this.connectTimeout = builder.connectTimeout;
    this.readTimeout = builder.readTimeout;
  }

  /**
   * Returns a new builder for creating an instance of {@link StsRequestHandler}.
   *
   * @param tokenExchangeEndpoint The STS token exchange endpoint.
   * @param stsTokenExchangeRequest The STS token exchange request.
   * @param httpRequestFactory The HTTP request factory to use for sending the request.
   * @return A new builder instance.
   */
  public static Builder newBuilder(
      String tokenExchangeEndpoint,
      StsTokenExchangeRequest stsTokenExchangeRequest,
      HttpRequestFactory httpRequestFactory) {
    return new Builder(tokenExchangeEndpoint, stsTokenExchangeRequest, httpRequestFactory);
  }

  /** Exchanges the provided token for another type of token based on the RFC 8693 spec. */
  public StsTokenExchangeResponse exchangeToken() throws IOException {
    UrlEncodedContent content = new UrlEncodedContent(buildTokenRequest());

    HttpRequest httpRequest =
        httpRequestFactory.buildPostRequest(new GenericUrl(tokenExchangeEndpoint), content);
    httpRequest.setParser(new JsonObjectParser(OAuth2Utils.JSON_FACTORY));
    if (headers != null) {
      httpRequest.setHeaders(headers);
    }
    httpRequest.setConnectTimeout(connectTimeout);
    httpRequest.setReadTimeout(readTimeout);

    try {
      HttpResponse response = httpRequest.execute();
      GenericData responseData = response.parseAs(GenericData.class);
      return buildResponse(responseData);
    } catch (HttpResponseException e) {
      throw OAuthException.createFromHttpResponseException(e);
    }
  }

  private GenericData buildTokenRequest() {
    GenericData tokenRequest =
        new GenericData()
            .set("grant_type", TOKEN_EXCHANGE_GRANT_TYPE)
            .set("subject_token_type", request.getSubjectTokenType())
            .set("subject_token", request.getSubjectToken());

    // Add scopes as a space-delimited string.
    List<String> scopes = new ArrayList<>();
    if (request.hasScopes()) {
      scopes.addAll(request.getScopes());
      tokenRequest.set("scope", Joiner.on(' ').join(scopes));
    }

    // Set the requested token type, which defaults to
    // urn:ietf:params:oauth:token-type:access_token.
    String requestTokenType =
        request.hasRequestedTokenType()
            ? request.getRequestedTokenType()
            : OAuth2Utils.TOKEN_TYPE_ACCESS_TOKEN;
    tokenRequest.set("requested_token_type", requestTokenType);

    // Add other optional params, if possible.
    if (request.hasResource()) {
      tokenRequest.set("resource", request.getResource());
    }
    if (request.hasAudience()) {
      tokenRequest.set("audience", request.getAudience());
    }

    if (request.hasActingParty()) {
      tokenRequest.set("actor_token", request.getActingParty().getActorToken());
      tokenRequest.set("actor_token_type", request.getActingParty().getActorTokenType());
    }

    if (internalOptions != null && !internalOptions.isEmpty()) {
      tokenRequest.set("options", internalOptions);
    }
    return tokenRequest;
  }

  private StsTokenExchangeResponse buildResponse(GenericData responseData) throws IOException {
    String accessToken =
        OAuth2Utils.validateString(responseData, "access_token", PARSE_ERROR_PREFIX);
    String issuedTokenType =
        OAuth2Utils.validateString(responseData, "issued_token_type", PARSE_ERROR_PREFIX);
    String tokenType = OAuth2Utils.validateString(responseData, "token_type", PARSE_ERROR_PREFIX);

    StsTokenExchangeResponse.Builder builder =
        StsTokenExchangeResponse.newBuilder(accessToken, issuedTokenType, tokenType);

    if (responseData.containsKey("expires_in")) {
      builder.setExpiresInSeconds(
          OAuth2Utils.validateLong(responseData, "expires_in", PARSE_ERROR_PREFIX));
    }
    if (responseData.containsKey("refresh_token")) {
      builder.setRefreshToken(
          OAuth2Utils.validateString(responseData, "refresh_token", PARSE_ERROR_PREFIX));
    }
    if (responseData.containsKey("scope")) {
      String scope = OAuth2Utils.validateString(responseData, "scope", PARSE_ERROR_PREFIX);
      builder.setScopes(Arrays.asList(scope.trim().split("\\s+")));
    }
    if (responseData.containsKey("access_boundary_session_key")) {
      builder.setAccessBoundarySessionKey(
          OAuth2Utils.validateString(
              responseData, "access_boundary_session_key", PARSE_ERROR_PREFIX));
    }
    return builder.build();
  }

  private GenericJson parseJson(String json) throws IOException {
    JsonParser parser = OAuth2Utils.JSON_FACTORY.createJsonParser(json);
    return parser.parseAndClose(GenericJson.class);
  }

  public static class Builder {
    private final String tokenExchangeEndpoint;
    private final StsTokenExchangeRequest request;
    private final HttpRequestFactory httpRequestFactory;

    @Nullable private HttpHeaders headers;
    @Nullable private String internalOptions;

    private int connectTimeout = 20000; // Default to 20000ms = 20s
    private int readTimeout = 20000; // Default to 20000ms = 20s

    private Builder(
        String tokenExchangeEndpoint,
        StsTokenExchangeRequest stsTokenExchangeRequest,
        HttpRequestFactory httpRequestFactory) {
      this.tokenExchangeEndpoint = tokenExchangeEndpoint;
      this.request = stsTokenExchangeRequest;
      this.httpRequestFactory = httpRequestFactory;
    }

    @CanIgnoreReturnValue
    public StsRequestHandler.Builder setHeaders(HttpHeaders headers) {
      this.headers = headers;
      return this;
    }

    @CanIgnoreReturnValue
    public StsRequestHandler.Builder setInternalOptions(String internalOptions) {
      this.internalOptions = internalOptions;
      return this;
    }

    /** Warning: Not for public use and can be removed at any time. */
    @InternalApi
    public StsRequestHandler.Builder setConnectTimeout(int connectTimeout) {
      this.connectTimeout = connectTimeout;
      return this;
    }

    /** Warning: Not for public use and can be removed at any time. */
    @InternalApi
    public StsRequestHandler.Builder setReadTimeout(int readTimeout) {
      this.readTimeout = readTimeout;
      return this;
    }

    public StsRequestHandler build() {
      return new StsRequestHandler(this);
    }
  }
}
