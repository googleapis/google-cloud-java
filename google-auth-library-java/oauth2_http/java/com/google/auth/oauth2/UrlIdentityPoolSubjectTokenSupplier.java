/*
 * Copyright 2024 Google LLC
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

import static com.google.auth.oauth2.FileIdentityPoolSubjectTokenSupplier.parseToken;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.json.JsonObjectParser;
import com.google.auth.http.HttpTransportFactory;
import java.io.IOException;

/**
 * Provider for retrieving the subject tokens for {@link IdentityPoolCredentials} to exchange for
 * GCP access tokens. The subject token is retrieved by calling a URL that returns the token.
 */
class UrlIdentityPoolSubjectTokenSupplier implements IdentityPoolSubjectTokenSupplier {

  private static final long serialVersionUID = 4964578313468011844L;

  private final IdentityPoolCredentialSource credentialSource;
  private final transient HttpTransportFactory transportFactory;

  /**
   * Constructor for UrlIdentityPoolSubjectTokenProvider.
   *
   * @param credentialSource the credential source to use.
   * @param transportFactory the transport factory to use for calling the URL.
   */
  UrlIdentityPoolSubjectTokenSupplier(
      IdentityPoolCredentialSource credentialSource, HttpTransportFactory transportFactory) {
    this.credentialSource = credentialSource;
    this.transportFactory = transportFactory;
  }

  @Override
  public String getSubjectToken(ExternalAccountSupplierContext context) throws IOException {
    HttpRequest request =
        transportFactory
            .create()
            .createRequestFactory()
            .buildGetRequest(new GenericUrl(credentialSource.getCredentialLocation()));
    request.setParser(new JsonObjectParser(OAuth2Utils.JSON_FACTORY));

    if (credentialSource.hasHeaders()) {
      HttpHeaders headers = new HttpHeaders();
      headers.putAll(credentialSource.headers);
      request.setHeaders(headers);
    }

    try {
      HttpResponse response = request.execute();
      return parseToken(response.getContent(), this.credentialSource);
    } catch (IOException e) {
      throw new IOException(
          String.format("Error getting subject token from metadata server: %s", e.getMessage()), e);
    }
  }
}
