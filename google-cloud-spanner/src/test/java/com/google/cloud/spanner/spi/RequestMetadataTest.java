/*
 * Copyright 2017 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner.spi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;

import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.spi.DefaultSpannerRpc.MetadataClientCall;
import io.grpc.ClientCall;
import io.grpc.ClientCall.Listener;
import io.grpc.ManagedChannel;
import io.grpc.Metadata;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/** Unit tests for {@link com.google.cloud.spanner.spi.DefaultSpannerRpc.MetadataClientCall}. */
@RunWith(JUnit4.class)
public class RequestMetadataTest {
  static final Metadata.Key<String> HEADER_KEY =
      Metadata.Key.of("google-cloud-resource-prefix", Metadata.ASCII_STRING_MARSHALLER);

  // Used to mock out channels to Cloud Spanner.
  private class TestChannelFactory implements SpannerOptions.RpcChannelFactory {
    @Override
    public ManagedChannel newChannel(String host, int port) {
      return channel;
    }
  }

  SpannerOptions options;
  DefaultSpannerRpc rpc;
  Metadata metadata;

  @Mock ManagedChannel channel;
  @Mock ClientCall<Void, Void> innerCall;
  @Mock Listener<Void> innerListener;
  @Mock ClientCall.Listener<Void> listener;
  @Captor ArgumentCaptor<Metadata> innerMetadata;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    options =
        SpannerOptions.newBuilder()
            .setRpcChannelFactory(new TestChannelFactory())
            .setProjectId("p")
            .setCredentials(NoCredentials.getInstance())
            .build();
    rpc = new DefaultSpannerRpc(options);
    metadata = new Metadata();
  }

  @Test
  public void extractHeaderTest() {
    assertEquals(rpc.extractHeader("garbage"), "projects/p");
    assertEquals(rpc.extractHeader("projects/p"), "projects/p");
    assertEquals(rpc.extractHeader("projects/p/instances/i"), "projects/p/instances/i");
    assertEquals(
        rpc.extractHeader("projects/p/instances/i/databases/d"),
        "projects/p/instances/i/databases/d");
    assertEquals(
        rpc.extractHeader("projects/p/instances/i/databases/d/sessions/s"),
        "projects/p/instances/i/databases/d");
    assertEquals(
        rpc.extractHeader("projects/p/instances/i/operations/op"), "projects/p/instances/i");
    assertEquals(
        rpc.extractHeader("projects/p/instances/i/databases/d/operations/op"),
        "projects/p/instances/i/databases/d");
    assertEquals(rpc.extractHeader("projects/p/instances/i/operations"), "projects/p/instances/i");
    assertEquals(
        rpc.extractHeader("projects/p/instances/i/databases/d/operations"),
        "projects/p/instances/i/databases/d");
  }

  @Test
  public void metadataForwardingTest() {
    doNothing()
        .when(innerCall)
        .start(Mockito.<ClientCall.Listener<Void>>any(), innerMetadata.capture());

    Metadata in = new Metadata();
    in.put(HEADER_KEY, "TEST_HEADER");
    MetadataClientCall<Void, Void> metadataCall = new MetadataClientCall<>(innerCall, in);
    metadataCall.start(listener, metadata);
    assertTrue(innerMetadata.getValue().containsKey(HEADER_KEY));
    assertEquals(innerMetadata.getValue().get(HEADER_KEY), "TEST_HEADER");
  }
}
