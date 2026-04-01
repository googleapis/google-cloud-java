/*
 * Copyright 2017 Google LLC
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

package com.google.cloud.spanner;

import static com.google.common.truth.Truth.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

import com.google.api.core.NanoClock;
import com.google.api.gax.retrying.RetrySettings;
import com.google.cloud.NoCredentials;
import com.google.cloud.ServiceRpc;
import com.google.cloud.grpc.GrpcTransportOptions;
import com.google.cloud.spanner.SpannerImpl.ClosedException;
import com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient;
import com.google.cloud.spanner.admin.database.v1.stub.DatabaseAdminStub;
import com.google.cloud.spanner.admin.database.v1.stub.DatabaseAdminStubSettings;
import com.google.cloud.spanner.admin.instance.v1.InstanceAdminClient;
import com.google.cloud.spanner.admin.instance.v1.stub.InstanceAdminStub;
import com.google.cloud.spanner.admin.instance.v1.stub.InstanceAdminStubSettings;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import com.google.spanner.v1.ExecuteSqlRequest.QueryOptions;
import io.opentelemetry.api.OpenTelemetry;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/** Unit tests for {@link SpannerImpl}. */
@RunWith(JUnit4.class)
public class SpannerImplTest {
  @Mock private SpannerRpc rpc;
  @Mock private SpannerOptions spannerOptions;
  @Mock private DatabaseAdminStubSettings databaseAdminStubSettings;
  @Mock private DatabaseAdminStub databaseAdminStub;
  @Mock private InstanceAdminStubSettings instanceAdminStubSettings;
  @Mock private InstanceAdminStub instanceAdminStub;
  private SpannerImpl impl;

  @Captor ArgumentCaptor<Map<SpannerRpc.Option, Object>> options;

