/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.data.v2.stub;

import static com.google.cloud.bigtable.data.v2.MetadataSubject.assertThat;
import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.StatusCode;
import com.google.bigtable.v2.BigtableGrpc;
import com.google.bigtable.v2.CheckAndMutateRowRequest;
import com.google.bigtable.v2.CheckAndMutateRowResponse;
import com.google.bigtable.v2.GenerateInitialChangeStreamPartitionsRequest;
import com.google.bigtable.v2.GenerateInitialChangeStreamPartitionsResponse;
import com.google.bigtable.v2.MutateRowRequest;
import com.google.bigtable.v2.MutateRowResponse;
import com.google.bigtable.v2.MutateRowsRequest;
import com.google.bigtable.v2.MutateRowsResponse;
import com.google.bigtable.v2.ReadChangeStreamRequest;
import com.google.bigtable.v2.ReadChangeStreamResponse;
import com.google.bigtable.v2.ReadModifyWriteRowRequest;
import com.google.bigtable.v2.ReadModifyWriteRowResponse;
import com.google.bigtable.v2.ReadRowsRequest;
import com.google.bigtable.v2.ReadRowsResponse;
import com.google.bigtable.v2.SampleRowKeysRequest;
import com.google.bigtable.v2.SampleRowKeysResponse;
import com.google.bigtable.v2.StreamContinuationToken;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.BigtableDataClientFactory;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.FakeServiceBuilder;
import com.google.cloud.bigtable.data.v2.models.BulkMutation;
import com.google.cloud.bigtable.data.v2.models.ChangeStreamRecord;
import com.google.cloud.bigtable.data.v2.models.ConditionalRowMutation;
import com.google.cloud.bigtable.data.v2.models.Mutation;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.ReadChangeStreamQuery;
import com.google.cloud.bigtable.data.v2.models.ReadModifyWriteRow;
import com.google.cloud.bigtable.data.v2.models.RowMutation;
import com.google.cloud.bigtable.data.v2.models.RowMutationEntry;
import io.grpc.ForwardingServerCall;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Server;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.threeten.bp.Duration;

@RunWith(JUnit4.class)
public class CookiesHolderTest {
  private static final Metadata.Key<String> ROUTING_COOKIE_1 =
      Metadata.Key.of("x-goog-cbt-cookie-routing", Metadata.ASCII_STRING_MARSHALLER);
  private static final Metadata.Key<String> ROUTING_COOKIE_2 =
      Metadata.Key.of("x-goog-cbt-cookie-random", Metadata.ASCII_STRING_MARSHALLER);
  private static final Metadata.Key<String> ROUTING_COOKIE_HEADER =
      Metadata.Key.of("x-goog-cbt-cookie-header", Metadata.ASCII_STRING_MARSHALLER);
  private static final Metadata.Key<String> BAD_KEY =
      Metadata.Key.of("x-goog-cbt-not-cookie", Metadata.ASCII_STRING_MARSHALLER);

  private static final String testHeaderCookie = "header-cookie";
  private static final String testCookie = "test-routing-cookie";
  private static final String routingCookie1Header = "should-be-overridden";

  private Server server;
  private final FakeService fakeService = new FakeService();
  private BigtableDataSettings.Builder settings;
  private BigtableDataClient client;
  private final List<Metadata> serverMetadata = Collections.synchronizedList(new ArrayList<>());

  private final Set<String> methods = Collections.synchronizedSet(new HashSet<>());

  @Before
  public void setup() throws Exception {
    ServerInterceptor serverInterceptor =
        new ServerInterceptor() {
          @Override
          public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
              ServerCall<ReqT, RespT> serverCall,
              Metadata metadata,
              ServerCallHandler<ReqT, RespT> serverCallHandler) {
            serverMetadata.add(metadata);
            if (metadata.containsKey(ROUTING_COOKIE_1)) {
              methods.add(serverCall.getMethodDescriptor().getBareMethodName());
            }

            Metadata responseHeaders = new Metadata();
            responseHeaders.put(ROUTING_COOKIE_HEADER, testHeaderCookie);
            responseHeaders.put(ROUTING_COOKIE_1, routingCookie1Header);
            serverCall.sendHeaders(responseHeaders);

            return serverCallHandler.startCall(
                new ForwardingServerCall.SimpleForwardingServerCall<ReqT, RespT>(serverCall) {
                  @Override
                  public void sendHeaders(Metadata responseHeaders) {
                    // headers already sent!
                  }
                },
                metadata);
          }
        };

