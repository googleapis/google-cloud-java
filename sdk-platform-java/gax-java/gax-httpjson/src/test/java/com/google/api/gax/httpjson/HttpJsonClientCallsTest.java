/*
 * Copyright 2024 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
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
package com.google.api.gax.httpjson;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.api.gax.rpc.EndpointContext;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.UnauthenticatedException;
import com.google.auth.Credentials;
import com.google.auth.Retryable;
import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class HttpJsonClientCallsTest {

  // Auth Library's GoogleAuthException is package-private. Copy basic functionality for tests
  private static class GoogleAuthException extends IOException implements Retryable {

    private final boolean isRetryable;

    private GoogleAuthException(boolean isRetryable) {
      this.isRetryable = isRetryable;
    }

    @Override
    public boolean isRetryable() {
      return isRetryable;
    }

    @Override
    public int getRetryCount() {
      return 0;
    }
  }

  private Credentials credentials;
  private EndpointContext endpointContext;
  private HttpJsonChannel mockChannel;
  private ApiMethodDescriptor descriptor;
  private HttpJsonCallOptions callOptions;
  private HttpJsonCallContext callContext;

  @BeforeEach
  void setUp() throws IOException {
    credentials = Mockito.mock(Credentials.class);
    endpointContext = Mockito.mock(EndpointContext.class);
    mockChannel = Mockito.mock(HttpJsonChannel.class);
    descriptor = Mockito.mock(ApiMethodDescriptor.class);
    callOptions = Mockito.mock(HttpJsonCallOptions.class);

    callContext =
        HttpJsonCallContext.of(mockChannel, callOptions)
            .withEndpointContext(endpointContext)
            .withChannel(mockChannel);

    Mockito.when(callOptions.getCredentials()).thenReturn(credentials);
    Mockito.doNothing()
        .when(endpointContext)
        .validateUniverseDomain(
            Mockito.any(Credentials.class), Mockito.any(HttpJsonStatusCode.class));
  }

  @Test
  void testValidUniverseDomain() {
    HttpJsonClientCalls.newCall(descriptor, callContext);
    Mockito.verify(mockChannel, Mockito.times(1)).newCall(descriptor, callOptions);
  }

  // This test is when the universe domain does not match
  @Test
  void testInvalidUniverseDomain() throws IOException {
    Mockito.doThrow(
            new UnauthenticatedException(
                null, HttpJsonStatusCode.of(StatusCode.Code.UNAUTHENTICATED), false))
        .when(endpointContext)
        .validateUniverseDomain(
            Mockito.any(Credentials.class), Mockito.any(HttpJsonStatusCode.class));

    UnauthenticatedException exception =
        assertThrows(
            UnauthenticatedException.class,
            () -> HttpJsonClientCalls.newCall(descriptor, callContext));
    assertThat(exception.getStatusCode().getCode())
        .isEqualTo(HttpJsonStatusCode.Code.UNAUTHENTICATED);
    Mockito.verify(mockChannel, Mockito.never()).newCall(descriptor, callOptions);
  }

  // This test is when the MDS is unable to return a valid universe domain
  @Test
  void testUniverseDomainNotReady_shouldRetry() throws IOException {
    Mockito.doThrow(new GoogleAuthException(true))
        .when(endpointContext)
        .validateUniverseDomain(
            Mockito.any(Credentials.class), Mockito.any(HttpJsonStatusCode.class));
    HttpJsonCallContext context =
        HttpJsonCallContext.createDefault()
            .withChannel(mockChannel)
            .withCredentials(credentials)
            .withEndpointContext(endpointContext);

    HttpJsonCallOptions callOptions = context.getCallOptions();

    UnauthenticatedException exception =
        assertThrows(
            UnauthenticatedException.class,
            () -> HttpJsonClientCalls.newCall(descriptor, callContext));
    assertThat(exception.getStatusCode().getCode())
        .isEqualTo(HttpJsonStatusCode.Code.UNAUTHENTICATED);
    Mockito.verify(mockChannel, Mockito.never()).newCall(descriptor, callOptions);
  }
}
