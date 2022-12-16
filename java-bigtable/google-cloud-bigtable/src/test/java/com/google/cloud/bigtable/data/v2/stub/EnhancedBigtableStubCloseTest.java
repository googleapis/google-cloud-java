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
import static java.util.concurrent.TimeUnit.MINUTES;

import com.google.api.core.ApiFuture;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.bigtable.v2.BigtableGrpc;
import com.google.bigtable.v2.ReadRowsRequest;
import com.google.bigtable.v2.ReadRowsResponse;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.FakeServiceBuilder;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.common.util.concurrent.SettableFuture;
import io.grpc.Server;
import io.grpc.stub.StreamObserver;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Ensure that an outstanding RPC will finish during a close */
@RunWith(JUnit4.class)
public class EnhancedBigtableStubCloseTest {
  private static final String PROJECT_ID = "fake-project";
  private static final String INSTANCE_ID = "fake-instance";

  private ExecutorService testExecutor;
  private SettableFuture<Void> requestReceivedBarrier = SettableFuture.create();
  private SettableFuture<Void> clientClosedBarrier = SettableFuture.create();

  private Server server;
  private EnhancedBigtableStub stub;

  @Before
  public void setUp() throws Exception {
    testExecutor = Executors.newCachedThreadPool();
    requestReceivedBarrier = SettableFuture.create();
    clientClosedBarrier = SettableFuture.create();

    server = FakeServiceBuilder.create(new FakeBigtable()).start();

    EnhancedBigtableStubSettings stubSettings =
        BigtableDataSettings.newBuilderForEmulator(server.getPort())
            .setProjectId(PROJECT_ID)
            .setInstanceId(INSTANCE_ID)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build()
            .getStubSettings();

    stub = EnhancedBigtableStub.create(stubSettings);
  }

  @After
  public void tearDown() throws Exception {
    testExecutor.shutdown();
    stub.close();
    server.shutdown();
  }

  @Test
  public void outstandingRequestsFinishAfterClose() throws Exception {
    ApiFuture<List<Row>> resultFuture =
        stub.readRowsCallable().all().futureCall(Query.create("table1"));

    // Wait for the server to receive the request
    requestReceivedBarrier.get(1, MINUTES);
    // Close the client - must happen in a separate thread because close will block until all
    // requests have completed, which can't happen until the clientClosedBarrier is released.
    testExecutor.submit(
        new Runnable() {
          @Override
          public void run() {
            stub.close();
          }
        });
    Thread.sleep(200); // give the closer a chance to run
    clientClosedBarrier.set(null);

    assertThat(resultFuture.get(1, MINUTES)).isEmpty();
  }

  class FakeBigtable extends BigtableGrpc.BigtableImplBase {
    @Override
    public void readRows(
        ReadRowsRequest request, StreamObserver<ReadRowsResponse> responseObserver) {

      // signal that server received the request
      requestReceivedBarrier.set(null);
      // wait until the main thread closes the client
      try {
        clientClosedBarrier.get();
      } catch (Exception e) {
        // Shouldn't happen
        responseObserver.onError(e);
      }

      // send the response
      responseObserver.onCompleted();
    }
  }
}
