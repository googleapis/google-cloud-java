/*
 * Copyright 2024 Google LLC
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

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.when;

import com.google.api.core.ApiFuture;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.tracing.ApiTracerFactory;
import com.google.auto.value.AutoValue;
import com.google.bigtable.v2.BigtableGrpc;
import com.google.bigtable.v2.CheckAndMutateRowResponse;
import com.google.bigtable.v2.MutateRowResponse;
import com.google.bigtable.v2.PingAndWarmResponse;
import com.google.bigtable.v2.ReadModifyWriteRowResponse;
import com.google.bigtable.v2.ReadRowsResponse;
import com.google.bigtable.v2.Row;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.FakeServiceBuilder;
import com.google.cloud.bigtable.data.v2.models.ConditionalRowMutation;
import com.google.cloud.bigtable.data.v2.models.Filters;
import com.google.cloud.bigtable.data.v2.models.Mutation;
import com.google.cloud.bigtable.data.v2.models.ReadModifyWriteRow;
import com.google.cloud.bigtable.data.v2.models.RowMutation;
import com.google.cloud.bigtable.data.v2.models.TableId;
import com.google.cloud.bigtable.data.v2.models.TargetId;
import com.google.cloud.bigtable.data.v2.stub.metrics.BigtableTracer;
import com.google.cloud.bigtable.data.v2.stub.metrics.NoopMetricsProvider;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.ByteString;
import com.google.protobuf.BytesValue;
import com.google.protobuf.Message;
import com.google.protobuf.StringValue;
import io.grpc.BindableService;
import io.grpc.MethodDescriptor;
import io.grpc.Server;
import io.grpc.ServerServiceDefinition;
import io.grpc.stub.ServerCalls;
import io.grpc.stub.StreamObserver;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

@RunWith(JUnit4.class)
public class SkipTrailersTest {
  @Rule public final MockitoRule mockitoRule = MockitoJUnit.rule();

  private static final String PROJECT_ID = "fake-project";
  private static final String INSTANCE_ID = "fake-instance";
  private static final TargetId TABLE_ID = TableId.of("fake-table");

  private HackedBigtableService hackedService;
  private Server server;

  @Mock private ApiTracerFactory tracerFactory;
  private FakeTracer tracer = new FakeTracer();

  private BigtableDataClient client;

  @Before
  public void setUp() throws Exception {
    hackedService = new HackedBigtableService();
    server = FakeServiceBuilder.create(hackedService).start();

    when(tracerFactory.newTracer(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(tracer);

    BigtableDataSettings.Builder clientBuilder =
        BigtableDataSettings.newBuilderForEmulator(server.getPort())
            .setProjectId(PROJECT_ID)
            .setInstanceId(INSTANCE_ID)
            .setMetricsProvider(NoopMetricsProvider.INSTANCE)
            .setCredentialsProvider(NoCredentialsProvider.create());
    clientBuilder.stubSettings().setEnableSkipTrailers(true).setTracerFactory(tracerFactory);

    client = BigtableDataClient.create(clientBuilder.build());
  }

  @After
  public void tearDown() throws Exception {
    client.close();
    server.shutdown();
  }

  @Test
  public void testReadRow() throws InterruptedException, ExecutionException {
    ReadRowsResponse fakeResponse =
        ReadRowsResponse.newBuilder()
            .addChunks(
                ReadRowsResponse.CellChunk.newBuilder()
                    .setRowKey(ByteString.copyFromUtf8("fake-key"))
                    .setFamilyName(StringValue.newBuilder().setValue("cf"))
                    .setQualifier(BytesValue.newBuilder().setValue(ByteString.copyFromUtf8("q")))
                    .setTimestampMicros(0)
                    .setValue(ByteString.copyFromUtf8("value"))
                    .setCommitRow(true))
            .build();
    test(() -> client.readRowAsync(TABLE_ID, "fake-key"), fakeResponse);
  }

  @Test
  public void testMutateRow() throws ExecutionException, InterruptedException {
    test(
        () -> client.mutateRowAsync(RowMutation.create(TABLE_ID, "fake-key")),
        MutateRowResponse.getDefaultInstance());
  }

  @Test
  public void testCheckAndMutateRow() throws ExecutionException, InterruptedException {
    ConditionalRowMutation req =
        ConditionalRowMutation.create(TABLE_ID, "fake-key")
            .condition(Filters.FILTERS.pass())
            .then(Mutation.create().deleteRow());
    test(() -> client.checkAndMutateRowAsync(req), CheckAndMutateRowResponse.getDefaultInstance());
  }

  @Test
  public void testRMW() throws ExecutionException, InterruptedException {
    ReadModifyWriteRow req = ReadModifyWriteRow.create(TABLE_ID, "fake-key").append("cf", "q", "A");
    test(
        () -> client.readModifyWriteRowAsync(req),
        ReadModifyWriteRowResponse.newBuilder().setRow(Row.getDefaultInstance()).build());
  }

  private <T> void test(Supplier<ApiFuture<?>> invoker, T fakeResponse)
      throws InterruptedException, ExecutionException {
    ApiFuture<?> future = invoker.get();

    // Wait for the call to start on the server
    @SuppressWarnings("unchecked")
    ServerRpc<?, T> rpc = (ServerRpc<?, T>) hackedService.rpcs.poll(30, TimeUnit.SECONDS);
    Preconditions.checkNotNull(
        rpc, "Timed out waiting for the call to be received by the mock server");

    // Send the only row
    rpc.getResponseStream().onNext(fakeResponse);

    // Ensure that the future resolves and does not throw an error
    try {
      future.get(1, TimeUnit.MINUTES);
    } catch (TimeoutException e) {
      Assert.fail("timed out waiting for the trailer optimization future to resolve");
    }

    // The tracer will be notified in parallel to the future being resolved
    // This normal and expected, but requires the test to wait a bit
    for (int i = 10; i > 0; i--) {
      try {
        assertThat(tracer.getCallCount("operationFinishEarly")).isEqualTo(1);
        break;
      } catch (AssertionError e) {
        if (i > 1) {
          Thread.sleep(100);
        } else {
          throw e;
        }
      }
    }
    assertThat(tracer.getCallCount("operationSucceeded")).isEqualTo(0);

    // clean up
    rpc.getResponseStream().onCompleted();

    // Ensure that the tracer is invoked after the internal operation is complete
    // Since we dont have a way to know exactly when this happens, we poll
    for (int i = 10; i > 0; i--) {
      try {
        assertThat(tracer.getCallCount("operationSucceeded")).isEqualTo(1);
        break;
      } catch (AssertionError e) {
        if (i > 1) {
          Thread.sleep(100);
        } else {
          throw e;
        }
      }
    }
  }

  static class FakeTracer extends BigtableTracer {
    ConcurrentHashMap<String, AtomicInteger> callCounts = new ConcurrentHashMap<>();

    @Override
    public void operationFinishEarly() {
      record("operationFinishEarly");
    }

    @Override
    public void operationSucceeded() {
      record("operationSucceeded");
    }

    private void record(String op) {
      callCounts.computeIfAbsent(op, (ignored) -> new AtomicInteger()).getAndIncrement();
    }

    private int getCallCount(String op) {
      return Optional.ofNullable(callCounts.get(op)).map(AtomicInteger::get).orElse(0);
    }
  }

  /**
   * Hack the srvice definition to allow grpc server to simulate delayed trailers. This will augment
   * the bigtable service definition to promote unary rpcs to server streaming
   */
  class HackedBigtableService implements BindableService {
    private final LinkedBlockingDeque<ServerRpc<?, ?>> rpcs = new LinkedBlockingDeque<>();

    @Override
    public ServerServiceDefinition bindService() {
      ServerServiceDefinition.Builder builder =
          ServerServiceDefinition.builder(BigtableGrpc.SERVICE_NAME)
              .addMethod(
                  BigtableGrpc.getPingAndWarmMethod(),
                  ServerCalls.asyncUnaryCall(
                      (ignored, observer) -> {
                        observer.onNext(PingAndWarmResponse.getDefaultInstance());
                        observer.onCompleted();
                      }))
              .addMethod(
                  BigtableGrpc.getReadRowsMethod(),
                  ServerCalls.asyncServerStreamingCall(
                      (req, observer) -> rpcs.add(ServerRpc.create(req, observer))));
      ImmutableList<MethodDescriptor<? extends Message, ? extends Message>> unaryDescriptors =
          ImmutableList.of(
              BigtableGrpc.getMutateRowMethod(),
              BigtableGrpc.getCheckAndMutateRowMethod(),
              BigtableGrpc.getReadModifyWriteRowMethod());

      for (MethodDescriptor<? extends Message, ? extends Message> desc : unaryDescriptors) {
        builder.addMethod(
            desc.toBuilder().setType(MethodDescriptor.MethodType.SERVER_STREAMING).build(),
            ServerCalls.asyncServerStreamingCall(
                (req, observer) -> rpcs.add(ServerRpc.create(req, observer))));
      }
      return builder.build();
    }
  }

  @AutoValue
  abstract static class ServerRpc<ReqT, RespT> {
    abstract ReqT getRequest();

    abstract StreamObserver<RespT> getResponseStream();

    static <ReqT, RespT> ServerRpc<ReqT, RespT> create(ReqT req, StreamObserver<RespT> resp) {
      // return new AutoValue__(req, resp);
      return new AutoValue_SkipTrailersTest_ServerRpc<>(req, resp);
    }
  }
}
