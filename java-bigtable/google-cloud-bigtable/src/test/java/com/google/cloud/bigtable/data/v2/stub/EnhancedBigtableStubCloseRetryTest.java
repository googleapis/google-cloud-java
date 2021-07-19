/*
 * Copyright 2021 Google LLC
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

import com.google.api.core.ApiFuture;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.bigtable.v2.BigtableGrpc;
import com.google.bigtable.v2.ReadRowsRequest;
import com.google.bigtable.v2.ReadRowsResponse;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.FakeServiceHelper;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.Row;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Ensures that closing a client during exponential retry will not hang any requests. */
@RunWith(JUnit4.class)
public class EnhancedBigtableStubCloseRetryTest {
  private static final String PROJECT_ID = "fake-project";
  private static final String INSTANCE_ID = "fake-instance";

  private ExecutorService testExecutor;
  private BlockingQueue<ReadRowsRequest> requests;
  private AtomicInteger numRequests;

  private FakeServiceHelper serviceHelper;
  private EnhancedBigtableStub stub;

  @Before
  public void setUp() throws Exception {
    testExecutor = Executors.newCachedThreadPool();
    requests = new ArrayBlockingQueue<>(10);
    numRequests = new AtomicInteger();

    serviceHelper = new FakeServiceHelper(new FakeBigtable());
    serviceHelper.start();

    BigtableDataSettings.Builder settingBuilder =
        BigtableDataSettings.newBuilderForEmulator(serviceHelper.getPort())
            .setProjectId(PROJECT_ID)
            .setInstanceId(INSTANCE_ID)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setRefreshingChannel(false);

    stub = EnhancedBigtableStub.create(settingBuilder.build().getStubSettings());
  }

  @After
  public void tearDown() throws Exception {
    testExecutor.shutdown();
    stub.close();
    serviceHelper.shutdown();
  }

  @Test
  public void outstandingRequestsFinishAfterClose() throws Exception {
    final ApiFuture<List<Row>> resultFuture =
        stub.readRowsCallable().all().futureCall(Query.create("table1"));

    // wait for the first request to hit the server
    requests.take();
    // wait enough time for a retry attempt to be scheduled before closing the client
    Thread.sleep(100);
    stub.close();

    ExecutionException error =
        Assert.assertThrows(
            ExecutionException.class,
            new ThrowingRunnable() {
              @Override
              public void run() throws Throwable {
                resultFuture.get();
              }
            });

    assertThat(error.getCause()).isInstanceOf(RejectedExecutionException.class);
  }

  class FakeBigtable extends BigtableGrpc.BigtableImplBase {
    @Override
    public void readRows(
        ReadRowsRequest request, StreamObserver<ReadRowsResponse> responseObserver) {

      requests.add(request);
      // Keep returning a retriable error
      responseObserver.onError(Status.UNAVAILABLE.asRuntimeException());
    }
  }
}
