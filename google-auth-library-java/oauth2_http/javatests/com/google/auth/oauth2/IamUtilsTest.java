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
package com.google.auth.oauth2;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.api.client.http.HttpStatusCodes;
import com.google.auth.Credentials;
import com.google.auth.ServiceAccountSigner;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class IamUtilsTest {

  private static final String CLIENT_EMAIL =
      "36680232662-vrd7ji19qe3nelgchd0ah2csanun6bnr@developer.gserviceaccount.com";

  private ServiceAccountCredentials credentials;

  @BeforeEach
  void setup() throws IOException {
    // Mock this call for the Credentials because the IAM SignBlob RPC requires an access token. The
    // call is initialized with HttpCredentialsAdapter which will make a call to get the access
    // token
    credentials = Mockito.mock(ServiceAccountCredentials.class);
    Mockito.when(credentials.getRequestMetadata(Mockito.any())).thenReturn(ImmutableMap.of());
    Mockito.when(credentials.getUniverseDomain()).thenReturn("googleapis.com");
  }

  @Test
  void sign_success_noRetry() {
    byte[] expectedSignature = {0xD, 0xE, 0xA, 0xD};

    MockIAMCredentialsServiceTransportFactory transportFactory =
        new MockIAMCredentialsServiceTransportFactory();
    transportFactory.getTransport().setSignedBlob(expectedSignature);
    transportFactory.getTransport().setTargetPrincipal(CLIENT_EMAIL);
    transportFactory.getTransport().addStatusCodeAndMessage(HttpStatusCodes.STATUS_CODE_OK, "");

    byte[] signature =
        IamUtils.sign(
            CLIENT_EMAIL,
            credentials,
            Credentials.GOOGLE_DEFAULT_UNIVERSE,
            transportFactory.getTransport(),
            expectedSignature,
            ImmutableMap.of());
    assertArrayEquals(expectedSignature, signature);

    assertEquals(1, transportFactory.getTransport().getNumRequests());
  }

  // The SignBlob RPC will retry up to three times before it gives up. This test will return two
  // 5xx status codes before returning a success. This test covers the cases where the number of
  // retry attempts is below the configured retry attempt count bounds (3 attempts).
  @Test
  void sign_retryTwoTimes_success() {
    byte[] expectedSignature = {0xD, 0xE, 0xA, 0xD};

    MockIAMCredentialsServiceTransportFactory transportFactory =
        new MockIAMCredentialsServiceTransportFactory();
    transportFactory
        .getTransport()
        .addStatusCodeAndMessage(HttpStatusCodes.STATUS_CODE_BAD_GATEWAY, "Bad Gateway");
    transportFactory
        .getTransport()
        .addStatusCodeAndMessage(HttpStatusCodes.STATUS_CODE_SERVICE_UNAVAILABLE, "Unavailable");
    transportFactory.getTransport().addStatusCodeAndMessage(HttpStatusCodes.STATUS_CODE_OK, "");
    transportFactory.getTransport().setSignedBlob(expectedSignature);
    transportFactory.getTransport().setTargetPrincipal(CLIENT_EMAIL);

    byte[] signature =
        IamUtils.sign(
            CLIENT_EMAIL,
            credentials,
            Credentials.GOOGLE_DEFAULT_UNIVERSE,
            transportFactory.getTransport(),
            expectedSignature,
            ImmutableMap.of());
    assertArrayEquals(expectedSignature, signature);

    // Expect that three requests are made (2 failures which are retries + 1 final requests which
    // resulted in a successful response)
    assertEquals(3, transportFactory.getTransport().getNumRequests());
  }

  // The rpc will retry up to three times before it gives up. This test will enqueue three failed
  // status codes + messages before returning a success. After the third retry attempt, the request
  // will try one last time and the result will be reported back to the user.
  @Test
  void sign_retryThreeTimes_success() {
    byte[] expectedSignature = {0xD, 0xE, 0xA, 0xD};

    MockIAMCredentialsServiceTransportFactory transportFactory =
        new MockIAMCredentialsServiceTransportFactory();
    transportFactory.getTransport().setSignedBlob(expectedSignature);
    transportFactory.getTransport().setTargetPrincipal(CLIENT_EMAIL);
    transportFactory
        .getTransport()
        .addStatusCodeAndMessage(HttpStatusCodes.STATUS_CODE_BAD_GATEWAY, "Bad Gateway");
    transportFactory
        .getTransport()
        .addStatusCodeAndMessage(HttpStatusCodes.STATUS_CODE_SERVICE_UNAVAILABLE, "Unavailable");
    transportFactory
        .getTransport()
        .addStatusCodeAndMessage(HttpStatusCodes.STATUS_CODE_SERVER_ERROR, "Server Error");
    transportFactory.getTransport().addStatusCodeAndMessage(HttpStatusCodes.STATUS_CODE_OK, "");

    byte[] signature =
        IamUtils.sign(
            CLIENT_EMAIL,
            credentials,
            Credentials.GOOGLE_DEFAULT_UNIVERSE,
            transportFactory.getTransport(),
            expectedSignature,
            ImmutableMap.of());
    assertArrayEquals(expectedSignature, signature);

    // Expect that three requests are made (3 failures which are retried + 1 final request which
    // resulted the final success response)
    assertEquals(4, transportFactory.getTransport().getNumRequests());
  }

  // The rpc will retry up to three times before it gives up. This test will enqueue four failed
  // status codes + messages before returning a success. After the third retry attempt, the request
  // will try one last time and the result will be reported back to the user.
  @Test
  void sign_retryThreeTimes_exception() {
    byte[] expectedSignature = {0xD, 0xE, 0xA, 0xD};

    MockIAMCredentialsServiceTransportFactory transportFactory =
        new MockIAMCredentialsServiceTransportFactory();
    transportFactory.getTransport().setSignedBlob(expectedSignature);
    transportFactory.getTransport().setTargetPrincipal(CLIENT_EMAIL);
    transportFactory
        .getTransport()
        .addStatusCodeAndMessage(HttpStatusCodes.STATUS_CODE_BAD_GATEWAY, "Bad Gateway");
    transportFactory
        .getTransport()
        .addStatusCodeAndMessage(HttpStatusCodes.STATUS_CODE_SERVICE_UNAVAILABLE, "Unavailable");
    transportFactory
        .getTransport()
        .addStatusCodeAndMessage(HttpStatusCodes.STATUS_CODE_SERVER_ERROR, "Server Error");
    transportFactory
        .getTransport()
        .addStatusCodeAndMessage(HttpStatusCodes.STATUS_CODE_BAD_GATEWAY, "Bad Gateway");
    transportFactory.getTransport().addStatusCodeAndMessage(HttpStatusCodes.STATUS_CODE_OK, "");

    ServiceAccountSigner.SigningException exception =
        assertThrows(
            ServiceAccountSigner.SigningException.class,
            () ->
                IamUtils.sign(
                    CLIENT_EMAIL,
                    credentials,
                    Credentials.GOOGLE_DEFAULT_UNIVERSE,
                    transportFactory.getTransport(),
                    expectedSignature,
                    ImmutableMap.of()));
    assertTrue(exception.getMessage().contains("Failed to sign the provided bytes"));
    assertTrue(
        exception
            .getCause()
            .getMessage()
            .contains("Unexpected Error code 502 trying to sign provided bytes"));

    // Expect that three requests are made (3 failures which are retried + 1 final request which
    // resulted in another failed response)
    assertEquals(4, transportFactory.getTransport().getNumRequests());
  }

  @Test
  void sign_4xxError_noRetry_exception() {
    byte[] expectedSignature = {0xD, 0xE, 0xA, 0xD};

    MockIAMCredentialsServiceTransportFactory transportFactory =
        new MockIAMCredentialsServiceTransportFactory();
    transportFactory.getTransport().setSignedBlob(expectedSignature);
    transportFactory.getTransport().setTargetPrincipal(CLIENT_EMAIL);
    transportFactory
        .getTransport()
        .addStatusCodeAndMessage(
            HttpStatusCodes.STATUS_CODE_UNAUTHORIZED, "Failed to sign the provided bytes");

    ServiceAccountSigner.SigningException exception =
        assertThrows(
            ServiceAccountSigner.SigningException.class,
            () ->
                IamUtils.sign(
                    CLIENT_EMAIL,
                    credentials,
                    Credentials.GOOGLE_DEFAULT_UNIVERSE,
                    transportFactory.getTransport(),
                    expectedSignature,
                    ImmutableMap.of()));
    assertTrue(exception.getMessage().contains("Failed to sign the provided bytes"));
    assertTrue(
        exception
            .getCause()
            .getMessage()
            .contains("Error code 401 trying to sign provided bytes:"));

    // Only one request will have been made for a 4xx error (no retries)
    assertEquals(1, transportFactory.getTransport().getNumRequests());
  }
}