    server = FakeServiceBuilder.create(fakeService).intercept(serverInterceptor).start();

    BigtableDataSettings.Builder settings =
        BigtableDataSettings.newBuilderForEmulator(server.getPort())
            .setProjectId("fake-project")
            .setInstanceId("fake-instance");

    // Override CheckAndMutate and ReadModifyWrite retry settings here. These operations
    // are currently not retryable but this could change in the future after we
    // have routing cookie sends back meaningful information and changes how retry works.
    // Routing cookie still needs to be respected and handled by the callables.
    settings
        .stubSettings()
        .checkAndMutateRowSettings()
        .setRetrySettings(
            RetrySettings.newBuilder()
                .setInitialRetryDelay(Duration.ofMillis(10))
                .setMaxRetryDelay(Duration.ofMinutes(1))
                .setMaxAttempts(2)
                .build())
        .setRetryableCodes(StatusCode.Code.UNAVAILABLE);

    settings
        .stubSettings()
        .readModifyWriteRowSettings()
        .setRetrySettings(
            RetrySettings.newBuilder()
                .setInitialRetryDelay(Duration.ofMillis(10))
                .setMaxRetryDelay(Duration.ofMinutes(1))
                .setMaxAttempts(2)
                .build())
        .setRetryableCodes(StatusCode.Code.UNAVAILABLE);

    this.settings = settings;

