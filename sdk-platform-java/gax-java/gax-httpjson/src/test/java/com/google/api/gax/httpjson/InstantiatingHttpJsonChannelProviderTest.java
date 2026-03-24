/*
 * Copyright 2019 Google LLC
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
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.mtls.AbstractMtlsTransportChannelTest;
import com.google.api.gax.rpc.mtls.CertificateBasedAccess;
import com.google.auth.mtls.MtlsProvider;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class InstantiatingHttpJsonChannelProviderTest extends AbstractMtlsTransportChannelTest {

  private static final String DEFAULT_ENDPOINT = "localhost:8080";
  private static final Map<String, String> DEFAULT_HEADER_MAP = Collections.emptyMap();
  private CertificateBasedAccess certificateBasedAccess;

  @BeforeEach
  public void setup() throws IOException {
    certificateBasedAccess =
        new CertificateBasedAccess(
            name -> name.equals("GOOGLE_API_USE_MTLS_ENDPOINT") ? "never" : "false");
  }

  @Test
  void basicTest() throws IOException {
    ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(1);
    executor.shutdown();

    TransportChannelProvider provider =
        InstantiatingHttpJsonChannelProvider.newBuilder()
            .setCertificateBasedAccess(certificateBasedAccess)
            .build();

    assertThat(provider.needsEndpoint()).isTrue();
    provider = provider.withEndpoint(DEFAULT_ENDPOINT);
    assertThat(provider.needsEndpoint()).isFalse();

    assertThat(provider.needsHeaders()).isTrue();
    provider = provider.withHeaders(DEFAULT_HEADER_MAP);
    assertThat(provider.needsHeaders()).isFalse();

    // Make sure getTransportChannel works without setting executor
    assertThat(provider.getTransportChannel()).isInstanceOf(HttpJsonTransportChannel.class);

    assertThat(provider.needsExecutor()).isTrue();
    provider = provider.withExecutor((Executor) executor);
    assertThat(provider.needsExecutor()).isFalse();

    // Added for code coverage. Remove when withExecutor(ScheduledExecutorService) is removed.
    assertThat(provider.needsExecutor()).isFalse();
    provider = provider.withExecutor(executor);
    assertThat(provider.needsExecutor()).isFalse();

    assertThat(provider.acceptsPoolSize()).isFalse();
    Exception thrownException = null;
    try {
      provider.withPoolSize(1);
    } catch (Exception e) {
      thrownException = e;
    }
    assertThat(thrownException).isInstanceOf(UnsupportedOperationException.class);

    assertThat(provider.needsCredentials()).isFalse();
    thrownException = null;
    try {
      provider.withCredentials(null);
    } catch (Exception e) {
      thrownException = e;
    }
    assertThat(thrownException).isInstanceOf(UnsupportedOperationException.class);

    assertEquals(HttpJsonTransportChannel.getHttpJsonTransportName(), provider.getTransportName());
    assertThat(provider.getTransportChannel()).isInstanceOf(HttpJsonTransportChannel.class);

    // Make sure we can create channels OK.
    provider.getTransportChannel().shutdownNow();
  }

  // Ensure that a default executor is created by the ManagedHttpJsonChannel even
  // if not provided by the TransportChannelProvider
  @Test
  void managedChannelUsesDefaultChannelExecutor() throws IOException {
    InstantiatingHttpJsonChannelProvider instantiatingHttpJsonChannelProvider =
        InstantiatingHttpJsonChannelProvider.newBuilder()
            .setEndpoint(DEFAULT_ENDPOINT)
            .setCertificateBasedAccess(certificateBasedAccess)
            .build();
    instantiatingHttpJsonChannelProvider =
        (InstantiatingHttpJsonChannelProvider)
            instantiatingHttpJsonChannelProvider.withHeaders(DEFAULT_HEADER_MAP);
    HttpJsonTransportChannel httpJsonTransportChannel =
        instantiatingHttpJsonChannelProvider.getTransportChannel();

    // By default, the channel will be wrapped with ManagedHttpJsonInterceptorChannel
    ManagedHttpJsonInterceptorChannel interceptorChannel =
        (ManagedHttpJsonInterceptorChannel) httpJsonTransportChannel.getManagedChannel();
    // call getChannel() twice because interceptors are chained in layers by recursive construction
    // inside com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider.createChannel
    ManagedHttpJsonInterceptorChannel managedHttpJsonChannel =
        (ManagedHttpJsonInterceptorChannel) interceptorChannel.getChannel();
    ManagedHttpJsonChannel channel = managedHttpJsonChannel.getChannel();
    assertThat(channel.getExecutor()).isNotNull();

    // Clean up the resources (executor, deadlineScheduler, httpTransport)
    instantiatingHttpJsonChannelProvider.getTransportChannel().shutdownNow();
  }

  // Ensure that the user's executor is used by the ManagedHttpJsonChannel
  @Test
  void managedChannelUsesCustomExecutor() throws IOException {
    // Custom executor to use -- Lifecycle must be managed by this test
    ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(1);
    executor.shutdown();

    InstantiatingHttpJsonChannelProvider instantiatingHttpJsonChannelProvider =
        InstantiatingHttpJsonChannelProvider.newBuilder()
            .setEndpoint(DEFAULT_ENDPOINT)
            .setExecutor(executor)
            .setCertificateBasedAccess(certificateBasedAccess)
            .build();
    instantiatingHttpJsonChannelProvider =
        (InstantiatingHttpJsonChannelProvider)
            instantiatingHttpJsonChannelProvider.withHeaders(DEFAULT_HEADER_MAP);
    HttpJsonTransportChannel httpJsonTransportChannel =
        instantiatingHttpJsonChannelProvider.getTransportChannel();

    // By default, the channel will be wrapped with ManagedHttpJsonInterceptorChannel
    ManagedHttpJsonInterceptorChannel interceptorChannel =
        (ManagedHttpJsonInterceptorChannel) httpJsonTransportChannel.getManagedChannel();
    // call getChannel() twice because interceptors are chained in layers by recursive construction
    // inside com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider.createChannel
    ManagedHttpJsonInterceptorChannel managedHttpJsonChannel =
        (ManagedHttpJsonInterceptorChannel) interceptorChannel.getChannel();
    ManagedHttpJsonChannel channel = managedHttpJsonChannel.getChannel();

    assertThat(channel.getExecutor()).isNotNull();
    assertThat(channel.getExecutor()).isEqualTo(executor);

    // Clean up the resources (executor, deadlineScheduler, httpTransport)
    instantiatingHttpJsonChannelProvider.getTransportChannel().shutdownNow();
  }

  @Override
  protected Object getMtlsObjectFromTransportChannel(
      MtlsProvider provider, CertificateBasedAccess certificateBasedAccess)
      throws IOException, GeneralSecurityException {
    InstantiatingHttpJsonChannelProvider channelProvider =
        InstantiatingHttpJsonChannelProvider.newBuilder()
            .setEndpoint("localhost:8080")
            .setMtlsProvider(provider)
            .setCertificateBasedAccess(certificateBasedAccess)
            .setHeaderProvider(Mockito.mock(HeaderProvider.class))
            .setExecutor(Mockito.mock(Executor.class))
            .build();
    return channelProvider.createHttpTransport();
  }
}
