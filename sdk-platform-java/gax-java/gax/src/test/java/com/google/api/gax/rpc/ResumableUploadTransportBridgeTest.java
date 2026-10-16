/*
 * Copyright 2026 Google LLC
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
package com.google.api.gax.rpc;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.rpc.testing.FakeChannel;
import com.google.api.gax.rpc.testing.FakeStubSettings;
import com.google.api.gax.rpc.testing.FakeTransportChannel;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class ResumableUploadTransportBridgeTest {

  private static final HeaderProvider HTTP_JSON_INTERNAL_HEADERS =
      FixedHeaderProvider.create("x-goog-api-client", "httpjson-token");

  @Test
  void testCreateUploadClientContext_sameTransport() throws IOException {
    FakeTransportChannel originalChannel = FakeTransportChannel.create(new FakeChannel());
    StubSettings<?> settings =
        FakeStubSettings.newBuilder()
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setTransportChannelProvider(FixedTransportChannelProvider.create(originalChannel))
            .build();

    ClientContext context =
        ResumableUploadTransportBridge.createUploadClientContext(
            settings,
            FixedTransportChannelProvider.create(FakeTransportChannel.create(new FakeChannel())),
            HTTP_JSON_INTERNAL_HEADERS);

    assertThat(context.getTransportChannel()).isSameInstanceAs(originalChannel);
    assertThat(
            ResumableUploadTransportBridge.hasNonSettingsTransportCustomization(
                context.getDefaultCallContext()))
        .isFalse();
  }

  @Test
  void testCreateUploadClientContext_differentTransport() throws IOException {
    TransportChannelProvider originalProvider =
        mock(TransportChannelProvider.class, withSettings().withoutAnnotations());
    when(originalProvider.getTransportName()).thenReturn("grpc");
    StubSettings<?> settings =
        FakeStubSettings.newBuilder()
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setTransportChannelProvider(originalProvider)
            .build();
    FakeTransportChannel httpJsonChannel = FakeTransportChannel.create(new FakeChannel());

    ClientContext context =
        ResumableUploadTransportBridge.createUploadClientContext(
            settings,
            FixedTransportChannelProvider.create(httpJsonChannel),
            HTTP_JSON_INTERNAL_HEADERS);

    assertThat(context.getTransportChannel()).isSameInstanceAs(httpJsonChannel);
    assertThat(context.getInternalHeaders()).containsEntry("x-goog-api-client", "httpjson-token");
    assertThat(
            ResumableUploadTransportBridge.hasNonSettingsTransportCustomization(
                context.getDefaultCallContext()))
        .isTrue();
  }

  @Test
  void testCreateUploadClientContext_differentTransport_uncustomized() throws IOException {
    TransportChannelProvider originalProvider =
        mock(TransportChannelProvider.class, withSettings().withoutAnnotations());
    when(originalProvider.getTransportName()).thenReturn("grpc");
    when(originalProvider.needsHeaders()).thenReturn(true);
    when(originalProvider.needsCredentials()).thenReturn(true);
    when(originalProvider.needsEndpoint()).thenReturn(true);
    StubSettings<?> settings =
        FakeStubSettings.newBuilder()
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setTransportChannelProvider(originalProvider)
            .build();

    ClientContext context =
        ResumableUploadTransportBridge.createUploadClientContext(
            settings,
            FixedTransportChannelProvider.create(FakeTransportChannel.create(new FakeChannel())),
            HTTP_JSON_INTERNAL_HEADERS);

    assertThat(
            ResumableUploadTransportBridge.hasNonSettingsTransportCustomization(
                context.getDefaultCallContext()))
        .isFalse();
  }

  @Test
  void testFailingCallable() {
    IOException cause = new IOException("no credentials");
    ResumableUploadCallable<String, String> callable =
        ResumableUploadTransportBridge.failingCallable(cause);
    InputStreamSupplier payload = () -> new ByteArrayInputStream(new byte[0]);

    IllegalStateException futureCallException =
        assertThrows(
            IllegalStateException.class, () -> callable.futureCall("request", payload, null, null));
    assertThat(futureCallException).hasCauseThat().isSameInstanceAs(cause);
    IllegalStateException resumeCallException =
        assertThrows(
            IllegalStateException.class,
            () -> callable.resumeCall("https://example.com/session", payload, null));
    assertThat(resumeCallException).hasCauseThat().isSameInstanceAs(cause);
  }
}
