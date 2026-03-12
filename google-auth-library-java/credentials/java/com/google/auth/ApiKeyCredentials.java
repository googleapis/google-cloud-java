/*
 * Copyright 2024, Google Inc. All rights reserved.
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
package com.google.auth;

import java.io.IOException;
import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Credentials class for calling Google APIs using an API key.
 *
 * <p>Uses an API key directly in the request metadata to provide authorization.
 *
 * <p>Note: ApiKeyCredentials extends from base {@link Credentials} class rather than
 * GoogleCredentials/OAuth2Credentials, as it does not provide an access token and is not considered
 * an OAuth2 credential.
 *
 * <pre><code>
 * Credentials credentials = ApiKeyCredentials.create("your api key");
 * </code></pre>
 */
public class ApiKeyCredentials extends Credentials {
  static final String API_KEY_HEADER_KEY = "x-goog-api-key";
  private final String apiKey;

  ApiKeyCredentials(String apiKey) {
    this.apiKey = apiKey;
  }

  public static ApiKeyCredentials create(String apiKey) {
    if (apiKey == null || apiKey.isEmpty()) {
      throw new IllegalArgumentException("API key cannot be null or blank");
    }
    return new ApiKeyCredentials(apiKey);
  }

  @Override
  public String getAuthenticationType() {
    return "API-Key";
  }

  @Override
  public Map<String, List<String>> getRequestMetadata(URI uri) throws IOException {
    return Collections.singletonMap(API_KEY_HEADER_KEY, Collections.singletonList(apiKey));
  }

  @Override
  public boolean hasRequestMetadata() {
    return true;
  }

  @Override
  public boolean hasRequestMetadataOnly() {
    return true;
  }

  /** There is no concept of refreshing an API tokens, this method is a no-op. */
  @Override
  public void refresh() throws IOException {}
}
