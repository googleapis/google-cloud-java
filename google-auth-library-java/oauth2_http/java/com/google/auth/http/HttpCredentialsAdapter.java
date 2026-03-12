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

import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpStatusCodes;
import com.google.api.client.http.HttpUnsuccessfulResponseHandler;
import com.google.api.client.util.Preconditions;
import com.google.auth.Credentials;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/** A wrapper for using Credentials with the Google API Client Libraries for Java with Http. */
public class HttpCredentialsAdapter
    implements HttpRequestInitializer, HttpUnsuccessfulResponseHandler {

  private static final Logger LOGGER = Logger.getLogger(HttpCredentialsAdapter.class.getName());

  /**
   * In case an abnormal HTTP response is received with {@code WWW-Authenticate} header, and its
   * value contains this error pattern, we will try to refresh the token.
   */
  private static final Pattern INVALID_TOKEN_ERROR =
      Pattern.compile("\\s*error\\s*=\\s*\"?invalid_token\"?");

  private final Credentials credentials;

  /**
   * @param credentials Credentials instance to adapt for HTTP
   */
  public HttpCredentialsAdapter(Credentials credentials) {
    Preconditions.checkNotNull(credentials);
    this.credentials = credentials;
  }

  /** A getter for the credentials instance being used */
  public Credentials getCredentials() {
    return credentials;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Initialize the HTTP request prior to execution.
   *
   * @param request HTTP request
   */
  @Override
  public void initialize(HttpRequest request) throws IOException {
    request.setUnsuccessfulResponseHandler(this);

    if (!credentials.hasRequestMetadata()) {
      return;
    }
    HttpHeaders requestHeaders = request.getHeaders();
    URI uri = null;
    if (request.getUrl() != null) {
      uri = request.getUrl().toURI();
    }
    Map<String, List<String>> credentialHeaders = credentials.getRequestMetadata(uri);
    if (credentialHeaders == null) {
      return;
    }
    for (Map.Entry<String, List<String>> entry : credentialHeaders.entrySet()) {
      String headerName = entry.getKey();
      List<String> requestValues = new ArrayList<>();
      requestValues.addAll(entry.getValue());
      requestHeaders.put(headerName, requestValues);
    }
  }

  /**
   * {@inheritDoc}
   *
   * <p>Checks if {@code WWW-Authenticate} exists and contains a "Bearer" value (see <a
   * href="http://tools.ietf.org/html/rfc6750#section-3.1">rfc6750 section 3.1</a> for more
   * details). If so, it refreshes the token in case the error code contains {@code invalid_token}.
   * If there is no "Bearer" in {@code WWW-Authenticate} and the status code is {@link
   * HttpStatusCodes#STATUS_CODE_UNAUTHORIZED} it refreshes the token. If the token refresh throws
   * an I/O exception, this implementation will log the exception and return {@code false}.
   */
  @Override
  public boolean handleResponse(HttpRequest request, HttpResponse response, boolean supportsRetry) {
    boolean refreshToken = false;
    boolean bearer = false;

    List<String> authenticateList = response.getHeaders().getAuthenticateAsList();

    // if authenticate list is not null we will check if one of the entries contains "Bearer"
    if (authenticateList != null) {
      for (String authenticate : authenticateList) {
        if (authenticate.startsWith(InternalAuthHttpConstants.BEARER_PREFIX)) {
          // mark that we found a "Bearer" value, and check if there is a invalid_token error
          bearer = true;
          refreshToken = INVALID_TOKEN_ERROR.matcher(authenticate).find();
          break;
        }
      }
    }

    // if "Bearer" wasn't found, we will refresh the token, if we got 401
    if (!bearer) {
      refreshToken = response.getStatusCode() == HttpStatusCodes.STATUS_CODE_UNAUTHORIZED;
    }

    if (refreshToken) {
      try {
        credentials.refresh();
        initialize(request);
        return true;
      } catch (IOException exception) {
        LOGGER.log(Level.SEVERE, "unable to refresh token", exception);
      }
    }
    return false;
  }
}
