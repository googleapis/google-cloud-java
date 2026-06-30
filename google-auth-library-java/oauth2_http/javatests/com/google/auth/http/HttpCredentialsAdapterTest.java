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

package com.google.auth.http;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.auth.Credentials;
import com.google.auth.oauth2.MockTokenCheckingTransport;
import com.google.auth.oauth2.MockTokenServerTransportFactory;
import com.google.auth.oauth2.OAuth2Credentials;
import com.google.auth.oauth2.UserCredentials;
import java.io.IOException;
import org.junit.jupiter.api.Test;

/** Test case for {@link HttpCredentialsAdapter}. */
class HttpCredentialsAdapterTest {

  private static final String CLIENT_SECRET = "jakuaL9YyieakhECKL2SwZcu";
  private static final String CLIENT_ID = "ya29.1.AADtN_UtlxN3PuGAxrN2XQnZTVRvDyVWnYq4I6dws";
  private static final String REFRESH_TOKEN = "1/Tl6awhpFjkMkSJoj1xsli0H2eL5YsMgU_NKPY2TyGWY";

  @Test
  void initialize_populatesOAuth2Credentials() throws IOException {
    final String accessToken = "1/MkSJoj1xsli0AccessToken_NKPY2";
    final String expectedAuthorization = InternalAuthHttpConstants.BEARER_PREFIX + accessToken;
    MockTokenServerTransportFactory transportFactory = new MockTokenServerTransportFactory();
    transportFactory.transport.addClient(CLIENT_ID, CLIENT_SECRET);
    transportFactory.transport.addRefreshToken(REFRESH_TOKEN, accessToken);

    OAuth2Credentials credentials =
        UserCredentials.newBuilder()
            .setClientId(CLIENT_ID)
            .setClientSecret(CLIENT_SECRET)
            .setRefreshToken(REFRESH_TOKEN)
            .setHttpTransportFactory(transportFactory)
            .build();

    HttpCredentialsAdapter adapter = new HttpCredentialsAdapter(credentials);
    HttpRequestFactory requestFactory = transportFactory.transport.createRequestFactory();
    HttpRequest request = requestFactory.buildGetRequest(new GenericUrl("http://foo"));

    adapter.initialize(request);

    HttpHeaders requestHeaders = request.getHeaders();
    String authorizationHeader = requestHeaders.getAuthorization();
    assertEquals(expectedAuthorization, authorizationHeader);
  }

  @Test
  void initialize_populatesOAuth2Credentials_handle401() throws IOException {
    final String accessToken = "1/MkSJoj1xsli0AccessToken_NKPY2";
    final String accessToken2 = "2/MkSJoj1xsli0AccessToken_NKPY2";

    MockTokenServerTransportFactory tokenServerTransportFactory =
        new MockTokenServerTransportFactory();
    tokenServerTransportFactory.transport.addClient(CLIENT_ID, CLIENT_SECRET);
    tokenServerTransportFactory.transport.addRefreshToken(REFRESH_TOKEN, accessToken);

    OAuth2Credentials credentials =
        UserCredentials.newBuilder()
            .setClientId(CLIENT_ID)
            .setClientSecret(CLIENT_SECRET)
            .setRefreshToken(REFRESH_TOKEN)
            .setHttpTransportFactory(tokenServerTransportFactory)
            .build();

    credentials.refresh();
    HttpCredentialsAdapter adapter = new HttpCredentialsAdapter(credentials);

    HttpTransport primaryHttpTransport =
        new MockTokenCheckingTransport(tokenServerTransportFactory.transport, REFRESH_TOKEN);
    HttpRequestFactory requestFactory = primaryHttpTransport.createRequestFactory();
    HttpRequest request = requestFactory.buildGetRequest(new GenericUrl("http://foo"));
    adapter.initialize(request);

    // now switch out the access token so that the original one is invalid,
    //   requiring a refresh of the access token
    tokenServerTransportFactory.transport.addRefreshToken(REFRESH_TOKEN, accessToken2);

    HttpResponse response = request.execute();

    // make sure that the request is successful despite the invalid access token
    assertEquals(200, response.getStatusCode());
    assertEquals(MockTokenCheckingTransport.SUCCESS_CONTENT, response.parseAsString());
  }

  @Test
  void initialize_noURI() throws IOException {
    final String accessToken = "1/MkSJoj1xsli0AccessToken_NKPY2";
    final String expectedAuthorization = InternalAuthHttpConstants.BEARER_PREFIX + accessToken;
    MockTokenServerTransportFactory tokenServerTransportFactory =
        new MockTokenServerTransportFactory();
    tokenServerTransportFactory.transport.addClient(CLIENT_ID, CLIENT_SECRET);
    tokenServerTransportFactory.transport.addRefreshToken(REFRESH_TOKEN, accessToken);

    OAuth2Credentials credentials =
        UserCredentials.newBuilder()
            .setClientId(CLIENT_ID)
            .setClientSecret(CLIENT_SECRET)
            .setRefreshToken(REFRESH_TOKEN)
            .setHttpTransportFactory(tokenServerTransportFactory)
            .build();

    HttpCredentialsAdapter adapter = new HttpCredentialsAdapter(credentials);
    HttpRequestFactory requestFactory =
        tokenServerTransportFactory.transport.createRequestFactory();
    HttpRequest request = requestFactory.buildGetRequest(null);

    adapter.initialize(request);

    HttpHeaders requestHeaders = request.getHeaders();
    String authorizationHeader = requestHeaders.getAuthorization();
    assertEquals(authorizationHeader, expectedAuthorization);
  }

  @Test
  void getCredentials() {
    final String accessToken = "1/MkSJoj1xsli0AccessToken_NKPY2";
    MockTokenServerTransportFactory tokenServerTransportFactory =
        new MockTokenServerTransportFactory();
    tokenServerTransportFactory.transport.addClient(CLIENT_ID, CLIENT_SECRET);
    tokenServerTransportFactory.transport.addRefreshToken(REFRESH_TOKEN, accessToken);

    OAuth2Credentials credentials =
        UserCredentials.newBuilder()
            .setClientId(CLIENT_ID)
            .setClientSecret(CLIENT_SECRET)
            .setRefreshToken(REFRESH_TOKEN)
            .setHttpTransportFactory(tokenServerTransportFactory)
            .build();

    HttpCredentialsAdapter adapter = new HttpCredentialsAdapter(credentials);
    Credentials returnedCredentials = adapter.getCredentials();
    assertInstanceOf(Credentials.class, returnedCredentials);
  }
}
