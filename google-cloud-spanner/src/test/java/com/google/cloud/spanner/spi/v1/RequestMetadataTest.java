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

package com.google.cloud.spanner.spi.v1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;

import com.google.cloud.spanner.spi.v1.GrpcSpannerRpc.MetadataClientCall;
import io.grpc.ClientCall;
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

/** Unit tests for {@link GrpcSpannerRpc.MetadataClientCall}. */
@RunWith(JUnit4.class)
public class RequestMetadataTest {
  private static final Metadata.Key<String> HEADER_KEY =
      Metadata.Key.of("google-cloud-resource-prefix", Metadata.ASCII_STRING_MARSHALLER);

  private Metadata metadata;

  @Mock
  private ClientCall<Void, Void> innerCall;
  @Mock
  private ClientCall.Listener<Void> listener;
  @Captor
  private ArgumentCaptor<Metadata> innerMetadata;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    metadata = new Metadata();
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
