/*
 * Copyright 2022 Google LLC
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

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.FixedTransportChannelProvider;
import com.google.api.gax.rpc.InternalException;
import com.google.bigtable.v2.BigtableGrpc;
import com.google.bigtable.v2.MutateRowsRequest;
import com.google.bigtable.v2.MutateRowsResponse;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.models.BulkMutation;
import com.google.cloud.bigtable.data.v2.models.RowMutationEntry;
import com.google.common.collect.Queues;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import io.grpc.testing.GrpcServerRule;
import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MutateRowsRetryTest {

  @Rule public GrpcServerRule serverRule = new GrpcServerRule();

  private FakeBigtableService service;
  private BigtableDataClient client;

  private AtomicInteger attemptCounter = new AtomicInteger();

  @Before
  public void setUp() throws IOException {
    service = new FakeBigtableService();
    serverRule.getServiceRegistry().addService(service);

    BigtableDataSettings.Builder settings =
        BigtableDataSettings.newBuilder()
            .setProjectId("fake-project")
            .setInstanceId("fake-instance")
            .setCredentialsProvider(NoCredentialsProvider.create());

    settings
        .stubSettings()
        .setTransportChannelProvider(
            FixedTransportChannelProvider.create(
                GrpcTransportChannel.create(serverRule.getChannel())))
        .build();

    this.client = BigtableDataClient.create(settings.build());
  }

  @Test
  public void testRetryRstStream() {
    ApiException exception =
        new InternalException(
            new StatusRuntimeException(
                Status.INTERNAL.withDescription(
                    "INTERNAL: HTTP/2 error code: INTERNAL_ERROR\nReceived Rst Stream")),
            GrpcStatusCode.of(Status.Code.INTERNAL),
            false);

    service.expectations.add(exception);

    try {
      client.bulkMutateRows(
          BulkMutation.create("fake-table")
              .add(RowMutationEntry.create("row-key-1").setCell("cf", "q", "v")));
    } catch (ApiException e) {
      Assert.fail("Rst stream errors should be retried");
    }

    Assert.assertEquals(attemptCounter.get(), 2);
  }

  private class FakeBigtableService extends BigtableGrpc.BigtableImplBase {
    Queue<Exception> expectations = Queues.newArrayDeque();

    @Override
    public void mutateRows(
        MutateRowsRequest request, StreamObserver<MutateRowsResponse> responseObserver) {
      attemptCounter.incrementAndGet();
      if (expectations.isEmpty()) {
        responseObserver.onNext(MutateRowsResponse.getDefaultInstance());
        responseObserver.onCompleted();
      } else {
        Exception expectedRpc = expectations.poll();
        responseObserver.onError(expectedRpc);
      }
    }
  }
}
