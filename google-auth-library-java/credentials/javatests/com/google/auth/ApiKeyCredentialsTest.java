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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

/** Test case for {@link ApiKeyCredentials}. */
class ApiKeyCredentialsTest {

  private static final String TEST_API_KEY = "testApiKey";

  @Test
  void testGetAuthenticationType() {
    ApiKeyCredentials credentials = ApiKeyCredentials.create(TEST_API_KEY);
    assertEquals("API-Key", credentials.getAuthenticationType());
  }

  @Test
  void testGetRequestMetadata() throws IOException, URISyntaxException {
    ApiKeyCredentials credentials = ApiKeyCredentials.create(TEST_API_KEY);
    Map<String, List<String>> metadata = credentials.getRequestMetadata(new URI("http://test.com"));
    assertEquals(1, metadata.size());
    assertTrue(metadata.containsKey(ApiKeyCredentials.API_KEY_HEADER_KEY));
    assertEquals(1, metadata.get(ApiKeyCredentials.API_KEY_HEADER_KEY).size());
    assertEquals(TEST_API_KEY, metadata.get(ApiKeyCredentials.API_KEY_HEADER_KEY).get(0));
  }

  @Test
  void testHasRequestMetadata() {
    ApiKeyCredentials credentials = ApiKeyCredentials.create(TEST_API_KEY);
    assertTrue(credentials.hasRequestMetadata());
  }

  @Test
  void testHasRequestMetadataOnly() {
    ApiKeyCredentials credentials = ApiKeyCredentials.create(TEST_API_KEY);
    assertTrue(credentials.hasRequestMetadataOnly());
  }

  @Test
  void testNullApiKey_ThrowsException() {
    assertThrows(IllegalArgumentException.class, () -> ApiKeyCredentials.create(null));
  }

  @Test
  void testBlankApiKey_ThrowsException() {
    assertThrows(IllegalArgumentException.class, () -> ApiKeyCredentials.create(""));
  }
}
