/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.datastore;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.grpc.ChannelPoolSettings;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.cloud.NoCredentials;
import com.google.cloud.datastore.spi.DatastoreRpcFactory;
import com.google.cloud.datastore.spi.v1.DatastoreRpc;
import com.google.cloud.datastore.v1.DatastoreSettings;
import com.google.cloud.grpc.GrpcTransportOptions;
import com.google.cloud.http.HttpTransportOptions;
import com.google.datastore.v1.client.DatastoreFactory;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DatastoreOptionsTest {

  private static final String PROJECT_ID = "project-id";
  private static final String DATABASE_ID = "database-id";
  private static final int PORT = 8080;
  private static final int DEFAULT_MAX_CHANNEL_COUNT = 200;
  private DatastoreRpcFactory datastoreRpcFactory;
  private DatastoreRpc datastoreRpc;
  private DatastoreOptions.Builder options;

  @Before
  public void setUp() {
    datastoreRpcFactory = EasyMock.createMock(DatastoreRpcFactory.class);
    datastoreRpc = EasyMock.createMock(DatastoreRpc.class);
    options =
        DatastoreOptions.newBuilder()
            .setServiceRpcFactory(datastoreRpcFactory)
            .setProjectId(PROJECT_ID)
            .setDatabaseId(DATABASE_ID)
            .setCredentials(NoCredentials.getInstance())
            .setHost("http://localhost:" + PORT);

    EasyMock.expect(datastoreRpcFactory.create(EasyMock.anyObject(DatastoreOptions.class)))
        .andReturn(datastoreRpc)
        .anyTimes();
    EasyMock.replay(datastoreRpcFactory, datastoreRpc);
  }

  @Test
  public void testProjectId() {
    assertEquals(PROJECT_ID, options.build().getProjectId());
  }

  @Test
  public void testDatabaseId() {
    assertEquals(DATABASE_ID, options.build().getDatabaseId());
  }

  @Test
  public void testHost() {
    assertEquals("http://localhost:" + PORT, options.build().getHost());
  }

  @Test
  public void testOpenTelemetryOptionsDefault() {
    DatastoreOpenTelemetryOptions o1 = DatastoreOpenTelemetryOptions.newBuilder().build();
    assertFalse(o1.isMetricsEnabled());
    assertFalse(o1.isTracingEnabled());
    assertFalse(o1.isEnabled());
  }

  @Test
  public void testOpenTelemetryOptionsEnabled() {
    options.setOpenTelemetryOptions(
        DatastoreOpenTelemetryOptions.newBuilder()
            .setTracingEnabled(true)
            .setMetricsEnabled(true)
            .build());
    assertTrue(options.build().getOpenTelemetryOptions().isEnabled());
    assertTrue(options.build().getOpenTelemetryOptions().isTracingEnabled());
    assertTrue(options.build().getOpenTelemetryOptions().isMetricsEnabled());
  }

  @Test
  public void testOpenTelemetryOptionsDisabled() {
    options.setOpenTelemetryOptions(
        DatastoreOpenTelemetryOptions.newBuilder()
            .setTracingEnabled(false)
            .setMetricsEnabled(false)
            .build());
    assertFalse(options.build().getOpenTelemetryOptions().isEnabled());
    assertFalse(options.build().getOpenTelemetryOptions().isTracingEnabled());
    assertFalse(options.build().getOpenTelemetryOptions().isMetricsEnabled());
  }

  @Test
  public void testOpenTelemetryTracingEnabled() {
    DatastoreOpenTelemetryOptions o1 =
        DatastoreOpenTelemetryOptions.newBuilder().setTracingEnabled(false).build();
    assertFalse(o1.isTracingEnabled());
    assertFalse(o1.isEnabled());

    DatastoreOpenTelemetryOptions o2 =
        DatastoreOpenTelemetryOptions.newBuilder().setTracingEnabled(true).build();
    assertTrue(o2.isTracingEnabled());
    assertTrue(o2.isEnabled());
  }

  @Test
  public void testOpenTelemetryMetricsEnabled() {
    DatastoreOpenTelemetryOptions o1 =
        DatastoreOpenTelemetryOptions.newBuilder().setMetricsEnabled(false).build();
    assertFalse(o1.isMetricsEnabled());
    assertFalse(o1.isEnabled());

    DatastoreOpenTelemetryOptions o2 =
        DatastoreOpenTelemetryOptions.newBuilder().setMetricsEnabled(true).build();
    assertTrue(o2.isMetricsEnabled());
    assertTrue(o2.isEnabled());
  }

  @Test
  public void testTelemetrySignalsMixedEnabled() {
    DatastoreOpenTelemetryOptions o1 =
        DatastoreOpenTelemetryOptions.newBuilder()
            .setTracingEnabled(true)
            .setMetricsEnabled(false)
            .build();
    assertTrue(o1.isTracingEnabled());
    assertFalse(o1.isMetricsEnabled());
    assertTrue(o1.isEnabled());

    DatastoreOpenTelemetryOptions o2 =
        DatastoreOpenTelemetryOptions.newBuilder()
            .setTracingEnabled(false)
            .setMetricsEnabled(true)
            .build();
    assertFalse(o2.isTracingEnabled());
    assertTrue(o2.isMetricsEnabled());
    assertTrue(o2.isEnabled());
  }

  @Test
  public void testNamespace() {
    assertTrue(options.build().getNamespace().isEmpty());
    assertEquals("ns1", options.setNamespace("ns1").build().getNamespace());
  }

  @Test
  public void testDatastore() {
    assertSame(datastoreRpc, options.build().getRpc());
  }

  @Test
  public void testGrpcDefaultChannelConfigurations() {
    DatastoreOptions datastoreOptions =
        DatastoreOptions.newBuilder()
            .setServiceRpcFactory(datastoreRpcFactory)
            .setProjectId(PROJECT_ID)
            .setDatabaseId(DATABASE_ID)
            .setTransportOptions(GrpcTransportOptions.newBuilder().build())
            .setCredentials(NoCredentials.getInstance())
            .setHost("http://localhost:" + PORT)
            .build();
    ChannelPoolSettings channelPoolSettings =
        ((InstantiatingGrpcChannelProvider) datastoreOptions.getTransportChannelProvider())
            .getChannelPoolSettings();
    assertEquals(channelPoolSettings.getInitialChannelCount(), DatastoreOptions.INIT_CHANNEL_COUNT);
    assertEquals(channelPoolSettings.getMinChannelCount(), DatastoreOptions.MIN_CHANNEL_COUNT);
    assertEquals(channelPoolSettings.getMaxChannelCount(), DEFAULT_MAX_CHANNEL_COUNT);
  }

  @Test
  public void testCustomChannelAndCredentials() {
    InstantiatingGrpcChannelProvider channelProvider =
        DatastoreSettings.defaultGrpcTransportProviderBuilder()
            .setChannelPoolSettings(
                ChannelPoolSettings.builder()
                    .setInitialChannelCount(10)
                    .setMaxChannelCount(20)
                    .build())
            .build();
    DatastoreOptions datastoreOptions =
        DatastoreOptions.newBuilder()
            .setServiceRpcFactory(datastoreRpcFactory)
            .setProjectId(PROJECT_ID)
            .setDatabaseId(DATABASE_ID)
            .setTransportOptions(GrpcTransportOptions.newBuilder().build())
            .setChannelProvider(channelProvider)
            .setCredentials(NoCredentials.getInstance())
            .setHost("http://localhost:" + PORT)
            .build();
    assertEquals(datastoreOptions.getTransportChannelProvider(), channelProvider);
  }

  @Test
  public void testInvalidConfigForHttp() {
    DatastoreOptions.Builder options =
        DatastoreOptions.newBuilder()
            .setServiceRpcFactory(datastoreRpcFactory)
            .setProjectId(PROJECT_ID)
            .setDatabaseId(DATABASE_ID)
            .setTransportOptions(HttpTransportOptions.newBuilder().build())
            .setChannelProvider(
                DatastoreSettings.defaultGrpcTransportProviderBuilder()
                    .setChannelPoolSettings(
                        ChannelPoolSettings.builder()
                            .setInitialChannelCount(10)
                            .setMaxChannelCount(20)
                            .build())
                    .build())
            .setCredentials(NoCredentials.getInstance())
            .setHost("http://localhost:" + PORT);
    Assert.assertThrows(IllegalArgumentException.class, options::build);
  }

  @Test
  public void testTransport() {
    // default http transport
    assertThat(options.build().getTransportOptions()).isInstanceOf(HttpTransportOptions.class);

    // custom grpc transport
    DatastoreOptions grpcTransportOptions =
        DatastoreOptions.newBuilder()
            .setTransportOptions(GrpcTransportOptions.newBuilder().build())
            .setProjectId(PROJECT_ID)
            .setCredentials(NoCredentials.getInstance())
            .build();
    assertThat(grpcTransportOptions.getTransportOptions()).isInstanceOf(GrpcTransportOptions.class);
    assertThat(grpcTransportOptions.getTransportChannelProvider())
        .isInstanceOf(InstantiatingGrpcChannelProvider.class);
  }

  @Test
  public void testHostWithGrpcAndHttp() {
    DatastoreOptions grpcTransportOptions =
        DatastoreOptions.newBuilder()
            .setTransportOptions(GrpcTransportOptions.newBuilder().build())
            .setProjectId(PROJECT_ID)
            .setCredentials(NoCredentials.getInstance())
            .build();
    assertThat(grpcTransportOptions.getHost()).isEqualTo(DatastoreSettings.getDefaultEndpoint());
    assertThat(grpcTransportOptions.getHost()).isEqualTo("datastore.googleapis.com:443");

    String customHost = "http://localhost:" + PORT;
    DatastoreOptions grpcTransportOptionsCustomHost =
        DatastoreOptions.newBuilder()
            .setTransportOptions(GrpcTransportOptions.newBuilder().build())
            .setHost(customHost)
            .setProjectId(PROJECT_ID)
            .setCredentials(NoCredentials.getInstance())
            .build();
    assertThat(grpcTransportOptionsCustomHost.getHost()).isEqualTo(customHost);

    DatastoreOptions httpTransportOptions =
        DatastoreOptions.newBuilder()
            .setProjectId(PROJECT_ID)
            .setCredentials(NoCredentials.getInstance())
            .build();
    assertThat(httpTransportOptions.getHost()).isEqualTo(DatastoreFactory.DEFAULT_HOST);

    DatastoreOptions httpTransportOptionsCustomHost =
        DatastoreOptions.newBuilder()
            .setHost(customHost)
            .setProjectId(PROJECT_ID)
            .setCredentials(NoCredentials.getInstance())
            .build();
    assertThat(httpTransportOptionsCustomHost.getHost()).isEqualTo(customHost);
  }

  @Test
  public void testToBuilder() {
    DatastoreOptions original = options.setNamespace("ns1").build();
    DatastoreOptions copy = original.toBuilder().build();
    assertEquals(original.getProjectId(), copy.getProjectId());
    assertEquals(original.getNamespace(), copy.getNamespace());
    assertEquals(original.getDatabaseId(), copy.getDatabaseId());
    assertEquals(original.getHost(), copy.getHost());
    assertEquals(original.getRetrySettings(), copy.getRetrySettings());
    assertEquals(original.getCredentials(), copy.getCredentials());
    assertEquals(original, copy);
    assertEquals(original.hashCode(), copy.hashCode());

    DatastoreOptions newOptions = options.setDatabaseId("new-database-id").build();
    assertNotEquals(original, newOptions);
    assertNotEquals(original.hashCode(), newOptions.hashCode());
  }
}
