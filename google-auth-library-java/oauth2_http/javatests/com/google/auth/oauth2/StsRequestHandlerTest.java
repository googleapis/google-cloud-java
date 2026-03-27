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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.api.client.http.HttpHeaders;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.util.GenericData;
import com.google.auth.TestUtils;
import com.google.common.base.Joiner;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Tests for {@link StsRequestHandler}. */
final class StsRequestHandlerTest {

  private static final String TOKEN_EXCHANGE_GRANT_TYPE =
      "urn:ietf:params:oauth:grant-type:token-exchange";
  private static final String DEFAULT_REQUESTED_TOKEN_TYPE =
      "urn:ietf:params:oauth:token-type:access_token";
  private static final String TOKEN_URL = "https://sts.googleapis.com/v1/token";

  private MockStsTransport transport;

  @BeforeEach
  void setup() {
    transport = new MockStsTransport();
  }

  @Test
  void exchangeToken() throws IOException {
    StsTokenExchangeRequest stsTokenExchangeRequest =
        StsTokenExchangeRequest.newBuilder("credential", "subjectTokenType")
            .setScopes(Collections.singletonList(OAuth2Utils.CLOUD_PLATFORM_SCOPE))
            .build();

    StsRequestHandler requestHandler =
        StsRequestHandler.newBuilder(
                TOKEN_URL, stsTokenExchangeRequest, transport.createRequestFactory())
            .build();

    StsTokenExchangeResponse response = requestHandler.exchangeToken();

    // Validate response.
    assertEquals(transport.getAccessToken(), response.getAccessToken().getTokenValue());
    assertEquals(transport.getTokenType(), response.getTokenType());
    assertEquals(transport.getIssuedTokenType(), response.getIssuedTokenType());
    assertEquals(transport.getExpiresIn(), response.getExpiresInSeconds());

    // Validate request content.
    GenericData expectedRequestContent =
        new GenericData()
            .set("grant_type", TOKEN_EXCHANGE_GRANT_TYPE)
            .set("scope", OAuth2Utils.CLOUD_PLATFORM_SCOPE)
            .set("requested_token_type", DEFAULT_REQUESTED_TOKEN_TYPE)
            .set("subject_token_type", stsTokenExchangeRequest.getSubjectTokenType())
            .set("subject_token", stsTokenExchangeRequest.getSubjectToken());

    MockLowLevelHttpRequest request = transport.getRequest();
    Map<String, String> actualRequestContent = TestUtils.parseQuery(request.getContentAsString());
    assertEquals(expectedRequestContent.getUnknownKeys(), actualRequestContent);
  }

  @Test
  void exchangeToken_withOptionalParams() throws IOException {
    // Return optional params scope and the refresh_token.
    transport.addScopeSequence(Arrays.asList("scope1", "scope2", "scope3"));
    transport.addRefreshTokenSequence("refreshToken");

    // Build the token exchange request.
    StsTokenExchangeRequest stsTokenExchangeRequest =
        StsTokenExchangeRequest.newBuilder("credential", "subjectTokenType")
            .setAudience("audience")
            .setResource("resource")
            .setActingParty(new ActingParty("actorToken", "actorTokenType"))
            .setRequestTokenType("requestedTokenType")
            .setScopes(Arrays.asList("scope1", "scope2", "scope3"))
            .build();

    HttpHeaders httpHeaders =
        new HttpHeaders()
            .setContentType("application/x-www-form-urlencoded")
            .setAcceptEncoding("gzip")
            .set("custom_header_key", "custom_header_value");

    StsRequestHandler requestHandler =
        StsRequestHandler.newBuilder(
                TOKEN_URL, stsTokenExchangeRequest, transport.createRequestFactory())
            .setHeaders(httpHeaders)
            .setInternalOptions("internalOptions")
            .build();

    StsTokenExchangeResponse response = requestHandler.exchangeToken();

    // Validate response.
    assertEquals(transport.getAccessToken(), response.getAccessToken().getTokenValue());
    assertEquals(transport.getTokenType(), response.getTokenType());
    assertEquals(transport.getIssuedTokenType(), response.getIssuedTokenType());
    assertEquals(transport.getExpiresIn(), response.getExpiresInSeconds());
    assertEquals(Arrays.asList("scope1", "scope2", "scope3"), response.getScopes());
    assertEquals("refreshToken", response.getRefreshToken());

    // Validate headers.
    MockLowLevelHttpRequest request = transport.getRequest();
    Map<String, List<String>> requestHeaders = request.getHeaders();
    assertEquals("application/x-www-form-urlencoded", requestHeaders.get("content-type").get(0));
    assertEquals("gzip", requestHeaders.get("accept-encoding").get(0));
    assertEquals("custom_header_value", requestHeaders.get("custom_header_key").get(0));

    // Validate request content.
    GenericData expectedRequestContent =
        new GenericData()
            .set("grant_type", TOKEN_EXCHANGE_GRANT_TYPE)
            .set("scope", Joiner.on(' ').join(Arrays.asList("scope1", "scope2", "scope3")))
            .set("options", "internalOptions")
            .set("subject_token_type", stsTokenExchangeRequest.getSubjectTokenType())
            .set("subject_token", stsTokenExchangeRequest.getSubjectToken())
            .set("requested_token_type", stsTokenExchangeRequest.getRequestedTokenType())
            .set("actor_token", stsTokenExchangeRequest.getActingParty().getActorToken())
            .set("actor_token_type", stsTokenExchangeRequest.getActingParty().getActorTokenType())
            .set("resource", stsTokenExchangeRequest.getResource())
            .set("audience", stsTokenExchangeRequest.getAudience());

    Map<String, String> actualRequestContent = TestUtils.parseQuery(request.getContentAsString());
    assertEquals(expectedRequestContent.getUnknownKeys(), actualRequestContent);
  }

