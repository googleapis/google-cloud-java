/*
 * Copyright 2023, Google Inc. All rights reserved.
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

import com.google.api.client.testing.http.FixedClock;
import java.io.IOException;
import java.net.URI;
import java.util.Map;

/**
 * This class marked public as it is used in showcase tests to test GDCH:
 * https://github.com/googleapis/google-cloud-java/blob/e50b96b70826f173e6d23278fea96c2af9b6e817/java-showcase/gapic-showcase/src/test/java/com/google/showcase/v1beta1/it/ITGdch.java#L217-L225
 */
public class GdchCredentialsTestUtil {
  public static void registerGdchCredentialWithMockTransport(
      GdchCredentials credentials,
      MockTokenServerTransport transport,
      String projectId,
      String serviceIdentityName,
      String tokenString,
      URI tokenServerUri) {
    credentials.clock = new FixedClock(0L);
    transport.addGdchServiceAccount(
        GdchCredentials.getIssuerSubjectValue(projectId, serviceIdentityName), tokenString);
    transport.setTokenServerUri(tokenServerUri);
  }

  public static GdchCredentials fromJson(
      Map<String, Object> json, MockTokenServerTransportFactory transportFactory)
      throws IOException {
    return GdchCredentials.fromJson(json, transportFactory);
  }
}
