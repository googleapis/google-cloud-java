/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub.mutaterows;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

import com.google.api.client.util.Lists;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.FixedTransportChannelProvider;
import com.google.api.gax.rpc.StatusCode;
import com.google.bigtable.v2.BigtableGrpc;
import com.google.bigtable.v2.MutateRowsRequest;
import com.google.bigtable.v2.MutateRowsRequest.Entry;
import com.google.bigtable.v2.MutateRowsResponse;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.models.BulkMutationBatcher;
import com.google.cloud.bigtable.data.v2.models.RowMutation;
import com.google.common.collect.Maps;
import com.google.common.collect.Queues;
import io.grpc.Status;
import io.grpc.Status.Code;
import io.grpc.stub.StreamObserver;
import io.grpc.testing.GrpcServerRule;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.threeten.bp.Duration;

@RunWith(MockitoJUnitRunner.class)
public class BulkMutateRowsRetryTest {
  private static final String PROJECT_ID = "fake-project";
  private static final String INSTANCE_ID = "fake-instance";
  private static final String TABLE_ID = "fake-table";

  private static final int MAX_ATTEMPTS = 5;
  private static final long FLUSH_COUNT = 10;
  private static final Duration FLUSH_PERIOD = Duration.ofMillis(50);
  private static final Duration DELAY_BUFFER = Duration.ofSeconds(1);

  @Rule public GrpcServerRule serverRule = new GrpcServerRule();
  private TestBigtableService service;
  private BulkMutationBatcher bulkMutations;

  @Before
  public void setUp() throws Exception {
    service = new TestBigtableService();
    serverRule.getServiceRegistry().addService(service);

    BigtableDataSettings.Builder settings =
        BigtableDataSettings.newBuilder()
            .setProjectId(PROJECT_ID)
            .setInstanceId(INSTANCE_ID)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setTransportChannelProvider(
                FixedTransportChannelProvider.create(
                    GrpcTransportChannel.create(serverRule.getChannel())));

    settings
        .bulkMutationsSettings()
        .setRetrySettings(
            settings
                .bulkMutationsSettings()
                .getRetrySettings()
                .toBuilder()
                .setMaxAttempts(MAX_ATTEMPTS)
                .setInitialRetryDelay(Duration.ofMillis(10))
                .setRetryDelayMultiplier(2)
                .setMaxRetryDelay(Duration.ofMillis(100))
                .build())
        .setBatchingSettings(
            settings
                .bulkMutationsSettings()
                .getBatchingSettings()
                .toBuilder()
                .setDelayThreshold(FLUSH_PERIOD)
                .setElementCountThreshold(FLUSH_COUNT)
                .build());

    BigtableDataClient client = BigtableDataClient.create(settings.build());
    bulkMutations = client.newBulkMutationBatcher();
  }

  @Test
  public void simpleNoErrorsTest() {
    service.expectations.add(RpcExpectation.create().addEntry("key1", Code.OK));

    ApiFuture<Void> result = bulkMutations.add(RowMutation.create(TABLE_ID, "key1"));
    verifyOk(result);

    service.verifyOk();
  }

  @Test
  public void batchingNoErrorsTest() {
    service.expectations.add(
        RpcExpectation.create().addEntry("key1", Code.OK).addEntry("key2", Code.OK));

    ApiFuture<Void> result1 = bulkMutations.add(RowMutation.create(TABLE_ID, "key1"));
    ApiFuture<Void> result2 = bulkMutations.add(RowMutation.create(TABLE_ID, "key2"));

    verifyOk(result1);
    verifyOk(result2);

    service.verifyOk();
  }

  @Test
  public void fullRequestRetryTest() {
    service.expectations.add(RpcExpectation.create(Code.DEADLINE_EXCEEDED).addEntry("key1", null));
    service.expectations.add(RpcExpectation.create().addEntry("key1", Code.OK));

    ApiFuture<Void> result = bulkMutations.add(RowMutation.create(TABLE_ID, "key1"));
    verifyOk(result);

    service.verifyOk();
  }

  @Test
  public void partialRetryTest() {
    service.expectations.add(
        RpcExpectation.create().addEntry("key1", Code.DEADLINE_EXCEEDED).addEntry("key2", Code.OK));
    service.expectations.add(RpcExpectation.create().addEntry("key1", Code.OK));

    ApiFuture<Void> result1 = bulkMutations.add(RowMutation.create(TABLE_ID, "key1"));
    ApiFuture<Void> result2 = bulkMutations.add(RowMutation.create(TABLE_ID, "key2"));
    verifyOk(result1);
    verifyOk(result2);

    service.verifyOk();
  }

  @Test
  public void partialNoRetriesTest() {
    service.expectations.add(
        RpcExpectation.create().addEntry("key1", Code.INVALID_ARGUMENT).addEntry("key2", Code.OK));

    ApiFuture<Void> result1 = bulkMutations.add(RowMutation.create(TABLE_ID, "key1"));
    ApiFuture<Void> result2 = bulkMutations.add(RowMutation.create(TABLE_ID, "key2"));

    verifyError(result1, StatusCode.Code.INVALID_ARGUMENT);
    verifyOk(result2);

    service.verifyOk();
  }