  @BeforeClass
  public static void setupOpenTelemetry() {
    SpannerOptions.resetActiveTracingFramework();
    SpannerOptions.enableOpenTelemetryTraces();
  }

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    when(spannerOptions.getNumChannels()).thenReturn(4);
    when(spannerOptions.getDatabaseRole()).thenReturn("role");
    when(spannerOptions.getPrefetchChunks()).thenReturn(1);
    when(spannerOptions.getRetrySettings()).thenReturn(RetrySettings.newBuilder().build());
    when(spannerOptions.getClock()).thenReturn(NanoClock.getDefaultClock());
    when(spannerOptions.getSessionLabels()).thenReturn(Collections.emptyMap());
    when(spannerOptions.getOpenTelemetry()).thenReturn(OpenTelemetry.noop());
    impl = new SpannerImpl(rpc, spannerOptions);
  }

  @After
  public void teardown() {
    impl.close();
  }

  @Test
  public void getDbclientAgainGivesSame() {
    Map<String, String> labels = new HashMap<>();
    labels.put("env", "dev");
    Mockito.when(spannerOptions.getSessionLabels()).thenReturn(labels);
    Mockito.when(spannerOptions.getDatabaseRole()).thenReturn("role");
    String dbName = "projects/p1/instances/i1/databases/d1";
    DatabaseId db = DatabaseId.of(dbName);

    Mockito.when(spannerOptions.getTransportOptions())
        .thenReturn(GrpcTransportOptions.newBuilder().build());
    Mockito.when(spannerOptions.getSessionPoolOptions())
        .thenReturn(SessionPoolOptions.newBuilder().setMinSessions(0).build());

    DatabaseClient databaseClient = impl.getDatabaseClient(db);

    // Get db client again
    DatabaseClient databaseClient1 = impl.getDatabaseClient(db);

    assertThat(databaseClient1).isSameInstanceAs(databaseClient);
  }

  @Test
  public void queryOptions() {
    QueryOptions queryOptions =
        QueryOptions.newBuilder()
            .setOptimizerVersion("2")
            .setOptimizerStatisticsPackage("custom-package")
            .build();
    QueryOptions defaultOptions = QueryOptions.getDefaultInstance();
    DatabaseId db = DatabaseId.of("p", "i", "d");
    DatabaseId otherDb = DatabaseId.of("p", "i", "other");

    // Create a SpannerOptions with and without default query options.
    SpannerOptions optionsWithQueryOptions =
        new SpannerOptions.Builder(
            SpannerOptions.newBuilder()
                .setProjectId("some-project")
                .setCredentials(NoCredentials.getInstance())
                .build()) {
          @Override
          QueryOptions getEnvironmentQueryOptions() {
            // Override and return default instance to prevent environment variables from
            // interfering with the test case.
            return QueryOptions.getDefaultInstance();
          }
        }.setDefaultQueryOptions(db, queryOptions).build();
    SpannerOptions optionsWithoutQueryOptions =
        new SpannerOptions.Builder(
            SpannerOptions.newBuilder()
                .setProjectId("some-project")
                .setCredentials(NoCredentials.getInstance())
                .build()) {
          @Override
          QueryOptions getEnvironmentQueryOptions() {
            // Override and return default instance to prevent environment variables from
            // interfering with the test case.
            return QueryOptions.getDefaultInstance();
          }
        }.build();

    try (SpannerImpl implWithQueryOptions = new SpannerImpl(rpc, optionsWithQueryOptions);
        SpannerImpl implWithoutQueryOptions = new SpannerImpl(rpc, optionsWithoutQueryOptions)) {

      // Default query options are on a per-database basis, so we should only get the custom options
      // for 'db' and not for 'otherDb'.
      assertThat(implWithQueryOptions.getDefaultQueryOptions(db)).isEqualTo(queryOptions);
      assertThat(implWithQueryOptions.getDefaultQueryOptions(otherDb)).isEqualTo(defaultOptions);

      // The other Spanner instance should return default options for both databases.
      assertThat(implWithoutQueryOptions.getDefaultQueryOptions(db)).isEqualTo(defaultOptions);
      assertThat(implWithoutQueryOptions.getDefaultQueryOptions(otherDb)).isEqualTo(defaultOptions);
    }
  }

  @Test
  public void getDbclientAfterCloseThrows() {
    SpannerImpl imp = new SpannerImpl(rpc, spannerOptions);
    Map<String, String> labels = new HashMap<>();
    labels.put("env", "dev");
    Mockito.when(spannerOptions.getSessionLabels()).thenReturn(labels);
    String dbName = "projects/p1/instances/i1/databases/d1";
    DatabaseId db = DatabaseId.of(dbName);

    Mockito.when(spannerOptions.getTransportOptions())
        .thenReturn(GrpcTransportOptions.newBuilder().build());
    Mockito.when(spannerOptions.getSessionPoolOptions())
        .thenReturn(SessionPoolOptions.newBuilder().build());
    Mockito.when(spannerOptions.getDatabaseRole()).thenReturn("role");
    imp.close();

    IllegalStateException e =
        assertThrows(IllegalStateException.class, () -> imp.getDatabaseClient(db));
    assertThat(e.getMessage()).contains("Cloud Spanner client has been closed");
  }

  @Test
  public void testSpannerClosed() {
    SpannerOptions options = createSpannerOptions();
    Spanner spanner1 = options.getService();
    Spanner spanner2 = options.getService();
    ServiceRpc rpc1 = options.getRpc();
    ServiceRpc rpc2 = options.getRpc();
    // The SpannerOptions object should return the same instance.
    assertThat(spanner1 == spanner2, is(true));
    assertThat(rpc1 == rpc2, is(true));
    spanner1.close();
    // A new instance should be returned as the Spanner instance has been closed.
    Spanner spanner3 = options.getService();
    assertThat(spanner1 == spanner3, is(false));
    // A new instance should be returned as the Spanner instance has been closed.
    ServiceRpc rpc3 = options.getRpc();
    assertThat(rpc1 == rpc3, is(false));
    // Creating a copy of the SpannerOptions should result in new instances.
    options = options.toBuilder().build();
    Spanner spanner4 = options.getService();
    ServiceRpc rpc4 = options.getRpc();
    assertThat(spanner4 == spanner3, is(false));
    assertThat(rpc4 == rpc3, is(false));
    Spanner spanner5 = options.getService();
    ServiceRpc rpc5 = options.getRpc();
    assertThat(spanner4 == spanner5, is(true));
    assertThat(rpc4 == rpc5, is(true));
    spanner3.close();
    spanner4.close();
  }

  @Test
  public void testClosedException() {
    Spanner spanner = new SpannerImpl(rpc, spannerOptions);
    assertThat(spanner.isClosed()).isFalse();
    // Close the Spanner instance in a different method so we can actually verify that the entire
    // stacktrace of the method that closed the instance is included in the exception that will be
    // thrown by the instance after it has been closed.
    closeSpannerAndIncludeStacktrace(spanner);
    assertThat(spanner.isClosed()).isTrue();
    IllegalStateException e =
        assertThrows(
            IllegalStateException.class,
            () -> spanner.getDatabaseClient(DatabaseId.of("p", "i", "d")));
    assertThat(e.getCause()).isInstanceOf(ClosedException.class);
    StringWriter sw = new StringWriter();
    e.getCause().printStackTrace(new PrintWriter(sw));
    assertThat(sw.toString()).contains("closeSpannerAndIncludeStacktrace");
  }

  @Test
  public void testCreateDatabaseAdminClient_whenNullAdminSettings_assertPreconditionFailure() {
    Spanner spanner = new SpannerImpl(rpc, spannerOptions);
    assertThrows(NullPointerException.class, spanner::createDatabaseAdminClient);
  }

  @Test
  public void testCreateDatabaseAdminClient_whenMockAdminSettings_assertMethodInvocation()
      throws IOException {
    when(rpc.getDatabaseAdminStubSettings()).thenReturn(databaseAdminStubSettings);
    when(databaseAdminStubSettings.createStub()).thenReturn(databaseAdminStub);

    Spanner spanner = new SpannerImpl(rpc, spannerOptions);

    DatabaseAdminClient databaseAdminClient = spanner.createDatabaseAdminClient();
    assertNotNull(databaseAdminClient);
  }

  @Test(expected = SpannerException.class)
  public void testCreateDatabaseAdminClient_whenMockAdminSettings_assertException()
      throws IOException {
    when(rpc.getDatabaseAdminStubSettings()).thenReturn(databaseAdminStubSettings);
    when(databaseAdminStubSettings.createStub()).thenThrow(IOException.class);

    Spanner spanner = new SpannerImpl(rpc, spannerOptions);

    DatabaseAdminClient databaseAdminClient = spanner.createDatabaseAdminClient();
    assertNotNull(databaseAdminClient);
  }

  @Test
  public void testCreateInstanceAdminClient_whenNullAdminSettings_assertPreconditionFailure() {
    Spanner spanner = new SpannerImpl(rpc, spannerOptions);
    assertThrows(NullPointerException.class, spanner::createInstanceAdminClient);
  }

  @Test
  public void testCreateInstanceAdminClient_whenMockAdminSettings_assertMethodInvocation()
      throws IOException {
    when(rpc.getInstanceAdminStubSettings()).thenReturn(instanceAdminStubSettings);
    when(instanceAdminStubSettings.createStub()).thenReturn(instanceAdminStub);

    Spanner spanner = new SpannerImpl(rpc, spannerOptions);

    InstanceAdminClient instanceAdminClient = spanner.createInstanceAdminClient();
    assertNotNull(instanceAdminClient);
  }

  @Test(expected = SpannerException.class)
  public void testCreateInstanceAdminClient_whenMockAdminSettings_assertException()
      throws IOException {
    when(rpc.getInstanceAdminStubSettings()).thenReturn(instanceAdminStubSettings);
    when(instanceAdminStubSettings.createStub()).thenThrow(IOException.class);

    Spanner spanner = new SpannerImpl(rpc, spannerOptions);

    InstanceAdminClient instanceAdminClient = spanner.createInstanceAdminClient();
    assertNotNull(instanceAdminClient);
  }

  private void closeSpannerAndIncludeStacktrace(Spanner spanner) {
    spanner.close();
  }

  private SpannerOptions createSpannerOptions() {
    return SpannerOptions.newBuilder()
        .setProjectId("[PROJECT]")
        .setCredentials(NoCredentials.getInstance())
        .build();
  }
}
