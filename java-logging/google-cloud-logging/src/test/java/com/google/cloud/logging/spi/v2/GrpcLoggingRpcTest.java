/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.logging.spi.v2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.auth.Credentials;
import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.logging.LoggingOptions;
import com.google.cloud.logging.v2.LoggingSettings;
import java.io.IOException;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class GrpcLoggingRpcTest {

  private static final String PROJECT_ID = "test-project";
  private static final String CUSTOM_UNIVERSE = "s3nsapis.fr";
  private static final String CUSTOM_HOST = "custom-logging.example.com:443";

  /** Creates a dummy {@link GoogleCredentials} instance for testing. */
  private static GoogleCredentials createDummyCredentials() {
    return GoogleCredentials.create(
        new AccessToken("test-token", new Date(System.currentTimeMillis() + 3600_000L)));
  }

  @Test
  public void testCreateLoggingSettings_propagatesUniverseDomainAndDefersEndpoint()
      throws IOException {
    LoggingOptions options =
        LoggingOptions.newBuilder()
            .setProjectId(PROJECT_ID)
            .setCredentials(createDummyCredentials())
            .setUniverseDomain(CUSTOM_UNIVERSE)
            .build();

    LoggingSettings settings = GrpcLoggingRpc.createLoggingSettings(options);

    assertEquals(CUSTOM_UNIVERSE, settings.getUniverseDomain());
    InstantiatingGrpcChannelProvider channelProvider =
        (InstantiatingGrpcChannelProvider) settings.getTransportChannelProvider();
    assertTrue(channelProvider.needsEndpoint());
    assertNull(channelProvider.getEndpoint());

    ClientContext clientContext = ClientContext.create(settings);
    try {
      assertEquals(CUSTOM_UNIVERSE, clientContext.getUniverseDomain());
      GrpcTransportChannel transportChannel =
          (GrpcTransportChannel) clientContext.getTransportChannel();
      assertEquals(
          "logging." + CUSTOM_UNIVERSE + ":443", transportChannel.getChannel().authority());
    } finally {
      clientContext.getTransportChannel().shutdownNow();
    }
  }

  @Test
  public void testCreateLoggingSettings_defaultHostLeavesUniverseDomainAndEndpointUnset()
      throws IOException {
    LoggingOptions options =
        LoggingOptions.newBuilder()
            .setProjectId(PROJECT_ID)
            .setCredentials(createDummyCredentials())
            .build();

    LoggingSettings settings = GrpcLoggingRpc.createLoggingSettings(options);

    assertEquals(Credentials.GOOGLE_DEFAULT_UNIVERSE, settings.getUniverseDomain());
    InstantiatingGrpcChannelProvider channelProvider =
        (InstantiatingGrpcChannelProvider) settings.getTransportChannelProvider();
    assertTrue(channelProvider.needsEndpoint());
    assertNull(channelProvider.getEndpoint());
  }

  @Test
  public void testCreateLoggingSettings_customHostOverridesEndpoint() throws IOException {
    LoggingOptions options =
        LoggingOptions.newBuilder()
            .setProjectId(PROJECT_ID)
            .setCredentials(createDummyCredentials())
            .setUniverseDomain(CUSTOM_UNIVERSE)
            .setHost(CUSTOM_HOST)
            .build();

    LoggingSettings settings = GrpcLoggingRpc.createLoggingSettings(options);

    assertEquals(CUSTOM_UNIVERSE, settings.getUniverseDomain());
    assertEquals(CUSTOM_HOST, settings.getEndpoint());
    InstantiatingGrpcChannelProvider channelProvider =
        (InstantiatingGrpcChannelProvider) settings.getTransportChannelProvider();
    assertTrue(channelProvider.needsEndpoint());
    assertNull(channelProvider.getEndpoint());

    ClientContext clientContext = ClientContext.create(settings);
    try {
      assertEquals(CUSTOM_UNIVERSE, clientContext.getUniverseDomain());
      GrpcTransportChannel transportChannel =
          (GrpcTransportChannel) clientContext.getTransportChannel();
      assertEquals(CUSTOM_HOST, transportChannel.getChannel().authority());
    } finally {
      clientContext.getTransportChannel().shutdownNow();
    }
  }
}