  @Test
  void exchangeToken_throwsException() throws IOException {
    StsTokenExchangeRequest stsTokenExchangeRequest =
        StsTokenExchangeRequest.newBuilder("credential", "subjectTokenType").build();

    final StsRequestHandler requestHandler =
        StsRequestHandler.newBuilder(
                TOKEN_URL, stsTokenExchangeRequest, transport.createRequestFactory())
            .build();

    transport.addResponseErrorSequence(
        TestUtils.buildHttpResponseException(
            "invalidRequest", /* errorDescription= */ null, /* errorUri= */ null));

    OAuthException e = assertThrows(OAuthException.class, () -> requestHandler.exchangeToken());

    assertEquals("invalidRequest", e.getErrorCode());
    assertNull(e.getErrorDescription());
    assertNull(e.getErrorUri());
  }

  @Test
  void exchangeToken_withOptionalParams_throwsException() throws IOException {
    StsTokenExchangeRequest stsTokenExchangeRequest =
        StsTokenExchangeRequest.newBuilder("credential", "subjectTokenType").build();

    final StsRequestHandler requestHandler =
        StsRequestHandler.newBuilder(
                TOKEN_URL, stsTokenExchangeRequest, transport.createRequestFactory())
            .build();

    transport.addResponseErrorSequence(
        TestUtils.buildHttpResponseException("invalidRequest", "errorDescription", "errorUri"));

    OAuthException e = assertThrows(OAuthException.class, () -> requestHandler.exchangeToken());

    assertEquals("invalidRequest", e.getErrorCode());
    assertEquals("errorDescription", e.getErrorDescription());
    assertEquals("errorUri", e.getErrorUri());
  }

  @Test
  void exchangeToken_ioException() {
    StsTokenExchangeRequest stsTokenExchangeRequest =
        StsTokenExchangeRequest.newBuilder("credential", "subjectTokenType").build();

    final StsRequestHandler requestHandler =
        StsRequestHandler.newBuilder(
                TOKEN_URL, stsTokenExchangeRequest, transport.createRequestFactory())
            .build();

    IOException e = new IOException();
    transport.addResponseErrorSequence(e);

    IOException thrownException =
        assertThrows(IOException.class, () -> requestHandler.exchangeToken());
    assertEquals(e, thrownException);
  }

  @Test
  void exchangeToken_noExpiresInReturned() throws IOException {
    // Don't return expires in. This happens in the CAB flow when the subject token does not belong
    // to a service account.
    transport.setReturnExpiresIn(/* returnExpiresIn= */ false);

    StsTokenExchangeRequest stsTokenExchangeRequest =
        StsTokenExchangeRequest.newBuilder("credential", "subjectTokenType")
            .setScopes(Collections.singletonList(OAuth2Utils.CLOUD_PLATFORM_SCOPE))
            .build();

    StsRequestHandler requestHandler =
        StsRequestHandler.newBuilder(
                TOKEN_URL, stsTokenExchangeRequest, transport.createRequestFactory())
            .build();

    StsTokenExchangeResponse response = requestHandler.exchangeToken();

    // Validate response.
    assertEquals(transport.getAccessToken(), response.getAccessToken().getTokenValue());
    assertNull(response.getAccessToken().getExpirationTime());

    assertEquals(transport.getTokenType(), response.getTokenType());
    assertEquals(transport.getIssuedTokenType(), response.getIssuedTokenType());
    assertNull(response.getExpiresInSeconds());
  }

  @Test
  void exchangeToken_withAccessBoundarySessionKey() throws IOException {
    transport.setReturnAccessBoundarySessionKey(/* returnAccessBoundarySessionKey= */ true);

    StsTokenExchangeRequest stsTokenExchangeRequest =
        StsTokenExchangeRequest.newBuilder("credential", "subjectTokenType").build();

    StsRequestHandler requestHandler =
        StsRequestHandler.newBuilder(
                TOKEN_URL, stsTokenExchangeRequest, transport.createRequestFactory())
            .build();

    StsTokenExchangeResponse response = requestHandler.exchangeToken();

    // Validate response.
    assertEquals(transport.getAccessBoundarySessionKey(), response.getAccessBoundarySessionKey());
  }
}