  @Test
  public void partialRetryFailsEventuallyTest() {
    // Create a bunch of failures
    RpcExpectation rpcExpectation =
        RpcExpectation.create().addEntry("key1", Code.DEADLINE_EXCEEDED);
    for (int i = 0; i < MAX_ATTEMPTS; i++) {
      service.expectations.add(rpcExpectation);
    }

    ApiFuture<Void> result1 = bulkMutations.add(RowMutation.create(TABLE_ID, "key1"));
    verifyError(result1, StatusCode.Code.DEADLINE_EXCEEDED);

    service.verifyOk();
  }

  @Test
  public void elementCountTest() {
    // First request
    RpcExpectation rpcExpectation1 = RpcExpectation.create();
    int i = 0;
    for (; i < FLUSH_COUNT; i++) {
      rpcExpectation1.addEntry("key" + i, Code.OK);
    }
    service.expectations.add(rpcExpectation1);

    // Overflow request
    RpcExpectation rpcExpectation2 = RpcExpectation.create().addEntry("key" + i, Code.OK);
    service.expectations.add(rpcExpectation2);

    List<ApiFuture<Void>> results = Lists.newArrayList();

    for (int j = 0; j < FLUSH_COUNT + 1; j++) {
      ApiFuture<Void> result = bulkMutations.add(RowMutation.create(TABLE_ID, "key" + j));
      results.add(result);
    }

    verifyOk(ApiFutures.allAsList(results));
    service.verifyOk();
  }

  private void verifyOk(ApiFuture<?> result) {
    Throwable error = null;

    try {
      result.get(FLUSH_PERIOD.plus(DELAY_BUFFER).toMillis(), TimeUnit.MILLISECONDS);
    } catch (ExecutionException e) {
      error = e.getCause();
    } catch (Throwable t) {
      error = t;
    }

    assertThat(error).isNull();
  }

  @SuppressWarnings("ConstantConditions")
  private void verifyError(ApiFuture<?> result, StatusCode.Code expectedCode) {
    Throwable error = null;

    try {
      result.get(FLUSH_PERIOD.plus(DELAY_BUFFER).toMillis(), TimeUnit.MILLISECONDS);
    } catch (ExecutionException e) {
      error = e.getCause();
    } catch (Throwable t) {
      error = t;
    }

    assertThat(error).isInstanceOf(ApiException.class);
    assertThat(((ApiException) error).getStatusCode().getCode()).isEqualTo(expectedCode);
  }

  static class RpcExpectation {
    private final Map<String, Code> entries;
    private final Status.Code resultCode;

    RpcExpectation(Status.Code resultCode) {
      this.entries = Maps.newHashMap();
      this.resultCode = resultCode;
    }

    static RpcExpectation create() {
      return create(Code.OK);
    }

    static RpcExpectation create(Code resultCode) {
      return new RpcExpectation(resultCode);
    }

    RpcExpectation addEntry(String key, Code code) {
      entries.put(key, code);
      return this;
    }
  }

  static class TestBigtableService extends BigtableGrpc.BigtableImplBase {
    Queue<RpcExpectation> expectations = Queues.newArrayDeque();
    private final List<Throwable> errors = Lists.newArrayList();

    void verifyOk() {
      assertThat(expectations).isEmpty();
      assertThat(errors).isEmpty();
    }

    @Override
    public void mutateRows(
        MutateRowsRequest request, StreamObserver<MutateRowsResponse> responseObserver) {
      try {
        mutateRowsUnsafe(request, responseObserver);
      } catch (Throwable t) {
        errors.add(t);
        throw t;
      }
    }

    private void mutateRowsUnsafe(
        MutateRowsRequest request, StreamObserver<MutateRowsResponse> responseObserver) {
      RpcExpectation expectedRpc = expectations.poll();

      // Make sure that this isn't an extra request.
      assertWithMessage("Unexpected request: " + request.toString()).that(expectedRpc).isNotNull();

      // Make sure that this request has the same keys as the expected request.
      List<String> requestKeys = Lists.newArrayList();
      for (Entry entry : request.getEntriesList()) {
        requestKeys.add(entry.getRowKey().toStringUtf8());
      }
      assertThat(requestKeys).containsExactlyElementsIn(expectedRpc.entries.keySet());

      // Check if the expectation is to fail the entire request.
      if (expectedRpc.resultCode != Code.OK) {
        responseObserver.onError(Status.fromCode(expectedRpc.resultCode).asRuntimeException());
        return;
      }

      // Populate the response entries based on the set expectation.
      MutateRowsResponse.Builder responseBuilder = MutateRowsResponse.newBuilder();
      int i = 0;
      for (Entry requestEntry : request.getEntriesList()) {
        String key = requestEntry.getRowKey().toStringUtf8();
        Code responseCode = expectedRpc.entries.get(key);

        MutateRowsResponse.Entry responseEntry =
            MutateRowsResponse.Entry.newBuilder()
                .setIndex(i++)
                .setStatus(com.google.rpc.Status.newBuilder().setCode(responseCode.value()))
                .build();
        responseBuilder.addEntries(responseEntry);
      }

      responseObserver.onNext(responseBuilder.build());
      responseObserver.onCompleted();
    }
  }
}