    client = BigtableDataClient.create(settings.build());
  }

  @After
  public void tearDown() throws Exception {
    if (client != null) {
      client.close();
    }
    if (server != null) {
      server.shutdown();
    }
  }

  @Test
  public void testReadRows() {
    client.readRows(Query.create("fake-table")).iterator().hasNext();

    assertThat(fakeService.count.get()).isGreaterThan(1);
    assertThat(serverMetadata).hasSize(fakeService.count.get());

    Metadata lastMetadata = serverMetadata.get(fakeService.count.get() - 1);

    assertThat(lastMetadata)
        .containsAtLeast(
            ROUTING_COOKIE_1.name(),
            "readRows",
            ROUTING_COOKIE_2.name(),
            testCookie,
            ROUTING_COOKIE_HEADER.name(),
            testHeaderCookie);
    assertThat(lastMetadata).doesNotContainKeys(BAD_KEY.name());

    serverMetadata.clear();
  }

  @Test
  public void testReadRow() {
    client.readRow("fake-table", "key");

    assertThat(fakeService.count.get()).isGreaterThan(1);
    assertThat(serverMetadata).hasSize(fakeService.count.get());

    Metadata lastMetadata = serverMetadata.get(fakeService.count.get() - 1);

    assertThat(lastMetadata)
        .containsAtLeast(
            ROUTING_COOKIE_1.name(),
            "readRows",
            ROUTING_COOKIE_2.name(),
            testCookie,
            ROUTING_COOKIE_HEADER.name(),
            testHeaderCookie);
    assertThat(lastMetadata).doesNotContainKeys(BAD_KEY.name());

    serverMetadata.clear();
  }

  @Test
  public void testMutateRows() {
    client.bulkMutateRows(
        BulkMutation.create("fake-table")
            .add(RowMutationEntry.create("key").setCell("cf", "q", "v")));

    assertThat(fakeService.count.get()).isGreaterThan(1);
    assertThat(serverMetadata).hasSize(fakeService.count.get());

    Metadata lastMetadata = serverMetadata.get(fakeService.count.get() - 1);

    assertThat(lastMetadata)
        .containsAtLeast(
            ROUTING_COOKIE_1.name(),
            "mutateRows",
            ROUTING_COOKIE_2.name(),
            testCookie,
            ROUTING_COOKIE_HEADER.name(),
            testHeaderCookie);
    assertThat(lastMetadata).doesNotContainKeys(BAD_KEY.name());

    serverMetadata.clear();
  }

  @Test
  public void testMutateRow() {
    client.mutateRow(RowMutation.create("table", "key").setCell("cf", "q", "v"));

    assertThat(fakeService.count.get()).isGreaterThan(1);
    assertThat(serverMetadata).hasSize(fakeService.count.get());

    Metadata lastMetadata = serverMetadata.get(fakeService.count.get() - 1);

    assertThat(lastMetadata)
        .containsAtLeast(
            ROUTING_COOKIE_1.name(),
            "mutateRow",
            ROUTING_COOKIE_2.name(),
            testCookie,
            ROUTING_COOKIE_HEADER.name(),
            testHeaderCookie);
    assertThat(lastMetadata).doesNotContainKeys(BAD_KEY.name());

    serverMetadata.clear();
  }

  @Test
  public void testSampleRowKeys() {

    client.sampleRowKeys("fake-table");

    assertThat(fakeService.count.get()).isGreaterThan(1);
    assertThat(serverMetadata).hasSize(fakeService.count.get());

    Metadata lastMetadata = serverMetadata.get(fakeService.count.get() - 1);

    assertThat(lastMetadata)
        .containsAtLeast(
            ROUTING_COOKIE_1.name(),
            "sampleRowKeys",
            ROUTING_COOKIE_2.name(),
            testCookie,
            ROUTING_COOKIE_HEADER.name(),
            testHeaderCookie);
    assertThat(lastMetadata).doesNotContainKeys(BAD_KEY.name());

    serverMetadata.clear();
  }

  @Test
  public void testReadChangeStream() {
    for (ChangeStreamRecord record :
        client.readChangeStream(ReadChangeStreamQuery.create("table"))) {}

    assertThat(fakeService.count.get()).isGreaterThan(1);
    assertThat(serverMetadata).hasSize(fakeService.count.get());

    Metadata lastMetadata = serverMetadata.get(fakeService.count.get() - 1);

    assertThat(lastMetadata)
        .containsAtLeast(
            ROUTING_COOKIE_1.name(),
            "readChangeStream",
            ROUTING_COOKIE_2.name(),
            testCookie,
            ROUTING_COOKIE_HEADER.name(),
            testHeaderCookie);
    assertThat(lastMetadata).doesNotContainKeys(BAD_KEY.name());

    serverMetadata.clear();
  }

  @Test
  public void testGenerateInitialChangeStreamPartition() {
    client.generateInitialChangeStreamPartitions("table").iterator().hasNext();

    assertThat(fakeService.count.get()).isGreaterThan(1);
    assertThat(serverMetadata).hasSize(fakeService.count.get());

    Metadata lastMetadata = serverMetadata.get(fakeService.count.get() - 1);

    // generateInitialChangeStreamPartition uses SimpleStreamResumptionStrategy which means
    // it can't resume from the middle of the stream. So we are not able to send a header
    // for error responses.
    assertThat(lastMetadata)
        .containsAtLeast(
            ROUTING_COOKIE_1.name(),
            "generateInitialChangeStreamPartitions",
            ROUTING_COOKIE_2.name(),
            testCookie);
    assertThat(lastMetadata).doesNotContainKeys(BAD_KEY.name());

    serverMetadata.clear();
  }

  @Test
  public void testNoCookieSucceedReadRows() {
    fakeService.returnCookie = false;

    client.readRows(Query.create("fake-table")).iterator().hasNext();

    assertThat(fakeService.count.get()).isGreaterThan(1);
    assertThat(serverMetadata).hasSize(fakeService.count.get());

    Metadata lastMetadata = serverMetadata.get(fakeService.count.get() - 1);

    assertThat(lastMetadata).doesNotContainKeys(ROUTING_COOKIE_2.name());
    // Should contain initial metadata
    assertThat(lastMetadata).containsAtLeast(ROUTING_COOKIE_1.name(), routingCookie1Header);

    serverMetadata.clear();
  }

  @Test
  public void testNoCookieSucceedReadRow() {
    fakeService.returnCookie = false;

    client.readRow("fake-table", "key");

    assertThat(fakeService.count.get()).isGreaterThan(1);
    assertThat(serverMetadata).hasSize(fakeService.count.get());

    Metadata lastMetadata = serverMetadata.get(fakeService.count.get() - 1);

    assertThat(lastMetadata).doesNotContainKeys(ROUTING_COOKIE_2.name(), BAD_KEY.name());
    assertThat(lastMetadata).containsAtLeast(ROUTING_COOKIE_1.name(), routingCookie1Header);

    serverMetadata.clear();
  }

  @Test
  public void testNoCookieSucceedMutateRows() {
    fakeService.returnCookie = false;

    client.bulkMutateRows(
        BulkMutation.create("fake-table")
            .add(RowMutationEntry.create("key").setCell("cf", "q", "v")));

    assertThat(fakeService.count.get()).isGreaterThan(1);
    assertThat(serverMetadata).hasSize(fakeService.count.get());

    Metadata lastMetadata = serverMetadata.get(fakeService.count.get() - 1);

    assertThat(lastMetadata).doesNotContainKeys(ROUTING_COOKIE_2.name(), BAD_KEY.name());
    assertThat(lastMetadata).containsAtLeast(ROUTING_COOKIE_1.name(), routingCookie1Header);

    serverMetadata.clear();
  }

  @Test
  public void testNoCookieSucceedMutateRow() {
    fakeService.returnCookie = false;

    client.mutateRow(RowMutation.create("fake-table", "key").setCell("cf", "q", "v"));

    assertThat(fakeService.count.get()).isGreaterThan(1);
    assertThat(serverMetadata).hasSize(fakeService.count.get());

    Metadata lastMetadata = serverMetadata.get(fakeService.count.get() - 1);

    assertThat(lastMetadata).doesNotContainKeys(ROUTING_COOKIE_2.name(), BAD_KEY.name());
    assertThat(lastMetadata).containsAtLeast(ROUTING_COOKIE_1.name(), routingCookie1Header);

    serverMetadata.clear();
  }

  @Test
  public void testNoCookieSucceedSampleRowKeys() {
    fakeService.returnCookie = false;

    client.sampleRowKeys("fake-table");

    assertThat(fakeService.count.get()).isGreaterThan(1);
    assertThat(serverMetadata).hasSize(fakeService.count.get());

    Metadata lastMetadata = serverMetadata.get(fakeService.count.get() - 1);

    assertThat(lastMetadata).doesNotContainKeys(ROUTING_COOKIE_2.name(), BAD_KEY.name());
    assertThat(lastMetadata).containsAtLeast(ROUTING_COOKIE_1.name(), routingCookie1Header);

    serverMetadata.clear();
  }

  @Test
  public void testNoCookieSucceedReadChangeStream() {
    fakeService.returnCookie = false;

    for (ChangeStreamRecord record :
        client.readChangeStream(ReadChangeStreamQuery.create("table"))) {}

    assertThat(fakeService.count.get()).isGreaterThan(1);
    assertThat(serverMetadata).hasSize(fakeService.count.get());

    Metadata lastMetadata = serverMetadata.get(fakeService.count.get() - 1);

    assertThat(lastMetadata).doesNotContainKeys(ROUTING_COOKIE_2.name(), BAD_KEY.name());
    assertThat(lastMetadata).containsAtLeast(ROUTING_COOKIE_1.name(), routingCookie1Header);

    serverMetadata.clear();

    serverMetadata.clear();
  }

  @Test
  public void testNoCookieSucceedGenerateInitialChangeStreamParition() {
    fakeService.returnCookie = false;

    client.generateInitialChangeStreamPartitions("table").iterator().hasNext();

    assertThat(fakeService.count.get()).isGreaterThan(1);
    assertThat(serverMetadata).hasSize(fakeService.count.get());

    Metadata lastMetadata = serverMetadata.get(fakeService.count.get() - 1);

    assertThat(lastMetadata).doesNotContainKeys(ROUTING_COOKIE_2.name(), BAD_KEY.name());
    assertThat(lastMetadata).containsAtLeast(ROUTING_COOKIE_1.name(), routingCookie1Header);

    serverMetadata.clear();
  }

  @Test
  public void testCookiesInHeaders() throws Exception {
    // Send 2 cookies in the headers, with routingCookieKey and ROUTING_COOKIE_2. ROUTING_COOKIE_2
    // is also sent in the trailers so the value should be overridden.
    final Metadata.Key<String> routingCookieKey =
        Metadata.Key.of("x-goog-cbt-cookie-no-override", Metadata.ASCII_STRING_MARSHALLER);
    final String routingCookieValue = "no-override";
    ServerInterceptor serverInterceptor =
        new ServerInterceptor() {
          @Override
          public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
              ServerCall<ReqT, RespT> serverCall,
              Metadata metadata,
              ServerCallHandler<ReqT, RespT> serverCallHandler) {
            serverMetadata.add(metadata);

            metadata.put(routingCookieKey, routingCookieValue);
            return serverCallHandler.startCall(
                new ForwardingServerCall.SimpleForwardingServerCall<ReqT, RespT>(serverCall) {
                  @Override
                  public void sendHeaders(Metadata headers) {
                    headers.put(routingCookieKey, routingCookieValue);
                    headers.put(ROUTING_COOKIE_2, "will-be-overridden");
                    super.sendHeaders(headers);
                  }
                },
                metadata);
          }
        };

    Server newServer = null;
    try {
      newServer = FakeServiceBuilder.create(fakeService).intercept(serverInterceptor).start();

      BigtableDataSettings.Builder settings =
          BigtableDataSettings.newBuilderForEmulator(newServer.getPort())
              .setProjectId("fake-project")
              .setInstanceId("fake-instance");

      try (BigtableDataClient client = BigtableDataClient.create(settings.build())) {

        client.readRows(Query.create("table")).iterator().hasNext();

        Metadata lastMetadata = serverMetadata.get(fakeService.count.get() - 1);

        assertThat(lastMetadata)
            .containsAtLeast(
                ROUTING_COOKIE_2.name(), testCookie, routingCookieKey.name(), routingCookieValue);
      }
    } finally {
      if (newServer != null) {
        newServer.shutdown();
      }
    }
  }

  @Test
  public void testAllMethodsAreCalled() {
    // This test ensures that all methods respect the retry cookie except for the ones that are
    // explicitly added to the methods list. It requires that any newly method is exercised in this
    // test. This is enforced by introspecting grpc method descriptors.
    client.readRows(Query.create("fake-table")).iterator().hasNext();

    fakeService.count.set(0);
    client.mutateRow(RowMutation.create("fake-table", "key").setCell("cf", "q", "v"));

    fakeService.count.set(0);
    client.bulkMutateRows(
        BulkMutation.create("fake-table")
            .add(RowMutationEntry.create("key").setCell("cf", "q", "v")));

    fakeService.count.set(0);
    client.sampleRowKeys("fake-table");

    fakeService.count.set(0);
    client.checkAndMutateRow(
        ConditionalRowMutation.create("fake-table", "key")
            .then(Mutation.create().setCell("cf", "q", "v")));

    fakeService.count.set(0);
    client.readModifyWriteRow(
        ReadModifyWriteRow.create("fake-table", "key").append("cf", "q", "v"));

    fakeService.count.set(0);
    client.generateInitialChangeStreamPartitions("fake-table").iterator().hasNext();

    fakeService.count.set(0);
    for (ChangeStreamRecord record :
        client.readChangeStream(ReadChangeStreamQuery.create("fake-table"))) {}

    Set<String> expected =
        BigtableGrpc.getServiceDescriptor().getMethods().stream()
            .map(MethodDescriptor::getBareMethodName)
            .collect(Collectors.toSet());

    // Exclude methods that are not supported by routing cookie
    methods.add("PingAndWarm");
    methods.add("ExecuteQuery");

    assertThat(methods).containsExactlyElementsIn(expected);
  }

  @Test
  public void testCookieSetWithBigtableClientFactory() throws Exception {
    try (BigtableDataClientFactory factory = BigtableDataClientFactory.create(settings.build())) {
      BigtableDataClient client1 = factory.createDefault();
      BigtableDataClient client2 = factory.createForAppProfile("app-profile");

      client1.readRows(Query.create("fake-table")).iterator().hasNext();

      assertThat(fakeService.count.get()).isGreaterThan(1);
      assertThat(serverMetadata).hasSize(fakeService.count.get());

      Metadata lastMetadata = serverMetadata.get(fakeService.count.get() - 1);

      assertThat(lastMetadata)
          .containsAtLeast(
              ROUTING_COOKIE_1.name(),
              "readRows",
              ROUTING_COOKIE_2.name(),
              testCookie,
              ROUTING_COOKIE_HEADER.name(),
              testHeaderCookie);
      assertThat(lastMetadata).doesNotContainKeys(BAD_KEY.name());

      // Reset fake service status
      fakeService.count.set(0);
      serverMetadata.clear();

      client2.readRows(Query.create("fake-table")).iterator().hasNext();

      assertThat(fakeService.count.get()).isGreaterThan(1);
      assertThat(serverMetadata).hasSize(fakeService.count.get());

      lastMetadata = serverMetadata.get(fakeService.count.get() - 1);

      assertThat(lastMetadata)
          .containsAtLeast(
              ROUTING_COOKIE_1.name(),
              "readRows",
              ROUTING_COOKIE_2.name(),
              testCookie,
              ROUTING_COOKIE_HEADER.name(),
              testHeaderCookie);
      assertThat(lastMetadata).doesNotContainKeys(BAD_KEY.name());

      serverMetadata.clear();
    }
  }

  @Test
  public void testDisableRoutingCookie() throws IOException {
    // This test disables routing cookie in the client settings and ensures that none of the routing
    // cookie
    // is added.
    settings.stubSettings().setEnableRoutingCookie(false);
    try (BigtableDataClient client = BigtableDataClient.create(settings.build())) {
      client.readRows(Query.create("fake-table")).iterator().hasNext();
      assertThat(fakeService.count.get()).isEqualTo(2);
      fakeService.count.set(0);

      client.mutateRow(RowMutation.create("fake-table", "key").setCell("cf", "q", "v"));
      assertThat(fakeService.count.get()).isEqualTo(2);
      fakeService.count.set(0);

      client.bulkMutateRows(
          BulkMutation.create("fake-table")
              .add(RowMutationEntry.create("key").setCell("cf", "q", "v")));
      assertThat(fakeService.count.get()).isEqualTo(2);
      fakeService.count.set(0);

      client.sampleRowKeys("fake-table");
      assertThat(fakeService.count.get()).isEqualTo(2);
      fakeService.count.set(0);

      client.checkAndMutateRow(
          ConditionalRowMutation.create("fake-table", "key")
              .then(Mutation.create().setCell("cf", "q", "v")));
      assertThat(fakeService.count.get()).isEqualTo(2);
      fakeService.count.set(0);

      client.readModifyWriteRow(
          ReadModifyWriteRow.create("fake-table", "key").append("cf", "q", "v"));
      assertThat(fakeService.count.get()).isEqualTo(2);
      fakeService.count.set(0);

      client.generateInitialChangeStreamPartitions("fake-table").iterator().hasNext();
      assertThat(fakeService.count.get()).isEqualTo(2);
      fakeService.count.set(0);

      for (ChangeStreamRecord record :
          client.readChangeStream(ReadChangeStreamQuery.create("fake-table"))) {}

      assertThat(fakeService.count.get()).isEqualTo(2);

      assertThat(methods).isEmpty();
    }
  }

  static class FakeService extends BigtableGrpc.BigtableImplBase {

    private volatile boolean returnCookie = true;
    private final AtomicInteger count = new AtomicInteger();

    @Override
    public void readRows(
        ReadRowsRequest request, StreamObserver<ReadRowsResponse> responseObserver) {
      if (count.getAndIncrement() < 1) {
        Metadata trailers = new Metadata();
        maybePopulateCookie(trailers, "readRows");
        StatusRuntimeException exception = new StatusRuntimeException(Status.UNAVAILABLE, trailers);
        responseObserver.onError(exception);
        return;
      }
      responseObserver.onNext(ReadRowsResponse.getDefaultInstance());
      responseObserver.onCompleted();
    }

    @Override
    public void mutateRow(
        MutateRowRequest request, StreamObserver<MutateRowResponse> responseObserver) {
      if (count.getAndIncrement() < 1) {
        Metadata trailers = new Metadata();
        maybePopulateCookie(trailers, "mutateRow");
        StatusRuntimeException exception = new StatusRuntimeException(Status.UNAVAILABLE, trailers);
        responseObserver.onError(exception);
        return;
      }
      responseObserver.onNext(MutateRowResponse.getDefaultInstance());
      responseObserver.onCompleted();
    }

    @Override
    public void mutateRows(
        MutateRowsRequest request, StreamObserver<MutateRowsResponse> responseObserver) {
      if (count.getAndIncrement() < 1) {
        Metadata trailers = new Metadata();
        maybePopulateCookie(trailers, "mutateRows");
        StatusRuntimeException exception = new StatusRuntimeException(Status.UNAVAILABLE, trailers);
        responseObserver.onError(exception);
        return;
      }
      responseObserver.onNext(
          MutateRowsResponse.newBuilder()
              .addEntries(MutateRowsResponse.Entry.getDefaultInstance())
              .build());
      responseObserver.onCompleted();
    }

    @Override
    public void sampleRowKeys(
        SampleRowKeysRequest request, StreamObserver<SampleRowKeysResponse> responseObserver) {
      if (count.getAndIncrement() < 1) {
        Metadata trailers = new Metadata();
        maybePopulateCookie(trailers, "sampleRowKeys");
        StatusRuntimeException exception = new StatusRuntimeException(Status.UNAVAILABLE, trailers);
        responseObserver.onError(exception);
        return;
      }
      responseObserver.onNext(SampleRowKeysResponse.getDefaultInstance());
      responseObserver.onCompleted();
    }

    @Override
    public void checkAndMutateRow(
        CheckAndMutateRowRequest request,
        StreamObserver<CheckAndMutateRowResponse> responseObserver) {
      if (count.getAndIncrement() < 1) {
        Metadata trailers = new Metadata();
        maybePopulateCookie(trailers, "checkAndMutate");
        StatusRuntimeException exception = new StatusRuntimeException(Status.UNAVAILABLE, trailers);
        responseObserver.onError(exception);
        return;
      }
      responseObserver.onNext(CheckAndMutateRowResponse.getDefaultInstance());
      responseObserver.onCompleted();
    }

    @Override
    public void readModifyWriteRow(
        ReadModifyWriteRowRequest request,
        StreamObserver<ReadModifyWriteRowResponse> responseObserver) {
      if (count.getAndIncrement() < 1) {
        Metadata trailers = new Metadata();
        maybePopulateCookie(trailers, "readModifyWrite");
        StatusRuntimeException exception = new StatusRuntimeException(Status.UNAVAILABLE, trailers);
        responseObserver.onError(exception);
        return;
      }
      responseObserver.onNext(ReadModifyWriteRowResponse.getDefaultInstance());
      responseObserver.onCompleted();
    }

    @Override
    public void readChangeStream(
        ReadChangeStreamRequest request,
        StreamObserver<ReadChangeStreamResponse> responseObserver) {
      if (count.getAndIncrement() < 1) {
        Metadata trailers = new Metadata();
        maybePopulateCookie(trailers, "readChangeStream");
        responseObserver.onNext(
            ReadChangeStreamResponse.newBuilder()
                .setHeartbeat(
                    ReadChangeStreamResponse.Heartbeat.newBuilder()
                        .setContinuationToken(
                            StreamContinuationToken.newBuilder().setToken("a").build())
                        .build())
                .build());
        StatusRuntimeException exception = new StatusRuntimeException(Status.UNAVAILABLE, trailers);
        responseObserver.onError(exception);
        return;
      }
      responseObserver.onNext(
          ReadChangeStreamResponse.newBuilder()
              .setCloseStream(ReadChangeStreamResponse.CloseStream.getDefaultInstance())
              .build());
      responseObserver.onCompleted();
    }

    @Override
    public void generateInitialChangeStreamPartitions(
        GenerateInitialChangeStreamPartitionsRequest request,
        StreamObserver<GenerateInitialChangeStreamPartitionsResponse> responseObserver) {
      if (count.getAndIncrement() < 1) {
        Metadata trailers = new Metadata();
        maybePopulateCookie(trailers, "generateInitialChangeStreamPartitions");
        StatusRuntimeException exception = new StatusRuntimeException(Status.UNAVAILABLE, trailers);
        responseObserver.onError(exception);
        return;
      }
      responseObserver.onNext(GenerateInitialChangeStreamPartitionsResponse.getDefaultInstance());
      responseObserver.onCompleted();
    }

    private void maybePopulateCookie(Metadata trailers, String label) {
      if (returnCookie) {
        trailers.put(ROUTING_COOKIE_1, label);
        trailers.put(ROUTING_COOKIE_2, testCookie);
        trailers.put(BAD_KEY, "bad-key");
      }
    }
  }
}
