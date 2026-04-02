/*
 * Copyright 2016 Google LLC
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
package com.google.api.gax.grpc.testing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.gax.rpc.TransportChannel;
import com.google.common.truth.Truth;
import io.grpc.Server;
import io.grpc.ServerServiceDefinition;
import java.io.IOException;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/** Tests for {@link MockServiceHelper}. */
public class MockServiceHelperTest {
  @Mock private MockGrpcService grpcService;
  @Mock private MockGrpcService grpcService2;

  @Mock private Server server;

  /** Sets up mocks. */
  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
    when(grpcService.getServiceDefinition())
        .thenReturn(ServerServiceDefinition.builder("fake-service").build());
    when(grpcService2.getServiceDefinition())
        .thenReturn(ServerServiceDefinition.builder("fake-service2").build());
  }

  @Test
  void testGetService() {
    MockServiceHelper serviceHelper = new MockServiceHelper(server, "fake-address", grpcService);
    Truth.assertThat(serviceHelper.getService()).isSameInstanceAs(grpcService);
    Truth.assertThat(serviceHelper.getServices().size()).isEqualTo(1);
  }

  @Test
  void testGetServiceInvalid() {
    MockServiceHelper serviceHelper =
        new MockServiceHelper(server, "fake-address2", Arrays.asList(grpcService, grpcService2));
    assertThrows(IllegalStateException.class, serviceHelper::getService);
  }

  @Test
  void testStart() throws IOException {
    MockServiceHelper serviceHelper = new MockServiceHelper(server, "fake-address", grpcService);
    serviceHelper.start();
    verify(server, times(1)).start();
  }

  @Test
  void testReset() {
    MockServiceHelper serviceHelper = new MockServiceHelper("fake-address", grpcService);
    serviceHelper.reset();
    verify(grpcService, times(1)).getServiceDefinition();
    verify(grpcService, times(1)).reset();
  }

  @Test
  void testCreateChannelProvider() throws Exception {
    MockServiceHelper serviceHelper = new MockServiceHelper("fake-address", grpcService);
    TransportChannel channel = serviceHelper.createChannelProvider().getTransportChannel();
    assertNotNull(channel);
    assertFalse(channel.isTerminated());
    channel.shutdownNow();
  }
}
